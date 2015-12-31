import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class Tabbedpane 
{
		JButton b1,b2,b3,b4,logout;
		JLabel l1,l2,l3,l4,username;
		JTextField filepath,encryptpath,decryptpath,deletepath;
		JFrame frame;
		String path = new String();
		DefaultListModel<String> list1,list2;
		JList<String> jlist1,jlist2;
		DBManager1 DB = new DBManager1();
		public void init(final int userid)
		{
	    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame = new JFrame();
			frame.setTitle("Tabbed Pane");
	    	frame.setBounds(0,0,screenSize.width, screenSize.height);  
			
	    	l1 = new JLabel("Choose to Upload file...");
	    	l2 = new JLabel("Choose to Encrypt file");
	    	l3 = new JLabel("Choose to Decrypt file");
	    	l4 = new JLabel("Choose to Delete file...");
	    	
	    	String name;
	    	
	    	try{
	    		DBManager1 db1= new DBManager1();
				db1.loader();
				db1.getConnection();
				String query="select name from usertab1 where id='"+userid+"'";
				ResultSet rs = db1.fetchQuery(query);
				if(rs.next())
				{	
					name = rs.getString(1);
					username = new JLabel("Welcome "+name);
					username.setFont(new Font("Times New Roman", Font.BOLD,35));
					username.setForeground(Color.CYAN);
					username.setBounds(0, 20, 1000, 35);
				}
				
				query="select filename from filetab1 where userid='"+userid+"'";
				rs = db1.fetchQuery(query);
				list1 = new DefaultListModel<String>();
				list2 = new DefaultListModel<String>();
				
				if(rs.next())
				{	
					while(!rs.isLast())
					{
						name = rs.getString(1);
						list1.addElement(name);
						list2.addElement(name);
						rs.next();
					}
					name = rs.getString(1);
					list1.addElement(name);
					list2.addElement(name);
					
				}
				jlist1 = new JList<String>(list1);
				jlist1.setVisibleRowCount(8);
				jlist2 = new JList<String>(list2);
				jlist2.setVisibleRowCount(8);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	JScrollPane scrollPane1 = new JScrollPane(jlist1);
	    	JScrollPane scrollPane2 = new JScrollPane(jlist2);
	    	
	    	b1 = new JButton("Encrypt File");
	        b2 = new JButton("Upload File");
	        b3 = new JButton("Decrypt File");
	        b4 = new JButton("Delete File");
	        logout = new JButton("LOGOUT");
	        
	        filepath = new JTextField(150);
	        encryptpath = new JTextField(150);
	        decryptpath = new JTextField(150);
	        deletepath = new JTextField(150);
	        
	        JTabbedPane jtp = new JTabbedPane();
	        
	        filepath.setEditable(false);
	        encryptpath.setEditable(false);
	        decryptpath.setEditable(false);
	        deletepath.setEditable(false);
	        
	        l1.setBounds(100,100,500,20);
	        l2.setBounds(100,100,500,20);
	        l3.setBounds(100, 300, 500, 20);
	        l4.setBounds(100,300,500,20);
	        
	        b1.setBounds(750,100,150,20);
	        b2.setBounds(750,100,150,20);
	        b3.setBounds(750, 300, 150, 20);
	        b4.setBounds(750,300,150,20);
	        logout.setBounds(750,50,150,20);
	        
	        filepath.setBounds(350,100,300,20);
	        encryptpath.setBounds(350,100,300,20);
	        decryptpath.setBounds(350, 300, 300, 20);
	        deletepath.setBounds(350,300,300,20);
	        
	        scrollPane1.setBounds(350, 350, 300, 100);
	        scrollPane2.setBounds(350, 150, 300, 100);
	        
	        frame.getContentPane().add(jtp);
	    	
	    	JPanel jp1 = new JPanel();
	        JPanel jp2 = new JPanel();
	        JPanel p1 = new JPanel();
	        p1.setLayout(null);
	        jp1.setLayout(null);
	        jp2.setLayout(null);
	        jp2.add(b1);
	        jp1.add(b2);
	        jp1.add(l1);
	        jp1.add(filepath);
	        jp2.add(encryptpath);
	        jp2.add(l2);
	        jp2.add(l3);
	        jp2.add(decryptpath);
	        jp2.add(b3);
	        jp1.add(b4);
	        jp1.add(deletepath);
	        jp1.add(l4);
	        jp1.add(scrollPane1);
	        jp2.add(scrollPane2);
	        p1.add(logout);
	        p1.add(username);
	        b2.addActionListener(new ActionListener() 
	        {
				public void actionPerformed(ActionEvent arg0) 
				{
					File_chooser obj = new File_chooser();
					path = obj.init(1,userid);
					filepath.setText(path);
					
					DB.loader();
					DB.getConnection();
					int id=DB.getMaxIdFile();
					try
					{
						String[] filearray=path.split("/");
						int size = filearray.length;
						System.out.println("SIZE: "+size);
						System.out.println("FILEARAY:" +filearray[size-1]);
						String temp = filearray[size-1];
						String[] fileext = temp.split("\\.");
						int size1 = fileext.length;
						PreparedStatement ps = DB.con.prepareStatement("insert into filetab1 values(?,?,?,?,?)");
						ps.setInt(1, id);
						ps.setInt(2,userid);
						ps.setString(3,userid+filearray[size-1]);
						ps.setString(4,path);
						ps.setString(5,fileext[size1-1]);
	
						int num=ps.executeUpdate();
						
						if(num>0)
						{
							JOptionPane.showMessageDialog(null, "Upload Successfull");
							DB.closeConnection();
							frame.dispose();
							Tabbedpane obj1 = new Tabbedpane();
							obj1.init(userid);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Upload Failed");
						}
					}		
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			});
	        
	        
	        b4.addActionListener(new ActionListener() 
	        {
				public void actionPerformed(ActionEvent arg0) 
				{
					String name = (String) jlist1.getSelectedValue();
					String fname = "/home/mandar/Files_Uploaded/"+name;
					System.out.println(fname);
					
					File file = new File(fname);
					
					if(file.delete() == true)
					{
						DBManager1 temp = new DBManager1();
						temp.loader();
						temp.getConnection();
						String query="delete from filetab1 where filename='"+name+"'";
						temp.deleteRecord(query);
						temp.closeConnection();
						frame.dispose();
						Tabbedpane obj1 = new Tabbedpane();
						obj1.init(userid);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You are not authorised to delete this file");
					}
				}
			});
	        
	        b1.addActionListener(new ActionListener() 
	        {
				public void actionPerformed(ActionEvent arg0) {
					
					String name = (String) jlist2.getSelectedValue();
					File fileToSave = new File(name);
					
					 if(fileToSave.getName().startsWith(""+userid))
					    {
						  	Object[] selectionValues = { "Additive Cipher", "Caesar Cipher" };
						  	String initialSelection = "Additive Cipher";
						  	Object selection = JOptionPane.showInputDialog(null, "Please choose algorithm?",
					        "Algorithm Selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
					    					    
						  	JOptionPane.showMessageDialog(null, "Remember your choice for Decryption!!!");
						    JOptionPane.showMessageDialog(null, "Upload Image for data hiding now...");
						    JFileChooser fileChooser1 = new JFileChooser();
							fileChooser1.setDialogTitle("Upload a file to directory");   
						
							int userSelection1 = fileChooser1.showOpenDialog(null);
					   
							if (userSelection1 == JFileChooser.APPROVE_OPTION) 
							{
							    File fileToSave1 = fileChooser1.getSelectedFile();
							    String filepath = "/home/mandar/Files_Uploaded/"+fileToSave.getName();
							    if(fileToSave1.getName().endsWith("png") || fileToSave1.getName().endsWith("jpg") || fileToSave1.getName().endsWith("bmp"))
							    {
							    	if(selection == "Additive Cipher")
							    	{
							    		
								    	Keyaddition1 obj = new Keyaddition1();
								    	Object result = JOptionPane.showInputDialog(null, "Enter Key", "Enter key");
										String key = result.toString();
								    	try {
											obj.encrypt(new File(filepath),key);
										} catch (Exception e) {
											e.printStackTrace();
										}
								    	
								    	String newpath ="/home/mandar/Encrypted_Files/"+fileToSave.getName(); 
										System.out.println("newpath: "+newpath);
								    	RandomAccessFile encryptedFile;
										try 
										{
											encryptedFile = new RandomAccessFile(newpath,"rw");
											temporary.init(fileToSave1.getAbsolutePath(),encryptedFile);
										} 
										catch (Exception e) {
											e.printStackTrace();
										}
									}
								    
								    else
								    {
								    		try{
								    		Rot13.encrypt(new File(filepath)); 
								    		String newpath ="/home/mandar/Encrypted_Files/"+fileToSave.getName(); 
								    		System.out.println("newpath: "+newpath);
								    		RandomAccessFile encryptedFile = new RandomAccessFile(newpath,"rw");
								    		temporary.init(fileToSave1.getAbsolutePath(),encryptedFile);
								    		}
								    		catch(Exception e)
								    		{
								    			e.printStackTrace();
								    		}
								    }
							    }
							    
							    else
							    {
							    	JOptionPane.showMessageDialog(null, "This format is not supported for an image");
							    	frame.dispose();
									Tabbedpane obj1 = new Tabbedpane();
									obj1.init(userid);
	
							    }
							
							}
					    }
						else
						{
							  JOptionPane.showMessageDialog(null, "You are not authorised to ENCRYPT this file");
							  frame.dispose();
							  Tabbedpane obj1 = new Tabbedpane();
							  obj1.init(userid);

						}
				}
			});
	        
	        
	        b3.addActionListener(new ActionListener() 
	        {
				public void actionPerformed(ActionEvent arg0) 
				{
					File_chooser obj = new File_chooser();
					path = obj.init(4,userid);
					decryptpath.setText(path);
					frame.dispose();
					Tabbedpane obj1 = new Tabbedpane();
					obj1.init(userid);
					
				}
			});
	        
	        logout.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					Login_screen obj = new Login_screen();
					try {
						obj.init();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
	        
	        
	        p1.setBounds(0, 0, screenSize.width, 3*(screenSize.height/4));
			jtp.setBounds(0, (screenSize.height/10), screenSize.width, (screenSize.height));
			
			jtp.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Uploading File</body></html>", jp1);
	        jtp.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Encrypt & Decrypt</body></html>", jp2);
	        
	        frame.getContentPane().add(jtp);
	        frame.add(p1);
	        frame.setVisible(true);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     }

}
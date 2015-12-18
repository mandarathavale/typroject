import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;


public class File_chooser{

	//static int ecnt=1;
	static String key = new String();
	
	public String init(int choice,int userid)
	{
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Upload a file to directory");   
		String path = new String();
		int userSelection = fileChooser.showOpenDialog(null);
		 
		String userid1 = ""+userid;
		
		if (userSelection == JFileChooser.APPROVE_OPTION) 
		{
		    
			File fileToSave = fileChooser.getSelectedFile();
		    //System.out.println(fileToSave.getAbsolutePath());
		    path = fileChooser.getSelectedFile().getAbsolutePath();
		  try {
			  		/*Files.copy(fileToSave.toPath(),	
			  				(new File("D:\\Movies\\Files" + fileToSave.getName())).toPath(),
			  				StandardCopyOption.REPLACE_EXISTING);
		   
			  
			  if(fileToSave.renameTo(new File("D:\\Movies\\Files\\" + fileToSave.getName())))
		    		System.out.println("File is moved successful!");*/
			  
			 
			  if(choice == 1){ 
				  File new1 = new File("/home/mandar/Files_Uploaded/"+userid + fileToSave.getName());
			  
				  FileInputStream is = new FileInputStream(fileToSave);
				  FileOutputStream os = new FileOutputStream(new1);
			  
			  
				  byte[] buffer = new byte[(int)fileToSave.length()];
	    		
				  int length;
	    	    //copy the file content in bytes 
				  while ((length = is.read(buffer)) > 0){
					  	os.write(buffer, 0, length);
				  }
				  is.close();
				  os.close();
				  return fileToSave.getAbsolutePath();
			  }
			  
			  if(choice == 2){
				
				  if(fileToSave.getName().startsWith(userid1))
				  {
					  if(fileToSave.delete() == true){
						  JOptionPane.showMessageDialog(null, "Deleted Succesfully");
						  return fileToSave.getAbsolutePath();
					  }
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(null, "You are not authorised to delete this file");
					  return "FAILED";
				  }
			  }
			  
			  if(choice == 3){
				  
				  if(fileToSave.getName().startsWith(userid1))
				    {
				  Object[] selectionValues = { "Additive Cipher", "Caesar Cipher" };
				    String initialSelection = "Additive Cipher";
				    Object selection = JOptionPane.showInputDialog(null, "Please choose algorithm?",
				        "Algorithm Selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				    //System.out.println(selection);
				    
				    JOptionPane.showMessageDialog(null, "Remember your choice for Decryption!!!");
				    
				    JFrame parentFrame1 = new JFrame();
					JFileChooser fileChooser1 = new JFileChooser();
					fileChooser1.setDialogTitle("Upload a file to directory");   
					//String path = new String();
					
					int userSelection1 = fileChooser.showOpenDialog(null);
				   
					if (userSelection1 == JFileChooser.APPROVE_OPTION) 
					{
					    File fileToSave1 = fileChooser.getSelectedFile();
					    
					    if(fileToSave1.getName().endsWith("jpg")){
					    	System.out.println("jpg");
					/*    	   if(selection == "Additive Cipher"){
							    	Keyaddition1 obj = new Keyaddition1();
							    	obj.init(fileToSave.getAbsolutePath());
							    }
							    
							    else{
							    	Rot13 obj = new Rot13();
							    	obj.init(fileToSave.getAbsolutePath());
							    }*/
					    }
					    else{
					    	parentFrame.dispose();
					    	Tabbedpane tp = new Tabbedpane();
					    	tp.init(userid);
					    }
					 
					}
				    
				
					if(selection == "Additive Cipher"){
				    	Keyaddition1 obj = new Keyaddition1();
				    	Object result = JOptionPane.showInputDialog(null, "Enter Key", "Enter key");
						key = result.toString();
				    	obj.encrypt(fileToSave,key);
						return fileToSave.getAbsolutePath();
				    }
				    
				    else{
				    	Rot13 obj = new Rot13();
				    	obj.encrypt(fileToSave); 
				    	return fileToSave.getAbsolutePath();
				    }
					}
					else
					{
						  JOptionPane.showMessageDialog(null, "You are not authorised to ENCRYPT this file");
						  return "FAILED";
					}
			  }
			  
			  if(choice == 4){
				  
				  if(fileToSave.getName().startsWith(userid1))
				    {
				  Object[] selectionValues = { "Additive Cipher", "Caesar Cipher" };
				    String initialSelection = "Additive Cipher";
				    Object selection = JOptionPane.showInputDialog(null, "Please choose algorithm?",
				        "Algorithm Selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				    //System.out.println(selection);
				    
				    JOptionPane.showMessageDialog(null, "Are you sure???");
				    JOptionPane optionPane = new JOptionPane("Continue printing?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
				    
				    
				    	if(selection == "Additive Cipher"){
				    
				    	Keyaddition1 obj = new Keyaddition1();
				    	
				    	Object result = JOptionPane.showInputDialog(null, "Enter Key", "Enter key");
						key = result.toString();
				    	
				    	//System.out.println("Enter the key: ");
						//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						/*try {
							key = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							
							e.printStackTrace();
						}*/
				    	//obj.init(fileToSave.getAbsolutePath());
				    	obj.decrypt(fileToSave,key);
						return fileToSave.getAbsolutePath();
				    }
				    else{
				    	Rot13 obj = new Rot13();
				    	obj.decrypt(fileToSave);
				    	 return fileToSave.getAbsolutePath();
				    }
				    }
				    
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "You are not authorised to Decrypt this file");
						  return "FAILED";
				    }
				    
			  }
	    	    
			  
		   }
			
		 catch (Exception e) {
				
				e.printStackTrace();
			}
		    
		  
		}
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//parentFrame.setBounds(0,0,screenSize.width, screenSize.height);
		parentFrame.setLayout(null);
		parentFrame.add(fileChooser);
		parentFrame.setVisible(true);
		parentFrame.pack();
		parentFrame.dispose();
		return path;
	}
	public static void main(String[] args)
	{
		File_chooser obj = new File_chooser();
		//obj.init(3);
	}
}
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;

public class File_chooser{

	static String key = new String();
	
	public String init(int choice,int userid)
	{
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Upload a file to directory");   
		String path = new String();
		int userSelection = fileChooser.showOpenDialog(null);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) 
		{
		    
			File fileToSave = fileChooser.getSelectedFile();
		    path = fileChooser.getSelectedFile().getAbsolutePath();
		  try {
			  		  
			 
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
			  
			/*  if(choice == 2){
				
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
			  }*/
			  
			  /*if(choice == 3){
				  
				  
				  
				  if(fileToSave.getName().startsWith(userid1))
				    {
				 
					  Object[] selectionValues = { "Additive Cipher", "Caesar Cipher" };
					  String initialSelection = "Additive Cipher";
					  Object selection = JOptionPane.showInputDialog(null, "Please choose algorithm?",
				        "Algorithm Selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				    //System.out.println(selection);
				    
				    JOptionPane.showMessageDialog(null, "Remember your choice for Decryption!!!");
				    JOptionPane.showMessageDialog(null, "Upload Image for data hiding now...");
				    JFrame parentFrame1 = new JFrame();
					JFileChooser fileChooser1 = new JFileChooser();
					fileChooser1.setDialogTitle("Upload a file to directory");   
					
					int userSelection1 = fileChooser1.showOpenDialog(null);
				   
					if (userSelection1 == JFileChooser.APPROVE_OPTION) 
					{
					    File fileToSave1 = fileChooser1.getSelectedFile();
					    
					    if(fileToSave1.getName().endsWith("png") || fileToSave1.getName().endsWith("jpg") || fileToSave1.getName().endsWith("bmp")){
					    	//System.out.println("true");
					    	
					    	
					    	
						    if(selection == "Additive Cipher"){
						    	Keyaddition1 obj = new Keyaddition1();
						    	Object result = JOptionPane.showInputDialog(null, "Enter Key", "Enter key");
								key = result.toString();
						    	obj.encrypt(fileToSave,key);
						    	
						    	String newpath ="/home/mandar/Encrypted_Files/"+fileToSave.getName(); 
								System.out.println("newpath: "+newpath);
						    	RandomAccessFile encryptedFile = new RandomAccessFile(newpath,"rw");
								//byte b[] = new byte[(int) encryptedFile.length()];
								//encryptedFile.readFully(b);
								//encryptedFile.close();
								//String tempo = new String(b);
								//System.out.println("tempo"+tempo);
								//WriteMessage.writeMessage(fileToSave1.getAbsolutePath(),tempo);
								temporary.init(fileToSave1.getAbsolutePath(),encryptedFile);
								return fileToSave.getAbsolutePath();
						    }
						    
						    else{
						    	Rot13 obj = new Rot13();
						    	obj.encrypt(fileToSave); 
						    	
						    	String newpath ="/home/mandar/Encrypted_Files/"+fileToSave.getName(); 
								System.out.println("newpath: "+newpath);
						    	RandomAccessFile encryptedFile = new RandomAccessFile(newpath,"rw");
								//byte b[] = new byte[(int) encryptedFile.length()];
								//encryptedFile.readFully(b);
								
								//String tempo = new String(b);
								//System.out.println("tempo"+tempo);
								//WriteMessage.writeMessage(fileToSave1.getAbsolutePath(),tempo);
								temporary.init(fileToSave1.getAbsolutePath(),encryptedFile);
						    	return fileToSave.getAbsolutePath();
						    }
					}
					    else{
					    	JOptionPane.showMessageDialog(null, "This format is not supported for an image");
					    	parentFrame.dispose();
					    	Tabbedpane tp = new Tabbedpane();
					    	tp.init(userid);
					    }
					}
				    }
					else
					{
						  JOptionPane.showMessageDialog(null, "You are not authorised to ENCRYPT this file");
						  return "FAILED";
					}
			  }*/
			  
			  if(choice == 4){
				  
				  if(fileToSave.getName().endsWith("jpg") || fileToSave.getName().endsWith("png") || fileToSave.getName().endsWith("bmp") )
				    {
					  Object[] selectionValues = { "Additive Cipher", "Caesar Cipher" };
					  String initialSelection = "Additive Cipher";
					  Object selection = JOptionPane.showInputDialog(null, "Please choose algorithm?",
				        "Algorithm Selection", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
					  JOptionPane.showMessageDialog(null, "Are you sure???");
					  File encrypted = ReadMessage.init(fileToSave.getAbsolutePath());
					  
					  if(selection == "Additive Cipher")
					  {
				    	Keyaddition1 obj = new Keyaddition1();
				    	Object result = JOptionPane.showInputDialog(null, "Enter Key", "Enter key");
						key = result.toString();
				    	obj.decrypt(encrypted,key);
						return fileToSave.getAbsolutePath();
					  }
					  else
					  {
				    	Rot13.decrypt(encrypted);
				    	return fileToSave.getAbsolutePath();
					  }
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "This file is not an image");
						  return "FAILED";
				    }
			  }
		   }
			
		 catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		parentFrame.setLayout(null);
		parentFrame.add(fileChooser);
		parentFrame.setVisible(true);
		parentFrame.pack();
		parentFrame.dispose();
		return path;
	}
}
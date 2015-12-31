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
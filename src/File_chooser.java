import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class File_chooser{

	public void init()
	{
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Upload a file to directory");   
		
		int userSelection = fileChooser.showOpenDialog(null);
		 
		
		
		if (userSelection == JFileChooser.APPROVE_OPTION) 
		{
		    File fileToSave = fileChooser.getSelectedFile();
		    System.out.println(fileToSave.getAbsolutePath());
		  
		  try {
			  		/*Files.copy(fileToSave.toPath(),	
			  				(new File("D:\\Movies\\Files" + fileToSave.getName())).toPath(),
			  				StandardCopyOption.REPLACE_EXISTING);
		   
			  
			  if(fileToSave.renameTo(new File("D:\\Movies\\Files\\" + fileToSave.getName())))
		    		System.out.println("File is moved successful!");*/
			  
			  File new1 = new File("/home/mandar/Files_Uploaded/" + fileToSave.getName());
			  
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
		
		//parentFrame.setResizable(true);
		parentFrame.pack();
		parentFrame.dispose();
	}
	public static void main(String[] args)
	{
		File_chooser obj = new File_chooser();
		obj.init();
	}
}
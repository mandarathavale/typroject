import java.io.*;
import javax.swing.*;

public class Keyaddition1 {

	static String key = new String();
	
public static void main(String[] args) {
		try {
			
				Keyaddition1.init("/home/nahush/Dec/test.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init(String fname) throws Exception{
		System.out.println("Enter the key: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			key = br.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void encrypt(File file, String secretKey)
			throws Exception {
		
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder encryptedText = new StringBuilder();
		String plainText;
		
		RandomAccessFile file1 = new RandomAccessFile(file,"rw");
		byte b[] = new byte[(int) file1.length()];
		file1.readFully(b);
		plainText = new String(b);
		
		if(plainText.length() >= secretKey.length()){
			
			if(plainText.length() == secretKey.length()){
					for(int i =0 ;i<plainText.length();i++){
						char temp = (char)(plainText.charAt(i)+secretKey.charAt(i));
						String newstr = ""+temp;
						encryptedText.append(newstr);
				}
			}
			
			else{
				int diff = plainText.length() - secretKey.length();
				int j = 0;
				
				for(int i=0;i<diff;i++){
					char temp =secretKey.charAt(j);
					String temp2 = ""+temp;
					newKey.append(temp2);
					j++;
					if(j == (secretKey.length()))
						j = 0;
				}
				
				System.out.println("New Key: "+newKey);
					for(int i =0 ;i<plainText.length();i++){
						char temp = (char)(plainText.charAt(i)+newKey.charAt(i));
						String newstr = ""+temp;
						encryptedText.append(newstr);
					}
		
			}
			
			String path = "/home/nahush/Enc" + file.getName(); 
			RandomAccessFile encryptedFile = new RandomAccessFile(path,"rw");
			encryptedFile.write(encryptedText.toString().getBytes());
			encryptedFile.close();
			file1.close();
		}
		
		else{
			JFrame parent = new JFrame();
		    JOptionPane.showMessageDialog(parent, "INVALID KEY");
		}
		
		
	}

	public void decrypt(File file, String secretKey) throws IOException
	{	
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder decryptedText = new StringBuilder();
		String encryptedText = new String();
		
		RandomAccessFile file1 = new RandomAccessFile(file,"rw");
		byte b[] = new byte[(int) file1.length()];
		file1.readFully(b);
		encryptedText = new String(b);
		
		if(encryptedText.length() >= secretKey.length()){
			
			if(encryptedText.length() == secretKey.length()){
					for(int i =0 ;i<encryptedText.length();i++){
						char temp = (char)(encryptedText.charAt(i)-secretKey.charAt(i));
						String newstr = ""+temp;
						decryptedText.append(newstr);
				}
			}
			
			else{
				int diff = encryptedText.length() - secretKey.length();
				int j = 0;
				
				for(int i=0;i<diff;i++){
					char temp = secretKey.charAt(j);
					String temp2 = ""+temp;
					newKey.append(temp2);
					j++;
					if(j == (secretKey.length()))
						j = 0;
				}
				
				System.out.println(newKey);
					
				for(int i =0 ;i<encryptedText.length();i++){
						char temp = (char)(encryptedText.charAt(i)-newKey.charAt(i));
						String newstr = ""+temp;
						decryptedText.append(newstr);
					}
		
			}
			
			System.out.println("Decrypted Text: \n"+decryptedText);
		}
		
		else{
			JFrame parent = new JFrame();

		    JOptionPane.showMessageDialog(parent, "Invalid key");
		}
		String path = "/home/nahush/Dec" + file.getName();
		RandomAccessFile obj = new RandomAccessFile(path,"rw");
		obj.write(decryptedText.toString().getBytes());
		obj.close();
		file1.close();
	}
}
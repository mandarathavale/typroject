//import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Keyaddition {

	//static String tempKey;
	static String key = new String();
	//static StringBuilder newKey = new StringBuilder();
	
		/*public static String init(){
		
		JFrame frame = new JFrame("Enter a key");
		JTextField txt = new JTextField(10);
		JButton accept = new JButton("accept");
		
		//String tempKey;
		frame.setLayout(new FlowLayout());
		
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tempKey = txt.getText();
				//return tempKey;
				frame.dispose();
			}
		});
		
		frame.add(txt);
		frame.add(accept);
		frame.setVisible(true);
		frame.setSize(300, 300);

		return key;
	}*/
	
	
	
	public static void main(String[] args) throws Exception {

		System.out.println("Enter the key: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		key = br.readLine();
		
	
		RandomAccessFile encryptedFile = new RandomAccessFile("/media/nahush/New Volume/EncryptedFiles/Encrypted.txt","rw");
		RandomAccessFile decryptedFile = new RandomAccessFile("/media/nahush/New Volume/DecryptedFiles/Decrypted.txt","rw");
		
		encrypt(decryptedFile,key);
		decrypt(encryptedFile,key);
	}

	
	
	public static void encrypt(RandomAccessFile file, String secretKey)
			throws Exception {
		
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder encryptedText = new StringBuilder();
		
		byte[] plain = new byte[(int) file.length()];
		file.readFully(plain);
		String plainText = new String(plain);
		System.out.println(plainText);
		file.close();
		
		
		if(plainText.length() >= secretKey.length()){
			/*if length of text to be encrypted is equal to length of the 
			 * key entered add characters of the key to the text and append 
			 * the result to the encryptedText string*/
			if(plainText.length() == secretKey.length()){
					for(int i =0 ;i<plainText.length();i++){
						char temp = (char)(plainText.charAt(i)+secretKey.charAt(i));
						String newstr = ""+temp;
						encryptedText.append(newstr);
				}
			}
			/*calculate differance between length of key and text and expand key to 
			 * the length of the text*/
			else{
				int diff = plainText.length() - secretKey.length();
				int j = 0;
				
				for(int i=0;i<diff;i++){
					char temp = secretKey.charAt(j);
					String temp2 = ""+temp;
					newKey.append(temp2);
					j++;
					if(j == (secretKey.length()-1))
						j = 0;
				}
				
				System.out.println("New Key: "+newKey);
					for(int i =0 ;i<plainText.length();i++){
						char temp = (char)(plainText.charAt(i)+newKey.charAt(i));
						String newstr = ""+temp;
						encryptedText.append(newstr);
					}
		
			}
			
			System.out.println("Encrypted Text: \n"+encryptedText);
				
		}
		/*if length of key entered is bigger than length of text to be encrypted
		 * throw error message*/
		else{
			JFrame parent = new JFrame();

		    JOptionPane.showMessageDialog(parent, "INVALID KEY");
			//System.out.println("Invalid Key");
			System.exit(0);
		}
		//Write the encrypted text to the file at the predefined location
		RandomAccessFile obj = new RandomAccessFile("/media/nahush/New Volume/EncryptedFiles/Encrypted.txt","rw");
		obj.write(encryptedText.toString().getBytes());
		obj.close();
	}

	public static void decrypt(RandomAccessFile file, String secretKey) throws IOException
	{	
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder decryptedText = new StringBuilder();
		byte[] encrypted = new byte[(int) file.length()];
		file.readFully(encrypted);
		String encryptedText = new String(encrypted);
		file.close();
		
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
					if(j == (secretKey.length()-1))
						j = 0;
				}
				
				//System.out.println(newKey);
					
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
		    System.exit(0);
		}
		RandomAccessFile obj  = new RandomAccessFile("/media/nahush/New Volume/DecryptedFiles/Decrypted.txt","rw");
		obj.write(decryptedText.toString().getBytes());
		obj.close();
	}
}
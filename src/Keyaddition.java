import java.awt.*;
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
		
		String plainText = "/home/mandar/workspace/Cryptography/src/file.txt";
		
		System.out.println("Enter the key: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		key = br.readLine();
		
		
		//System.out.println("afcadg");
		RandomAccessFile obj = new RandomAccessFile(plainText, "r");
		byte[] plain = new byte[(int) obj.length()];
		obj.readFully(plain);
		String normalText = new String(plain);
		obj.close();
		
		StringBuilder encryptedText = encrypt(normalText,key);
		String encrypted = new String(encryptedText);
		
		obj = new RandomAccessFile("/home/mandar/Files/Encrypted.txt","rw");
		obj.write(encrypted.getBytes());
		obj.close();
		
		/*obj = new RandomAccessFile("/home/mandar/Files/Rot.txt", "r");
		plain = new byte[(int) obj.length()];
		obj.readFully(plain);
		encrypted = new String(plain);
		obj.close();
		*/
		
		
		StringBuilder decryptedText = decrypt(encrypted,key);
		String decrypted = new String(decryptedText);
		
		obj = new RandomAccessFile("/home/mandar/Files/Decrypted.txt","rw");
		obj.write(decrypted.getBytes());
		obj.close();
	
	}

	
	
	public static StringBuilder encrypt(String plainText, String secretKey)
			throws Exception {
		
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder encryptedText = new StringBuilder();
		
		
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
		
		else{
			JFrame parent = new JFrame();

		    JOptionPane.showMessageDialog(parent, "INVALID KEY");
			//System.out.println("Invalid Key");
			System.exit(0);
		}
			
		return encryptedText;
		
		
	}

	public static StringBuilder decrypt(String encryptedText, String secretKey) throws IOException
	{	
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder decryptedText = new StringBuilder();
		
		
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
			
		return decryptedText;
	}
}
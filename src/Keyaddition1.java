import java.io.*;
import javax.swing.*;

public class Keyaddition1 {

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
	
	
	
	public static void main(String[] args) {
		
		
		Keyaddition1 obj = new Keyaddition1();
		try {
			
				obj.init("/home/nahush/Dec/test.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*	File normalText = new File("/home/mandar/workspace/Cryptography/src/file.txt");
		File encryptedText = new File("/home/mandar/Encrypted_Files/file.txt");
		encrypt(normalText,key);
		decrypt(encryptedText,key);*/
		
		
		
	}

	public static void init(String fname) throws Exception{
		
		//String normalfname
		System.out.println("Enter the key: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			key = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		File normalText = new File(fname);
		String efname = "/home/nahush/Enc"+normalText.getName();
		File encryptedText = new File(efname);
	//	encrypt(normalText,key);
	//	decrypt(encryptedText,key);
	}
	
	public void encrypt(File file, String secretKey)
			throws Exception {
		
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder encryptedText = new StringBuilder();
		//BufferedReader br = new BufferedReader(new FileReader(file));
		String plainText;
		//String line = br.readLine();
		
		RandomAccessFile file1 = new RandomAccessFile(file,"rw");
		byte b[] = new byte[(int) file1.length()];
		file1.readFully(b);
		plainText = new String(b);
		/*while(line != null)
		{
			plainText = plainText + line;
			line = br.readLine();
		}*/
		
		
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
			//System.exit(0);
		}
		
		else{
			JFrame parent = new JFrame();

		    JOptionPane.showMessageDialog(parent, "INVALID KEY");
			//System.out.println("Invalid Key");
			//System.exit(0);
		}
		
		
	}

	public void decrypt(File file, String secretKey) throws IOException
	{	
		StringBuilder newKey = new StringBuilder(secretKey);
		StringBuilder decryptedText = new StringBuilder();
		//BufferedReader br = new BufferedReader(new FileReader(file));
		String encryptedText = new String();
			//,line = br.readLine();
		
		RandomAccessFile file1 = new RandomAccessFile(file,"rw");
		byte b[] = new byte[(int) file1.length()];
		file1.readFully(b);
		encryptedText = new String(b);
		
		
		
		
	/*	while(line != null)
		{
			encryptedText = encryptedText + line;
			line = br.readLine();
		}*/
		
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
		  //  System.exit(0);
		}
		//br.close();
		String path = "/home/nahush/Dec" + file.getName();
		RandomAccessFile obj = new RandomAccessFile(path,"rw");
		obj.write(decryptedText.toString().getBytes());
		obj.close();
		//System.exit(0);
		//br.close();
	}
}
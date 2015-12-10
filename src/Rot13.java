import java.io.*;
public class Rot13 {

	
	/*method used to encrypt and decrypt the text file (same fuction performs
	 * both the tasks because the alphabet is just rotated by 13 places)*/ 
	void encrypt(File file) throws IOException
	{
		char c;
		/*StringBuffer object used for fast and more memory efficient 
		concatination within loop*/
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		//read the text file line by line
		while (line != null) {
			for(int i = 0; i < line.length(); i++)
			{
				c = line.charAt(i);
				//check whether the character is from the first 13 alphabets  
				if(c >= 'a' && c <= 'm')
					c += 13;	//shift right by 13 places
				else if(c >= 'm' && c <= 'z')	//check whether the character is from the last 13 alphabets
					c -= 13;	//shift left by 13 places
				else if(c >= 'A' && c <= 'M')
					c += 13;
				else if(c >= 'M' && c <= 'Z')
					c -= 13;
				sb.append(c);	//if character does not belong to the set 
			}					//of alphabets it is directly appended to final string
			sb.append("\n");
            line = br.readLine();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("/media/nahush/New Volume/EncryptedFiles/Encrypted.txt"));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	void decrypt(File file) throws IOException
	{
		char c;
		/*StringBuffer object used for fast and more memory efficient 
		concatination within loop*/
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		//read the text file line by line
		while (line != null) {
			for(int i = 0; i < line.length(); i++)
			{
				c = line.charAt(i);
				//check whether the character is from the first 13 alphabets  
				if(c >= 'a' && c <= 'm')
					c += 13;	//shift right by 13 places
				else if(c >= 'm' && c <= 'z')	//check whether the character is from the last 13 alphabets
					c -= 13;	//shift left by 13 places
				else if(c >= 'A' && c <= 'M')
					c += 13;
				else if(c >= 'M' && c <= 'Z')
					c -= 13;
				sb.append(c);	//if character does not belong to the set 
			}					//of alphabets it is directly appended to final string
			sb.append("\n");
            line = br.readLine();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("/media/nahush/New Volume/DecryptedFiles/Decrypted.txt"));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		Rot13 obj = new Rot13();
		File encryptedFile = new File("/media/nahush/New Volume/EncryptedFiles/Encrypted.txt");
		File decryptedFile = new File("/media/nahush/New Volume/DecryptedFiles/Decrypted.txt");
		//obj.encrypt(decryptedFile);
		obj.decrypt(encryptedFile);
}
}
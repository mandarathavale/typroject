import java.io.*;
public class Rot13 {

	
	/*method used to encrypt and decrypt the text file (same fuction performs
	 * both the tasks because the alphabet is just rotated by 13 places)*/ 
	static void encrypt(File file) throws IOException
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
		System.out.println(sb);
		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/mandar/Encrypted_Files/" + file.getName()));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void decrypt(File file) throws IOException
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
		
		System.out.println(sb);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/mandar/Decrypted_Files/" + file.getName()));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void init(String fname) throws IOException{
		File normalText = new File(fname);
		String efname = "/home/mandar/Encrypted_Files/"+normalText.getName();
		File encryptedText = new File(efname);
		encrypt(normalText);
		decrypt(encryptedText);
	}
	
	public static void main(String[] args) throws IOException {
		Rot13 obj = new Rot13();
		obj.init("/home/mandar/Files/file1.txt");
	}
}
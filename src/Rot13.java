import java.io.*;
public class Rot13 {

	void encrypt(String file) throws IOException
	{
		char c;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while (line != null) {
			for(int i = 0; i < line.length(); i++)
			{
				c = line.charAt(i);
				if(c >= 'a' && c <= 'm')
					c += 13;
				else if(c >= 'm' && c <= 'z')
					c -= 13;
				else if(c >= 'A' && c <= 'M')
					c += 13;
				else if(c >= 'M' && c <= 'Z')
					c -= 13;
				sb.append(c);
			}
			sb.append("\n");
            line = br.readLine();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/mandar/Files/Rot.txt"));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		Rot13 obj = new Rot13();
		obj.encrypt("/home/mandar/Files/Rot.txt");
}
}
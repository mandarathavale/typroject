import java.io.IOException;
import java.io.RandomAccessFile;

//this class contains methods to encode and decode text in binary
public class ASCII {

	//converts the text in the specified file to its binary equivalent 
	public static String encode(String filepath) throws IOException
	{
		StringBuilder binaryString = new StringBuilder(); 
		RandomAccessFile file = new RandomAccessFile(filepath,"rw");
		byte[] bytes = new byte[(int) file.length()];
		file.readFully(bytes);
		//iterate loop for all characters in the text file
		for(byte b : bytes)
		{
			int val = b;
			//iterate loop for all bits of binary
			for(int j = 0; j < 8; j++)
			{
				//check if MSB of binary is 0, if yes append 0 else 1
				binaryString.append((val & 128) == 0 ? 0 : 1);
				//leftshift binary by 1
				val <<= 1;
			}	
		}
		file.close();
		return binaryString.toString();
	}
	
	//converts the given binary string to its text equivalent
	public static String decode(String binaryString) throws IOException
	{
		int value;
		String normalString = "";
		//find out the no. of chunks the binary string is to be split into
		int chunkCount = (binaryString.length() / 8) + (binaryString.length() % 8 == 0 ? 0 : 1);
		String temp = "";
		for(int i=0; i<chunkCount; i++) {
			//group 8 consecutive bits in a chunk
			temp = binaryString.substring(i*8, Math.min((i+1)*8, binaryString.length()));
			//find out the integer value of a chunk
		    value = Integer.parseInt(temp, 2);
		    //typecast integer value to char and append to normal string
		    normalString += (char)value;
		}
		return normalString;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(ASCII.decode(ASCII.encode("/home/mandar/workspace/Cryptography/src/file.txt")));
	}

}
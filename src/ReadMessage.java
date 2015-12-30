import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class ReadMessage
{
	public static void readMessage(String fname) throws IOException
	{
		RandomAccessFile encrypted = new RandomAccessFile("/home/mandar/AfterSteg/temp.txt","rw");
		File image = new File(fname);
		int v = 0,k=0,result;
		BufferedImage bimg = null;
		try
		{
			bimg = ImageIO.read(image);
		} catch(Exception e) { e.printStackTrace(); }
		
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				result = bimg.getRGB(i, j);
				v <<= 1;
				if( (result & 1) != 0)
					v |= 1;
					
				k++;
				if(k==8)
				{
					k=0;
					if((char)v == '#')
					{
						System.out.println("END");
						System.exit(0);
					}
					else{
						String a = ""+(char)v;
						encrypted.writeChars(a);
						System.out.print((char) v);
						v = 0;
					}
					
				}
			}
		}
		encrypted.close();
		System.out.println("END");;

	}
	
	
	public static void main(String[] args) throws IOException
	{
		readMessage(args[0]);
	}
}

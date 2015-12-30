import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.imageio.ImageIO;

public class RetrieveMessage {

	public static void main(String[] args) throws IOException 
	{
		RandomAccessFile obj = new RandomAccessFile("image.txt","rw");
		File image = new File(args[0]);
		BufferedImage bimg = ImageIO.read(image);
		
		String pixel[][] = new String[bimg.getWidth()][bimg.getHeight()];
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				obj.writeBytes( Integer.toBinaryString(bimg.getRGB(i,j)) +"\n");
			}
		}
		obj.close();
	}
}
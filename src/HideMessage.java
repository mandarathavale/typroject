import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
// parameters are: image path, message file path
public class HideMessage {

	public static void main(String[] args) throws IOException {
		char temp;
		String binaryString, binaryBlue;
		File image = new File(args[0]);
		System.out.println(args[0]);
		BufferedImage bimg = ImageIO.read(image);
		int pixel[][] = new int[bimg.getWidth()][bimg.getHeight()];
		binaryString = ASCII.encode(args[1]);
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				System.out.println(Integer.toBinaryString(bimg.getRGB(i, j) & 0xff));
			}
		}
	}

}

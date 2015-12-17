import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
// parameters are: image path, message file path
public class HideMessage {

	public static void main(String[] args) throws IOException {
		char temp;
		StringBuilder binaryBlue = new StringBuilder();
		String binaryString;
		File image = new File(args[0]);
		System.out.println(args[0]);
		BufferedImage bimg = ImageIO.read(image);
		String pixel[][] = new String[bimg.getWidth()][bimg.getHeight()];
		binaryString = ASCII.encode(args[1]);
		int a = 0;
		System.out.println("Before bit adding: ");
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				pixel[i][j] = Integer.toBinaryString(bimg.getRGB(i, j) & 0xff);
				System.out.println(pixel[i][j]);
			}
		}
		label:
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				binaryBlue.append(Integer.toBinaryString(bimg.getRGB(i, j) & 0xff));
				binaryBlue.setCharAt(binaryBlue.length()-1, binaryString.charAt(a));
				pixel[i][j] = binaryBlue.toString();
				a++;
				if(a <= binaryString.length())
					break label;
			}
		}
		System.out.println("After bit adding: ");
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				System.out.println(pixel[i][j]);
			}
		}
	}
}

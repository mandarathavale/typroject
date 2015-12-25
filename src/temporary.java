import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
// parameters are: image path, message file path
public class temporary {

	public static void main(String[] args) throws IOException {
		char temp;
		
		StringBuilder binaryBlue;
		String binaryString;
		File image = new File(args[0]);
		BufferedImage bimg = ImageIO.read(image);
		String pixel[][] = new String[bimg.getWidth()][bimg.getHeight()];
		binaryString = ASCII.encode(args[1]);
		int a = 0;
		String temp1;
		BufferedImage dest = new BufferedImage(bimg.getWidth(),bimg.getHeight(),BufferedImage.TYPE_INT_ARGB);
		
		RandomAccessFile obj = new RandomAccessFile("before.txt","rw");
		RandomAccessFile obj1 = new RandomAccessFile("after.txt","rw");
		
		// Original image data
		for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				pixel[i][j] = Integer.toBinaryString(bimg.getRGB(i, j));
				obj.writeBytes(pixel[i][j]+"\n");
			}
		}
		
		
		int cnt=0;
		//Adding bits inside LSB of blue value of each pixel
		label:
		for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				binaryBlue = new StringBuilder();
				binaryBlue.append(Integer.toBinaryString(bimg.getRGB(i, j)));
				binaryBlue.setCharAt(binaryBlue.length()-1, binaryString.charAt(a));
				pixel[i][j] = binaryBlue.toString();
				System.out.println(pixel[i][j]);
				a++;
				if(a == binaryString.length())
					break label;
			}
		}
		
		//Creating new Image using RGB values of pixels
		for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				obj1.writeBytes(pixel[i][j]+"\n");
				Integer result = temporary1.getstring(pixel[i][j]);
				dest.setRGB(i, j, result);
			}
		}
		
		obj.close();
		obj1.close();
		ImageIO.write(dest, "png", new File("imagefile.png"));
	
		image = new File("imagefile.png");
		bimg = ImageIO.read(image);
		
		a=0;
		StringBuilder new1 = new StringBuilder();
		
		
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				
				pixel[i][j] = Integer.toBinaryString(bimg.getRGB(i, j));
				if((pixel[i][j].charAt(pixel[i][j].length()-1)) == '0')
				{
					new1.append("1");
				}
				else
					new1.append("0");
				
				a++;
				if(a==7)
					a=0;
			}
		}
		
		String temp2 = ASCII.decode(new1.toString());
		
		System.out.println("Displaying retrieved message: \n\n");
		System.out.println(temp2);
	}
}

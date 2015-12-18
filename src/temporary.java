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
		System.out.println(args[0]);
		BufferedImage bimg = ImageIO.read(image);
		String pixel[][] = new String[bimg.getWidth()][bimg.getHeight()];
		binaryString = ASCII.encode(args[1]);
		int a = 0;
		long b;
		
		
		
		String temp1;
		BufferedImage dest = new BufferedImage(bimg.getWidth(),bimg.getHeight(),BufferedImage.TYPE_INT_ARGB);
		
		RandomAccessFile obj = new RandomAccessFile("before.txt","rw");
		RandomAccessFile obj1 = new RandomAccessFile("after.txt","rw");
		
		
		//System.out.println("Before bit adding: ");
		for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				pixel[i][j] = Integer.toBinaryString(bimg.getRGB(i, j));
				//System.out.println(Integer.parseInt(pixel[i][j],2));
			//	System.out.println(pixel[i][j]);
				obj.writeBytes(pixel[i][j]+"\n");
				
			}
		}
		
		
		
		label:
		for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				binaryBlue = new StringBuilder();
				binaryBlue.append(Integer.toBinaryString(bimg.getRGB(i, j)));
				binaryBlue.setCharAt(binaryBlue.length()-1, binaryString.charAt(a));
				pixel[i][j] = binaryBlue.toString();
				a++;
				if(a == binaryString.length())
					break label;
			}
		}
		
		
		
		//System.out.println("After bit adding: ");
		for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				dest.setRGB(i, j, temporary1.getstring(pixel[i][j]));
				obj1.writeBytes(pixel[i][j]+"\n");
			}
		}
		
		obj.close();
		obj1.close();
		
		ImageIO.write(dest, "png",new File("imagefile.png"));
		//ImageIO.write(arg0, arg1, arg2)
	
	
		image = new File("imagefile.png");
		bimg = ImageIO.read(image);
		
		a=0;
		StringBuilder new1 = new StringBuilder();
		/*for(int i=0; i<bimg.getHeight(); i++)
		{
			for(int j=0; j<bimg.getWidth(); j++)
			{
				
				pixel[i][j] = Integer.toBinaryString(bimg.getRGB(i, j));
				new1.append(pixel[i][j].charAt(pixel[i][j].length()-1));
				a++;
				if(a==7)
					a=0;
				
				
				//System.out.println(pixel[i][j]);
			}
		}*/
		int j=0;
		while(true){
			
			pixel[0][j] = Integer.toBinaryString(bimg.getRGB(0, j));
			new1.append(pixel[0][j].charAt(pixel[0][j].length()-1));
			j++;
			a++;
			if(a==7)
				break;
		}
	
		System.out.println(new1.toString());
	
	
	}
}

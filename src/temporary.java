import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
// parameters are: image path, message file path
public class temporary {

	public static void init(String imagepath,RandomAccessFile filepath) throws IOException{
		StringBuilder binaryBlue;
		String binaryString;
		
		String array[] = imagepath.split("/");
		System.out.println(array[array.length-1]);
		String imagename1 = array[array.length-1];
		array = imagename1.split("\\.");
		System.out.println(array[array.length-1]);
		
		File image = new File(imagepath);
		BufferedImage bimg = ImageIO.read(image);
		String pixel[][] = new String[bimg.getWidth()][bimg.getHeight()];
		//RandomAccessFile msgfile = new RandomAccessFile(filepath,"rw");
		binaryString = ASCII.encode(filepath);
		//BufferedImage dest = new BufferedImage(bimg.getWidth(),bimg.getHeight(),bimg.getType());
		BufferedImage dest = new BufferedImage(bimg.getWidth(),bimg.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
		RandomAccessFile obj1 = new RandomAccessFile("after.txt","rw");
//     	Original image data
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				pixel[i][j] = Integer.toBinaryString(bimg.getRGB(i, j));
//				obj.writeBytes(pixel[i][j]+"\n");
			}
		}
		//Adding bits inside LSB of blue value of each pixel
		int a = 0;
		label:
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				binaryBlue = new StringBuilder();
				binaryBlue.append(pixel[i][j]);
				binaryBlue.setCharAt(binaryBlue.length()-1, binaryString.charAt(a));
				pixel[i][j] = binaryBlue.toString();
				a++;
				if(a == binaryString.length())
					break label;
			}
		}
		//Creating new Image using RGB values of pixels
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				int result = (int) Long.parseLong(pixel[i][j],2);
				obj1.writeBytes( Integer.toBinaryString(result) + "\n");
				dest.setRGB(i, j, result);
			}
		}
		obj1.close();
		
		image = new File("/home/mandar/Steg/"+imagename1);
		ImageIO.write(dest, array[array.length-1], image);
	}
}
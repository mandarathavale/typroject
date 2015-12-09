import java.net.*;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;

public class ImageC {

	public static void main(String args[]) throws Exception
	{
		Socket socket = new Socket("localhost",60000);
		
		OutputStream outputstream = socket.getOutputStream();
		BufferedImage image = ImageIO.read(new File("C:\\Users\\Mandar\\Documents\\YouCam\\mandar.jpg"));
		
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ImageIO.write(image,"jpg", bao);
		//byte[] abc = ByteBuffer.allo
		byte[] size = ByteBuffer.allocate(4).putInt(bao.size()).array();
		outputstream.write(size);
		outputstream.write(bao.toByteArray());
		outputstream.flush();
		
		//Thread.sleep(1200000);
		socket.close();
	}
}
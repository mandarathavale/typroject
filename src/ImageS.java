import java.net.*;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class ImageS 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(60000);
		Socket socket = server.accept();
		InputStream inputstream = socket.getInputStream();
		byte[] sizeArr = new byte[8192];
		inputstream.read(sizeArr);
		int size = ByteBuffer.wrap(sizeArr).asIntBuffer().get();
		byte[] imageAr = new byte[size];
		inputstream.read(imageAr);
		System.out.println("image arr is "+imageAr);
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
		System.out.println("image is "+image);
		ImageIO.write(image, "jpg",new File("/home/mandar/Files/copy.jpg"));
		server.close();
	}
}
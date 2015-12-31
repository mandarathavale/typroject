import java.awt.image.BufferedImage;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
public class Server1 {
ServerSocket serverSocket = null;
Socket socket = null;

public Server1() {
    try {
    	serverSocket = new ServerSocket(6002);
    	socket = serverSocket.accept();
        BufferedImage image = ImageIO.read(socket.getInputStream());
        ImageIO.write(image, "JPG",new File("/home/mandar/Images/copy.jpg"));
		
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    new Server1();
}
}

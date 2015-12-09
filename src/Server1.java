import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

public class Server1 {

ServerSocket serverSocket = null;
Socket socket = null;
DataInputStream dataInputStream = null;

public Server1() {
    try {
  
    	serverSocket = new ServerSocket(6002);
        System.out.println("Server is Waiting for request...");
        socket = serverSocket.accept();
        System.out.println("Connected with: " + socket.getInetAddress());
        dataInputStream = new DataInputStream(socket.getInputStream());
       // System.out.println("Server Read from client: " + dataInputStream.readUTF());
        BufferedImage image = ImageIO.read(socket.getInputStream());
        System.out.println("Server: Image received from client.");

        ImageIO.write(image, "jpg",new File("/home/mandar/Images/copy.jpg"));
		
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    new Server1();
}
}
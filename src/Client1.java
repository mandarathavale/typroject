import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
public class Client1 {
Socket clientSocket = null;
OutputStream outputStream = null;
DataOutputStream dataOutputStream = null;
public Client1() {
    try {
        clientSocket = new Socket("localhost", 6002);
        outputStream = clientSocket.getOutputStream();
        BufferedImage image = ImageIO.read(new File("/home/mandar/Desktop/stego/chitta.jpg"));
        ImageIO.write(image, "JPG", clientSocket.getOutputStream());
        clientSocket.close();
} catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    new Client1();
}
}

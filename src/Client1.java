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
InputStream inputStream = null;

public Client1() {
    try {
        clientSocket = new Socket("localhost", 6002);
        outputStream = clientSocket.getOutputStream();
       // dataOutputStream = new DataOutputStream(outputStream);
        inputStream = clientSocket.getInputStream();

        //dataOutputStream.writeUTF("Hello");
        System.out.println("Client to server says: Hello");
        BufferedImage image = ImageIO.read(new File("HelloNewPic.jpg"));
        ImageIO.write(image, "JPG", clientSocket.getOutputStream());
        System.out.println("Client: Image sent to server");
        clientSocket.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    new Client1();
}
}

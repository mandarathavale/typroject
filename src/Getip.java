import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class Getip {
 
    public static void main(String a[]) throws IOException{
     
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            System.out.println(ipAddr.getHostAddress());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}

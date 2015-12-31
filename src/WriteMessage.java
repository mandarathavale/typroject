import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class WriteMessage
{
	public static void writeMessage(String imagename,String message) throws IOException{
		
		int tempcnt=0;
		File image = new File(imagename);
		BufferedImage bimg = ImageIO.read(image);
		BufferedImage dest = new BufferedImage(bimg.getWidth(), bimg.getHeight(), bimg.getType());
		dest.getGraphics().drawImage(bimg, 0, 0, null);
		
		
		String array[] = imagename.split("/");
		String imagename1 = array[array.length-1];
		array = imagename1.split("\\.");
		//String msg = "Mandar Athavale#";
		//System.out.println(message);
		String msg = message+"#";
		System.out.println("MSG: "+msg);
		//System.out.println(msg);
		//System.out.println("len: "+msg.length());
		int m;
		int k = 0, v, p=7, result=0;
		
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				if( k < msg.length() )
				{
						m = msg.charAt(k);						
						result = dest.getRGB(i, j);
						v = (int) Math.pow(2,p);
						if( (m & v) != 0)
							result |= (v>>p);
						else			
						{				
							if( (result & 1) != 0 )
								result ^= 1;
						}
						//System.out.println(result);
						dest.setRGB(i, j, result);
						tempcnt++;
						p--;
						if( p==-1 )
						{
							p = 7;
							m = msg.charAt(k);
							k++;	
						}
				}
				else
				{
					result = dest.getRGB(i, j);
					dest.setRGB(i, j, result);
					
				} 
			}
		}
		try 
		{ 
			System.out.println("In WRITE");
			image = new File("/home/mandar/Steg/"+imagename1);
			ImageIO.write(dest, array[array.length-1], image); 
		} catch(Exception e) { e.printStackTrace(); }
		
		System.out.println("cnt"+tempcnt);
	}
	
	public static void main(String[] args) throws IOException 
	{
		String msg="";
		RandomAccessFile file1 = new RandomAccessFile(args[1],"rw");
		byte b[] = new byte[(int) file1.length()];
		file1.readFully(b);
		msg = new String(b);
		
		writeMessage(args[0],msg);
		file1.close();
	}
}
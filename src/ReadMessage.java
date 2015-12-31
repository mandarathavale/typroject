import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class ReadMessage
{
	public static File init(String img) throws IOException
	{
	
		File image = new File(img);
		int v = 0, k=0,result;
		BufferedImage bimg = null;
		RandomAccessFile newfile = new RandomAccessFile("/home/mandar/AfterSteg/new.txt","rw");
		
		
		try
		{
			bimg = ImageIO.read(image);
		} catch(Exception e) { e.printStackTrace(); }
		
		label:
		for(int i=0; i<bimg.getWidth(); i++)
		{
			for(int j=0; j<bimg.getHeight(); j++)
			{
				result = bimg.getRGB(i, j);
				v <<= 1;
				if( (result & 1) != 0)
					v |= 1;
					
				k++;
				if(k==8)
				{
					k=0;
					if((char)v == '#')
					{
						break label;
					}
									
					
					else
					{
						System.out.println((char) v);
						//newfile.writeChar(v);
						String s = ""+(char)v;
						newfile.writeBytes(s);
						v = 0;
						
					}
					//try { Thread.sleep(500); } catch(Exception e) { }
				}
			}
		}
		newfile.close();
		return(new File("/home/mandar/AfterSteg/new.txt"));

	}
	
}

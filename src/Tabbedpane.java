
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Tabbedpane {
	
		JButton b1,b2;
		JLabel l1,l2,l3;
		JFrame frame;
		public Tabbedpane() throws IOException {
         
//this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Mandar\\workspace\\encryption\\src\\bin\\cryptography\\yahoo2.jpg")))));
    }
		
		
		public void init(){
	    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame = new JFrame();
	    	frame.setBounds(0,0,screenSize.width, screenSize.height);
			//this.setLayout(null);  
			l1 = new JLabel("Choose to upload file...");
	    	b1 = new JButton("Encrypt File");
	        b2= new JButton("Upload File");
	    	frame.setTitle("Tabbed Pane");
	    	
	    	//UIManager.put("TabbedPane.contentOpaque", false);
	    	
	    	JTabbedPane jtp = new JTabbedPane();
	        frame.getContentPane().add(jtp);
	        //JFileChooser try1 = new JFileChooser("null");
	        b2.setOpaque(true);
	        
	        //jtp.setOpaque(false);
	        
	        JPanel jp1 = new JPanel();
	        JPanel jp2 = new JPanel();
	        jp1.setLayout(null);
	        jp2.setLayout(null);
	        //jp1.setOpaque(false);
	        //jp1.setBackground(new Color(0,0,0,0));
	        //jp2.setOpaque(false);
	        //jp2.setBackground(new Color(0,0,0,0));
	        b1.setBounds(100, 200, 100,20);
	        l1.setBounds(100,100,500,20);
	     
	        b2.setBounds(350,100,100,20);
	        jp2.add(b1);
	        jp1.add(b2);
	        jp1.add(l1);
	        //jp1.add(try1);
	        JLabel label1 = new JLabel();
	        label1.setText("Click here to Upload a file -->");
	        label1.setBounds(500,10,100,20);
	        JLabel label2 = new JLabel();
	        label2.setText("You are in area of Tab2");
	        
	        b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					File_chooser obj = new File_chooser();
					obj.init();
				}
			});
	        
	       
	        //jp1.setBackground(Color.GRAY);
	       // jp1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Mandar\\workspace\\encryption\\src\\bin\\cryptography\\yahoo2.jpg")))));
	        //jp2.setBackground(Color.GRAY);
	        //jp1.add(label1);
	        //jp2.add(label2);
	      
	        jtp.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=100 marginheight=5>Uploading File</body></html>", jp1);
	        jtp.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=100 marginheight=5>Encrypt & Decrypt</body></html>", jp2);
	        frame.add(jtp);
	        frame.setVisible(true);
	    	
		}
    public static void main(String[] args) throws IOException {
         
        Tabbedpane tp = new Tabbedpane();
        tp.init();
        //tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tp.setVisible(true);
         
    }
}
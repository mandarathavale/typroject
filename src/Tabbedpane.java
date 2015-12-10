
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
	
		JButton b1,b2,b3,b4;
		JLabel l1,l2,l3,l4;
		JTextField filepath,encryptpath,decryptpath,deletepath;
		JFrame frame;
		String path = new String();
		public Tabbedpane() throws IOException {
         
//this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Mandar\\workspace\\encryption\\src\\bin\\cryptography\\yahoo2.jpg")))));
    }
		
		
		public void init(){
	    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame = new JFrame();
			frame.setTitle("Tabbed Pane");
	    	frame.setBounds(0,0,screenSize.width, screenSize.height);  
			
	    	l1 = new JLabel("Choose to Upload file...");
	    	l2 = new JLabel("Choose to Encrypt file");
	    	l3 = new JLabel("Choose to Decrypt file");
	    	l4 = new JLabel("Choose to Delete file...");
	    	
	    	b1 = new JButton("Encrypt File");
	        b2 = new JButton("Upload File");
	        b3 = new JButton("Decrypt File");
	        b4 = new JButton("Delete File");
	        
	        filepath = new JTextField(150);
	        encryptpath = new JTextField(150);
	        decryptpath = new JTextField(150);
	        deletepath = new JTextField(150);
	        
	        JTabbedPane jtp = new JTabbedPane();
	        
	        filepath.setEditable(false);
	        encryptpath.setEditable(false);
	        decryptpath.setEditable(false);
	        deletepath.setEditable(false);
	        
	        l1.setBounds(100,100,500,20);
	        l2.setBounds(100,100,500,20);
	        l3.setBounds(100, 300, 500, 20);
	        l4.setBounds(100,300,500,20);
	        
	        b1.setBounds(750,100,150,20);
	        b2.setBounds(750,100,150,20);
	        b3.setBounds(750, 300, 150, 20);
	        b4.setBounds(750,300,150,20);
	        
	        filepath.setBounds(350,100,300,20);
	        encryptpath.setBounds(350,100,300,20);
	        decryptpath.setBounds(350, 300, 300, 20);
	        deletepath.setBounds(350,300,300,20);
	        
	        frame.getContentPane().add(jtp);
	    	
	    	JPanel jp1 = new JPanel();
	        JPanel jp2 = new JPanel();
	        jp1.setLayout(null);
	        jp2.setLayout(null);
	        //jp1.setBounds(0, 50,screenSize.width , screenSize.height);
	        //jp2.setBounds(0, 50,screenSize.width , screenSize.height);
	        jtp.setBounds(0, 50, screenSize.width, screenSize.height);
	        jp2.add(b1);
	        jp1.add(b2);
	        jp1.add(l1);
	        jp1.add(filepath);
	        jp2.add(encryptpath);
	        jp2.add(l2);
	        jp2.add(l3);
	        jp2.add(decryptpath);
	        jp2.add(b3);
	        jp1.add(b4);
	        jp1.add(deletepath);
	        jp1.add(l4);
	        //jp1.add(try1);
	        //JLabel label1 = new JLabel();
	        //label1.setText("Click here to Upload a file -->");
	        //label1.setBounds(500,10,100,20);
	        
	        b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					File_chooser obj = new File_chooser();
					path = obj.init();
					filepath.setText(path);
				}
			});
	        
	        
	       
	        //jp1.setBackground(Color.GRAY);
	       // jp1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Mandar\\workspace\\encryption\\src\\bin\\cryptography\\yahoo2.jpg")))));
	        //jp2.setBackground(Color.GRAY);
	        //jp1.add(label1);
	        //jp2.add(label2);
	      
	        jtp.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Uploading File</body></html>", jp1);
	        jtp.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Encrypt & Decrypt</body></html>", jp2);
	        
	        frame.add(jtp);
	        frame.setVisible(true);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
    public static void main(String[] args) throws IOException {
         
        Tabbedpane tp = new Tabbedpane();
        tp.init();
        //tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tp.setVisible(true);
         
    }
}
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class temp {
	
	JFrame frame;
	JPanel p1, p2, p3, p4;
	JTabbedPane tp1 , tp2;
	
	public void init()
	{
		Dimension reso = Toolkit.getDefaultToolkit().getScreenSize();
		tp1 = new JTabbedPane();
		tp2 = new JTabbedPane();
		frame = new JFrame();
		frame.setBounds(0, 0, reso.width, reso.height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1 = new JPanel();
		//p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p1.setLayout(null);
		//p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		frame.getContentPane().add(tp2);
		frame.add(p1);
		
		p1.setBounds(0, 0, reso.width, 3*(reso.height/4));
		
		tp2.setBounds(0, (reso.height/4), reso.width, (reso.height));
		//tp1.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Panel 1</body></html>", p1);
		//tp1.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Panel 2</body></html>", p2);
		tp2.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Panel 3</body></html>", p3);
		tp2.addTab("<html><body leftmargin=50 topmargin=8 marginwidth=80 marginheight=5>Panel 4</body></html>", p4);
	}
	
	public static void main(String[] args) {
		temp obj = new temp();
		obj.init();
	}
}

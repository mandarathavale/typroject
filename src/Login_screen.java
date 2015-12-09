import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;
import javax.imageio.*;

public class Login_screen extends JFrame {
	
	final String adminid="admin",adminpass="admin";
	JTextField login;
	JLabel title,id,pass,sign,forg;
	JPasswordField passwd;
	JButton log,pss,signup,forgot;
	//Image i1;
	//private Image backgroundImage = ImageIO.read(new File("image1.png"));
	
	
	
	void init() throws IOException
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0,0,screenSize.width, screenSize.height);
		this.setLayout(null);
		login = new JTextField(20);
		title = new JLabel("Cryptography");
		title.setFont(new Font("Serif", Font.BOLD, 50));
		id = new JLabel("USER ID: ");
		pass = new JLabel("PASSWORD: ");
		passwd = new JPasswordField(16);
		log = new JButton("LOGIN");
		pss = new JButton("RESET");
		signup = new JButton("SIGNUP");
		sign = new JLabel("New to this site? ---->>");
		forg = new JLabel("Forgot your Password??");
	
		
		
		pss.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login.setText("");
				passwd.setText("");
				}
		});
		
		forg.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e)
			{
				Forgot_pass obj = new Forgot_pass();
				obj.init();
			}
			
		});
		
		title.setBounds(0,0,400,200);//label
		title.setForeground(Color.WHITE);
		forg.setForeground(Color.WHITE);
		pass.setBounds(500, 350, 100, 20);//label
		pass.setForeground(Color.WHITE);
		id.setBounds(500,300,100,20);//label
		id.setForeground(Color.WHITE);
		login.setBounds(600, 300, 150, 20);//tf
		passwd.setBounds(600, 350, 150, 20);//tf
		
		log.setBounds(500, 400, 100, 20);//button
		pss.setBounds(650,400, 100,20);//button
		
		sign.setBounds(500,450,200,20);
		sign.setForeground(Color.WHITE);
		
		sign.setFont(new Font("Serif", Font.BOLD, 16));
		signup.setBounds(700,450,100,20);
		forg.setBounds(500,500,250,35);
		
		forg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		log.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pss.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				// TODO Auto-generated method stub
				Signup_form obj = new Signup_form();
				dispose();
				try {
					obj.init();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		/*log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String st1=login.getText();
				text_pattern=Pattern.compile("[a-zA-Z]{2,10}");
				mat_matcher=text_pattern.matcher(st1);
				if(!mat_matcher.matches())
				{
					if(!st1.isEmpty())
					{
						fnameerror_label.setText("* Invalid first name");
					}
					fnameerror_label.setVisible(true);
					flag=true;
				}
					
				/*String st2=ln_textfield.getText();
				text_pattern=Pattern.compile("[a-zA-Z]{2,10}");
				mat_matcher=text_pattern.matcher(st2);
				if(!mat_matcher.matches())
				{
					if(!st2.isEmpty())
					{
						lnameerror_label.setText("* Invalid last name");
					}
					lnameerror_label.setVisible(true);
					flag=true;
				}
					
				String st3=username_textfield.getText();
				username_pattern=Pattern.compile("[a-zA-Z0-9a-zA-Z]{2,10}");			
				contact_matcher=username_pattern.matcher(st3);
				if(!contact_matcher.matches())
				{
					if(!st3.isEmpty())
					{
						usernameerror_label.setText("* Invalid contact number");
					}
					usernameerror_label.setVisible(true);
					flag=true;
				}
				
				String st4=email_textfield.getText();
				email_pattern=Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				email_matcher=email_pattern.matcher(st4);
				if(!email_matcher.matches())
				{
					if(!st4.isEmpty())
					{
						emailerror_label.setText("* Invalid email id");
					}
					emailerror_label.setVisible(true);
					flag=true;
				}
				*/	
	/*			String st5=uname_textfield.getText();
				contact_pattern=Pattern.compile("[0-9]{8,13}");
				username_matcher=username_pattern.matcher(st5);
				if(!username_matcher.matches())
				{
					if(!st5.isEmpty())
					{
						usernameerror_label.setText("* Invalid User name");
					}
					usernameerror_label.setVisible(true);
					flag=true;
				}*/
				
	/*			String st6=pw_textfield.getText();
				password_pattern=Pattern.compile("[a-z0-9A-Z]{2,10}");
				password_matcher=password_pattern.matcher(st6);
				if(!password_matcher.matches())
				{
					if(!st6.isEmpty())
					{
						passworderror_label.setText("* Invalid Password");
					}
					passworderror_label.setVisible(true);
					flag=true;
				}
				
			}
		});
	*/	
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/home/mandar/workspace/Cryptography/src/yahoo2.jpg")))));
		
		add(title);
		add(id);
		add(pass);
		add(login);
		add(passwd);
		add(log);
		add(pss);
		add(signup);add(sign);add(forg);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		
	}
	
	/*public void paint( Graphics g ) { 
	    super.paint(g);
	    g.drawImage(backgroundImage, 0, 0, null);
	  }*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Login_screen obj = new Login_screen();
		obj.init();
	}

}
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Signup_form{

	JTextField name,email,userid,answer;
	JLabel name1,email1,userid1,passwd,passwd1,signup,sec,ans;
	JButton submit,reset,back;
	JComboBox securityQ;
	JPasswordField pass,pass1;
	JFrame frame;

	Signup_form()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
	}
	void init() throws IOException
	{
		//frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screenSize.width, screenSize.height);
		frame.setLayout(null);  
		
		
		name = new JTextField(50);
		email = new JTextField(20);
		userid = new JTextField(20);
		pass = new JPasswordField(20);
		answer = new JTextField(20);
		pass1 = new JPasswordField(20);
		
		name1 = new JLabel("Name: ");
		email1 = new JLabel("Email id: ");
		userid1 = new JLabel("User id: ");
		passwd = new JLabel("Choose Password: ");
		passwd1 = new JLabel("Confirm Password: ");
		signup = new JLabel("SIGNUP NOW!");
		signup.setFont(new Font("Serif", Font.BOLD, 20));
		ans = new JLabel("Answer to your question: ");
		
		
		submit = new JButton("Submit");
		reset = new JButton("Reset");
		sec = new JLabel("Choose your security question: ");
		back = new JButton("Back");
				
		DefaultComboBoxModel securityq = new DefaultComboBoxModel();

	      securityq.addElement("What was your first school?");
	      securityq.addElement("What was the name of your first pet?");
	      securityq.addElement("What was you mother's maiden name?");
	      securityq.addElement("Where were you born?");

	      securityQ = new JComboBox(securityq);

		
		signup.setBounds(0,0,200,50);
		
		name.setBounds(500,200,150,20);
		name1.setBounds(300,200,250,20);
		
		email1.setBounds(300,250,250,20);
		email.setBounds(500,250,150,20);
		
		userid1.setBounds(300,300,250,20);
		userid.setBounds(500,300,150,20);
		
		passwd.setBounds(300,350,250,20);
		pass.setBounds(500,350,150,20);
		
		passwd1.setBounds(300,400,250,20);
		pass1.setBounds(500,400,150,20);
		
		sec.setBounds(300,450,250,20);
		securityQ.setBounds(550,450,250,20);
		
		ans.setBounds(300,480,250,20);
		answer.setBounds(550,480,250,20);
		
		
		submit.setBounds(300,550,100,20);
		reset.setBounds(600,550,100,20);
		
		back.setBounds(50,50,70,20);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  Login_screen obj = new Login_screen();
		    		try {
						frame.dispose();
		    			obj.init();
		    			
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				name.setText("");
				userid.setText("");
				email.setText("");
				pass.setText("");
				answer.setText("");
				pass1.setText("");
				securityQ.setSelectedIndex(0);
			}
		});
		
		frame.add(signup);frame.add(name);frame.add(name1);
		frame.add(email);frame.add(email1);frame.add(userid1);frame.add(userid);frame.add(passwd);
		frame.add(pass);
		frame.add(passwd1);frame.add(pass1);frame.add(securityQ);frame.add(sec);frame.add(answer);
		frame.add(ans);frame.add(submit);frame.add(reset);
		frame.add(back);
		//this.setBackground(Color.CYAN);	
		//this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/media/sanket/8052954552954138/cryptography/keepcalm.jpg")))));
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Signup_form obj = new Signup_form();
		obj.init();
	}
	

}
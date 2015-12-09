import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup_form{

	JTextField name,email,userid,answer;
	JLabel name1,email1,userid1,passwd,passwd1,signup,sec,ans,answererror_label,nameerror_label,usernameerror_label,emailerror_label,passworderror_label,passconform_label,submiterror_label,reseterror_label;
;
	JButton submit,reset,back;
	JComboBox securityQ;
	JPasswordField pass,pass1;
	JFrame frame;


	Pattern name_pattern,email_pattern,username_pattern,password_pattern,answer_pattern;
	Matcher mat_matcher,email_matcher,username_matcher,password_matcher,answer_matcher;
	
	
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
		
		nameerror_label = new JLabel("*");
		usernameerror_label = new JLabel("*");
		emailerror_label = new JLabel("*");
		passworderror_label = new JLabel("*");
		passconform_label = new JLabel("*");
		answererror_label = new JLabel("*");		
		
		nameerror_label.setForeground(Color.red);
		usernameerror_label.setForeground(Color.red);
		emailerror_label.setForeground(Color.red);
		passworderror_label.setForeground(Color.red);
		passconform_label.setForeground(Color.red);
		answererror_label.setForeground(Color.red);
		
		passconform_label.setVisible(false);
		emailerror_label.setVisible(false);
		nameerror_label.setVisible(false);
		usernameerror_label.setVisible(false);
		passworderror_label.setVisible(false);
		answererror_label.setVisible(false);
		
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
		nameerror_label.setBounds(700,200,150,20);
		
		email1.setBounds(300,250,250,20);
		email.setBounds(500,250,150,20);
		emailerror_label.setBounds(700,250,150,20);
		
		userid1.setBounds(300,300,250,20);
		userid.setBounds(500,300,150,20);
		usernameerror_label.setBounds(700,300,150,20);
		
		passwd.setBounds(300,350,250,20);
		pass.setBounds(500,350,150,20);
		passworderror_label.setBounds(700,350,150,20);
		
		passwd1.setBounds(300,400,250,20);
		pass1.setBounds(500,400,150,20);
		passconform_label.setBounds(700,400,400,20);
		
		sec.setBounds(300,450,250,20);
		securityQ.setBounds(550,450,250,20);
		
		ans.setBounds(300,480,250,20);
		answer.setBounds(550,480,250,20);
		answererror_label.setBounds(850,480,400,20);
		
		submit.setBounds(300,550,100,20);
		reset.setBounds(600,550,100,20);
		
		back.setBounds(50,50,70,20);
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean flag = false;
				
				String st1=name.getText();										//name pattern
				name_pattern=Pattern.compile("[a-zA-Z] [a-zA-Z]");
				mat_matcher=name_pattern.matcher(st1);
				if(!mat_matcher.matches())
				{
					if(!st1.isEmpty())
					{
						nameerror_label.setText("* Invalid name");
					}
					nameerror_label.setVisible(true);
					flag=true;
				}
				
				String st3=userid.getText();									//userid pattern
				username_pattern=Pattern.compile("[a-zA-Z0-9a-zA-Z]{8,10}");			
				username_matcher = username_pattern.matcher(st3);
				if(!username_matcher.matches())
				{
					if(!st3.isEmpty())
					{
						usernameerror_label.setText("* Invalid userid");
					}
					usernameerror_label.setVisible(true);
					flag=true;
				}
				
				
				String st4=email.getText();										//email pattern
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
				
				String st6 = pass.getText();									//password
				password_pattern=Pattern.compile("[a-z0-9A-Z]{8,10}");
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
				else
				{
					String st7 = pass1.getText();
					if(!st7.equals(st6))
					{
						passconform_label.setText("* Password not matching");
					}
					passconform_label.setVisible(true);
					flag = true;
				}
				
				String st8 = ans.getText();
				answer_pattern = Pattern.compile("[a-zA-Z]");
				answer_matcher = answer_pattern.matcher(st8);
				
				if(!answer_matcher.matches())
				{
					if(!st8.isEmpty())
					{
						answererror_label.setText("* answer field should not be empty");
					}
					answererror_label.setVisible(true);
					flag = true;
				}
				
			}
		});
		
		
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
		frame.add(emailerror_label);
		frame.add(nameerror_label);
		frame.add(passconform_label);
		frame.add(passworderror_label);
		frame.add(usernameerror_label);
		frame.add(answererror_label);
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
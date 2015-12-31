import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Login_screen {
	
	final String adminid="admin",adminpass="admin";
	JTextField login;
	JFrame frame;
	JLabel title,id,pass,sign,forg,passerror_label,useriderror_label;
	JPasswordField passwd;
	JButton log,pss,signup,forgot;
	Pattern pass_pattern,userid_pattern;
	Matcher mat_matcher;
	
	void init() throws IOException
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("Login");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0,0,screenSize.width, screenSize.height);
		frame.setLayout(null);
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
		useriderror_label = new JLabel("*");
		passerror_label = new JLabel("*");	
		
		pss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setText("");
				passwd.setText("");
				}
		});
		
		forg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				frame.dispose();
				Forgot_pass obj = new Forgot_pass();
				obj.init();
			}
		});
		
		title.setBounds(0,0,400,200);//label
		title.setForeground(Color.WHITE);
		
		forg.setForeground(Color.WHITE);
		forg.setBounds(500,500,250,35);
		forg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		pass.setBounds(500, 350, 100, 20);//label
		pass.setForeground(Color.WHITE);
		
		id.setBounds(500,300,100,20);//label
		id.setForeground(Color.WHITE);
		
		login.setBounds(600, 300, 150, 20);//tf
		passwd.setBounds(600, 350, 150, 20);//tf
		
		log.setBounds(500, 400, 100, 20);//button
		log.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		pss.setBounds(650,400, 100,20);//button
		pss.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		sign.setBounds(500,450,200,20);
		sign.setForeground(Color.WHITE);
		sign.setFont(new Font("Serif", Font.BOLD, 16));
		
		signup.setBounds(700,450,100,20);
		signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		signup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0){
				frame.dispose();
				Signup_form obj = new Signup_form();
				
				try {
					obj.init();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		log.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				String st1 = login.getText();
				String st2 = passwd.getText();
				
				try
				{
					DBManager1 db1= new DBManager1();
					db1.loader();
					db1.getConnection();
					String query="select * from usertab1 where user_id='"+st1+"'"+"and pass='"+st2+"'";
					ResultSet rs1=db1.fetchQuery(query);
					if(rs1.next())
					{	
						int id=rs1.getInt(1);
						frame.dispose();
						Tabbedpane obj = new Tabbedpane();
						obj.init(id);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Login not successful");
						frame.dispose();
						Login_screen obj = new Login_screen();
						obj.init();    
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					e1.getMessage();
				}
			}
		});
		
		frame.setContentPane(new JLabel(new ImageIcon("/home/nahush/workspace/typroject/src/coderain.gif")));
		frame.add(title);
		frame.add(id);
		frame.add(pass);
		frame.add(login);
		frame.add(passwd);
		frame.add(log);
		frame.add(pss);
		frame.add(signup);frame.add(sign);frame.add(forg);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {

		Login_screen obj = new Login_screen();
		obj.init();
	}
}
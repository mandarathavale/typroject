import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Forgot_pass {
	
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField answer,userid;
	JPasswordField pass,pass1;
	JButton submit1,reset,submit2,back;
	JPanel p1;
	JFrame frame;
	
	void init()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setBounds(0,0,screenSize.width, screenSize.height);
		frame.setLayout(null);  
		
		DefaultComboBoxModel securityq = new DefaultComboBoxModel();

	      securityq.addElement("What was your first school?");
	      securityq.addElement("What was the name of your first pet?");
	      securityq.addElement("What was you mother's maiden name?");
	      securityq.addElement("Where were you born?");

	      final JComboBox securityQ = new JComboBox(securityq);
	      p1 = new JPanel();
	      p1.setLayout(null);
	      
	      
	      l1 = new JLabel("Forgot Your Password? No Problem...");
	      l1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
	      
	      l2 = new JLabel("Choose you security question: ");
	      l3 = new JLabel("Answer: ");
	      l4 = new JLabel("Enter new Password: ");
	      l5 = new JLabel("Confirm Password: ");
	      l6 = new JLabel("Enter User id: ");
	      
	      userid = new JTextField(40);
	      answer = new JTextField(40);
	      pass = new JPasswordField(20);
	      pass1 = new JPasswordField(20);
	      submit1 = new JButton("SUBMIT");
	      submit2 = new JButton("SUBMIT");
	      reset = new JButton("RESET");
	      back = new JButton("BACK");
	    		  
	      securityQ.setSelectedIndex(0);
	      
	      back.setBounds(50,50,70,20);
	      
	      l6.setBounds(400,200,150,20);
	      userid.setBounds(550,200,250,20);
	      
	      l2.setBounds(400,250,250,20);
	      securityQ.setBounds(650, 250, 300, 20);
	      l1.setBounds(0,0,500,300);
	      
	      l3.setBounds(400, 300, 100, 20);
	      answer.setBounds(550,300,100,20);
	      
	      l4.setBounds(400,450,180,20);	      pass.setBounds(550,450,100,20);
	      
	      l5.setBounds(400,500,200,20);
	      pass1.setBounds(550,500,100,20);
	      
	      l4.setVisible(false);
	      l5.setVisible(false);
	      pass.setVisible(false);
	      pass1.setVisible(false);
	      submit2.setVisible(false);
	      submit1.setBounds(400,350,100,20);
	      submit2.setBounds(400,600,100,20);
	      reset.setBounds(550,350,100,20);
	      
	      reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				securityQ.setSelectedIndex(0);
				userid.setText("");
				pass.setText("");
				pass1.setText("");
				answer.setText("");
				
			}
		});
	      
	      back.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
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
	      
	      
	      
	      
	      
	      submit1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			      l4.setVisible(true);
			      l5.setVisible(true);
			      pass.setVisible(true);
			      pass1.setVisible(true);
			      submit2.setVisible(true);
			}
		});
	      
	      p1.add(securityQ);
	      p1.add(l1);
	      p1.add(l2);
	      p1.add(l3);
	      p1.add(l4);
	      p1.add(l4);
	      p1.add(l5);
	      p1.add(pass1);
	      p1.add(answer);
	      p1.add(pass);
	      p1.add(submit1);
	      p1.add(submit2);
	      p1.add(reset);
	      p1.add(l6);
	      p1.add(userid);
	      p1.add(back);
	      p1.setBounds(0,0,10000,10000);
	      p1.setBackground(Color.WHITE);
	      
	      frame.add(p1);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     // frame.setResizable(false);
	      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	      //this.dispose();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Forgot_pass obj = new Forgot_pass();
		obj.init();
	}

}

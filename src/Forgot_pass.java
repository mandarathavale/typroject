import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Forgot_pass {
	
	JLabel l1,l2,l3,l4,l5,l6,passworderror_label,passworderror_label1;
	JTextField answer,userid;
	JPasswordField pass,pass1;
	JButton submit1,reset,submit2,back;
	JPanel p1;
	JFrame frame;
	int id;
	Pattern password_pattern;
	Matcher password_matcher;
	DBManager1 db1= new DBManager1();
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
	      passworderror_label = new JLabel("*");
	      passworderror_label.setForeground(Color.red);
	      passworderror_label.setVisible(false);
	      passworderror_label1 = new JLabel("*");
	      passworderror_label1.setForeground(Color.red);
	      passworderror_label1.setVisible(false);
	      
	      
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
	      passworderror_label.setBounds(700,450,300,20);
	      passworderror_label1.setBounds(700,500,300,20);
	      
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

				String st1 = userid.getText();
				String st2 = securityQ.getSelectedItem().toString();
				String st3 = answer.getText();
				
				System.out.println(st1+st2+st3);
				try
				{
					
					db1.loader();
					db1.getConnection();
					
					String query= "select * from usertab1 where user_id='"+st1+"'"+"and sec_q='"+st2+"'"+"and sec_a='"+st3+"'";
					
					ResultSet rs1=db1.fetchQuery(query);
					
					if(rs1.next())
					{
						  l4.setVisible(true);
					      l5.setVisible(true);
					      pass.setVisible(true);
					      pass1.setVisible(true);
					      submit2.setVisible(true);
					      id=rs1.getInt(1);
					 }
					else
					{
						JOptionPane.showMessageDialog(null,"Login not successful");
						Login_screen obj = new Login_screen();
						frame.dispose();    
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					e1.getMessage();
				}
			}
		});
	      
	      
	      submit2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				passworderror_label.setVisible(false);
				passworderror_label1.setVisible(false);
				boolean flag = false;
				
				String st6 = pass.getText();									//password
				String st7 = pass1.getText();	
				
				password_pattern=Pattern.compile("[a-z0-9A-Z]{6,10}");
				password_matcher=password_pattern.matcher(st6);
				
				if(!password_matcher.matches())
				{
					if(!st6.isEmpty())
					{
						passworderror_label.setText("* Invalid Password minimum len is 8");
					}
					passworderror_label.setVisible(true);
					flag=true;
				}
				
				if(!st7.equals(st6))
				{
					System.out.println("not matching");
					passworderror_label1.setText("* Password not matching");
					passworderror_label1.setVisible(true);
					flag=true;
				}
				
				if(!flag)
				{
					try
					{
						DBManager1 db1= new DBManager1();
						db1.loader();
						db1.getConnection();
					
						String query="update usertab1 set pass='"+st6+"'"+"where id='"+id+"'";
						
						int num = db1.updateRecord(query);
						System.out.println("num"+num);
						if(num == 1)
						{
							JOptionPane.showMessageDialog(null, "Inserted Succesfully");
							frame.dispose();
							Login_screen obj = new Login_screen();
							obj.init();
						}
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					
				}
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
	      
	      p1.add(passworderror_label);p1.add(passworderror_label1);
	      p1.setBounds(0,0,10000,10000);
	      p1.setBackground(Color.WHITE);
	      
	      frame.add(p1);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     // frame.setResizable(false);
	      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	      //this.dispose();

	}


}

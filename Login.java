package javaSwing;

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;


public class Login extends JFrame implements ActionListener {
	
	private static JButton login;
	private static JTextField email ;
	private static JPasswordField password ;
	
	Login(){
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.getContentPane().setBackground(new Color(0x383838));
		this.setTitle("Muslim podcast");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		 JLabel skip=new JLabel("SKIP ->") ; 
		 skip.setBounds(1250,20,225,43);
		 skip.setForeground(Color.WHITE);
		 skip.setFont(new Font ("Tahoma",Font.BOLD,20));
		 this.add(skip);
		 skip.addMouseListener(new MouseAdapter()  
			{  
			    public void mouseClicked(MouseEvent e)  
			    {  
			       // you can open a new frame here as
			       // i have assumed you have declared "frame" as instance variable
					System.out.println("2");
					Home home = new Home();
					home.show();
					dispose();
					

			    }  
			}); 
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x383838));
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome back, ready to listen to ");
		welcome.setBounds(494, 145, 350,200);
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel.add(welcome);
		
		JLabel welcome2 = new JLabel("our latest podcasts?");
		welcome2.setBounds(565, 215, 350,105);
		welcome2.setForeground(Color.WHITE);
		welcome2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(welcome2);
		
		email = new JTextField();
		email.setBorder(null);
		 
		email.setEnabled(true);
		panel.add(email);
		
		email.setBounds(500, 300, 327,48);
		
		password= new JPasswordField();
		password.setBorder(null);
		password.setBounds(500, 360, 327,48);
		password.setEnabled(true);
		panel.add(password);
               
		 
		 
		 
		 
		
		login = new JButton("Login");
		login.setBorder(null);
		login.setBounds(500, 430, 327, 48);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.GREEN);
		login.setFont(new Font("Tahoma", Font.BOLD, 17));
		login.addActionListener(this);
		panel.add(login);

		
		JPanel message = new JPanel();
		message.setBackground(new Color(0x383838));
		panel.add(message);
		message.setBounds(460, 480, 400, 43);
		message.setLayout(new FlowLayout());
		
		JLabel account = new JLabel("You don't have an account ?");
		
		account.setForeground(Color.WHITE);
		account.setFont(new Font("Tahoma", Font.BOLD, 17));
		message.add(account);
		
		JLabel register = new JLabel("register here");
		register.setForeground(Color.GREEN);
		register.setFont(new Font("Tahoma", Font.BOLD, 17));
		message.add(register);
		register.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
				System.out.println("2");
				SignUp signUp = new SignUp();
				signUp.show();
				dispose();
				

		    }  
		}); 
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {

	
	     new Login();
		 
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			loginFunction();
			System.out.println("2");
		}
	}
	
	private void loginFunction() {
        String emailStr = email.getText();
        String passwordStr = String.valueOf(password.getPassword());
     
        
        if (emailStr.isEmpty() || passwordStr.isEmpty() ) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        checkLogin(emailStr,passwordStr);

      
	}
	
	private void checkLogin( String email, String password) {
        
        final String DB_URL = "jdbc:mysql://localhost/ihm";
        final String USERNAME = "root";
        final String PASSWORD = "";
        
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            
            String query = "select * from user where email = '" + email + "'  and password ='" + password + "' ";//Storing MySQL query in A string variable
            ResultSet resultSet = stmt.executeQuery(query);//executing query and storing result in ResultSet
            
            if(resultSet.next() == false) {
            	JOptionPane.showMessageDialog(this,
                        "account doesnt exist",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
               
            }
            else {
            	JOptionPane.showMessageDialog(this,
                        "account exist",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                
            }
            
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
     
	}

}

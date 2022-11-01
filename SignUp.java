package javaSwing;



import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.*;


public class SignUp extends JFrame implements ActionListener {
	
	private static JTextField email ;
	private static JTextField userName ;
	private static JPasswordField password ;
	private static JPasswordField cPassword ;	
	private static JButton signUp;
	
	SignUp(){
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.getContentPane().setBackground(new Color(0x383838));
		this.setTitle("Muslim podcast");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		JLabel skip = new JLabel("SKIP >");
		skip.setBounds(1250,20,225,43);
		skip.setForeground(Color.WHITE);
		skip.setFont(new Font("Tahoma", Font.BOLD, 20));
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
		panel.setBounds(500,350,350,48);
		
		JLabel welcome = new JLabel("Sign up and start listening to our");
		welcome.setBounds(500, 170, 400, 43);
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel.add(welcome);
		 
		JLabel welcome3 = new JLabel("podcasts anytime");
		welcome3.setBounds(575, 200, 350, 43);
		welcome3.setForeground(Color.WHITE);
		welcome3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(welcome3);
		 
		 
		 
		email = new JTextField();
		email.setBorder(null);
		email.setBounds(494, 255, 350, 48);
		email.setEnabled(true);
		panel.add(email);

		userName = new JTextField();
		userName.setBorder(null);
		userName.setBounds(494, 315, 350,48);
		userName.setEnabled(true);
		panel.add(userName);
		
		 password= new JPasswordField ();
		password.setBorder(null);
		password.setBounds(494, 375, 350, 48);
		password.setEnabled(true);
		panel.add(password);
		
		cPassword= new JPasswordField ();
		cPassword.setBorder(null);
		cPassword.setBounds(494, 435, 350, 48);
		cPassword.setEnabled(true);
		panel.add(cPassword);

		
		signUp = new JButton("SIGN UP");
		signUp.setBorder(null);
		signUp.setBounds(494, 505, 350, 48);
		signUp.setForeground(Color.WHITE);
		signUp.setBackground(Color.GREEN);
		signUp.setFont(new Font("Tahoma", Font.BOLD, 17));
		signUp.addActionListener(this);
		panel.add(signUp);
		
		
		
		
		JPanel message = new JPanel();
		message.setBackground(new Color(0x383838));
		panel.add(message);
		message.setBounds(468, 555, 400, 48);
		message.setLayout(new FlowLayout());
		
		JLabel account = new JLabel("You don't have an account ?");
		account.setForeground(Color.WHITE);
		account.setFont(new Font("Tahoma", Font.BOLD, 17));
		message.add(account);
		
		JLabel login = new JLabel("Login here");
		login.setForeground(Color.GREEN);
		login.setFont(new Font("Tahoma", Font.BOLD, 17));
		message.add(login);
		login.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
				System.out.println("2");
				Login login = new Login();
				login.show();
				dispose();
				

		    }  
		}); 
		this.setVisible(true);
	 
	}
	public static void main(String[] args) {

		new SignUp();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==signUp) {
			System.out.println("1");
			registerUser();
		}
		
	}
	
	private void registerUser() {
		// TODO Auto-generated method stub
		
		System.out.println("2");
		
        String nameStr = userName.getText();
        String emailStr = email.getText();
        String passwordStr = String.valueOf(password.getPassword());
        String confirmPasswordStr = String.valueOf(cPassword.getPassword());
        
        
        
        if (nameStr.isEmpty() || emailStr.isEmpty() || passwordStr.isEmpty()|| confirmPasswordStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!passwordStr.equals(confirmPasswordStr)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
      user =  addUserToDatabase(nameStr, emailStr,  passwordStr);
      if (user != null) {
          dispose();
      }
      else {
          JOptionPane.showMessageDialog(this,
                  "Failed to register new user",
                  "Try again",
                  JOptionPane.ERROR_MESSAGE);
      } 
		
	}
	
	 public User user;
	 private User addUserToDatabase(String name, String email, String password) {
	        User user = null;
	        
	        final String DB_URL = "jdbc:mysql://localhost/ihm";
	        final String USERNAME = "root";
	        final String PASSWORD = "";
	        
	        
	        try{
	            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	            // Connected to database successfully...

	            Statement stmt = conn.createStatement();
	            String sql = "INSERT INTO user (username, email, password) " +
	                    "VALUES (?, ?, ?)";
	            PreparedStatement preparedStatement = conn.prepareStatement(sql);
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, email);
	            preparedStatement.setString(3, password);

	            //Insert row into the table
	            int addedRows = preparedStatement.executeUpdate();
	            if (addedRows > 0) {
	                user = new User();
	                user.name = name;
	                user.email = email;
	                user.password = password;
	            }

	            stmt.close();
	            conn.close();
	            
	            Home home = new Home();
				home.show();
				dispose();
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        return user;
	    }

}

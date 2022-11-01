package javaSwing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame implements ActionListener{
	private static JButton button;
	start(){
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.getContentPane().setBackground(new Color(0x383838));
		this.setTitle("Muslim podcast");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x383838));
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("MUSLIM PODCAST",JLabel.CENTER);
		title.setEnabled(true);
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		title.setForeground(Color.WHITE);
		title.setBounds(495, 257, 420, 118);
		panel.add(title);
		title.setVisible(true);
		 
	 button = new JButton("GET STARTED");
		button.setBounds(593, 445, 225, 43);
		button.setBorder(null);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0x17F24B));
		panel.add(button);
		button.addActionListener(this);
		
		JLabel title2 = new JLabel("A product app that contain a very caeruly");
		title2.setEnabled(true);
		title2.setFont(new Font("Tahoma", Font.BOLD, 25));
		title2.setForeground(Color.WHITE);
		title2.setBounds(448, 353, 537, 43);
		panel.add(title2);
		
		JLabel title3 = new JLabel("chosen audios in the islam topic");
		title3.setEnabled(true);
		title3.setFont(new Font("Tahoma", Font.BOLD, 25));
		title3.setBounds(505, 393, 516, 31);
		title3.setForeground(Color.WHITE);
		panel.add(title3);
		button.setVisible(true);
	}

	public static void main(String[] args) {
new start();


	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			SignUp signUp = new SignUp();
			signUp.show();
			dispose();
		}
		
	}}
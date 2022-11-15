package javaSwing;

import java.awt.*;

import java.awt.event.*;

import javax.sound.sampled.Clip;
import javax.swing.*;


public class Home extends JFrame implements ActionListener{
	public static Clip clip;
	public static JPanel audioControl;
	public static JPanel rightPanel;
	public static AudioController audioControll;
	public static boolean isPlaying=false;
	public static boolean isControllExist=false;
	Home(){
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.getContentPane().setBackground(new Color(0x383838));
		this.setTitle("Muslim podcast");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(null);
		
		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(0x383838));
		rightPanel.setBounds(75, 0, 1600, 1800);
		this.getContentPane().add(rightPanel,BorderLayout.WEST);
		rightPanel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(0x595959));
		leftPanel.setBounds(0, 0, 75, 2000);
		this.getContentPane().add(leftPanel,BorderLayout.EAST);
		leftPanel.setLayout(null);
		
		
		JPanel homeBox = new JPanel();
		homeBox.setBackground(new Color(0x383838));
		homeBox.setBounds(0, 200, 75, 75);
		leftPanel.add(homeBox);

		
		JPanel searchBox = new JPanel();
		searchBox.setBackground(new Color(0x656565));
		searchBox.setBounds(0, 275, 75, 75);
		leftPanel.add(searchBox);
		
		JPanel logOutBox = new JPanel();
		logOutBox.setBackground(new Color(0x656565));
		logOutBox.setBounds(0, 500, 75, 75);
		leftPanel.add(logOutBox);
		
		JPanel popular = new JPanel();
		popular.setBounds(80,20,1400,75);
		popular.setBackground(new Color(0x383838));
		popular.setLayout(null);
		rightPanel.add(popular);
		
		JLabel popularText = new JLabel("Most Popular");
		popularText.setFont(new Font("Tahoma", Font.BOLD, 15));
		popularText.setBounds(0,0,1400,100);
		popularText.setForeground(Color.WHITE);
		popular.add(popularText);
		
		
		JLabel seeAll1 = new JLabel("see all");
		seeAll1.setFont(new Font("Tahoma", Font.BOLD, 15));
		seeAll1.setBounds(1200,0,1400,100);
		seeAll1.setForeground(new Color(0x17F24B));
		popular.add(seeAll1);
		
		JPanel popularCardContainer = new JPanel();
		popularCardContainer.setBounds(80,100,1400,250);
		popularCardContainer.setBackground(new Color(0x383838));
		popularCardContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
		rightPanel.add(popularCardContainer);
		
		JPanel card1 = new JPanel();
		card1.setBackground(new Color(0x595959));
		card1.setPreferredSize(new Dimension(150, 250));
		
		popularCardContainer.add(new PodcastBox(0,"D:\\Users\\Desktop\\ihm\\src\\audio\\amv.wav","amv","17:05",""));
		popularCardContainer.add(new PodcastBox(1,"D:\\Users\\Desktop\\ihm\\src\\audio\\bones.wav","bones","17:05",""));
		popularCardContainer.add(new PodcastBox(2,"D:\\Users\\Desktop\\ihm\\src\\audio\\clouds.wav","clouds","14:05",""));
		
		
		JPanel latest = new JPanel();
		latest.setBounds(80,350,1400,75);
		latest.setBackground(new Color(0x383838));
		latest.setLayout(null);
		rightPanel.add(latest);
		
		JLabel latestText = new JLabel("Latest podcasts");
		latestText.setFont(new Font("Tahoma", Font.BOLD, 15));
		latestText.setBounds(0,0,1400,100);
		latestText.setForeground(Color.WHITE);
		latest.add(latestText);
		
		
		JLabel seeAll2 = new JLabel("see all");
		seeAll2.setFont(new Font("Tahoma", Font.BOLD, 15));
		seeAll2.setBounds(1200,0,1400,100);
		seeAll2.setForeground(new Color(0x17F24B));
		latest.add(seeAll2);
		
		JPanel latestCardContainer = new JPanel();
		latestCardContainer.setBounds(80,430,1400,275);
		latestCardContainer.setBackground(new Color(0x383838));
		latestCardContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
		rightPanel.add(latestCardContainer);
		

		
		latestCardContainer.add(new PodcastBox(0,"D:\\\\Users\\\\Desktop\\\\ihm\\\\src\\\\audio\\\\bones.wav","title","17:05",""));
		latestCardContainer.add(new PodcastBox(1,"D:\\\\Users\\\\Desktop\\\\ihm\\\\src\\\\audio\\\\bones.wav","title2","17:222",""));
		
		
		
		
		
		
		
		
		this.setVisible(true);
	}
	public static void addControll(JPanel controll) {
		rightPanel.add(controll);
		rightPanel.repaint();
	}
	
	
	public static void main(String[] args) {

		new Home();
	

		
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


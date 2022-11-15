package javaSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Search extends JFrame implements ActionListener{
	JTextField searchField ;
	PodcastBox[] cards = new PodcastBox[3] ;
	
	Search(){
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.getContentPane().setBackground(new Color(0x383838));
		this.setTitle("Muslim podcast");		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(null);
		
		JPanel rightPanel = new JPanel();
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
		homeBox.setBackground(new Color(0x656565));
		homeBox.setBounds(0, 200, 75, 75);
		leftPanel.add(homeBox);

		
		JPanel searchBox = new JPanel();
		searchBox.setBackground(new Color(0x383838));
		searchBox.setBounds(0, 275, 75, 75);
		leftPanel.add(searchBox);
		
		JPanel logOutBox = new JPanel();
		logOutBox.setBackground(new Color(0x656565));
		logOutBox.setBounds(0, 500, 75, 75);
		leftPanel.add(logOutBox);
		
	
		
		 searchField = new JTextField(100);		
		searchField.setBounds(80,40,1200,50);
		searchField.setEnabled(true);
		searchField.setBorder(null);
		
		rightPanel.add(searchField);
		
		
		
		JPanel allCardsContainer = new JPanel();
		allCardsContainer.setBounds(80,100,1400,250);
		allCardsContainer.setBackground(new Color(0x383838));
		allCardsContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
		rightPanel.add(allCardsContainer);
		
		JPanel card1 = new JPanel();
		card1.setBackground(new Color(0x595959));
		card1.setPreferredSize(new Dimension(150, 250));
		
		PodcastBox card= new  PodcastBox("D:\\Users\\Desktop\\ihm\\src\\audio\\bones.wav","wa","17:05","");
		PodcastBox card2= new  PodcastBox("D:\\Users\\Desktop\\ihm\\src\\audio\\clouds.wav","fa","14:05","");
		PodcastBox card3= new  PodcastBox("D:\\Users\\Desktop\\ihm\\src\\audio\\clouds.wav","za","14:05","");
		this.cards[0]=card;
		this.cards[1]=card2;
		this.cards[2]=card3;
		allCardsContainer.add(card);
		allCardsContainer.add(card2);
		allCardsContainer.add(card3);
		
		
		
		searchField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				search();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				search();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				search();
			}
		    // implement the methods
		});
		
		
		
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {

		new Search();
	

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void search() {
		String title = searchField.getText();


		for(int i =0;i<3;i++) {
			
			if(cards[i].title1.contains(title)) {
				cards[i].setVisible(true);
				
			}
			else {
				cards[i].setVisible(false);
			}
		}
	}
	
}

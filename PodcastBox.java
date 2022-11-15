package javaSwing;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class PodcastBox extends JPanel{


	

	public String title1;



	PodcastBox(final int id,final String fileName, final String title1,final String duré1,  String img1){
		super();
		this.setBackground(new Color(0x595959));
		this.setPreferredSize(new Dimension(150, 250));
		setLayout(null);
		
		this.title1= title1;
		
		JLabel	title = new JLabel(title1);
		title.setBounds(15,210, 100, 20);
		title.setForeground(new Color(0x000000));
		title.setBackground(new Color(0x595959));
		add(title);
	
		JLabel duré = new JLabel(duré1);
		duré.setBounds(15, 228, 100, 20);
		duré.setForeground(new Color(0x000000));
		duré.setBackground(new Color(0x595959));
		add(duré);
		
		JCheckBox favoris = new JCheckBox();
		favoris.setBounds(120, 220, 25, 25);
		favoris.addItemListener(new ItemListener() {
		    

			@Override
		    public void itemStateChanged(ItemEvent e) {
		    	
		        if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
		         
		        } else {
		        };
		    }
		});
		this.add(favoris);
	   
		JLabel imglabel = new JLabel();
		imglabel.setBounds(0, 0, 150, 212);
		add(imglabel);
	 
		ImageIcon podcimg =new ImageIcon(this.getClass().getResource(img1));
		podcimg.setImage(podcimg.getImage().getScaledInstance(150,212,Image.SCALE_DEFAULT));
		imglabel.setIcon(podcimg);
		this.addMouseListener(new MouseAdapter()  {  
			
		    public void mouseClicked(MouseEvent e) {
		    	
		    	if(Home.clip == null) {
		    		
		    	}else {Home.clip.stop();
		    	Home.isPlaying=false;
		    	};
		    
		    	File file =new File (fileName);
				 AudioInputStream audioStream = null;
				try {
					audioStream = AudioSystem.getAudioInputStream(file);
				} catch (UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Home.clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 try {
					Home.clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	System.out.println("clicked");
		    	
		    	 Home.clip.start();	
		    	 AudioController.clipDuration= (int)Home.clip.getMicrosecondLength()/1000000;
		    	 if(AudioController.slider!=null)AudioController.slider.setMaximum((int) AudioController.clipDuration);
		    	 if(AudioController.slider!=null)AudioController.slider.setValue(0);
		    	 Home.clip.loop(UNDEFINED_CONDITION);

		    	 Home.isPlaying=true;
		    	 
		    	 if(Home.isControllExist==false) {
		    		 AudioController controll = new AudioController(title1,duré1);
		    		 Home.audioControl = controll;
		    		 
		    		 Home.addControll(controll);
		    	 }else {

		    		 
		    		 ((AudioController) Home.audioControl).setTime(duré1);
		    		 ((AudioController) Home.audioControl).setTitle(title1);
		    		 Home.audioControl.repaint();
		    		 Home.audioControl.revalidate();
		    		 }
		    	
		    	 
		    	 
		    	 }
		    
		    }
			);	}
	

}
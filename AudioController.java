package javaSwing;

import java.awt.*;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AudioController extends JPanel {
	public static JLabel title;
	public static JLabel time;
	public long clipTime; 
	public static long clipDuration;
	public static Thread a ;
	
	
	public void setTime(String Time) {
		// TODO Auto-generated method stub
		time.setText(Time);
	}

	public void setTitle(String Title) {
		// TODO Auto-generated method stub
		title.setText(Title);
	}

	public static JSlider slider;



	AudioController(String Name,String Time){
		
		super();
		int centerY=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y;
		int centerX=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x;
		this.setBackground(new Color(0x656565));
		this.setLayout(null);
		this.setBounds(0, centerY*2-100, centerX*2, 100);
		
		JPanel picture = new JPanel();
		picture.setBackground(Color.blue);
		picture.setBounds(0, 0,100,100);
		this.add(picture);
		
		
		slider = new JSlider();
		slider.setBounds(300, 15,500,50);
		slider.setValue(0);
		slider.setBackground(new Color(0x656565));
		slider.setMaximum((int) clipDuration);
		this.add(slider);
		

		slider.addChangeListener(new ChangeListener() 
		{ 
		   @Override public void stateChanged(ChangeEvent e) 
		   
		   { 

			   int k = (int)slider.getValue()-((int)Home.clip.getMicrosecondPosition()/1000000);
				if(Math.abs(k)>=0 && Math.abs(k)<=2) {
					
				}else {
					Home.clip.setMicrosecondPosition(slider.getValue()*1000000);
				}
				
				if(slider.getValue()== slider.getMaximum()) {
						
					slider.setValue(0);
				}
				
		   } 
		});
		
		JPanel action = new JPanel();
		action.setBackground(Color.red);
		action.setBounds(centerX*2-200, 15,50,50);
		action.addMouseListener(new MouseAdapter()  {  
			
				public void mouseClicked(MouseEvent e) {
					
					long clipTime = 0; 
					if(Home.clip!=null)clipTime= Home.clip.getMicrosecondPosition();
					
					if(Home.isPlaying==true) {
						clipTime= Home.clip.getMicrosecondPosition();
						Home.clip.stop();
						Home.isPlaying=false;
						System.out.println(clipTime);
					}else {
						Home.clip.setMicrosecondPosition(clipTime);
						Home.clip.start();
						Home.isPlaying=true;
					}
					
				}});
		this.add(action);
		
		title = new JLabel(Name);
		title.setBounds(125,15,100,25);
		this.add(title);
		
		time = new JLabel(Time);
		time.setBounds(125,40,100,25);
		this.add(time);
		
		Home.isControllExist=true;
		
		a = new Thread() {
			public void run() {
				try {
					while(Home.clip.getMicrosecondPosition()/1000000 <= slider.getMaximum()) {
						slider.setValue((int)Home.clip.getMicrosecondPosition()/1000000);
						Thread.sleep(1000);
					}
					
					
					slider.setValue(0);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		a.start();
		
		this.setVisible(true);
		
		
		
		
		
		
	}
	
	









}

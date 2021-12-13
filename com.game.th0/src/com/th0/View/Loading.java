package com.th0.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import com.th0.entity.Membership;

public class Loading extends JFrame implements Runnable{
  
	JLabel img;
	
	JProgressBar jpb;
	Membership ms ; 
	
	Loading(Membership ms){
		
		super("LOADING...");
		
		this.ms = ms;
	this.setUndecorated(true);
	int random = (int) (Math.random()*5);
	
	img = new JLabel(new ImageIcon("th0image/loading/ea"+random+".png"));
	this.add(img,BorderLayout.CENTER);
	
	jpb = new JProgressBar();
	jpb.setStringPainted(true);
	jpb.setBackground(Color.magenta);
	
	this.add(jpb,BorderLayout.SOUTH);
	
	
	 this.setVisible(true);
	 this.setLocation(500,200);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(512,480);
	 
	 this.setIconImage(new ImageIcon("th0image/icon.png").getImage());
    }
	
	
	public  void start(){
		Loading loading = new Loading(ms);
		Thread t = new Thread(loading);
		t.start();
		this.dispose();
	}
    
	public void run(){
		int[] progressValue = {0,1,3,5,10,10,10,15,25,30,32,34,36,40,48,50,58,62,66,72,78,84,86,90,92,96,98,99,100};
		for(int i  = 0;i<progressValue.length;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);
		}		
		this.dispose();
		new GameFrame(ms);
		
		
	}


}

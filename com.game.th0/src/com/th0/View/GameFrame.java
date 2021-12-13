package com.th0.View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.th0.entity.Membership;



public class GameFrame extends JFrame{
	public static void main(String[] args) {
		Membership ms;
		ms = new Membership();
		new GameFrame(ms);
	}
	
	
	
	GamePannel gp;
	
	GameFrame(Membership ms ){
		super("game");
		
		gp = new GamePannel(ms);
		gp.action();
		this.add(gp);
		this.addKeyListener(gp);
		
	     this.setVisible(true);
		 this.setLocation(300,200);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(512,512);
		 
		 this.setIconImage(new ImageIcon("th0image/icon.png").getImage());
		 while(true){
			 if(gp.flag == false){
				 this.dispose();
			 }
			 try {
				 Thread.sleep(100);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		 
		 }
	}
}

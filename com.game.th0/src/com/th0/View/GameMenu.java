package com.th0.View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.jar.JarOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.th0.entity.BackgroundImage;
import com.th0.entity.Membership;



public class GameMenu extends JFrame implements MouseListener{
	
	JLabel jb1,jb2,jb3,jb4;
	Membership ms ;

		
	  GameMenu(Membership ms){
		  super("東方白夜嘆");
		  this.ms = ms;
  	  
  	    JLabel jl1 = new JLabel("欢迎您，"+ms.getNickName());
  	    this.add(jl1);
  	     
  		 jb1 = new JLabel(new ImageIcon("th0image/gamestart.png"));
  		 jb1.setBounds(200, 800, 150, 40);
  		 jb1.setEnabled(false);
  		 jb1.addMouseListener(this);
  		 this.add(jb1);
  		 jb2 = new JLabel(new ImageIcon("th0image/help.png"));
  		 jb2.setBounds(200, 850, 150, 40);
  		 jb2.setEnabled(false);
  		 jb2.addMouseListener(this);
  		 this.add(jb2); 
  		 jb3 = new JLabel(new ImageIcon("th0image/exitgame.png"));
  		 jb4 = new JLabel(new ImageIcon("th0image/manage.png"));
 		 jb4.setBounds(200, 900, 150, 40);
 		 jb4.setEnabled(false);
 		 jb4.addMouseListener(this);
 		 if(ms.isAdmin() == true){
 			 jb3.setBounds(200, 950, 150, 40);
 			 jb3.setEnabled(false);
 			 jb3.addMouseListener(this);
 			 this.add(jb3);
 		     this.add(jb4);
 		 }else{ 
 			 jb3.setBounds(200, 900, 150, 40);
			 jb3.setEnabled(false);
			 jb3.addMouseListener(this);
			 this.add(jb3);
 			 
 		 }
  		 
  		 
  		 this.setUndecorated(true);
  		 
  		 BackgroundImage bgi = new BackgroundImage("th0image/gamemenu.jpg");
  		 bgi.setBounds(0, 0, 1920, 1080);
  		 this.add(bgi);
  		 
  		 
  	     this.add(jl1);
  	     this.setVisible(true);
  		 this.setLocation(0,0);
  		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		 this.setSize(1920,1080);
  		 
  		 this.setIconImage(new ImageIcon("th0image/icon.png").getImage());
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == jb3){
			System.exit(0);
		}else if(e.getSource() == jb4){
			new AdminView();
		}else if(e.getSource() == jb1){
			this.dispose();
			Loading loading = new Loading(ms);
			loading.start();
		}else if(e.getSource() == jb2){
			JOptionPane.showMessageDialog(null,"上下左右控制行进\nshift发射子弹\n祝你好运");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == jb1){
			jb1.setEnabled(true);
		}else if(e.getSource() == jb2){
			jb2.setEnabled(true);
		}else if (e.getSource() == jb3){
			jb3.setEnabled(true);
		}else if (e.getSource() == jb4){
			jb4.setEnabled(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == jb1){
			jb1.setEnabled(false);
		}else if(e.getSource() == jb2){
			jb2.setEnabled(false);
		}else if (e.getSource() == jb3){
			jb3.setEnabled(false);
		}else if (e.getSource() == jb4){
			jb4.setEnabled(false);
		}
		
	}

	
	
}

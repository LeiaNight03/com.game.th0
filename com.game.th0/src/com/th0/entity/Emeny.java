package com.th0.entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Emeny {

	Image image;
    int speed = 10;
	public int x= 500;
	public int y = 500;
	public int height=32,weight = 32;
	
	public Emeny(){
		int num = (int) (Math.random()*4+1);
		
		image =new ImageIcon("th0image/emeny/e"+(num)+".png").getImage();
		x = (int)(Math.random()*400+100);	
		y = -200;
	}
	
	public void paint(Graphics g){
		g.drawImage(image, x, y, 32, 32, null);
	
	}
	
	public void step(){
		int  limit = (int) (Math.random()*150);
		y += speed;
		int justic = (int) (Math.random()*10);
				switch(justic%2){
				case 1: x+= 20;break;
				case 0 : x-= 20; break;
				}
		if(x<0){
			x=0;
		}else if(x>500){
			x = 500;
		}
		if(y>=limit+100){
			
			y=limit+100;		    
		}
		
		
		
	}
	
	
}

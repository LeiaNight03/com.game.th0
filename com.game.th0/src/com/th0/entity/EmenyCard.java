package com.th0.entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class EmenyCard {

	Image image;
    int speed = 20;
	public int x;
	public int y;
	public int height=32,weight = 32;
	
	public EmenyCard(int xx,int yy){
		int num = (int) (Math.random()*4+1);
		
		image =new ImageIcon("th0image/emeny/d"+(num)+".png").getImage();
		x = xx;	
		y = yy;
	}
	
	public void paint(Graphics g){
		g.drawImage(image, x, y, 32, 32, null);
	}
	
	public void step(){
		y += speed;		
	}
	
	
}

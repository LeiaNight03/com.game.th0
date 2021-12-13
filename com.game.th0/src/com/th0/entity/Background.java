package com.th0.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Background {
	int index = 20;
	int x=0;
	int y=0;
	int temp1,temp2;
	BufferedImage n1,n2,n3,n4,n5,n6,n7,n8;
	BufferedImage[] images = {};
	Image background1,background2,background;
	public Background(){
	 temp1 = (int) ((Math.random()*7)+1);
	 temp2 = (int) ((Math.random()*7)+1);
	
	initBgi();
	images =new BufferedImage[]{n1,n2,n3,n4,n5,n6,n7,n8};
	background1 = images[temp1];
	background2 = images[temp2];
	//background = new ImageIcon("th0image/bgi/bg8.png").getImage();
	
	
   
	if(y<=-512){
	index = 0;
	temp1 =temp2;
	background1 = images[temp1];
	temp2 =(int) ((Math.random()*7)+1);
	background2 = images[temp2];
	}
	}
	public void paintBgi(Graphics g){
		g.drawImage(background1, x,y,512,512,null);
		g.drawImage(background2, x,y-512,512,512,null);
	}
	
	public void initBgi(){
		try {
			n1 = ImageIO.read(new File("th0image/bgi/bg1.png"));
			n2 = ImageIO.read(new File("th0image/bgi/bg12.png"));
			n3 = ImageIO.read(new File("th0image/bgi/bg3.png"));
			n4 = ImageIO.read(new File("th0image/bgi/bg4.png"));
			n5 = ImageIO.read(new File("th0image/bgi/bg5.png"));
			n6 = ImageIO.read(new File("th0image/bgi/bg6.png"));
			n7 = ImageIO.read(new File("th0image/bgi/bg7.png"));
			n8 = ImageIO.read(new File("th0image/bgi/bg8.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void step(){
		y += index;
		if(y>=512){
			y=0;
			temp1 =temp2;
			background1 = images[temp1];
			temp2 =(int) ((Math.random()*7)+1);
			background2 = images[temp2];
			
			}
	}
	
	
	
}

package com.th0.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Crad {
	int speed = 20;
	int height=8;
	int weight = 8;
	public int x;
	public int y;
	BufferedImage n1,n2,n3;
	BufferedImage[] images = {};
	Image image;
	public Crad(int x,int y){
	this.x = x;
	this.y=y;
	initcard();
	images =new BufferedImage[]{n1,n2,n3};
	image = images[(int) (Math.random()*3)];
	
	}
	
	
	
	public void initcard(){
		try {
			n1 = ImageIO.read(new File("th0image/player/a1.png"));
			n2 = ImageIO.read(new File("th0image/player/a2.png"));
			n3 = ImageIO.read(new File("th0image/player/a3.png"));

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(image, x+24, y, 8, 8,null);
	}
	
	public void step(){
		y -= speed;
	}
	
	
	
	
	
}

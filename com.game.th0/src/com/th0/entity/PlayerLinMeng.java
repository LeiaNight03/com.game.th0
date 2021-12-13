package com.th0.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerLinMeng {

	int index = 0;
	public int x;
	public int y;
	public BufferedImage  image;
	public BufferedImage n1,n2,n3,n4,n5,n6,n7,n8,l1,l2,l3,l4,l5,l6,l7,l8,r1,r2,r3,r4,r5,r6,r7,r8;
	public BufferedImage[] imagesn = {}, imagesl = {}, imagesr = {};
	public int width = 16, height = 16;
	public int score = 0;
	
	public PlayerLinMeng(){
		
		x = 300;
		y = 300;
		
		initPlayer();
		
		imagesn = new BufferedImage[]{n1,n2,n3,n4,n5,n6,n7,n8};
		imagesl = new BufferedImage[]{l1,l2,l3,l4,l5,l6,l7,l8};
		imagesr = new BufferedImage[]{r1,r2,r3,r4,r5,r6,r7,r8};
		
	}
	
	 public void paintPlayer(Graphics g){
    	 g.drawImage(image, x, y, 60, 80, null);
     }
		
	public void initPlayer(){
		 try {
			 n1 = ImageIO.read(new File("th0image/player/p01.png"));
			 n2 = ImageIO.read(new File("th0image/player/p02.png"));
			 n3 = ImageIO.read(new File("th0image/player/p03.png"));
			 n4 = ImageIO.read(new File("th0image/player/p04.png"));
			 n5 = ImageIO.read(new File("th0image/player/p05.png"));
			 n6 = ImageIO.read(new File("th0image/player/p06.png"));
			 n7 = ImageIO.read(new File("th0image/player/p07.png"));
			 n8 = ImageIO.read(new File("th0image/player/p08.png"));
			 r1 = ImageIO.read(new File("th0image/player/r01.png"));
			 r2 = ImageIO.read(new File("th0image/player/r02.png"));
			 r3 = ImageIO.read(new File("th0image/player/r03.png"));
			 r4 = ImageIO.read(new File("th0image/player/r04.png"));
			 r5 = ImageIO.read(new File("th0image/player/r05.png"));
			 r6 = ImageIO.read(new File("th0image/player/r06.png"));
			 r7 = ImageIO.read(new File("th0image/player/r07.png"));
			 r8 = ImageIO.read(new File("th0image/player/r08.png"));
			 l1 = ImageIO.read(new File("th0image/player/l01.png"));
			 l2 = ImageIO.read(new File("th0image/player/l02.png"));
		//	 l3 = ImageIO.read(new File("th0image/player/l03.png"));
			 l4 = ImageIO.read(new File("th0image/player/l04.png"));
			 l5 = ImageIO.read(new File("th0image/player/l05.png"));
			 l6 = ImageIO.read(new File("th0image/player/l06.png"));
			 l7 = ImageIO.read(new File("th0image/player/l07.png"));
			l8 = ImageIO.read(new File("th0image/player/l08.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public void step(String type){
		index ++;
		switch(type){
		case "l" :   image = imagesl[index%imagesl.length]; break;
		case"r" :    image = imagesr[index%imagesr.length]; break;
		default  :   image = imagesn[index%imagesn.length];break;
		}
		if(x<0){
			x=0;
		}else if(x>512-60){
			x= 452;
		}else if(y<0){
			y=0;}
		else if(y>512-80){
		    y = 512-80;
		}
		
		
		
		}
		
}
		
		
	
	
	
	
	

	


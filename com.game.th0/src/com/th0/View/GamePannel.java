package com.th0.View;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.th0.entity.Background;
import com.th0.entity.BackgroundImage;
import com.th0.entity.Crad;
import com.th0.entity.Emeny;
import com.th0.entity.EmenyCard;
import com.th0.entity.Membership;
import com.th0.entity.PlayerLinMeng;

public class GamePannel extends JPanel implements KeyListener{
	Image background1,background2,background;
	PlayerLinMeng player; 
	String playerflag = "n";
	Background bhi; 
	Crad[] crad ;
	Emeny[] emeny;
	EmenyCard[] emenycard;
	int emenynum=0;
	int emenycardnum=0;
	int score = 0;
	boolean flag = true;
	Membership ms;
	
	GamePannel(Membership ms){
	player 	= new PlayerLinMeng();
	bhi = new Background();
	crad = new Crad[]{};
	emeny = new Emeny[]{};
	emenycard = new EmenyCard[]{};
	this.ms = ms;
	}
	
	
		
	public void paint(Graphics g){
			super.paint(g);	
			bhi.paintBgi(g);
			player.paintPlayer(g);
			for (int i =0;i<crad.length;i++){
				crad[i].paint(g);
			}
			for (int i =0;i<emeny.length;i++){
				emeny[i].paint(g);
			}		
			for (int i =0;i<emenycard.length;i++){
				emenycard[i].paint(g);
			}		
		}
	
	public void EnterCrad(){
		Crad crads = new Crad(player.x,player.y);
		crad = Arrays.copyOf(crad, crad.length+1);
		crad[crad.length-1] = crads;
	}
	public void EnterEmeny(){
		if(emenynum++%10==0){
			
			Emeny emenys = new Emeny();
			emeny = Arrays.copyOf(emeny, emeny.length+1);
			emeny[emeny.length-1] = emenys;
		}
	}
	public void EnterEmenyCard(){
		    if(emenycardnum++%5==0){
			if(emeny.length>0){
			int random = (int) (Math.random()*emeny.length-1);
			EmenyCard emenycards = new EmenyCard(emeny[random].x,emeny[random].y);
			emenycard = Arrays.copyOf(emenycard, emenycard.length+1);
			emenycard[emenycard.length-1] = emenycards;
		}
			}
	}
	
	public void justice(){
		for(int i = 0;i<crad.length;i++){
			for (int j = 0; j<emeny.length;j++){
				if(crad[i].x>emeny[j].x&&crad[i].x<emeny[j].x+emeny[j].weight&&crad[i].y>=emeny[j].y&&crad[i].y<=emeny[j].y+emeny[j].height){
					score += 20;
					emeny[j] = emeny[emeny.length-1];
					emeny = Arrays.copyOf(emeny, emeny.length-1);
					crad[i] = crad[crad.length-1];
					crad = Arrays.copyOf(crad, crad.length-1);
				}
			}
		}
	}
	
	public void gamecontinue(){
		boolean flagq = true;
		for(int i =0;i<emeny.length;i++){
			for(int j = 0;j<emenycard.length;j++){
				if(emenycard[j].x>player.x+5&&emenycard[j].x<player.x+44&&emenycard[j].x+emenycard[j].weight>player.x+44&&emenycard[j].x+emenycard[j].weight>player.x&&emenycard[j].y+emenycard[j].height>player.y&&emenycard[j].y<player.y+34){
					flagq = false;
					break;
				}
				if(emeny[i].x>player.x+5&&emeny[i].x<player.x+44&&emeny[i].x+emeny[i].weight>player.x+44&&emeny[i].x+emeny[i].weight>player.x&&emeny[i].y+emeny[i].height>player.y&&emeny[i].y<player.y+34){
					flagq = false;
					break;
				}
				}
			}
		if(flagq == false){
			JOptionPane.showMessageDialog(null, "GameOver");
			flag = false;
			new Ending(ms,score);
			
		}
	}
	
	
	
	
	public void action(){
		 new Thread(){		 	
		public void run() {
			
			super.run();
			while(true){
				if(flag){					
					player.step(playerflag);		
					bhi.step();
					justice();
					gamecontinue();
					for(int i = 0;i<crad.length;i++){
						crad[i].step();
					}
					EnterEmeny();
					for(int i = 0;i<emeny.length;i++){
						emeny[i].step();
					}
					EnterEmenyCard();
					for(int i = 0;i<emenycard.length;i++){
						emenycard[i].step();
					}
					score++;
					repaint();
				}
					try {				
					Thread.sleep(100);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
					}
			}
		}.start();
	
	
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)	{
			player.y = player.y-10;
			playerflag = "n";
        }
       else if (e.getKeyCode() == KeyEvent.VK_LEFT)
       {
    	   player.x -= 10;
    	   playerflag = "r";
       }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
        	player.x +=10;
        	playerflag = "l";
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
        	player.y += 10;
        	playerflag = "n";
        }else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
        	EnterCrad();
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)	{
			playerflag = "n";
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
     	   playerflag = "n";
        }
		
	}
}
package com.th0.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundImage extends JPanel{
                Image background;
                public BackgroundImage(String address){
                	try {
						background = ImageIO.read(new File(address));
					} catch (IOException e) {
						e.printStackTrace();
					}
                }
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(background, 0, 0, null);
	}
}

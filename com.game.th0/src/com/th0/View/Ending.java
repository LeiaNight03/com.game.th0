package com.th0.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.th0.Userservice.MsUserservice;
import com.th0.entity.BackgroundImage;
import com.th0.entity.Membership;

public class Ending extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		Membership ms = new Membership();
		ms.setNickName("leia");
		ms.setRank("gold");
		ms.setGameNum(1);
		ms.setGold(10000);
		ms.setBestscore(0);
		new Ending(ms,200);
	}
	
	JLabel usernamet,usernamen,scoret,scoren,bscoren,bscoret,nrecord,nrankt,nrankn,ngamet,ngamen,ngoldt,ngoldn;
	BufferedImage n1,n2,n3,n4,n5,n6,n7,n8;
	BufferedImage[] images = {};
	Image background1,background2,background;
	MsUserservice msus = new MsUserservice();
	JButton retry,exit;
	Membership nms;
	
Ending(Membership ms,int score){
	
	super("结算画面");
	this.setLayout(null);
	String rank = ms.getRank();
	BackgroundImage bgi = null;
	
	boolean newrecord = false;
	if(ms.getBestscore()<score){
		msus.updatebestscore(score,ms.getID());
		newrecord = true;
	}
	int gamenum = ms.getGameNum()+1;
	ms.setGameNum(gamenum);
	int gold = ms.getGold()+score;
	ms.setGold(gold);
	msus.updategamenum(ms);
	
	
	if(msus.updaterank(ms)){
		newrecord  =true;
	}
	
    switch (rank) {
  case "Plastic" : bgi = new BackgroundImage("th0image/ending/ea00.png");	
	break;
  case "copper" : bgi = new BackgroundImage("th0image/ending/ea01.png"); 
	break;
  case "sliver" : bgi = new BackgroundImage("th0image/ending/ea02.png"); 
	break;
  case "gold" : bgi = new BackgroundImage("th0image/ending/ea03.png"); 
	break;
  case "platinum" : bgi = new BackgroundImage("th0image/ending/ea04.png"); 
	break;
  case "master" : bgi = new BackgroundImage("th0image/ending/ea05.png"); 
	break;
  case "gurn" : bgi = new BackgroundImage("th0image/endingea06.png"); 
	break;
  default: rank = "Plastic";
	  bgi = new BackgroundImage("th0image/ending/e00a.png");
	break;
}
    
   
   
        if(newrecord){
        	nrecord = new JLabel(new ImageIcon("th0image/ending/zhuangshi.gif"));	
            nrecord.setBounds(0, 0, 96, 96);
            this.add(nrecord);      
        }
             
         nms = new Membership();
        nms = msus.showHeroByID(ms.getID());
        
        
        usernamen = new JLabel("抱歉，游戏结束");
        usernamen.setBounds(300, 50, 200, 80);
        usernamen.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(usernamen);
        usernamet = new JLabel(ms.getNickName());
        usernamet.setBounds(100, 50, 200, 80);
        usernamet.setFont(new Font("华文行楷",Font.BOLD,24));
        usernamet.setForeground(Color.getHSBColor(181, 161, 189));
        this.add(usernamet);
               
        scoret = new JLabel("本局游戏得分");
        scoret.setBounds(100, 100, 200, 80);
        scoret.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(scoret);
        scoren = new JLabel(score+"");
        scoren.setBounds(400, 100, 200, 80);
        scoren.setFont(new Font("华文行楷",Font.BOLD,24));
        scoren.setForeground(Color.getHSBColor(181, 161, 189));
        this.add(scoren);
        
        
        
        bscoret = new JLabel("最高纪录");
        bscoret.setBounds(100, 150, 200, 80);
        bscoret.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(bscoret);
        bscoren = new JLabel(nms.getBestscore()+"");
        bscoren.setBounds(400, 150, 200, 80);
        bscoren.setFont(new Font("华文行楷",Font.BOLD,24));
        bscoren.setForeground(Color.getHSBColor(181, 161, 189));
        this.add(bscoren);
        
        nrankt = new JLabel("段位");
        nrankt.setBounds(100, 200, 200, 80);
        nrankt.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(nrankt);
        nrankn = new JLabel(nms.getRank());
        nrankn.setBounds(400, 200, 200, 80);
        nrankn.setFont(new Font("华文行楷",Font.BOLD,24));
        nrankn.setForeground(Color.getHSBColor(181, 161, 189));
        this.add(nrankn);
        
        ngamet = new JLabel("游戏局数");
        ngamet.setBounds(100, 250, 200, 80);
        ngamet.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(ngamet);
        ngamen = new JLabel(nms.getGameNum()+"");
        ngamen.setBounds(250, 250, 200, 80);
        ngamen.setFont(new Font("华文行楷",Font.BOLD,24));
        ngamen.setForeground(Color.getHSBColor(181, 161, 189));
        this.add(ngamen);
        
        ngoldt = new JLabel("积分");
        ngoldt.setBounds(350, 250, 200, 80);
        ngoldt.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(ngoldt);
        ngoldn = new JLabel(nms.getGold()+"");
        ngoldn.setBounds(500, 250, 200, 80);
        ngoldn.setFont(new Font("华文行楷",Font.BOLD,24));
        ngoldn.setForeground(Color.getHSBColor(181, 161, 189));
        this.add(ngoldn);
        
        JLabel paihang = new JLabel("排行榜");
        paihang.setBounds(450, 320, 200, 80);
        paihang.setFont(new Font("华文行楷",Font.BOLD,36));
        this.add(paihang);
        List<Membership> list = new ArrayList<Membership>();
        list = msus.selectMembershiprank();
      
        JLabel listn = new JLabel("昵称");
        listn.setBounds(200, 400, 200, 80);
        listn.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(listn);
        JLabel lists = new JLabel("最高分数");
        lists.setBounds(500, 400, 200, 80);
        lists.setFont(new Font("华文行楷",Font.BOLD,24));
        this.add(lists);
        
        
        
        int flag = 0;
        for(int i = 0 ;i<list.size();i++){
        	if(flag >10){
        		break;
        	}
        	JLabel rankn = new JLabel(list.get(i).getNickName());
            rankn.setBounds(200, 450+i*30, 200, 80);
            rankn.setFont(new Font("华文行楷",Font.BOLD,24));
            rankn.setForeground(Color.getHSBColor(181, 161, 189));
            this.add(rankn);
            JLabel ranks = new JLabel(list.get(i).getBestscore()+"");
            ranks.setBounds(500, 450+i*30, 200, 80);
            ranks.setFont(new Font("华文行楷",Font.BOLD,24));
            ranks.setForeground(Color.getHSBColor(181, 161, 189));
            this.add(ranks);
        }
        
        
        
        
        
        
        
        
        retry = new JButton(new ImageIcon("th0image/again.png"));
        retry.setBounds(100, 900, 300, 50);
        this.add(retry);
        retry.addActionListener(this);
        exit = new JButton(new ImageIcon("th0image/tuichu.png"));
        exit.setBounds(500, 900, 300, 50);
        this.add(exit);
        exit.addActionListener(this);
        
        
        
        bgi.setBounds(0, 0,1024, 960);
        this.add(bgi);
        
	this.setUndecorated(true);
	
	this.setVisible(true);
	this.setLocation(250,50);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1024,960);
	
	this.setIconImage(new ImageIcon("th0image/icon.png").getImage());
	
	
}




@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource() == retry){
	this.dispose();
	new GameMenu(nms);
	
}else if(e.getSource() == exit){
	System.exit(0);
}
	
}






}

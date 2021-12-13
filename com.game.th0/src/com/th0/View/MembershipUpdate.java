package com.th0.View;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Expection.UserNameException;


import com.th0.Userservice.MsUserservice;
import com.th0.entity.BackgroundImage;
import com.th0.entity.Membership;
import com.th0.very.VerCode;

public class MembershipUpdate extends JFrame implements ActionListener{

	public static void main(String[] args) {
		Membership msw = new Membership();
		msw.setNickName("khg");
		msw.setAdmin(true);
		new GameMenu(msw);
	}
	
		JLabel jl1,jl2,jl3,jl4,jl5,jtf1,gamenuml,rankl,goldl,bestscorel;
	    JTextField jtf2,jtf3,jtf5,gamenumt,rankt,goldt,bestscoret;
	    JTextField jpf;
	    JButton jb1,jb2,jb3;
		File fl;
		URL url;
		URI uri;
		AudioClip aap;
		String code;
		VerCode verycode= new VerCode();
		
		MsUserservice msus = new MsUserservice();
		
		MembershipUpdate(Membership ms){
			
			super(ms.getUserName()+"工事中......");
				
			this.setLayout(null);
		    jl1 = new JLabel("ID");
		    jl1.setBounds(140,270,70,30);
		    jl1.setFont(new Font("华文行楷",Font.BOLD,30));
		    jl1.setForeground(Color.BLACK);
			this.add(jl1);
			jtf1 = new JLabel(ms.getID()+"");
			jtf1.setBounds(240, 270, 120, 30);
			jtf1.setFont(new Font("华文行楷",Font.BOLD,30));
		    jtf1.setForeground(Color.MAGENTA);
			this.add(jtf1);
			jl2 = new JLabel("账号");
			jl2.setBounds(140, 320, 100, 30);
			jl2.setFont(new Font("华文行楷",Font.BOLD,24));
			jl2.setForeground(Color.BLACK);
			this.add(jl2);
			jpf = new JTextField(ms.getUserName());
			jpf.setBounds(240, 320, 120, 30);
			this.add(jpf);
			jl3 = new JLabel("昵称");
			jl3.setBounds(140, 370, 120, 30);
			jl3.setFont(new Font("华文行楷",Font.BOLD,24));
			jl3.setForeground(Color.BLACK);
			this.add(jl3);
			jtf2 = new JTextField(ms.getNickName());
			jtf2.setBounds(240, 370, 120, 30);
			this.add(jtf2);			
			jl4 = new JLabel("手机号码");
			jl4.setBounds(140, 420, 120, 30);
			jl4.setFont(new Font("华文行楷",Font.BOLD,24));
			jl4.setForeground(Color.BLACK);
			this.add(jl4);
			jtf3 = new JTextField(ms.getPhoneNum());
			jtf3.setBounds(240, 420, 120, 30);
			this.add(jtf3);
			gamenuml = new JLabel("游戏局数");
			gamenuml.setBounds(140, 470, 120, 30);
			gamenuml.setFont(new Font("华文行楷",Font.BOLD,24));
			gamenuml.setForeground(Color.BLACK);
			this.add(gamenuml);
			gamenumt = new JTextField(ms.getGameNum()+"");
			gamenumt.setBounds(240, 470, 120, 30);
			this.add(gamenumt);
			rankl = new JLabel("排位");
			rankl.setBounds(140, 520, 120, 30);
			rankl.setFont(new Font("华文行楷",Font.BOLD,24));
			rankl.setForeground(Color.BLACK);
			this.add(rankl);
			rankt = new JTextField(ms.getRank());
			rankt.setBounds(240, 520, 120, 30);
			this.add(rankt);
			goldl = new JLabel("暂停符");
			goldl.setBounds(140, 570, 120, 30);
			goldl.setFont(new Font("华文行楷",Font.BOLD,24));
			goldl.setForeground(Color.BLACK);
			this.add(goldl);
			goldt = new JTextField(ms.getGold()+""); 
			goldt.setBounds(240, 570, 120, 30);
			this.add(goldt);
			bestscorel = new JLabel("最高纪录"); 
			bestscorel.setBounds(140, 620, 120, 30);
			bestscorel.setFont(new Font("华文行楷",Font.BOLD,24));
			bestscorel.setForeground(Color.BLACK);
			this.add(bestscorel);
			bestscoret = new JTextField(ms.getBestscore()+"");
			bestscoret.setBounds(240, 620, 120, 30);
			this.add(bestscoret);
			
			
			jl5 = new JLabel("验证码");
			jl5.setBounds(140, 720, 120, 30);
			jl5.setFont(new Font("华文行楷",Font.BOLD,24));
			jl5.setForeground(Color.BLACK);
			this.add(jl5);
			jtf5 = new JTextField();
			jtf5.setBounds(240, 720, 80, 30);
			this.add(jtf5);
			
			
			
			code = verycode.very();
			jb3 = new JButton(code);
			jb3.setBounds(320, 720, 100, 30);
			this.add(jb3);
			jb3.setBackground(Color.magenta);
			jb3.addActionListener(this);
			
			
			jb1 = new JButton("修改");
			jb1.setBounds(200, 800, 70, 30);
	        jb1.addActionListener(this);		
			this.add(jb1);
			jb2 = new JButton("取消");
			jb2.setBounds(350,800, 70, 30);
			jb2.addActionListener(this);
			this.add(jb2);
			
			
		 BackgroundImage bgi = new BackgroundImage("th0image/update.png");
		 bgi.setBounds(0, 0, 700, 961);
		 this.add(bgi);
		 
		 this.setUndecorated(true);
		 
		 this.setVisible(true);
		 this.setLocation(600,50);
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setSize(700,961);
		 
		 this.setIconImage(new ImageIcon("image/miku冷漠.PNG").getImage());
	     
	 }
		

		
		public void actionPerformed(ActionEvent e) {
			 if(e.getSource() == jb1){
				
				if(code.equalsIgnoreCase(jtf5.getText())){
				String id = jtf1.getText();
				System.out.println(id);
				int num = Integer.parseInt(id);
				String username = jpf.getText();
				String nickname = jtf2.getText();
				String phonenum  = jtf3.getText();
				String gamenums = gamenumt.getText();
				
				int gamenum = 0;
				if(Pattern.matches("^[0-9]*$", gamenums));
				{
					gamenum = Integer.parseInt(gamenums);
				}
				
				String rank = rankt.getText();
				String golds = goldt.getText();
				
				int gold = 0;
				if(Pattern.matches("^[0-9]*$", golds));
				{
					gold = Integer.parseInt(golds);
				}
				
				String bestscores = bestscoret.getText();
				int bestscore = 0;				
				if(Pattern.matches("^[0-9]*$", bestscores));
				{
					bestscore = Integer.parseInt(bestscores);
				}
				
				Membership msup = new Membership();
				msup.setID(num);
				msup.setUserName(username);
				msup.setNickName(nickname);
				msup.setPhoneNum(phonenum);
				msup.setGameNum(gamenum);
				msup.setRank(rank);
				msup.setGold(gold);
				msup.setBestscore(bestscore);
				
				try {
					boolean flag = msus.update(msup);
					System.out.println(flag);
					if(flag){
						JOptionPane.showMessageDialog(null, "修改成功");
						new AdminView();
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null,"修改失败");
					}
				} catch (UserNameException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				}else{
				JOptionPane.showMessageDialog(null, "验证码错误");
				}
			}else if(e.getSource() == jb2){
				new AdminView();
				this.dispose();
			}else if(e.getSource() == jb3){
				code = verycode.very();
				jb3.setText(code); 
			}
			
		}
		
		

}

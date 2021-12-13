package com.th0.View;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.th0.Userservice.MsUserservice;
import com.th0.entity.BackgroundImage;
import com.th0.entity.Membership;

public class LoginSurface extends JFrame implements ActionListener{
    JLabel jl1,jl2,gametitle;
    JTextField jtf1;
    JPasswordField jpf;
    JButton jb1,jb2,vercodeb,exit;
	File fl;
	URL url;
	URI uri;
	AudioClip aap;
	
	MsUserservice msus = new MsUserservice(); 
	
	LoginSurface(){
		
		super("�|����ҹ��");
		
		try {
			fl = new File("th0music/�����.wav");
			uri = fl.toURI();
			url = uri.toURL();
			aap = Applet.newAudioClip(url);
			aap.loop();//ѭ������
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		
		this.setLayout(null);
		gametitle = new JLabel(new ImageIcon("th0image/gametitle.png"));
		gametitle.setBounds(450,20,800,500);
		this.add(gametitle);
		
		jl1 = new JLabel("�û���");
	    jl1.setBounds(650,620,70,30);  
		jl1.setFont( new Font("�����п�",Font.BOLD,16));
		jl1.setForeground(Color.getHSBColor(222, 100, 100));
	    this.add(jl1);
		jtf1 = new JTextField();
		jtf1.setBounds(720, 620, 120, 30);
		jtf1.setFont( new Font("�����п�",Font.BOLD,24));
		jtf1.setForeground(Color.black);
		this.add(jtf1);
		jl2 = new JLabel("����");
		jl2.setBounds(650, 670, 70, 30);
		jl2.setFont( new Font("�����п�",Font.BOLD,16));
		jl2.setForeground(Color.getHSBColor(222, 100, 100));
		this.add(jl2);
		jpf = new JPasswordField();
		jpf.setBounds(720, 670, 120, 30);
		this.add(jpf);
		jb1 = new JButton(new ImageIcon("th0image/denglu3.png"));
		jb1.setBounds(650, 750, 80, 40);
		jb1.addActionListener(this);
		this.add(jb1);
		jb2 = new JButton(new ImageIcon("th0image/ע��2.png"));
		jb2.setBounds(750, 750, 80, 40);
		jb2.addActionListener(this);
		this.add(jb2);
		exit = new JButton(new ImageIcon("th0image/exit2.png"));
		exit.setBounds(900, 750, 80, 40);
		exit.addActionListener(this);
		this.add(exit);
		
		
		
		BackgroundImage bgi = new BackgroundImage("th0image/loginmenu.jpg");
		bgi.setBounds(0, 0, 1492, 879);
		this.add(bgi);
		
		this.setUndecorated(true);
		
		this.setVisible(true);
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1492,879);
		
		this.setIconImage(new ImageIcon("th0image/icon.png").getImage());
		
	}


	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == jb1){
		String username = jtf1.getText();
		String password = jpf.getText();
		if(username==null&&password == null){
			JOptionPane.showMessageDialog(null,"����Ϊ��");
		}else{
			Membership ms = new Membership();
			ms.setUserName(username);
			ms.setPassword(password);
			ms = msus.Login(username, password);
		    if(ms == null){
		    	JOptionPane.showMessageDialog(null,"�˺Ż��������");
		    }else{
		    	if(ms.isStatus()){		    		
		    		
		    		this.dispose();
		    		new GameMenu(ms);
		    		
		    	}else{
		    		JOptionPane.showMessageDialog(null,"you have been banned by system administer.");
		    	}
		    }
		
		}
	}
		
	  else if(e.getSource() == jb2){
				RegeisterSurface reg = new RegeisterSurface();
				this.dispose();
	}else if(e.getSource() == exit){
		System.exit(0);
	}
}
}

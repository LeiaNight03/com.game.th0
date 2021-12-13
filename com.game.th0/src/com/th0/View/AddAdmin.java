package com.th0.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Expection.UserNameException;

import com.th0.Userservice.MsUserservice;
import com.th0.entity.BackgroundImage;
import com.th0.entity.Membership;
import com.th0.very.VerCode;


public class AddAdmin extends JFrame implements ActionListener{
        public static void main(String[] args) {
			new AddAdmin();
		}
        
        
	   JLabel title,usernamel,nicknamel,passwordl,phoneNuml,varCodel;
	   JTextField usernamet,nicknamet,phoneNumt,varCodet;
	   JPasswordField  passwordt;
	   JButton varCodeb,regeister,cancel;
	   String code;
	   VerCode verycode= new VerCode();
	
	   MsUserservice Msus = new MsUserservice();
	   
	   
	   
	    AddAdmin(){	    	
	    	
		 super("注册");
		
		 this.setLayout(null);
		 
		 title = new JLabel(new ImageIcon("th0image/title.png"));
		 title.setBounds(50, 0, 300, 200);
		 this.add(title);
		 
		 usernamel = new JLabel("账号名称");
		 usernamel.setFont( new Font("华文行楷",Font.BOLD,24));
		 usernamel.setBounds(70, 250, 100, 30);
		 usernamel.setForeground(Color.getHSBColor(181, 91, 89));
		 this.add(usernamel);
		 usernamet = new JTextField();
		 usernamet.setBounds(200, 250, 120, 30);
		 this.add(usernamet);
		 
		 nicknamel = new JLabel("昵称");
		 nicknamel.setFont( new Font("华文行楷",Font.BOLD,24));
		 nicknamel.setBounds(70, 300, 100, 30);
		 nicknamel.setForeground(Color.getHSBColor(181, 91, 89));
		 this.add(nicknamel);
		 nicknamet = new JTextField();
		 nicknamet.setBounds(200, 300, 120, 30);
		 this.add(nicknamet);
		 
		 passwordl = new JLabel("密码");
		 passwordl.setFont( new Font("华文行楷",Font.BOLD,24));
		 passwordl.setBounds(70, 350, 100, 30);
		 passwordl.setForeground(Color.getHSBColor(101, 95, 57));
		 this.add(passwordl);
		 passwordt = new JPasswordField();
		 passwordt.setBounds(200, 350, 120, 30);
		 this.add(passwordt);
		 phoneNuml = new JLabel("手机号码");
		 phoneNuml.setFont(new Font("华文行楷",Font.BOLD,24));
		 phoneNuml.setBounds(70, 400, 100, 30);
		 phoneNuml.setForeground(Color.getHSBColor(171,57, 95));
		 this.add(phoneNuml);
		 phoneNumt = new JTextField();
		 phoneNumt.setBounds(200, 400, 120, 30);
		 this.add(phoneNumt);
		 varCodel = new JLabel("验证码");
		 varCodel.setFont(new Font("华文行楷",Font.BOLD,24));
		 varCodel.setBounds(70, 450, 100, 30);
		 varCodel.setForeground(Color.getHSBColor(171,57, 95));
		 this.add(varCodel);
		 varCodet= new JTextField();
		 varCodet.setBounds(200, 450, 80, 30);
		 this.add(varCodet);
		 code=verycode.very();
		 varCodeb = new JButton(code);
		 varCodeb.setBounds(300, 450, 120, 30);
		 varCodeb.addActionListener(this);
		 this.add(varCodeb);
		 
		 
		 regeister = new JButton("注册");
		 regeister.setBounds(100, 530, 80, 30);
		 regeister.addActionListener(this);
		 this.add(regeister);
		 cancel = new JButton("取消");
		 cancel.setBounds(260, 530, 80, 30);
		 cancel.addActionListener(this);
		 this.add(cancel);
		 
		 BackgroundImage bgi = new BackgroundImage("th0image/regeist.jpg");
		 bgi.setBounds(0, 0, 431, 598);
		 this.add(bgi);
		 
		 this.setUndecorated(true);
		 
		 this.setVisible(true);
		 this.setLocation(400,300);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(431,598);
		 
		// this.setIconImage(new ImageIcon("").getImage());
		 
	 }


		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == varCodeb){
				code = verycode.very();
				varCodeb.setText(code);
			}else if (e.getSource() == regeister){
				if(code.equalsIgnoreCase(varCodet.getText())){
				Membership msr = new Membership();
			    msr.setUserName(usernamet.getText());
			    msr.setNickName(nicknamet.getText());
			    msr.setPassword(passwordt.getText());
				msr.setPhoneNum(phoneNumt.getText());
			    try {
					boolean flag = Msus.regeisteradmin(msr);
					if(flag){
						JOptionPane.showMessageDialog(null, "注册成功");
						new AdminView();
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "注册失败");
					}
				} catch (UserNameException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				}else {
					JOptionPane.showMessageDialog(null,"验证码错误");
				}
				}else if(e.getSource() == cancel){
					new AdminView();
					this.dispose();
				}
			
		}
}

package com.th0.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.th0.Dao.MembershipDao;
import com.th0.Userservice.MsUserservice;
import com.th0.Userservice.UserModel;
import com.th0.entity.Membership;

public class AdminView extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		new AdminView();
	}
	
	
	MembershipDao msdao = new MembershipDao();

	JPanel jp,chaxun;
	JButton jb1,jb2,jb3,jb4,search;
	JTextField content;
	UserModel hm;
	JTable jt;
	JScrollPane jsp;	
	MsUserservice msu = new MsUserservice();
	
	AdminView(){
		
		super("后台");
		
		search = new JButton("查询");
		search.addActionListener(this);
		content = new JTextField(9);
		chaxun = new JPanel();
		chaxun.add(content);
		chaxun.add(search);
		this.add(chaxun,BorderLayout.NORTH);
		
		
		hm = new UserModel();
		jt = new JTable(hm);
		jsp = new JScrollPane(jt);
		this.add(jsp,BorderLayout.CENTER);
		jp = new JPanel();
		
		jb1 = new JButton("添加");
		jb1.addActionListener(this);
		jb2 = new JButton("状态解除");
		jb2.addActionListener(this);
		jb3 = new JButton("修改");
		jb3.addActionListener(this);
		jb4 = new JButton("退出");
		jb4.addActionListener(this);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		this.add(jp,BorderLayout.SOUTH);
		

		 this.setVisible(true);
		 this.setLocation(500,400);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(568,320);
		 
		 this.setIconImage(new ImageIcon("th0image/icon.png").getImage());
	     
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1){
			new AddAdmin();
			this.dispose();
		}else if (e.getSource() == jb2){
			int number = jt.getSelectedRow();
			if(number == -1){
				JOptionPane.showMessageDialog(null, "请选择需要修改状态的数据");
			}else {
				int id =   (int) hm.getValueAt(number, 0);
				boolean result = msu.changeStatus(id);
			if(result){
				JOptionPane.showMessageDialog(null,"封印解除！");
			}else {
				JOptionPane.showMessageDialog(null,  "封印吧，小坏蛋！");
			}
			    hm = new UserModel();
				jt.setModel(hm);			
			}
		}else if(e.getSource() == jb3){
			int number = jt.getSelectedRow();
			if(number == -1){
				JOptionPane.showMessageDialog(null, "请选择需要修改的数据");
				
			}else{
				int id = (int) hm.getValueAt(number, 0);
				Membership temp = msu.showHeroByID(id);
				new MembershipUpdate(temp);
				this.dispose();
			}
		}else if(e.getSource() == search){
			String contentTest = content.getText();
			hm = new UserModel(contentTest);
			
			jt.setModel(hm);				
		}else if(e.getSource() == jb4){
			this.dispose();
		}
		
	}
	




}

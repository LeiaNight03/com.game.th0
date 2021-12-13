package com.th0.Userservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.th0.entity.Membership;


public class UserModel extends AbstractTableModel{
	//定义两个集合，一个用于装表头，一个用于装数据
	ArrayList rowData,columnNames;
	MsUserservice msus = new MsUserservice();
	public UserModel() {
		columnNames = new ArrayList();
		columnNames.add("ID");
		columnNames.add("账号");
		columnNames.add("昵称");
		//columnNames.add("密码");
		columnNames.add("电话号码");
		columnNames.add("游戏局数");
		columnNames.add("段位");
		columnNames.add("金币");
		columnNames.add("最高纪录");
		columnNames.add("状态");
		columnNames.add("管理员");
		
		
		List<Membership> list = msus.showHeroAll();
		rowData = new ArrayList();
		for(int i = 0; i< list.size();i++){
			ArrayList array = new ArrayList();
			array.add(list.get(i).getID());
			array.add(list.get(i).getUserName());
			array.add(list.get(i).getNickName());
			array.add(list.get(i).getPhoneNum());
			array.add(list.get(i).getGameNum());
			array.add(list.get(i).getRank());
			array.add(list.get(i).getGold());
			array.add(list.get(i).getBestscore());
			array.add(list.get(i).isStatus());
			array.add(list.get(i).isAdmin());
			rowData.add(array);
		}
		
	}
	
	public UserModel (String content){
		columnNames = new ArrayList();
		columnNames.add("ID");
		columnNames.add("账号");
		columnNames.add("昵称");
		//columnNames.add("密码");
		columnNames.add("电话号码");
		columnNames.add("游戏局数");
		columnNames.add("段位");
		columnNames.add("金币");
		columnNames.add("最高纪录");
		columnNames.add("状态");
		columnNames.add("管理员");
		
		
		//装数据
		List<Membership> list = msus.selectMembershipContent(content);
		rowData = new ArrayList();
		for(int i = 0; i< list.size();i++){
			ArrayList array = new ArrayList();
			array.add(list.get(i).getID());
			array.add(list.get(i).getUserName());
			array.add(list.get(i).getNickName());
			array.add(list.get(i).getPhoneNum());
			array.add(list.get(i).getGameNum());
			array.add(list.get(i).getRank());
			array.add(list.get(i).getGold());
			array.add(list.get(i).getBestscore());
			array.add(list.get(i).isStatus());
			array.add(list.get(i).isAdmin());
			rowData.add(array);
		}
		
	}
	
	
	
	@Override
	public int getRowCount() {
		return this.rowData.size();
	}
	@Override
	public int getColumnCount() {
		return this.columnNames.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((ArrayList)this.rowData.get(rowIndex)).get(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		return (String) this.columnNames.get(column);
	}
}

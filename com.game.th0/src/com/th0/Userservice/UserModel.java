package com.th0.Userservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.th0.entity.Membership;


public class UserModel extends AbstractTableModel{
	//�����������ϣ�һ������װ��ͷ��һ������װ����
	ArrayList rowData,columnNames;
	MsUserservice msus = new MsUserservice();
	public UserModel() {
		columnNames = new ArrayList();
		columnNames.add("ID");
		columnNames.add("�˺�");
		columnNames.add("�ǳ�");
		//columnNames.add("����");
		columnNames.add("�绰����");
		columnNames.add("��Ϸ����");
		columnNames.add("��λ");
		columnNames.add("���");
		columnNames.add("��߼�¼");
		columnNames.add("״̬");
		columnNames.add("����Ա");
		
		
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
		columnNames.add("�˺�");
		columnNames.add("�ǳ�");
		//columnNames.add("����");
		columnNames.add("�绰����");
		columnNames.add("��Ϸ����");
		columnNames.add("��λ");
		columnNames.add("���");
		columnNames.add("��߼�¼");
		columnNames.add("״̬");
		columnNames.add("����Ա");
		
		
		//װ����
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

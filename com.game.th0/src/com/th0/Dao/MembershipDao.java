package com.th0.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.th0.entity.Membership;

public class MembershipDao extends Operation{

	public boolean checkusername(String content) {
		boolean flag = true;
		String sql = "select * from Membership where username like ?";
		executeQuery(sql, content);
		try {
			if(rs.next()){
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean checknickname(String content) {
		boolean flag = true;
		String sql = "select * from Membership where nickname like ? ";
		executeQuery(sql, content);
		try {
			if(rs.next()){
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean regeister(Membership ms) {
		boolean flag = false;
	    String sql = "insert into Membership (username,nickname,password,phonenum) values (?,?,?,?)";
	    executeUpdate(sql, ms.getUserName(),ms.getNickName(),ms.getPassword(),ms.getPhoneNum());
		if(count>0){
			flag = true;
		}
	    	//System.out.println("ok");    
	    return flag;
		
	}
	
	public Membership Login(String username,String password) throws SQLException{
		Membership mslogin = null;
		String sql = "select * from Membership where username = ? and password = ?";
	    executeQuery(sql, username,password);	    
	    while(rs.next()){
	    	mslogin = new Membership();
	    	mslogin.setID(rs.getInt(1));
	    	mslogin.setUserName(rs.getString(2));
	    	mslogin.setNickName(rs.getString(3));
	        mslogin.setPassword("password");
	        mslogin.setPhoneNum(rs.getString(5));
	        mslogin.setGameNum(rs.getInt(6));
	        mslogin.setRank(rs.getString(7));
	        mslogin.setGold(rs.getInt(8));
	        mslogin.setBestscore(rs.getInt(9));
	        mslogin.setStatus(rs.getBoolean(10));
	    	mslogin.setAdmin(rs.getBoolean(11));
	    }
		return mslogin;

	
	}
	
	public List<Membership> showAll() throws SQLException {
	 ArrayList<Membership> list = new ArrayList<Membership>();
		String sql = "select * from Membership where admin is false";
		executeQuery(sql, null);
		while(rs.next()){
		Membership mst = new Membership();
		mst.setID(rs.getInt(1));
		mst.setUserName(rs.getString(2));
		mst.setNickName(rs.getString(3));
		mst.setPassword(rs.getString(4));
		mst.setPhoneNum(rs.getString(5));
		mst.setGameNum(rs.getInt(6));
		mst.setRank(rs.getString(7));
		mst.setGold(rs.getInt(8));
		mst.setBestscore(rs.getInt(9));
		mst.setStatus(rs.getBoolean(10));
		mst.setAdmin(rs.getBoolean(11));
		list.add(mst);
		}
	 return list;
	}
	
    public ArrayList<Membership> selectMembershipContent(String content) throws SQLException {
		 ArrayList<Membership> list = new ArrayList<Membership>();
    	   String sql = "select * from Membership where UserName like ? or NickName like ? or Rank like ? ";
       	executeQuery(sql, "%"+content+"%","%"+content+"%","%"+content+"%");
 			while(rs.next()){
 				Membership mst = new Membership();
 				mst.setID(rs.getInt(1));
 				mst.setUserName(rs.getString(2));
 				mst.setNickName(rs.getString(3));
 				mst.setPassword(rs.getString(4));
 				mst.setPhoneNum(rs.getString(5));
 				mst.setGameNum(rs.getInt(6));
 				mst.setRank(rs.getString(7));
 				mst.setGold(rs.getInt(8));
 				mst.setBestscore(rs.getInt(9));
 				mst.setStatus(rs.getBoolean(10));
 				mst.setAdmin(rs.getBoolean(11));
 				list.add(mst);
 			 }
		return list;
	}
	
	public boolean updatestatusById(int id) {
		boolean temp = true;
		boolean flag = false;
		String sql1 = "select status from membership where id = ?";
		executeQuery(sql1, id);
		try {
			while(rs.next()){
				temp = !(rs.getBoolean(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql2 = "update membership set status = ? where id = ?";
		executeUpdate(sql2, temp,id);
		if(temp){
			flag = true;
		}
		return flag;
	}
	
	public Membership selectByID(int id){
		String sql = "select * from Membership where id = ? ";
       	executeQuery(sql, id);
       	Membership mst = new Membership();
 			    try {
					while(rs.next()){
					mst.setID(rs.getInt(1));
					mst.setUserName(rs.getString(2));
					mst.setNickName(rs.getString(3));
					mst.setPassword(rs.getString(4));
					mst.setPhoneNum(rs.getString(5));
					mst.setGameNum(rs.getInt(6));
					mst.setRank(rs.getString(7));
					mst.setGold(rs.getInt(8));
					mst.setBestscore(rs.getInt(9));
					mst.setStatus(rs.getBoolean(10));
					mst.setAdmin(rs.getBoolean(11));
	 }
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return mst;
	}
	
	public boolean update(Membership ms) {
		boolean flag = false;
		String sql = "update Membership set username = ?,nickname= ?,phonenum = ?,gamenum = ?,rank = ?,gold= ?,bestscore = ? where id = ?";
		executeUpdate(sql, ms.getUserName(),ms.getNickName(),ms.getPhoneNum(),ms.getGameNum(),ms.getRank(),ms.getGold(),ms.getBestscore(),ms.getID());
	    if(count>0){
	    	flag = true;
	    }
	return flag;
	}
	
    public boolean regeisteradmin(Membership ms) {
		boolean flag = false;
	    String sql = "insert into Membership (username,nickname,password,phonenum,admin) values (?,?,?,?,?)";
	    executeUpdate(sql, ms.getUserName(),ms.getNickName(),ms.getPassword(),ms.getPhoneNum(),ms.isAdmin());
		if(count>0){
			flag = true;
		}
	    	System.out.println("ok");    
	    return flag;
		
	}
	
    public boolean updatebestscore(int score,int id){
    	boolean flag = false;
    	String sql = "update Membership set bestscore= ? where id = ?";
        executeUpdate(sql, score,id);
        if(count>0){
	    	flag = true;
	    }
	return flag;
    
    }
	
	public boolean updaterank(String nrank,int id){
		boolean flag = false;
		String sql= "update Membership set rank = ? where id = ?";
	    executeUpdate(sql, nrank,id);
	    if(count>0){
	    	flag = true;
	    }
	return flag;
	}
	
	public ArrayList<Membership> selectMembershiprank() throws SQLException {
		 ArrayList<Membership> list = new ArrayList<Membership>();
   	     String sql = "select * from membership where status = true order by bestscore desc";
      	executeQuery(sql);
		int i = 0;
      	while(rs.next()){
				if(i<=10){
				Membership mst = new Membership();
				mst.setNickName(rs.getString(3));
				mst.setBestscore(rs.getInt(9));
				list.add(mst);
				}
				else {
					break;
				}
			 }
		return list;
	}
	public boolean updategamenum(Membership ms) {
		boolean flag = false;
		String sql = "update membership set gamenum = ?,gold= ? where id = ?";
		executeUpdate(sql, ms.getGameNum(),ms.getGold(),ms.getID());
		if(count>0){
			flag = true;
		}
		return flag;
	}
}

package com.th0.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.th0.entity.Membership;

public class Operation {
	private String DRIVER = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/th0";
	private String USER = "root";
	private String PWD = "root";
	public ResultSet rs;
    public int count = 0 ;
	         
	         public boolean executeUpdate(String sql,Object...params){
	        	 boolean flag = false;
	        	 try {
	        		 
					Class.forName(DRIVER);
				    Connection conn = DriverManager.getConnection(URL, USER, PWD);
	        	    PreparedStatement pstmt = conn.prepareStatement(sql);
	        	    for(int i =0; i<params.length;i++){
	        	    	pstmt.setObject((i+1), params[i]);
	        	    }
	        	    count = pstmt.executeUpdate();
	        	    if(count > 0){
	        	    	flag = true;
	        	    }
	        	 } catch (ClassNotFoundException e) {		
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return flag;
	         }
	         
	         public void executeQuery(String sql,Object...params){
	        	 ArrayList<Membership> list = new ArrayList<Membership>();
	        	 try {
	        		 
					Class.forName(DRIVER);
				    Connection conn = DriverManager.getConnection(URL, USER, PWD);
	        	    PreparedStatement pstmt = conn.prepareStatement(sql);
	        	   if(null != params){
	        		   for (int i =0;i<params.length;i++){
	        			   pstmt.setObject((i+1),params[i]);
	        		   }
	        	   }
	        	   rs = pstmt.executeQuery();
	        	 
	        	    
	        	 } catch (ClassNotFoundException e) {		
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	         } 
              
	     
}



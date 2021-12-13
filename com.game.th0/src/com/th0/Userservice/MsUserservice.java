package com.th0.Userservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Expection.UserNameException;

import com.th0.Dao.MembershipDao;
import com.th0.entity.Membership;

public class MsUserservice {
    MembershipDao msDao = new MembershipDao();          
	Membership ms = new Membership();
	
	
	
    public boolean regeister(Membership msregeister) throws UserNameException{
		boolean flag = false;
    	if(msregeister.getUserName()==null||msregeister.getNickName()==null||msregeister.getPassword()==null||msregeister.getPhoneNum()==null){
			throw new UserNameException("不能为空");
		}else{
    	
    	String  userName = msregeister.getUserName();
    	String  nickName = msregeister.getNickName();
		String  password = msregeister.getPassword();
		String  phoneNum = msregeister.getPhoneNum();
		String unp = "^[a-zA-Z][a-zA-Z0-9_]{4,31}$";
		String nnp = "^.{3,31}$";
		String pwp = "^[a-zA-Z]\\w{5,17}$";
		String pnp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
		
		
		boolean unm,nnm,pwm,pnm;
		unm = Pattern.matches(unp, userName);
		nnm = Pattern.matches(nnp, nickName);
		pwm = Pattern.matches(pwp, password);
		pnm = Pattern.matches(pnp, phoneNum);
 		boolean isNickName = msDao.checknickname(nickName);
 		//System.out.println(isNickName);
 		boolean isUserName = msDao.checkusername(userName);
		//System.out.println(isUserName);
 		if(unm&&nnm&&pwm&&pnm&&isNickName&&isUserName){
			
				msDao.regeister(msregeister);
				flag = true;
			}else if(isNickName == false){
				throw new UserNameException("用户名已被注册");
			}else if (isUserName == false){
				throw new UserNameException("昵称已被占用");
			}else if(unm == false){
				throw new UserNameException("用户名格式错误"); 
			}else if (nnm == false){
				throw new UserNameException("昵称格式错误");
			}else if(pwm == false ){
				throw new UserNameException("密码格式错误");			
		}
	}
    	return flag;
    }
    
    
    public Membership Login(String username,String password){
    	Membership mslogin = null;
    	mslogin = new Membership();
    	try {
			mslogin =  msDao.Login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mslogin;
    }


	public List<Membership> showHeroAll()  {
		List<Membership> list = null;
		try {
			list =  msDao.showAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<Membership> selectMembershipContent(String content) {
		 ArrayList<Membership> list = new ArrayList<Membership>();
		 try {
			list = msDao.selectMembershipContent(content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public boolean changeStatus(int id) {		
		return  msDao.updatestatusById(id);
	}


	public Membership showHeroByID(int id) {		
		return msDao.selectByID(id);
	}
   
	 public boolean update(Membership msregeister) throws UserNameException{
			boolean flag = false;
	    	if(msregeister.getUserName()==null||msregeister.getNickName()==null||msregeister.getPhoneNum()==null||msregeister.getRank()==null){
				throw new UserNameException("不能为空");
			}else{
	    	
	    	String  userName = msregeister.getUserName();
	    	String  nickName = msregeister.getNickName();
			String  password = msregeister.getPassword();
			String  phoneNum = msregeister.getPhoneNum();
			String unp = "^[a-zA-Z][a-zA-Z0-9_]{4,31}$";
			String nnp = "^.{3,31}$";
			String pwp = "^[a-zA-Z]\\w{5,17}$";
			String pnp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
			
			
			boolean unm,nnm,pnm;
			unm = Pattern.matches(unp, userName);
			nnm = Pattern.matches(nnp, nickName);
			pnm = Pattern.matches(pnp, phoneNum);
			
	 		boolean isNickName = msDao.checknickname(nickName);
	 		boolean isUserName = msDao.checkusername(userName);
	 		if(unm&&nnm&&pnm){				
					
					flag = msDao.update(msregeister);
					
				}else if(isNickName == false){
					throw new UserNameException("用户名已被注册");
				}else if (isUserName == false){
					throw new UserNameException("昵称已被占用");
				}else if(unm == false){
					throw new UserNameException("用户名格式错误"); 
				}else if (nnm == false){
					throw new UserNameException("昵称格式错误");
				
			}
		}
	    	return flag;
	    }


	public boolean regeisteradmin(Membership msregeister) throws UserNameException {
		boolean flag = false;
    	if(msregeister.getUserName()==null||msregeister.getNickName()==null||msregeister.getPassword()==null||msregeister.getPhoneNum()==null){
			throw new UserNameException("不能为空");
		}else{
    	
    	String  userName = msregeister.getUserName();
    	String  nickName = msregeister.getNickName();
		String  password = msregeister.getPassword();
		String  phoneNum = msregeister.getPhoneNum();
		String unp = "^[a-zA-Z][a-zA-Z0-9_]{4,31}$";
		String nnp = "^.{3,31}$";
		String pwp = "^[a-zA-Z]\\w{5,17}$";
		String pnp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
		
		
		boolean unm,nnm,pwm,pnm;
		unm = Pattern.matches(unp, userName);
		nnm = Pattern.matches(nnp, nickName);
		pwm = Pattern.matches(pwp, password);
		pnm = Pattern.matches(pnp, phoneNum);
 		boolean isNickName = msDao.checknickname(nickName);
 		//System.out.println(isNickName);
 		boolean isUserName = msDao.checkusername(userName);
		//System.out.println(isUserName);
 		if(unm&&nnm&&pwm&&pnm&&isNickName&&isUserName){
 			    msregeister.setAdmin(true);
				msDao.regeisteradmin(msregeister);
				flag = true;
			}else if(isNickName == false){
				throw new UserNameException("用户名已被注册");
			}else if (isUserName == false){
				throw new UserNameException("昵称已被占用");
			}else if(unm == false){
				throw new UserNameException("用户名格式错误"); 
			}else if (nnm == false){
				throw new UserNameException("昵称格式错误");
			}else if(pwm == false ){
				throw new UserNameException("密码格式错误");			
		}
	}
    	return flag;
	}
	
	public boolean updatebestscore(int score,int id){
		return msDao.updatebestscore(score,id);
	}
	
	public boolean updaterank(Membership ms){
		boolean flag = false;
		String temp = ms.getRank();
		String nrank = "Plastic";
		int res = ms.getGold()/ms.getGameNum();
		if(res>20000){
			nrank = "gurn";
		}else if(res>10000){
			nrank = "master";
		}else if(res > 5000){
			nrank = "platinum";
		}else if(res >3000){
			nrank = "gold";
		}else if(res > 1000){
			nrank = "sliver";
		}else if(res>600){
			nrank = "copper";
		}else{
			nrank = "Plastic";
		}
		if(nrank.equalsIgnoreCase(temp)){
			flag  =false;
		}else {
			flag = true;
			msDao.updaterank(nrank,ms.getID());
		}
		return flag;
		
	}
	public List<Membership> selectMembershiprank() {
		 ArrayList<Membership> list = new ArrayList<Membership>();
		 try {
			list = msDao.selectMembershiprank();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public boolean updategamenum(Membership ms) {
		return msDao.updategamenum(ms);
		
	}
	
}

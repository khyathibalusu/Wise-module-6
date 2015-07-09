package com.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.bts.beans.*;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.jdbc.ConnectionFactory;

public class BtsDao {
	
	public static boolean checkLogin(LoginBean lb){
		try{
			
			Connection con = ConnectionFactory.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from loginver where EmpId=? and LoginId=? and Password=? ");
			System.out.println(lb.getLid()+" "+lb.getUid()+" "+lb.getPwd());
			ps.setInt(2, lb.getLid());
			ps.setString(1, lb.getUid());
			ps.setString(3, lb.getPwd());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				return true;
			
			
			
		} catch(Exception e){
			System.out.println(e);
		}
		
		return false;
	}
	
	public static boolean user(LoginBean ul) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from loginver where LoginId=? ");
			ps.setInt(1,ul.getLid());
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int uid=Integer.parseInt(rs.getString("LoginId"));
				PreparedStatement bs = con.prepareStatement("select Password from loginver where  LoginId=? ");
				bs.setInt(1, uid);
				ResultSet rss=bs.executeQuery();
				if(rss.next())
				{
					return true;
				}
				

			}
						
	
		}
		catch(Exception es) {
			es.printStackTrace();
		}
		return false;
	}


public  static   ArrayList<LoginBean> getOne(LoginBean u) {
    System.out.println("Checked");
    ArrayList<LoginBean> al= new ArrayList<LoginBean>();
    try
    {
        Connection con =ConnectionFactory.getConnection();
PreparedStatement st =con.prepareStatement("insert  into emptable values('?','?',?)");
st.setString(1, u.getUid());
st.setString(3, u.getPwd());
st.setInt(2,u.getLid());
ResultSet rs= st.executeQuery();

System.out.println("Checked");
while(rs.next())
{
    LoginBean uu=new LoginBean();
    System.out.println("New user registered successfully");
    System.out.println(uu.getLid()+" "+uu.getUid()+" "+uu.getPwd());
uu.setUid(rs.getString("Uid"));
uu.setPwd(rs.getString("Pwd"));
uu.setLid(rs.getInt("Lid"));
al.add(uu);
    }
    return al;
}
catch(Exception es){ }
return null;
}



public static boolean InsertLoginBean(LoginBean l) {
	// TODO Auto-generated method stub
	
	
	try {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("Insert into loginver values(?,?,?)");
        ps.setString(1,l.getUid());
        ps.setInt(2,l.getLid());
        ps.setString(3,l.getPwd());
        
        
        ps.executeUpdate();
        return true;
    }
    catch (Exception e) {
       System.out.println(e);
 
    }
return false;
}
  


public static boolean InsertProfile(LoginBean l) {
	// TODO Auto-generated method stub
	
	
	try {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("Insert into loginver values(?,?,?)");
        ps.setString(1,l.getName());
        ps.setInt(7,l.getPhn());
        ps.setString(6,l.getEM());
        
        
        ps.executeUpdate();
        return true;
    }
    catch (Exception e) {
       System.out.println(e);
 
    }
return false;
}
  
	



public static boolean InsertProject(LoginBean s) {
	// TODO Auto-generated method stub
	
	
	try {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("Insert into projectname values(?,?,?,?,?,?)");
        ps.setString(1,s.getPN());
        ps.setString(2, s.getPI());
        ps.setInt(4, s.getNE());
        ps.setDate(5, s.getSD());
        ps.setDate(6, s.getED());
        ps.setString(3, s.getAM());
        
        ps.executeUpdate();
        return true;
    }
    catch (Exception e) {
       System.out.println(e);
 
    }
return false;
}
public  static   ArrayList<LoginBean> insertProject(LoginBean u) {
    System.out.println("Checked");
    ArrayList<LoginBean> al= new ArrayList<LoginBean>();
    try
    {
        Connection con =ConnectionFactory.getConnection();
PreparedStatement st =con.prepareStatement("insert  into projectname values(?,?,?,?,?,?)");
st.setString(1, u.getPN());
st.setString(2, u.getPI());
st.setInt(4, u.getNE());
st.setDate(5, u.getSD());
st.setDate(6,u.getED());
st.setString(3,u.getAM());
ResultSet rs= st.executeQuery();

System.out.println("Checked");
while(rs.next())
{
    LoginBean uu=new LoginBean();
    System.out.println("New user registered successfully");
    System.out.println(uu.getPN()+" "+uu.getSD()+" "+uu.getED()+" "+uu.getAM());
uu.setPN(rs.getString("PN"));
uu.setSD(rs.getDate("SD"));
uu.setED(rs.getDate("ED"));
uu.setAM(rs.getString("AM"));
al.add(uu);
    }
    return al;
}
catch(Exception es){ }
return null;
}


public static boolean LoginVer(LoginBean lb) {
	// TODO Auto-generated method stub
		try{
			
			Connection con = ConnectionFactory.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from loginver where LoginId=? and Password=? ");
			System.out.println(lb.getLid()+" " +lb.getPwd());
			ps.setInt(1, lb.getLid());
			
			ps.setString(2, lb.getPwd());
			
			ResultSet rs = ps.executeQuery();
		
		
		
		if(rs.next())
			return true;
		
		}
			
			
			
		 catch(Exception e){
			System.out.println(e);
		}
		
		return false;
	}
	
	
	
public static boolean InsertBug(LoginBean s) {
	// TODO Auto-generated method stub
	
	
	try {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("Insert into bug values(?,?,?)");
        ps.setString(1,s.getPost());
        ps.setString(2, s.getPname());
        ps.setString(3, s.getSt());
        
        
       
        ps.executeUpdate();
        return true;
    }
    catch (Exception e) {
       System.out.println(e);
 
    }
return false;
}
public  static   ArrayList<LoginBean> insertBug(LoginBean u) {
    System.out.println("Checked");
    ArrayList<LoginBean> al= new ArrayList<LoginBean>();
    try
    {
        Connection con =ConnectionFactory.getConnection();
PreparedStatement st =con.prepareStatement("insert  into bug values(?,?,?)");
st.setString(1, u.getPost());
st.setString(2, u.getPname());
st.setString(3, u.getSt());


ResultSet rs= st.executeQuery();

System.out.println("Checked");
while(rs.next())
{
    LoginBean uu=new LoginBean();
    System.out.println("New user registered successfully");
    System.out.println(uu.getPost()+" "+uu.getPname()+" "+uu.getSt());
uu.setPost(rs.getString("Post"));
uu.setPname(rs.getString("Pname"));
uu.setSt(rs.getString("St"));

al.add(uu);
    }
    return al;
}
catch(Exception es){ }
return null;
}



	
public static boolean InsertSol(LoginBean s) {
	// TODO Auto-generated method stub
	
	
	try {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("Insert into bugsolutions values(?,?,?)");
        ps.setString(1,s.getBN());
        ps.setString(2, s.getPsn());
        ps.setString(3, s.getSoln());
        
        
       
        ps.executeUpdate();
        return true;
    }
    catch (Exception e) {
       System.out.println(e);
 
    }
return false;
}
public  static   ArrayList<LoginBean> insertSol(LoginBean u) {
    System.out.println("Checked");
    ArrayList<LoginBean> al= new ArrayList<LoginBean>();
    try
    {
        Connection con =ConnectionFactory.getConnection();
PreparedStatement st =con.prepareStatement("insert  into bugsolutions values(?,?,?)");
st.setString(1, u.getBN());
st.setString(2, u.getPsn());
st.setString(3, u.getSoln());


ResultSet rs= st.executeQuery();

System.out.println("Checked");
while(rs.next())
{
    LoginBean uu=new LoginBean();
    System.out.println("New user registered successfully");
    System.out.println(uu.getPost()+" "+uu.getPname()+" "+uu.getSt());
uu.setBN(rs.getString("BN"));
uu.setPsn(rs.getString("Psn"));
uu.setSoln(rs.getString("Soln"));

al.add(uu);
    }
    return al;
}
catch(Exception es){ }
return null;
}

	
	





	
}
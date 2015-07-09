package com.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bts.beans.*;

import java.util.ArrayList;

import com.jdbc.ConnectionFactory;

public class BtsDao {
	
	public static boolean checkLogin(LoginBean lb){
		try{
			
			Connection con = ConnectionFactory.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from loginver where EmpId=? and LoginId=? and Password=? ");
			System.out.println(lb.getLid()+" "+lb.getUid()+" "+lb.getPwd());
			ps.setInt(1, lb.getLid());
			ps.setString(2, lb.getUid());
			ps.setString(3, lb.getPwd());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				return true;
			
			
			
		} catch(Exception e){
			System.out.println(e);
		}
		
		return false;
	}
	
	
	

	
	    public static boolean insertUser(LoginBean lb) {
	        try
	        {
	            Connection con =ConnectionFactory.getConnection();
	            PreparedStatement ps = con.prepareStatement("insert into emptable(?,?, ?)");
	            ps.setInt(1, lb.getLid());
	            ps.setString(2, lb.getUid());
	            ps.setString(3, lb.getPwd());
	            ps.executeUpdate();
	            
	            return true;
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }
	        return false;
	        
	                    
	        }
	    public ArrayList<LoginBean> getAll() {
	        ArrayList<LoginBean> al= new ArrayList<LoginBean>();
	        try
	        {
	            Connection con =ConnectionFactory.getConnection();
	    Statement st =con.createStatement();
	    ResultSet rs= st.executeQuery("select * from loginver");
	    while(rs.next())
	    {
	        LoginBean u=new LoginBean();
	    
	    u.setUid(rs.getString("EmpId"));
	    u.setLid(rs.getInt("LoginId"));
	    u.setPwd(rs.getString("password"));
	    al.add(u);
	        }
	        return al;
	    }
	catch(Exception e){}
	return null;
	}
			
			
	}

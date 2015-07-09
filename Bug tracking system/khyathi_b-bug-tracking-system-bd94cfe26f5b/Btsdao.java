package com.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.ConnectionFactory;

public class BtsDao {
public static boolean checkLogin(String uid, String pwd){
try{
Connection con = ConnectionFactory.getConnection();
PreparedStatement ps = con.prepareStatement("select * from loginver where loginid=? and password=?");
ps.setString(1, uid);
ps.setString(2, pwd);
ResultSet rs = ps.executeQuery();
if(rs.next())
return true;
else
return false;
} catch(Exception e){
System.out.println(e);
}
return false;
}

}

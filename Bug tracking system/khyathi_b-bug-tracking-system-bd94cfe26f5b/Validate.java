package com.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
import java.sql.*;

public class Validate
 {
 
     public static boolean checkUser(String LoginId,String Password) 
     {
      boolean st =false;
      try{

//loading driver 
         Class.forName("com.mysql.jdbc.Driver");

 	//creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/mysql","root","root");
         PreparedStatement ps =con.prepareStatement
                             ("select * from loginver  where LoginId=? and Password=?");
         ps.setString(1, LoginId);
         ps.setString(2, Password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}

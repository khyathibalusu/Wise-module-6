package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.validation.Validator;

import com.bts.beans.LoginBean;
import com.bts.dao.BtsDao;

/**
 * Servlet implementation class Login
 */


public class LoginValueExtraction extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String LoginId= request.getParameter("LoginId");
        String Password = request.getParameter("Password");
        
        LoginBean lb = new LoginBean();
        lb.setUid(LoginId);
        lb.setPwd(Password);
        
        if(BtsDao.checkLogin(LoginId, Password)){
        RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
           System.out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("version2.html");
           rs.include(request, response);
        }
       
    }  
}

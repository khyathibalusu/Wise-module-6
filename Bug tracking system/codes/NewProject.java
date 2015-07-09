package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bts.beans.LoginBean;
import com.bts.dao.BtsDao;

/**
 * Servlet implementation class Newproject
 */
public class Newproject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newproject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  response.getWriter();
        try {
        response.setContentType("text/html");
        String ProjectName = request.getParameter("PN");
        String StartDate = (request.getParameter("SD"));
        String EndDate = (request.getParameter("ED"));
        String AssignedManager = request.getParameter("AM");
        String ProjectId = request.getParameter("PI");
        int NoofEmp = Integer.parseInt(request.getParameter("NE"));

        System.out.println(ProjectName+" "+StartDate+" "+EndDate+" "+AssignedManager);
       
        
        LoginBean l= new LoginBean();
        l.setPN(ProjectName);
        l.setSD(java.sql.Date.valueOf(StartDate));
        l.setED(java.sql.Date.valueOf(EndDate));
        l.setAM(AssignedManager);
        
        boolean b = BtsDao.InsertProject(l);
        
       
        if (b == true)
        	
        {
        	out.println("Registration is successful");
        	RequestDispatcher rd=request.getRequestDispatcher("/successreg.jsp");
        	rd.include(request, response);    
        }
        
        else
        {
        	out.println("Please register again");
        	RequestDispatcher rd=request.getRequestDispatcher("/adminpage.jsp");
        	rd.include(request, response);    
        }


        }
        
	catch (Exception e) {
		
	out.println(e);
}

	}





	






	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
}
	}
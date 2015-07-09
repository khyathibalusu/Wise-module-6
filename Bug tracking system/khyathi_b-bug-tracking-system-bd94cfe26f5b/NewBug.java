package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bts.beans.LoginBean;
import com.bts.dao.BtsDao;

/**
 * Servlet implementation class NewBug
 */
public class NewBug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBug() {
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
        String Bug = request.getParameter("post");
        String Project = request.getParameter("pname");
        String Status = request.getParameter("st");
        
        
        
        
        
        
        
        
        System.out.println(Bug+" "+Project);      
        
        LoginBean l= new LoginBean();
        l.setPost(Bug);
        l.setPname(Project);
        l.setSt(Status);
        
   
        
        boolean b = BtsDao.InsertBug(l);
        
       
        if (b == true)
        	
        {
        	//out.println("Registration is successful");
        	RequestDispatcher rd=request.getRequestDispatcher("/bugsuccess.jsp");
        	rd.include(request, response);    
        }
        
        else
        {
        	out.println("Please register again");
        	RequestDispatcher rd=request.getRequestDispatcher("/Tester.jsp");
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
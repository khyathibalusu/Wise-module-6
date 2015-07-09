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
 * Servlet implementation class NewSolution
 */
public class NewSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSolution() {
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
        String BugName = request.getParameter("BN");
        String ProjectName = request.getParameter("psn");
        String Solution = request.getParameter("soln");
        
        
        
        
        
        
        
        
        System.out.println(BugName+" "+ProjectName+" "+Solution);      
        
        LoginBean l= new LoginBean();
        l.setBN(BugName);
        l.setPsn(ProjectName);
        l.setSoln(Solution);
        
   
        
        boolean b = BtsDao.InsertSol(l);
        
       
        if (b == true)
        	
        {
        	//out.println("Registration is successful");
        	RequestDispatcher rd=request.getRequestDispatcher("/bugsuccess.jsp");
        	rd.include(request, response);    
        }
        
        else
        {
        	out.println("Please register again");
        	RequestDispatcher rd=request.getRequestDispatcher("/Developer.jsp");
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
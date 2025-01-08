package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;
import com.bean.PatientIdBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class PatientIdController
 */
@WebServlet("/PatientIdController")
public class PatientIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("In Login Controller");
		 
		 
		 
			String id = request.getParameter("patientid");
			System.out.println(id);
			PatientIdBean pobj = new PatientIdBean(id);
			RegisterDao rd = new RegisterDao();
			boolean b=rd.ValidatePatientId(pobj);				
			if(b){
				Registrationbean r=rd.DisplayUser(id);
				System.out.println(r.getCity());
				HttpSession session = request.getSession(true);
				session.setAttribute("UserObj",r);
				request.getRequestDispatcher("Dashboard1.jsp").forward(request, response);
			}
			else{
				response.sendRedirect("Error.jsp");
			}
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

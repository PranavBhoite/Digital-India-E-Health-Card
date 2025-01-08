package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.DoctorLoginBean;
import com.bean.LoginBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;


/**
 * Servlet implementation class AddDoctorLogin
 */
@WebServlet("/AddDoctorLogin")
public class AddDoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        System.out.println("In Login Controller");
		
		String license = request.getParameter("license");
		String password = request.getParameter("password");
		System.out.println(license+password);
		DoctorLoginBean lobj = new DoctorLoginBean(license, password);
		RegisterDao rd = new RegisterDao();
		boolean b=rd.ValidateDoctor(lobj);				
		if(b){
			 
			 request.getRequestDispatcher("patientId.jsp").forward(request, response);
		
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

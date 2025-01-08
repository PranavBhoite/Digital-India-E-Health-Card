package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicalInfoBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddMedicalInfoControllerDr
 */
@WebServlet("/AddMedicalInfoControllerDr")
public class AddMedicalInfoControllerDr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicalInfoControllerDr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String wbg = request.getParameter("bloodgroup");
		String wbp = request.getParameter("bpgroup");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String allergies = request.getParameter("alergies");
		System.out.println("In add medical info controller: "+wbg+wbp+height+weight+allergies);
	
		
		
		HttpSession session = request.getSession(true);
		Registrationbean r=new Registrationbean();
		RegisterDao rd=new RegisterDao();		
		Boolean b=false;
		String str = (String) session.getAttribute("Usernm");
		System.out.println("str: "+str);
		
		r = rd.DisplayUser(str);
		
		MedicalInfoBean mib = new MedicalInfoBean(wbg,wbp,height,weight,allergies,str);
		
		int i = rd.UpdateMedicalInfo(mib);
		if(i > 0){
			session = request.getSession(true);
			session.setAttribute("UserObj",r);
			session.setAttribute("Usernm", str);
			request.getRequestDispatcher("Dashboard1.jsp").forward(request, response);
		}
		else{
			System.out.println("Updation of Amount Failed!");
		}			
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

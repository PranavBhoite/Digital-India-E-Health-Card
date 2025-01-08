package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Registrationbean;
import com.bean.DiseaseBean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddReportImage
 */
@WebServlet("/AddReportImage")
public class AddReportImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReportImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DiseaseBean> dlist = null;
		HttpSession session = request.getSession(true);
		Registrationbean r=new Registrationbean();
		RegisterDao rd=new RegisterDao();
		
		Boolean b=false;
		String str = (String) session.getAttribute("Usernm");
		System.out.println("iN add AddReport Controller!! str: "+str);
		
		
		dlist = rd.DisplayDiseaseHistory(str);
		request.setAttribute("DiseaseHistory", dlist);
		
		request.getRequestDispatcher("photo.jsp").forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

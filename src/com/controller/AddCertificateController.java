package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.CertificateBean;
import com.bean.MedicalInfoBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddCertificateController
 */
@MultipartConfig
@WebServlet("/AddCertificateController")
public class AddCertificateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCertificateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Part file=request.getPart("image"); 
		
		String imageFileName=file.getSubmittedFileName();  // get selected image file name
		System.out.println("Selected Image File Name : "+imageFileName);
		
		String uploadPath="E:\\e-health\\Health-Card-Project (2)\\Health-Card-Project\\Health-Card-Project\\WebContent\\images\\"+imageFileName;  // upload path where we have to upload our actual image
		
		System.out.println("Upload Path : "+uploadPath);
		
		System.out.println(imageFileName);
		
		
		
		// Uploading our selected image into the images folder
		
		try
		{
		
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = request.getSession(true);
		
		int i;
		String name = request.getParameter("vaccinationname");
		String date = request.getParameter("date");
		String authority = request.getParameter("authority");

		System.out.println(name+date+authority+imageFileName);

		
		RegisterDao rd=new RegisterDao();
		PrintWriter pw=response.getWriter();
		Registrationbean r=new Registrationbean();
		
		
		Boolean b=false;
		String str = (String) session.getAttribute("Usernm");
		System.out.println("iN add certificate controller! str: "+str);
		
		r=rd.DisplayUser(str);	
		CertificateBean cerobj = new CertificateBean(name, date, authority, imageFileName,str);
		
		
		
		session.setAttribute("Usernm", str);
		
		 i=rd.upload_certificate(cerobj);	
		if(i>0){
			System.out.println("Certificate saved in db!!");				
			pw.println("<script>alert('Certificate Uploaded Successfully');</script>");
			session = request.getSession(true);
			session.setAttribute("UserObj",r);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}
		}
	
	}


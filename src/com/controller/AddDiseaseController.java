package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.DiseaseBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddDiseaseController
 */
@MultipartConfig
@WebServlet("/AddDiseaseController")
public class AddDiseaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiseaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

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
			Registrationbean r=new Registrationbean();
			RegisterDao rd=new RegisterDao();		
			Boolean b=false;
			String str = (String) session.getAttribute("Usernm");
			System.out.println("iN add disease controller! str: "+str);
			
			r=rd.DisplayUser(str);		
			session.setAttribute("Usernm", str);
			
			String dname = request.getParameter("full_name");
			String dduration = request.getParameter("Period");
			String dsym = request.getParameter("message");
			String dmed = request.getParameter("medication");
			String dloc = request.getParameter("loc");
			String dhier = request.getParameter("hier_name");
			
			System.out.println(dname+dduration+dsym+dmed+dloc+dhier+str+imageFileName+str);
			
			DiseaseBean db = new DiseaseBean(dname,dduration,dsym,dmed,dloc,dhier,imageFileName,str);
			int i=rd.save_disease_Rec_Data(db);	
			if(i>0){
				System.out.println("Disease saved in db!!");				
				session = request.getSession(true);
				session.setAttribute("UserObj",r);
				request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
			}

			
			
			
			
		}

}

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
import javax.servlet.http.Part;

import com.bean.MedicalInfoBean;
import com.bean.DoctorRegistrationBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddDoctorRegistration
 */

@MultipartConfig
@WebServlet("/AddDoctorRegistration")
public class AddDoctorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorRegistration() {
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
		
		int i;
		String license = request.getParameter("medicallicense");
		String password = request.getParameter("pass");
	
		

		System.out.println(license+password+imageFileName);

		DoctorRegistrationBean drobj = new DoctorRegistrationBean(license,password,imageFileName);
		RegisterDao rd = new RegisterDao();
		i=rd.save_doctor_Rec_Data(drobj);
		
			if(i > 0){
				response.sendRedirect("doctorlogin.jsp");
			
			
			}
			else{
				response.sendRedirect("Error.jsp");
				System.out.println("Insertion Failed in medical data!");
			}
		}			
	}



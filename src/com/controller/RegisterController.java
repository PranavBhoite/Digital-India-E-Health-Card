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
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class RegisterController
 */

@MultipartConfig
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part file = request.getPart("image");

        String imageFileName = file.getSubmittedFileName();
        System.out.println("Selected Image File Name : " + imageFileName);

        String uploadPath = "E:\\e-health\\Health-Card-Project (2)\\Health-Card-Project\\Health-Card-Project\\WebContent\\images\\"
                + imageFileName;

        System.out.println("Upload Path : " + uploadPath);

        System.out.println(imageFileName);

        try {

            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String regFname = request.getParameter("firstname");
        String regMname = request.getParameter("mname");
        String regLname = request.getParameter("sname");
        String dob = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        String mobno = request.getParameter("mobno");
        String pass = request.getParameter("pass");
        String image = imageFileName;

        Registrationbean regobj = new Registrationbean(regFname, regMname, regLname, dob, gender, state, city, email,
                mobno, pass, image, null);
        regobj.createHealthid();

        String id = regobj.getHealthid();

        MedicalInfoBean mib = new MedicalInfoBean("NA", "NA", "NA", "NA", "NA", id);
        RegisterDao rd = new RegisterDao();
        int i = rd.saveData(regobj);

        if (i > 0) {
            i = rd.saveMedicalData(mib);
            if (i > 0) {
                // Redirect to display.jsp with Health ID as parameter
                response.sendRedirect("login.jsp?id=" + id);
            } else {
                response.sendRedirect("Error.jsp");
                System.out.println("Insertion Failed in medical data!");
            }
        } else {
            response.sendRedirect("Error.jsp");
            System.out.println("Insertion Failed in registration!");
        }

    }

}

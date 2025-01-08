<%@ page import="com.bean.Registrationbean"%>
<%@ page import="com.bean.DiseaseBean"%>
<%@ page import="com.bean.MedicalInfoBean"%>
<%@ page import="com.bean.CertificateBean"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!List<DiseaseBean> listdhis; %>
	<%
		if (!session.isNew()) {
		listdhis = (List<DiseaseBean>) request.getAttribute("DiseaseHistory");
	%>
	
	<%for(DiseaseBean dhisobjtemp : listdhis){ %>
	
	<center><img src="images//<%=dhisobjtemp.getImage()%>" width="700px"
						height="auto"></center>
						
						
	<%} %>		
	
	
		<%} %>			
						



</body>
</html>
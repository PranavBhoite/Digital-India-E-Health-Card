<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login.healthID</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.0/css/mdb.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="css/patnid.css">
</head>
<body>
   <div class="entirebody">
        <div class="logo">
            <img src="images//logos1.png">
        </div>
        <div class="healthlogo">
            <img src="images//healthidlogo.PNG">
        </div>
        <div class="topnav" id="myTopnav">
			<a href="#home" class="active">Home</a> <a href="login.jsp">Login</a>
			<a href="registration.jsp">Generate ID</a> <a href="#contactofpage">Facility</a>
			<a href="patientId.jsp">Doctor Register</a> 
			<a href="doctorlogin.jsp" >Doctor Login</a>
			<a href="#contactofpage">About</a> <a href="#contactofpage">Contact</a>
			<a href="javascript:void(0);" class="icon" onclick="myFunction()">
				<i class="fa fa-bars"></i>
			</a>
		</div>
		</div>
      <div class="movingtext">
            <marquee style="background-image: linear-gradient(rgb(18, 18, 98), black, rgb(32, 32, 65)); margin-top: 10px;">
                <h5>
                    <b>Health ID - Key to your digital healthcare journey</b> | As you are aware, PM Modi recently announced the National Digital Health Mission. Under this program, citizens will get a unique Health ID which can be used anytime to get
                    a complete medical history of the patient. Generate your Health ID today itself by using your Aadhar card or your mobile number.
                </h5>
            </marquee>
        </div>

        <div class="w3-container w3-cursive" style="text-align: center; background: linear-gradient(green,rgb(59, 179, 35),green); text-align: center; display: block;">
            <table style="width: 100%;">
                <tr>
                    <td>
                        <div class="cardlies">
                            <p class="w3-xlarge" style="color: red; float:left;"><i>"Card NEVER Lies!"</i></p>
                        </div>
                    </td>
                    <td>
                        <p class="w3-large ml6">
                            <span class="text-wrapper">
                  <span class="letters" style="font-size: 25px; font-weight: bolder; color: #fff; -webkit-text-stroke: 2px black; float: right;">Enter Patient Id!!</span>
                            </span>

                        </p>
                    </td>
                    <td>
                        <a href="guidelines.pdf" target="_blank"><Button type="button" style="float: right; background: rgb(255, 0, 0); width: 150px; height: fit-content;"> Guidelines </Button></a>
                        <div class="needhelp">
                            <span style="float: right; margin-top: 20px; font-size: 20px;"> Need Help? &nbsp;&nbsp; </span></div>
                    </td>
                </tr>
            </table>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
        </div>
        <div class="regform">
            <table style="width: 100%;">
                <tr>
                    <td>    
                    </td>
                    <td>
    
     
       <div class="login-box" style="position: absolute; top: 33%; left: 54%; transform: translate(-67%, -66%);">
        <div class="container-login100">
            <div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
               
                <form action="PatientIdController" method="get" name="patientform" class="login100-form validate-form flex-sb flex-w">
                <img src="images//ava.jpg" class="avatar">
               <span class="login100-form-title p-b-32"style="font-size: 15px;  color:#fff;"><br></span>

                   <span class="txt1 p-b-11" style="font-size: 20px; font-weight: bolder; color:#fff;"><br><b>Enter the Patient Id</b></span>
                  <div class="wrap-input100 validate-input m-b-36" data-validate="Username is required" style="background: transparent;">
                  
                 <input class="input100" type="text" name="patientid" style="background: transparent; color:white">

             <span class="focus-input100"></span>
                  </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn">Fetch Data</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
        
         </td>
                   
    
    
              <td>
              </table>
              </div>
              
    
   
    <div id="dropDownSelect1"></div>
    
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="vendor/animsition/js/animsition.min.js"></script>
    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/daterangepicker/moment.min.js"></script>
    <script src="vendor/daterangepicker/daterangepicker.js"></script>
    <script src="vendor/countdowntime/countdowntime.js"></script>
    <script src="js/main.js"></script>
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());
        gtag('config', 'UA-23581568-13');
    </script>
    <script defer src="https://static.cloudflareinsights.com/beacon.min.js/v84a3a4012de94ce1a686ba8c167c359c1696973893317" integrity="sha512-euoFGowhlaLqXsPWQ48qSkBSCFs3DPRyiwVu3FjR96cMPx+Fr+gpWRhIafcHwqwCqWS42RZhIudOvEI+Ckf6MA==" data-cf-beacon='{"rayId":"865407e15e9b2e35","version":"2024.2.4","token":"cd0b4b3a733644fc843ef0b185f98241"}' crossorigin="anonymous"></script>
</body>
</html>
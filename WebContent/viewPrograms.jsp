<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mainpackage.telecompackage.Program"%> 
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Group of Tech</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
  html,body,h1,h2,h3,h4 {font-family:"Lato", sans-serif}
  .mySlides {display:none}
  .w3-tag, .fa {cursor:pointer}
  .w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
  table { font-family: arial, sans-serif; border-collapse: collapse; width: 100%;}
  td { border: 1px solid #dddddd; text-align: left; padding: 8px;}
  th { border: 1px solid #dddddd; text-align: left; padding: 8px;  background-color:  #ac3973;}
</style>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.

    if(session.getAttribute("Username")==null)
    {
        response.sendRedirect("index.html");
    }

%>
<div class="w3-top">
    <div class="w3-row w3-large w3-light-grey">
        <div class="w3-col s3">
            <a href="sellersIndex.jsp" class="w3-button w3-block" style="color: #ac3973;">Back</a>
        </div>
        <div class="w3-col s3">
            <a href="" class="w3-button w3-block"></a>
        </div>
        <div class="w3-col s3">
            <a href="" class="w3-button w3-block"></a>
        </div>
        <div class="w3-col s3">
            <a href="" class="w3-button w3-block"></a>
        </div>
    </div>
</div>

<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-top:80px;margin-bottom:80px">

	<div class="w3-panel" style="text-align: left; color: #ac3973; font-size:10px;">
        <h4><b>WELCOME "${Username}"! </b></h4>
    </div>
    
    <div class="w3-panel" style="text-align: center; color: #ac3973;">
        <h1><b>NINJA GROUP OF TECH</b></h1>
    </div>

    <!-- Grid -->
    <div class="w3-row-padding" id="programs">
        <div class="w3-center w3-padding-64">
            <span class="w3-xlarge w3-bottombar w3-border-light-grey w3-padding-16"> Availabe Programs </span>
        </div>

		<%ArrayList<Program> programList = (ArrayList<Program>)request.getAttribute("programList"); 
        for(Program p:programList){%> 
        <%-- Dynamic cration of squares --%> 
        <div class="w3-third w3-margin-bottom">
            <ul class="w3-ul w3-border w3-center w3-hover-shadow">
                <li class="w3-xlarge w3-padding-32" style="background-color: #ac3973;"><%=p.getProgram_name()%></li>
                <li class="w3-padding-16"><b><%=p.getInternet()%></b> Internet</li>
        		<li class="w3-padding-16"><b><%=p.getMinutes()%></b> Minutes</li>
        		<li class="w3-padding-16"><b><%=p.getSms()%></b> SMS</li>
        		<li class="w3-padding-16"><b>Endless</b> Support</li>
        		<li class="w3-padding-16">
          			<h2 class="w3-wide"><b><%=p.getCost()%></b>&#8364;</h2>
          			<span class="w3-opacity">per month</span>
        		</li>
            </ul>
        </div>
        <%}%>      
    </div>

</div>

<footer class="w3-container w3-padding-32 w3-light-grey w3-center">
    <a href="#" class="w3-button w3-black w3-margin"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
    <div class="w3-xlarge w3-section">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
</footer>
<script>
function closeWindow() {
	  this.close();  /*Closes the new window*/ 
}

</script>
</body>
</html>
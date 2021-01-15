<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mainpackage.telecompackage.Bill"%> 
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
  table { font-family: "Lato", sans-serif; border-collapse: collapse; width: 100%; font-size:18px; margin-left:25px;}
  td { border: 0; text-align: left; padding: 8px; }
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
<!-- Links (sit on top) -->
<div class="w3-top">
    <div class="w3-row w3-large w3-light-grey">
        <div class="w3-col s3">
            <a href="clientsIndex.jsp" class="w3-button w3-block" style="color: #ac3973;">Back</a>
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
        <h4><b>"${Username}" </b></h4>
    </div>
    

    <div class="w3-panel" style="text-align: center; color: #ac3973;">
        <h1><b>NINJA GROUP OF TECH</b></h1>
    </div>
    
    <!-- Table -->
    <div class="w3-row-padding" id="clientsBill">
	    <%Bill clientsBill = (Bill)request.getAttribute("clientsBill");%>
	    <%-- Dynamic way to view clients details --%>
		<fieldset class="w3-center w3-padding-32" >
			<form class="w3-container" action="${pageContext.request.contextPath}/ViewCsBillServlet" method="post" target="_blank">
				<span class="w3-xlarge w3-bottombar w3-border-light-grey w3-padding-16" style="margin-top:10px;"> Client's Bill </span>
				<div>
					<table style="margin-top:50px;">
						<tr><td style="width: 17%; color: #ac3973;">Client: </td><td><%=clientsBill.getUsername()%></td>
						<td style="text-align: right; color: #ac3973;">Month: </td><td><%=clientsBill.getCurrent_month()%></td></tr>
						<tr><td style="width: 17%; color: #ac3973;">AFM: </td><td><%=clientsBill.getAfm()%></td></tr>
						<tr><td style="width: 17%; color: #ac3973;">Phone number:</td><td><%=clientsBill.getPhone_number()%></td></tr>
						<tr><td style="width: 17%; color: #ac3973;">Program name: </td><td><%=clientsBill.getProgram_name()%></td></tr>
					</table>
					<table style="margin-top: 100px;">
						<tr><td style="width: 17%; color: #ac3973;">Monthly payment: </td><td><%=clientsBill.getMonthly_payments()%> $</td>
						<tr><td style="width: 17%; color: #ac3973;">Previous debt: </td><td><%=clientsBill.getPrevious_debt()%> $</td></tr>
					</table>
					<hr style="height:2px;border-width:0;color:gray;background-color:gray;width: 100%;">	
					<table style="margin-top: 17px; width: 95%;">
						<tr><td style="width: 17%; color: #ac3973;">Total payment: </td><td><%=clientsBill.getTotal_payments()%> $</td>
					</table>		
					<table style="margin-top: 17px; width: 95%;">
						<tr>
						<td><a href="${pageContext.request.contextPath}/PayBillServlet" class="w3-button w3-block" style="background-color: #ac3973;">Pay</a></td>
						<td><button type="submit" class="w3-button w3-block" style="background-color: #ac3973;">Print</button></td>
					</table>
		    	</div>
			</form>	
	    </fieldset>	      
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
</body>
</html>
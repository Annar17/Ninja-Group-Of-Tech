<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mainpackage.telecompackage.Call"%> 
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
  th {text-align: left;}
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

    <div class="w3-panel" style="text-align: center; color: #ac3973;">
        <h1><b>NINJA GROUP OF TECH</b></h1>
    </div>

	<div class="w3-panel" style="text-align: left; color: #ac3973; font-size:10px;">
        <h4><b>"${Username}" </b></h4>
    </div>
    
    <!-- Table -->
    <div class="w3-row-padding" id="clientsCallLogs">     
	    <%ArrayList<Call> callList = (ArrayList<Call>)request.getAttribute("callList");%>
	    <%-- Dynamic way to view clients call logs --%>
		<fieldset class="w3-center w3-padding-32" >
			<form class="w3-container" action="${pageContext.request.contextPath}/CallLogsServlet" method="post" target="_blank">
				<span class="w3-xlarge w3-bottombar w3-border-light-grey w3-padding-16" style="margin-top:10px;"> Client's Call Logs </span>
				<div>
					<div class="w3-section" style="text-align: left; font-family: Lato, sans-serif; font-size:18px; margin-left:25px;">
		        		<label>Phone number: </label>
				        <label>"${Phone_number}"</label>
			    	</div>
					<table style="margin-top:50px;">
						<tr><th>Phone number sender</th><th>Phone number recipient</th><th>Call duration</th><th>Call date</th><th>Start call time</th></tr>
						<%for(Call c:callList){%> 
						<tr><td><%=c.getPhone_n_sender()%></td><td><%=c.getPhone_n_recipients()%></td>
						<td><%=c.getDuration()%></td><td><%=c.getDate()%></td><td><%=c.getStart_call_time()%></td></tr>
						<%}%> 
					</table>
					<table>
						<tr><td><button type="submit" class="w3-button w3-block" style="background-color: #ac3973;">Print</button></td></tr>
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
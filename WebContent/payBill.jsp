<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mainpackage.telecompackage.Bill"%> 
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<title>Ninja Group of Tech</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4 {font-family:"Lato", sans-serif}
.mySlides {display:none}
.w3-tag, .fa {cursor:pointer}
.w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
.icon1 {
    background: url('WebPhotos/visa.png');
    height: 64px;
    width: 64px;
    margin-left: 4px;
    margin-right: 4px;
    position:relative;
}
.icon2 {
    background: url('WebPhotos/mastercard.png');
    height: 64px;
    width: 64px;
    margin-left: 4px;
    margin-right: 4px;
    position:relative;
}
.icon3 {
    background: url('WebPhotos/american-express.png');
    height: 64px;
    width: 64px;
    margin-left: 4px;
    margin-right: 4px;
    position:relative;
}
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
       <h4><b>"${Username}"</b></h4>
    </div>
    <div class="w3-panel" style="text-align: center; color: #ac3973;">
      <h1><b>NINJA GROUP OF TECH</b></h1>
    </div>

	<div class="w3-row-padding" id="actions">
      <div class="w3-center">
      	<span class="w3-xlarge w3-bottombar w3-border-light-grey w3-padding-16">Payment Invoice</span>
      </div>
    </div>
    <p style="text-align: center;">
      <span style="text-align: left; display: inline-block;" class="icon1"></span>
      <span style="text-align: center; display: inline-block;" class="icon2"></span>
      <span style="text-align: right; display: inline-block;" class="icon3"></span></p>  
	<!-- Customer Textboxes -->
	<%Bill clientsDebt = (Bill)request.getAttribute("clientsDebt");%>
    <form class="w3-container" action="${pageContext.request.contextPath}/PayBillServlet" method="post" target="_blank" > <!--  -->
      <div class="w3-section">
        <label>Phone number: </label>
        <label><%=clientsDebt.getPhone_number()%></label>
      </div>
      <div class="w3-section">
        <label>Payment amount: </label>
        <label><%=clientsDebt.getTotal_payments()%> $</label>
      </div>
       <div class="w3-section">
        <label>Card Number</label>
        <input pattern="[0-9]{13,16}" class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="Card Number" required>
      </div>
      <div class="w3-section">
        <label>Expire date</label>
        <input pattern="(?:0[1-9]|1[0-2])/[0-9]{2}" class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="Expire date" required>
      </div>
	  <div class="w3-section">
        <label>CVV</label>
        <input pattern="[0-9]{3}" class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="CVV" required>
      </div>
	  <div class="w3-section">
        <label>Name on card</label>
        <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="Name on card" required>
      </div>
	  <div class="w3-section">
        <label>Email</label>
        <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="email" name="Email" required>
      </div>
      <table style="margin-top: 18px; width: 100%;">
		<tr>
		<td><button type="submit" class="w3-button w3-block" style="background-color:#ac3973;">Pay</button></td>
		<td><button type="reset" class="w3-button w3-block" style="background-color: #ac3973;">Reset</button></td>
	  </table>
    </form>
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

<script src="WebPhotos/"></script>

</body>
</html>
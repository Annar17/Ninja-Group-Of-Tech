<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Ninja Group of Tech</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    html,body,h1,h2,h3,h4 {font-family:"Lato", sans-serif}
    .mySlides {display:none}
    .w3-tag, .fa {cursor:pointer}
    .w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
</style>
<body>

<!-- Links (sit on top) -->
<div class="w3-top">
    <div class="w3-row w3-large w3-light-grey">
        <div class="w3-col s3">
            <a href="index.html#" class="w3-button w3-block" style="color: #ac3973;">Home</a>
        </div>
        <div class="w3-col s3">
            <a href="index.html#plans" class="w3-button w3-block" style="color: #ac3973;">Plans</a>
        </div>
        <div class="w3-col s3">
            <a href="index.html#contact" class="w3-button w3-block" style="color: #ac3973;">Contact Us</a>
        </div>
        <div class="w3-col s3">
            <a href="index.html#" class="w3-button w3-block" style="color: #ac3973;">Cancel</a>
        </div>
    </div>
</div>

<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-top:80px;margin-bottom:80px">

    <div class="w3-panel" style="text-align: center; color: #ac3973;">
        <h1><b>NINJA GROUP OF TECH</b></h1>
    </div>

        <!-- Log in -->
        <div class="w3-center w3-padding-64" id="login">
            <span class="w3-xlarge w3-bottombar w3-border-light-grey w3-padding-16">Login</span>
        </div>

        <form class="w3-container" action="${pageContext.request.contextPath}/LoginServlet" method="post" name="loginForm">
            <div class="w3-section">
                <label>Username</label>
                <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="Username" required>
            </div>
            <div class="w3-section">
                <label>Password</label>
                <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="password" name="Password" required>
            </div>
            <button type="submit" class="w3-button w3-block" style="background-color: #ac3973;">Login</button>
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

<script>
</script>

</body>
</html>


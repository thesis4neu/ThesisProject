<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ALS | Login</title>
<!-- Bootstrap -->
<link href="bootstrap-css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body >

<div class="hero-unit">
  <h1>Alternative Learning Center</h1>
  <p>blah blah</p>
  <p>
    <a class="btn btn-primary btn-large" data-toggle="modal" href="#myModal" >Login</a>
  </p>
</div>

<div class="modal hide" id="myModal">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">x</button>
    <h3>Login</h3>
  </div>
  <div class="modal-body">
    <form method="post" action="login" name="login_form">
      <p><input type="text" class="span3" name="username" id="email" placeholder="Username" required></p>
      <p><input type="password" class="span3" name="password" placeholder="Password" required ></p>
      <p><button type="submit" class="btn btn-primary">Sign in</button>
        <a href="#"> <span style="color: red" >Forgot Password? | Under Construction</span></a>
      </p>
    </form>
  </div>
  <div class="modal-footer">
    <span style="color: red" >New Student? | Under Construction</span>
    <a href="#" class="btn btn-primary">Register</a>
  </div>
</div>

<!-- Imports -->
<script src="http://code.jquery.com/jquery.js"></script>
<script src="bootstrap-js/bootstrap.min.js"></script>
</body>
</html>
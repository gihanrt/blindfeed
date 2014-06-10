<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
    <title>BlindFeed</title>
    <!-- Bootstrap core CSS -->
    <link href='<c:url value="resources/css/bootstrap.css"></c:url>' rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href='<c:url value="/resources/css/navbar-fixed-top.css"></c:url>' rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#btn1").click(function(){
   location.href="http://localhost:8080/show_para1/accept";
  });
});
</script>
    <script>
$(document).ready(function(){
  $("#btn2").click(function(){
   location.href="http://localhost:8080/show_para1/reject/";
  });
});
</script>

<script>
function myFunction() {
    alert("Thank You for your contribution");
}
</script>

    
  </head>
  <body>
    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><b>BlindFeed</b></a>
          </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="userindex">Home</a></li>
            <li><a href="usercontribute">Contribute</a></li>
            <li class="active"><a href="validate.html">Validate</a></li>
            <li><a href="userabout">About</a></li>
            <li><a href="usercontact">Contact us</a></li>
            <li><a href="userhelp">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="form">
             <a id="user" class="btn btn-success" href="#" role="button">Your Logged as ${user}</a>
             <a id="logout" class="btn btn-success" href="logout" role="button">logout</a>
          </form>
          <ul class="nav navbar-nav navbar-right"> 
            <li class="active"></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="jumbotron">

      
       
    

<h1>
	Thank You for your contribution
</h1>




        
      
      
      <div class="jumbotron">
        <center><p class="text-muted">Deadlock product - BlindFeed</p></center>
      </div>
    </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src='<c:url value="resources/js/bootstrap.min.js"></c:url>'></script>
  </body>

</html>
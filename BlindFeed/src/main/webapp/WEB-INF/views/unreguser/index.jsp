<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
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

  </head>
<body>
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
            <li class="active"><a href="#">Home</a></li>
            <li><a href="about">About</a></li>
            <li><a href="contact">Contact us</a></li>
            <li><a href="help">Help</a></li>
          </ul>

  <form action="login1" class="navbar-form navbar-right" role="form" method="post" commandName="login_user">
            <div class="form-group">
              <input type="text" placeholder="Email" name="EMail" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
             <a class="btn btn-success" href="#" role="button">Register</a>
          </form>

          <ul class="nav navbar-nav navbar-right"> 
            <li class="active"></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>BlindFeed</h1>
        <p>- shine to their lonely life -</p>
        
        
        <div class="row clearfix">
        
        <div class="col-md-12 column">
        
       	<p>
				
285 million people are estimated to be visually impaired worldwide, 39 million are blind 
and 246 million have low vision. About 90% of the worlds visually impaired live in developing 
countries. Reading is the only way for them to see the real world. Most of the visually impaired 
people love reading. Their only way of reading is braille books. But fewer than 10 percent of the 
people who are legally blind in the World are Braille readers. The tragedy is that there are only 
less than 1% of the books that have a braille edition. Our proposing project gives an appropriate 
solution for this problem.<br>
				This project is to give the ability of using books to visually impaired people by using special 
audio format that create from the contribution of volunteers. Our Web application is open to any volunteer who is
 willing to convert a pdf into an audio

			</p>
			<p>
          <a class="btn btn-lg btn-primary" href="about" role="button">More details &raquo;</a>
        </p>
			
        </div>
        
         <h3>Introduction Video</h3>
        <div class="media">
        <video width="820" height="540" controls>
  <source src="resources/movie.mp4" type="video/mp4">
  
  Your browser does not support the video tag.
</video>
</div>
        
       
        
      </div>
      </div>
      <div class="container">
        <center><p class="text-muted">Deadlock product - BlindFeed</p></center>
      </div>
    </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src='<c:url value="resources/js/bootstrap.min.js"></c:url>'></script>
  </body>
</body>
</html>
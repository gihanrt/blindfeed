<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
            <li class="active"><a href="#">Home</a></li>
            <li><a href="record">Contribute</a></li>
            <li><a href="validation">Validate</a></li>
            <li><a href="userabout">About</a></li>
            <li><a href="usercontact">Contact us</a></li>
            <li><a href="userhelp">Help</a></li>
          </ul>
           <form class="navbar-form navbar-right" role="form">
             <a id="user" class="btn btn-success" href="#" role="button">Your Logged as ${user} </a>
             <a id="logout" class="btn btn-success" href="logout" role="button">logout</a>
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
      </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
   <script src='<c:url value="resources/js/bootstrap.min.js"></c:url>'></script>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <li><a href="Nuserindex">Home</a></li>
            <li class="active"><a href="Nusercontribute">Contribute</a></li>
            <li><a href="Nuserabout">About</a></li>
            <li><a href="Nusercontact">Contact us</a></li>
            <li><a href="Nuserhelp">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="form">
             <a id="user" class="btn btn-success" href="#" role="button">Hello ${user}</a>
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
        <h1>contribute</h1>
        <p>show paragraph and recording module should be here...</p>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Paragraph Reading</h3>
                    </div>
                    <div class="panel-body"y>
                        <p style="font-size: 15px;">
                        It is a long established fact that a reader will be
                        distracted by the readable content of a page when
                        looking at its layout. The point of using Lorem Ipsum
                        is that it has a more-or-less normal distribution of
                        letters, as opposed to using 'Content here, content
                        here', making it look like readable English. Many desktop
                        publishing packages and web page editors now use Lorem Ipsum
                        as their default model text, and a search for 'lorem ipsum' wil
                        l uncover many web sites still in their infancy. Various versions
                        have evolved over the years, sometimes by accident, sometimes
                        on purpose (injected humour and the like).
                        </p>
                        
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Record Player</h3>
                    </div>
                    <div class="panel-body">
                        <h4 class="text-info">Record Player</h4>
                        <button class="glyphicon glyphicon-play">  </button>
                        <button class="glyphicon glyphicon-stop">  </button>
                        <button class="glyphicon glyphicon-pause">  </button>

                    </div>
                </div>
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
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>
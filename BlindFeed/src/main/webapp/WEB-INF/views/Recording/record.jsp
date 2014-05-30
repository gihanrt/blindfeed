<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<html>
<head>

	  <link href='<c:url value="/resources/css/navbar-fixed-top.css"></c:url>' rel="stylesheet">
	  <link href='<c:url value="/resources/css/bootstrap.css"></c:url>' rel="stylesheet">
	  <script src='<c:url value="/resources/jquery.min.js"></c:url>'> </script>
	  <script src='<c:url value="/resources/jRecorder.js"></c:url>'> </script>
  
		<title>jRecorder Example</title>  

		<style>
		li {display:inline; margin-right:10px;}
		</style>

</head>
<body> 
   <script>

    $.jRecorder({ 
        host : 'http://localhost:8080/blindfeed/record?filename=hello' ,  //replace with your server path please
        callback_started_recording:     function(){callback_started(); },
        callback_stopped_recording:     function(){callback_stopped(); },
        callback_activityLevel:         function(level){callback_activityLevel(level); },
        callback_activityTime:        function(time){   callback_activityTime(time); },
        callback_finished_sending: function(){ callback_finished_sending();},
        swf_path : '<c:url value="/resources/AudioRecorderCS4-1.0.swf"></c:url>'
     }
   );
    
   </script>
	<div  style="position: relative; top: -70px;">
		<div class="navbar navbar-default">
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
          <form class="navbar-form navbar-right">
             <a id="user" class="btn btn-success" href="#">user : Tharindu</a>
             <a id="logout" class="btn btn-success" href="#">logout</a>
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
                    <div class="panel-body">
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
                    
                    <div class="well-sm" style="background-color: #eeeeee;border:1px solid #cccccc">
		  Time: <span id="time">00:00</span>  
		</div>
		
		
		<div >
		  Level: <span class="well-sm" id="level"></span>
		</div>  
	
		<div id="levelbase" style="width:200px;height:20px;background-color:#ffff00">
		  <div id="levelbar" style="height:19px; width:2px;background-color:red"></div>  
		</div>
	
		<div>
		  Status: <span id="status"></span>
		</div> 
	
                        <h4 class="text-info">Record Player</h4>
                        <button class="glyphicon glyphicon-play" id="record">  </button>
                        <button class="glyphicon glyphicon-stop" id="stop">  </button>
                        <button class="glyphicon glyphicon-folder-open" id="send">  </button>

                    </div>
                </div>
            </div>
        </div>
        
      </div>
      <div class="container">
        <p class="text-muted">Deadlock product - BlindFeed</p>
      </div>
    </div> <!-- /container -->
    
		</div>

	
		
		<script type="text/javascript">
                  $('#record').click(function(){
                      $.jRecorder.record(30);
                  });
               
                  $('#stop').click(function(){     
                     $.jRecorder.stop();
                  });
               
                   $('#send').click(function(){
                     $.jRecorder.sendData();     
                  });
                  
                  function callback_finished()
                  {
                      $('#status').html('Recording is finished');                  
                  }
                  
                  function callback_started()
                  {      
                      $('#status').html('Recording is started');                   
                  }

                  function callback_error(code)
                  {
                      $('#status').html('Error, code:' + code);
                  }
                                    
                  function callback_stopped()
                  {
                      $('#status').html('Stop request is accepted');
                  }

                  function callback_finished_recording()
                  {                    
                      $('#status').html('Recording event is finished');                                       
                  }
                  
                  function callback_finished_sending()
                  {                   
                      $('#status').html('File has been sent to server mentioned as host parameter');                                           
                  }
                  
                  function callback_activityLevel(level)
                  {                    
                    $('#level').html(level);
                    
                    if(level == -1)
                    {
                      $('#levelbar').css("width",  "2px");
                    }
                    else
                    {
                      $('#levelbar').css("width", (level * 2)+ "px");
                    }                                       
                  }
                  
                  function callback_activityTime(time)
                  { 
                   //$('.flrecorder').css("width", "1px"); 
                   //$('.flrecorder').css("height", "1px"); 
                    $('#time').html(time);         
                  }
        </script>
</body>
</html>


 
		
		
    
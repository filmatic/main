<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/customer_home_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

		<div id="wrapper" class="center-horizontal">
        	
            
            <!-- logo -->
        	<div id="logo" class="center-horizontal">
            	<a class="brand" href="#"><img src="img/login_logo.jpg" id="logo" alt="login"/></a>
            </div>
            
            
            
            <!-- navigation bar -->
            <div id="navigationbar" class="navbar center-horizontal">
                <div class="navbar-inner">
                    <ul class="nav">
                      <li class="active"><a href="#">Home</a></li>
                        <li class=""><a href="#">Movies</a></li>
                        <li class=""><a href="#">Queue</a></li>
                        <li class=""><a href="#">History</a></li>
                        <li class=""><a href="#">Settings</a></li>
                        <li class=""><a href="#">Support</a></li>
                  </ul>
              </div>
            </div>
            
            
            
            <!-- carousel -->
            <div id="myCarousel" class="carousel slide">
            
            	<h3>Recommended Movies</h3>
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                </ol>
                
                <!-- Carousel items -->
                <div class="carousel-inner" id="carousel-items">
                
                	<!-- first item -->
                    <div class="active item">  
                    	<div class="row-fluid">
                        
                                <div class="span3 movie-heading">
                                	  <img src="img/movie_header.jpg" alt="" class="img-polaroid movie-logo">
                                </div>
                                
                                <div class="span3 movie-heading">
                                	  <img src="img/movie_header.jpg" alt="" class="img-polaroid movie-logo">
                                </div>
                                
                                <div class="span3 movie-heading">
                                	  <img src="img/movie_header.jpg" alt="" class="img-polaroid movie-logo">
                                </div>
                            
                        </div>
                	</div>
                  	
                  	<!-- second item -->
                    <div class="item">  
                     	 <div class="row-fluid">
                    
                                <div class="span3 movie-heading">
                                	  <img src="img/movie_header.jpg" alt="" class="img-polaroid movie-logo">
                                </div>
                                
                                <div class="span3 movie-heading">
                                	  <img src="img/movie_header.jpg" alt="" class="img-polaroid movie-logo">
                                </div>
                                
                                <div class="span3 movie-heading">
                                	  <img src="img/movie_header.jpg" alt="" class="img-polaroid movie-logo">
                                </div>
                     	</div>
                	</div>
                    
                </div>
                <!-- Carousel nav -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
            </div>
            
            
            
            <!-- DIVIDER -->
            <hr class="featurette-divider">
            
            
            
            <!-- CURRENT QUEUE/HELD MOVIES-->
            <div id="held_movies">
            	<h3> Current Queue </h3>
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Username</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                    </tr>
                  </tbody>
                </table>
            </div>
        </div> <!-- container div end -->
	</body>
</html>
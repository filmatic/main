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
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       
       <div id="wrapper" class="center-horizontal">
            <div id="logoff-frame">
                <p>
                    <a href="LogoutServlet">
                    <button id="logoff" style="" action="" class="btn btn-warning"><i class="icon-off icon-white"></i></button>
                    </a>
                </p>
            </div>
            
            
            <!-- logo -->
            <div id="logo" >
            	<a class="brand" href="#"><img src="img/login_logo.jpg" id="logo" alt="login"/></a>
                
            </div>
            

            
            
            <!-- navigation bar -->
            <div id="navigationbar" class="navbar center-horizontal">
                <div class="navbar-inner">
                    <ul class="nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li class=""><a href="GenerateAllMovieServlet">Movies</a></li>
                        <li class=""><a href="QueueServlet">Queue</a></li>
                        <li class=""><a href="HistoryServlet">History</a></li>
                        <li class=""><a href="SettingsServlet">Settings</a></li>
                        <li class=""><a href="SupportServlet">Support</a></li>
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
                            
                            <c:forEach items="${recMovieList}" varStatus="status" var="recMovie" begin="0" end="2">
                                    
                                <div class="span3 movie-heading">
                                   
                                    <c:choose>
                                        <c:when test="${empty recMovie}">
                                            <a href="GenerateMovieDetailServlet?movieToDetail=${recMovie.movieId}"> <img src="img/placeholder.jpg" alt="" class="img-polaroid movie-logo"> </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="GenerateMovieDetailServlet?movieToDetail=${recMovie.movieId}"> <img src="${recMovie.imageLocation}" alt="" onError="this.onerror=null;this.src='img/placeholder.jpg';" class="img-polaroid movie-logo"> </a>
                                        </c:otherwise>
                                    </c:choose>
                                              
                                </div>
                            
                            </c:forEach>
                            
                        </div>
                    </div>
                  	
                  	<!-- second item -->
                    <div class="item">  
                     	 <div class="row-fluid">
                    
                            <c:forEach items="${recMovieList}" varStatus="status" var="recMovie" begin="3" end="5">
                                    
                                <div class="span3 movie-heading">
                                   
                                    <c:choose>
                                        <c:when test="${empty recMovie}">
                                            <a href="GenerateMovieDetailServlet?movieToDetail=${recMovie.movieId}"> <img src="img/placeholder.jpg" alt="" class="img-polaroid movie-logo"> </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="GenerateMovieDetailServlet?movieToDetail=${recMovie.movieId}"> <img src="${recMovie.imageLocation}" onError="this.onerror=null;this.src='img/placeholder.jpg';" alt="" class="img-polaroid movie-logo"> </a>
                                        </c:otherwise>
                                    </c:choose>
                                              
                                </div>
                            
                            </c:forEach>
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
            	<h3>Currently Held Movies</h3>
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                          <tr>
                            <th>Title</th>
                            <th>Genre</th>
                            <th>Rented On</th>
                            <th>Rating</th>
                          </tr>
                    
                  </thead>
                  <tbody>
                    <c:forEach items="${customerCurrentlyHeld}" var="order">  
                    <tr>
                      <td>${order.movieId.title}</td>
                      <td>${order.movieId.genre}n</td>
                      <td>${order.dateTime}</td>
                      <td>
                          <c:choose>
                                        <c:when test="${order.movieId.rating == '5'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                        </c:when>
                                        <c:when test="${order.movieId.rating == '4'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${order.movieId.rating == '3'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${order.movieId.rating == '2'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${order.movieId.rating == '1'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${order.movieId.rating == '0'}">
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                    </c:choose>
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
            </div>
        </div> <!-- container div end -->
	</body>
</html>
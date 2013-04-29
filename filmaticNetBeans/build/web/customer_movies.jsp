<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/customer_movies_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                      <li class=""><a href="HomeServlet">Home</a></li>
                        <li class="active"><a href="#">Movies</a></li>
                        <li class=""><a href="QueueServlet">Queue</a></li>
                        <li class=""><a href="#">History</a></li>
                        <li class=""><a href="#">Settings</a></li>
                        <li class=""><a href="#">Support</a></li>
                  </ul>
              </div>
            </div>
            
            
            
           <!-- BEST SELLERS LIST -->
           <div id="best-sellers-frame">
           		<h3>Best Sellers List</h3>
           		
                <table class="table table-bordered table-condensed table-striped">  
                
                  <thead>
                    <tr>
                      <th class="number-column">#</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="rating-column">Rating</th>
                      <th class="queue-column"><!-- QUEUE BUTTONS --></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                      
                      <c:forEach var="movie" items="${movieList}">
                          <tr>
                              <td>${movie.movieId}</td>
                              <td>${movie.title}</td>
                              <td>${movie.genre}</td>
                              <td>
                                  <i class="icon-search icon-star"></i>
                                  <i class="icon-search icon-star"></i>
                                  <i class="icon-search icon-star"></i>
                                  <i class="icon-search icon-star-empty"></i>
                                  <i class="icon-search icon-star-empty"></i>
                              </td>
                              <td>
                                  <button class="btn btn-success" type="button" value="${movie.movieId}" action="AddToQueueServlet">Queue</button>
                              </td>
                          </tr>
                      </c:forEach>
                  </tbody>
                  
                </table>
           </div>
            
            
            <!-- DIVIDER -->
            <hr class="featurette-divider">
            
            
            
            <!-- CURRENT QUEUE/HELD MOVIES-->
            <div id="search-frame">
            	<h3>Search Movies</h3>
                
                <form class="form-search">
                    <div class="input-prepend input-append">
                        <input class="span3" id="appendedPrependedDropdownButton" placeholder="Search Movies" type="text">
                        
                        <div class="btn-group">
                            <button class="btn dropdown-toggle" data-toggle="dropdown">
                                    Keyword
                                    <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                            	<li class="active"><a href="">Keyword</a</li>
                                <li ><a href="">Title</a</li>
                                <li><a href="">Genre</a></li>
                            </ul>
                            
                            <button id="search-button" type="submit" class="btn btn-warning"><i class="icon-search icon-white"></i></button>
                        </div>
                    </div>
                </form>
                
                <table class="table table-bordered table-condensed table-striped">  
                
                  <thead>
                    <tr>
                      <th class="number-column">#</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="rating-column">Rating</th>
                      <th class="queue-column"><!-- QUEUE BUTTONS --></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Trouble in the Movie Queue</td>
                      <td>Documentary</td>
                      <td>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star-empty"></i>
                          <i class="icon-search icon-star-empty"></i>
                      </td>
                      <td>
						<button class="btn btn-success" type="button">Queue</button>
                      </td>
                    </tr>
                    
                    <tr>
                      <td>2</td>
                      <td>Random Movie</td>
                      <td>Action</td>
                      <td>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star-empty"></i>
                          <i class="icon-search icon-star-empty"></i>
                      </td>
                      <td>
						<button class="btn btn-success" type="button">Queue</button>
                      </td>
                    </tr>
                  </tbody>
                  
                </table>
            </div>
        </div> <!-- container div end -->
	</body>
</html>
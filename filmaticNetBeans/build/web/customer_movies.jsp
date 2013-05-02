<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                
                <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
                <script src="js/bootstrap-select.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
                <link href="css/customer_movies_style.css" rel="stylesheet" media="screen" />
                <link href="css/bootstrap-select.css" rel="stylesheet" media="screen" />
                
                <script src="js/bootstrap-select.js"></script>
        
                <script>
                    // Enable select style
                    /*
                    $(document).ready( function() {
                        $('.selectpicker').selectpicker();
                    });
                    */
                </script> 

	</head>

<body>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
                        <li class=""><a href="HistoryServlet">History</a></li>
                        <li class=""><a href="SettingsServlet">Settings</a></li>
                        <li class=""><a href="SupportServlet">Support</a></li>
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
                  
                  <form action="AddToQueueServlet" method="post">
                    <tbody>
                        <c:forEach var="movie" items="${movieList}">
                            <tr>
                                <td>${movie.movieId}</td>
                                <td>
                                    <a href="GenerateMovieDetailServlet?movieToDetail=${movie.movieId}">
                                        <input type="hidden" name="movieToDetail" value="${movie.movieId}">
                                            ${movie.title}
                                        </input>
                                    </a>
                                </td>
                                <td>${movie.genre}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${movie.rating == '5'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                        </c:when>
                                        <c:when test="${movie.rating == '4'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${movie.rating == '3'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${movie.rating == '2'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${movie.rating == '1'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${movie.rating == '0'}">
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <button class="btn btn-success" name="movieToQueue" value="${movie.movieId}" type="submit">Queue</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                  </form>
                </table>
           </div>
            
            
            <!-- DIVIDER -->
            <hr class="featurette-divider">
            
            
            
            <!-- CURRENT QUEUE/HELD MOVIES-->
            <div id="search-frame">
            	<h3>Search Movies</h3>
                
                <form class="form-search" method="post" action="SearchServlet">
                    <div class="input-prepend input-append">
                        <input class="span3" id="appendedPrependedDropdownButton" placeholder="Search Movies" name="searchKeyword" type="text">
                        
                        <div class="btn-group">
                            <select id="searchpick" class="selectpicker" name="searchType">
                                <option value="keyword">Keyword</option>
                                <option value="title">Title</option>
                                <option value="genre">Genre</option>
                            </select>
                            
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
                  
                    <form method="post" action="AddToQueueServlet">
                        <tbody>
                            <c:forEach var="movie" items="${searchResults}">
                                <tr>
                                    <td>${movie.movieId}</td>
                                    <td>${movie.title}</td>
                                    <td>${movie.genre}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${movie.rating == '5'}">
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                            </c:when>
                                            <c:when test="${movie.rating == '4'}">
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                            </c:when>
                                            <c:when test="${movie.rating == '3'}">
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                            </c:when>
                                            <c:when test="${movie.rating == '2'}">
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                            </c:when>
                                            <c:when test="${movie.rating == '1'}">
                                                <i class="icon-search icon-star"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                            </c:when>
                                            <c:when test="${movie.rating == '0'}">
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                                <i class="icon-search icon-star-empty"></i>
                                            </c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <button class="btn btn-success" name="movieToQueue" value="${movie.movieId}" type="submit">Queue</button>
                                    </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </form>
                  
                </table>
            </div>
        </div> <!-- container div end -->
	</body>
</html>
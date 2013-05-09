<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Movies</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_movies_style.css" rel="stylesheet" media="screen" />
		<link href="css/bootstrap-select.css" rel="stylesheet" media="screen" />
        <script src="js/bootstrap-select.js"></script>

        
        <script>
            $(document).ready( function() {
                $('.selectpicker').selectpicker();
            });
		</script>
	</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div id="wrapper" class="center-horizontal">
            
            <!-- logoff frame -->
            <div id="logoff-frame">
                <p>
                    <a href="LogoutServlet">
                    <button id="logoff" style="" action="" class="btn btn-warning"><i class="icon-off icon-white"></i></button>
                    </a>
                </p>
            </div>
            
            
            <!-- logo -->
            <div id="logo" class="center-horizontal">
            	<a class="brand" href="#"><img src="img/login_logo.jpg" id="logo" alt="login"/></a>
            </div>
            
            
            
            <!-- navigation bar -->
            <div id="navigationbar" class="navbar center-horizontal">
                <div class="navbar-inner">
                    <ul class="nav">
                        <li class=""><a href="AdminHomeServlet">Home</a></li>
                        <li class=""><a href="AdminSalesServlet">Sales</a></li>
                        <li class=""><a href="AdminEmployeesServlet">Employees</a></li>
                        <li class=""><a href="AdminRentalsServlet">Rentals</a></li>
                        <li class="active"><a href="">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- MOVIE RENTALS TABLE -->
            <div>
            
                <div style="overflow: hidden; margin-top:10px;">
                    <div style="float: left;">
                    	<h3>Movies</h3>
                    </div>
                    <div style="float: right;">
                        <form method="post" action="admin_add_movie.jsp">
                            <button style="height:30px; margin-top:16px;" class="btn btn-inverse" name="approve" value="1" type="submit">Add Movie</button>
                        </form>
                    </div>
		</div>
                
                <form method="post" action="SortMoviesServlet">
                    <div class="input-prepend input-append">
                        <div class="btn-group">
                                    <select id="searchpick" class="selectpicker" name="sortType">
                                        <option value="movieId">Movie Id</option>
                                        <option value="title">Title</option>
                                        <option value="genre">Genre</option>
                                        <option value="numberOfCopies">Number of Copies</option>
                                        <option value="timesRated">Times Rated</option>
                                    </select>

                                    <button id="search-button" type="submit" class="btn btn-warning"><i class="icon-search icon-white"></i></button>
                                </div>
                    </div>
                </form>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="movieid-column">Movie Id</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="distfee-column">Dist. Fee</th>
                      <th class="numcopies-column"># Copies</th>
                      <th class="timesrated-column">Times Rated</th>
                      <th class="remove-column"><!-- Remove Button --></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                      <c:forEach items="${movieList}" var="movie">
                        <tr>
                            <td>
                                <a href="EditMovieServlet?movieToEdit=${movie.movieId}">
                                        <input type="hidden" name="movieToEdit" value="${movie.movieId}">
                                            ${movie.movieId}
                                        </input>
                                    </a>
                            </td>
                            <td>${movie.title}</td>
                            <td>${movie.genre}</td>
                            <td>$${movie.distributionFee}</td>
                            <td>${movie.numberCopies}</td>
                            <td>${movie.timesRated}</td>
                            <form action="RemoveMovieFromDatabaseServlet" method="post">
                                <td>
                                    <button class="btn btn-danger" type="submit" name="movieToRemove" value="${movie.movieId}"><i class="icon-remove icon-white"></i></button>
                                </td>
                            </form>
                        </tr>
                      </c:forEach>
                  </tbody>
                  
                </table>
                
            </div>
            
        </div> <!-- container div end -->
	</body>
</html>
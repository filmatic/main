<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/admin_home_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

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
                        <li class="active"><a href="#">Home</a></li>
                        <li class=""><a href="AdminSalesServlet">Sales</a></li>
                        <li class=""><a href="AdminEmployeesServlet">Employees</a></li>
                        <li class=""><a href="AdminRentalsServlet">Rentals</a></li>
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- MOST ACTIVE CUSTOMERS -->
            <div>
            
            	<h3>Most Active Customers</h3>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="customerid-column">Customer Id</th>
                      <th>Name</th>
                      <th class="timeslogedin-column">Times Logged In</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${activePersons}" var="person">  
                        <tr>
                        <td>${person.personId}</td>
                        <td>${person.firstName} ${person.lastName}</td>
                        <td>${person.customer.timesLoggedIn}</td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
                
            </div>
            
            
            
            <!-- DIVIDER -->
            <hr class="featurette-divider">
            
            
            
            <!-- MOST RENTED MOVIES -->
            <div>
            
            	<h3>Most Rented Movies</h3>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="customerid-column">Movie Id</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="timeslogedin-column">Times Rented</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${mostRentedMovies}" var="movie">
                        <tr>
                            <td>${movie.movieId}</td>
                            <td>${movie.title}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.timesRented}</td>
                        </tr>
                      </c:forEach>
                  </tbody>
                </table>
                
            </div>
                
        </div> <!-- container div end -->
	</body>
</html>
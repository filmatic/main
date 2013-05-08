<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Rentals</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_rentals_style.css" rel="stylesheet" media="screen" />
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
                        <li class="active"><a href="">Rentals</a></li>
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            <!-- MOVIE RENTALS TABLE -->
            <div>
            
            	<h3>Movie Rentals</h3>
                
                <form method="post" action="SortRentalsServlet">
                    <div class="input-prepend input-append">
                        <div class="btn-group">
                                    <select id="searchpick" class="selectpicker" name="sortType">
                                        <option value="date">Date</option>
                                        <option value="movieId">Movie ID</option>
                                        <option value="customerId">Customer ID</option>
                                        <option value="employeeId">Employee ID</option>
                                    </select>

                                    <button id="search-button" type="submit" class="btn btn-warning"><i class="icon-search icon-white"></i></button>
                                </div>
                    </div>
                </form>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th>Date</th>
                      <th class="movieid-column">Movie ID</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="customerid-column">Customer ID</th>
                      <th>Employee ID</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${rentalList}" var="rental">  
                      <tr>
                        <td>${rental.dateTime}</td>
                        <td>${rental.movieId.movieId}</td>
                        <td>${rental.movieId.title}</td>
                        <td>${rental.movieId.genre}</td>
                        <td>${rental.customerId.customerId}</td>
                        <td>${rental.employeeId.employeeId}</td>
                      </tr>
                  </c:forEach>
                  </tbody>
                </table>
                
            </div>
            
        </div> <!-- container div end -->
	</body>
</html>
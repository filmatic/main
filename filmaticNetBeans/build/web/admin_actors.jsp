<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Actors</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_actors_style.css" rel="stylesheet" media="screen" />
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
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class="active"><a href="">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- MOVIE RENTALS TABLE -->
            <div>
            
            	<h3>Actors</h3>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="movieid-column">Actor Id</th>
                      <th>Name</th>
                      <th class="genre-column">Gender</th>
                      <th class="distfee-column">Age</th>
                      <th class="rating-column">Rating</th>
                      <th class="remove-column"><!-- Remove Button --></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                      <c:forEach items="${actorList}" var="actor">
                        <tr>
                            <td>${actor.actorId}</td>
                            <td>${actor.actorName}</td>
                            <td>${actor.gender == "M" ? "Male" : "Female"}</td>
                            <td>${actor.age}</td>
                            <td>
                                <c:choose>
                                        <c:when test="${actor.rating == '5'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                        </c:when>
                                        <c:when test="${actor.rating == '4'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${actor.rating == '3'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${actor.rating == '2'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${actor.rating == '1'}">
                                            <i class="icon-search icon-star"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                        <c:when test="${actor.rating == '0'}">
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                            <i class="icon-search icon-star-empty"></i>
                                        </c:when>
                                    </c:choose>
                            </td>
                            <form method="post" action="RemoveActorFromDatabaseServlet">
                                <td>
                                    <button class="btn btn-danger" type="submit" name="actorToRemove" value="${actor.actorId}"><i class="icon-remove icon-white"></i></button>
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
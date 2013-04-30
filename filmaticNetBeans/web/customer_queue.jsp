<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/customer_queue_style.css" rel="stylesheet" media="screen" />
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
                      <li class=""><a href="HomeServlet">Home</a></li>
                        <li class=""><a href="GenerateAllMovieServlet">Movies</a></li>
                        <li class="active"><a href="#">Queue</a></li>
                        <li class=""><a href="HistoryServlet">History</a></li>
                        <li class=""><a href="SettingsServlet">Settings</a></li>
                        <li class=""><a href="SupportServlet">Support</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
           <!-- BEST SELLERS LIST -->
           <div id="queue-frame">
           		<h3>Queue</h3>
           		
                <table class="table table-bordered table-condensed table-striped">  
                
                  <thead>
                    <tr>
                      <th class="number-column">#</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="rating-column">Rating</th>
                      <th class="rent-column"><!-- RENT BUTTONS --></th>
                      <th class="remove-column"><!-- REMOVE BUTTONS --></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                      <c:forEach var="movie" items="${queueList}">
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
                                  <form action="AskToRentServlet" method="post">
                                    <button class="btn btn-warning" type="submit" name="movieToRent" value="${movie.movieId}">Rent</button>
                                  </form>
                              </td>
                              <td>
                                  <form action="RemoveFromQueueServlet" method="post">
                                    <button class="btn btn-danger" type="submit" name="movieToRemove" value="${movie.movieId}"><i class="icon-remove icon-white"></i></button>
                                  </form>
                              </td>
                          </tr>
                      </c:forEach>
                  </tbody>
                </table>
           </div>
           
            </div>
        </div> <!-- container div end -->
	</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
                <link href="css/customer_history_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

	<div id="wrapper" class="center-horizontal">
            
            <!-- logoffbutton -->
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
                      <li class=""><a href="HomeServlet">Home</a></li>
                        <li class=""><a href="GenerateAllMovieServlet">Movies</a></li>
                        <li class=""><a href="QueueServlet">Queue</a></li>
                        <li class="active"><a href="#">History</a></li>
                        <li class=""><a href="SettingsServlet">Settings</a></li>
                        <li class=""><a href="SupportServlet">Support</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
           <!-- CUSTOMER HISTORY -->
           <div id="queue-frame">
           		<h3>History</h3>
           		
                <table class="table table-bordered table-condensed table-striped">  
                
                  <thead>
                    <tr>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="rating-column">Rating</th>
                      <th class="order-date-column">Order Date</th>
                      <th class="rent-column"></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                      <c:forEach items="${customerHistoryList}" var="order">
                        <tr>
                            <td>${order.movieId.title}</td>
                            <td>${order.movieId.genre}</td>
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
                            <td>${order.dateTime}</td>
                            <td>
                                    <c:if test="${order.currentlyOut == 1}">
                                        <form action="ReturnMovieServlet" method="post">
                                            <button class="btn btn-warning" type="submit" name="movieToReturn" value="${order.orderId}">Return</button>
                                        </form>
                                    </c:if>
                                    <c:if test="${order.currentlyOut == 0}">
                                        <form action="RateMovieServlet" method="post">
                                            <div class="btn-group">
                                                <select class="selectpicker" name="movieRating" id="rating">
                                                    <option value="1">1 Star</option>
                                                    <option value="2">2 Stars</option>
                                                    <option value="3" selected="selected">3 Stars</option>
                                                    <option value="4">4 Stars</option>
                                                    <option value="5">5 Stars</option>
                                                </select>
                                                <button class="btn btn-warning" type="submit" name="movieToRate" value="${order.orderId}">Rate</button>
                                            </div>
                                        </form>
                                    </c:if>
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
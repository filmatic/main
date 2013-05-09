<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Customer Representative Customers</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/custrep_recommendation_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                        <li class=""><a href="CustRepHomeServlet">Home</a></li>
                        <li class=""><a href="CustRepOrdersServlet">Orders</a></li>
                        <li class="active"><a href="CustRepCustomersServlet">Customers</a></li>
                        <li class=""><a href="CustRepMailingListServlet">Mailing List</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- PENDING ORDERS -->
            <div>
            
            	<h3>Customer Recommendations</h3>
                <h5></h5>
                <h5><u>Customer Id:</u> <span style="font-weight:normal;">${customerId}</span></h5>
                
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="customerid-column">Movie Id</th>
                      <th class="">Title</th>
                      <th class="genre-column">Genre</th>
                    </tr>
                  </thead>
                  <tbody>
                      
                    <c:forEach items="${recMovieList}" varStatus="status" var="recMovie">
                        <tr>
                            <td>${recMovie.movieId}</td>
                            <td>${recMovie.title}</td>
                            <td>${recMovie.genre}</td>
                        </tr>
                    </c:forEach>                
                    
                  </tbody>
                </table>
                
            </div>
                
        </div> <!-- container div end -->
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Customer Representative Orders</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/custrep_orders_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
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
                        <li class=""><a href="CustRepHomeServlet">Home</a></li>
                        <li class="active"><a href="CustRepOrdersServlet">Orders</a></li>
                        <li class=""><a href="CustRepCustomersServlet">Customers</a></li>
                        <li class=""><a href="CustRepMailingListServlet">Mailing List</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- PENDING ORDERS -->
            <div>
            
            	<h3>Pending Orders</h3>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="orderid-column">Order ID</th>
                      <th class="timeplaced-column">Time Placed</th>
                      <th class="movieid-column">Movie ID</th>
                      <th>Title</th>
                      <th class="approve-column"></th>
                      <th class="approve-column"></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${pendingList}" var="order">
                      <tr>
                        <td>${order.orderId}</td>
                        <td>${order.dateTime}</td>
                        <td>${order.movieId.movieId}</td>
                        <td>${order.movieId.title}</td>
                        <td>
                            <form method="post" action="ApproveMovieRentalServlet">
                                <button class="btn btn-success" name="orderToApprove" value="${order.orderId}" type="submit">Approve</button>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="DenyMovieRentalServlet">
                                <button class="btn btn-success" name="deny" value="${order.orderId}" type="submit">Deny</button>
                            </form>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
                
            </div>
                
        </div> <!-- container div end -->
	</body>
</html>
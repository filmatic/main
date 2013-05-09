<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Sales</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_sales_style.css" rel="stylesheet" media="screen" />
		<link href="css/bootstrap-select.css" rel="stylesheet" media="screen" />
        <script src="js/bootstrap-select.js"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        
        <script>
            /*
            $(document).ready( function() {
                $('.selectpicker').selectpicker();
            });*/
	</script>
	</head>

<body>
	
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
                        <li class="active"><a href="">Sales</a></li>
                        <li class=""><a href="AdminEmployeesServlet">Employees</a></li>
                        <li class=""><a href="AdminRentalsServlet">Rentals</a></li>
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            <!-- SALES REPORT -->
            <div>
            
            	<h3>Sales Report</h3>
                    
                <form class="form-search" method="post" action="AdminSalesServlet">
                    <div class="btn-group">
                        <select class="selectpicker" style="width:100px;" data-width="100px" name="selectmonth" id="selectmonth">
                            <option value="1">January</option>
                            <option value="2">February</option>
                            <option value="3">March</option>
                            <option value="4">April</option>
                            <option value="5">May</option>
                            <option value="6">June</option>
                            <option value="7">July</option>
                            <option value="8">August</option>
                            <option value="9">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                         </select>

                         <select class="selectpicker" style="width:75px;" data-width="75px" name="selectyear" id="selectyear">
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                         </select>

                        <button id="" type="submit" class="btn btn-warning">Generate</button>
                    </div>
                </form>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="customerid-column">Customer Id</th>
                      <th>Account Type</th>
                      <th class="genre-column">Monthly Fee</th>
                    </tr>
                  </thead>
                    
                  <tbody>   
                     
                    <c:forEach var="customer" items="${selectedCustomers}">
                       <tr>
                         <td>${customer.customerId}</td>
                         <td>${accountName[customer.accountType.accountType]}</td>
                         <td>$${customer.accountType.monthlyFee}</td>
                       </tr>
                    </c:forEach>
                       <tr>
                         <td><b>Total</b></td>
                         <td></td>
                         <td><b>$${salesTotal}</b></td>
                       </tr>
                  </tbody>
                    
                </table>
                
            </div>
            
        </div> <!-- container div end -->
	</body>
</html>
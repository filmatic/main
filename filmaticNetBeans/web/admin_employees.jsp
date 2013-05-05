<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Employees</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_employees_style.css" rel="stylesheet" media="screen" />
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
                        <li class="active"><a href="">Employees</a></li>
                        <li class=""><a href="AdminRentalsServlet">Rentals</a></li>
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            <!-- EMPLOYEES TABLE -->
            <div>
            
            	<h3>Employees</h3>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="employeeid-column">Employee Id</th>
                      <th>Name</th>
                      <th>Employee Type</th>
                      <th>SSN</th>
                      <th>Hourly Wage</th>
                      <th>Transactions Managed</th> <!-- Have to be able to sort by this -->
                      <th><!--Remove icon --></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${employeeList}" var="person">
                        <tr>
                        <td>${person.personId}</td>
                        <td>${person.firstName} ${person.lastName}</td>
                        <td>${person.employee.employeeType == "Customer Rep" ? "Customer Representative" : "Manager"}</td>
                        <td>${person.employee.ssn}</td>
                        <td>$${person.employee.hourlyRate}</td>
                        <td>${person.employee.transactionsManaged}</td>
                        <td><button class="btn btn-danger" type="submit" name="employeeToRemove" value="${person.personId}"><i class="icon-remove icon-white"></i></button></td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
                
            </div>
            
        </div> <!-- container div end -->
	</body>
</html>
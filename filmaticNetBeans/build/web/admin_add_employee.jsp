<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Add Employee</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_edit_employee_style.css" rel="stylesheet" media="screen" />
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
                        <li class="active"><a href="AdminEmployeesServlet">Employees</a></li>
                        <li class=""><a href="AdminRentalsServlet">Rentals</a></li>
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
           <!-- EMPLOYEE INFO -->
           <div id="personal-info-frame">
               <form action="AddEmployeeServlet" method="post">
                    <h3>Add Employee</h3>

                    <dl class="dl-horizontal">

                        <dt>First Name:</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeeFirstName"></dd>
                            
                        <dt>Last Name:</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeeLastName"></dd>

                        <dt>SSN</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeeSSN"></dd>
                            
                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeeEmail"></dd>
                            
                        <dt>Password:</dt>
                            <dd><input class="input-medium" type="password" name="newEmployeePassword"></dd>
                            
                        <dt>Phone:</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeePhone"></dd>
                            
                        <dt>Address:</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeeAddress"></dd>
                            
                        <dt>City:</dt>
                            <dd><input class="input-medium" type="text" name="newEmployeeCity"></dd>

                        <dt>State:</dt>
                            <dd>
                                <select class="selectpicker" name="newEmployeeState" id="state">
                                    <option value="" selected="selected">Select a State</option>
                                    <option value="AL">Alabama</option>
                                    <option value="AK">Alaska</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="DC">District Of Columbia</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WA">Washington</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WY">Wyoming</option>
                                </select>
                            </dd>      
                            
                        <dt>Zip Code:</dt>
                			<dd><input class="input-medium" type="text" name="newEmployeeZipCode"></dd>
                        
                        <dt>Employee Type:</dt>
                			<dd>
                            	<select class="selectpicker" data-width="164px"  name="newEmployeeType" id="type">
                                    <option value="Admin">Manager</option>
                                    <option value="Rep">Customer Rep</option>
                                </select>
                            </dd>     
                            
                        <dt>Hourly Wage:</dt>
                			<dd><input class="input-medium" type="text" name="newEmployeeHourlyWage"></dd>      
                            
                        <dt></dt>
                        	<dd><button class="btn btn-success" type="submit">Add Employee</button></dd>

                    </dl>
               </form>
           </div>
            
        </div> <!-- container div end -->
	</body>
</html>
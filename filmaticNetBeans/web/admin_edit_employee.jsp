<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Edit Employee</title>
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
            
            
           <!-- EMPLOYEE INFO -->
           <div id="personal-info-frame">
               <form action="SaveEmployeeSettingsServlet" method="post">
                    <h3>Edit Employee</h3>

                    <dl class="dl-horizontal">
                        <input type="hidden" name="employeePersonId" value="${sessionScope.editEmployee.personId}"/>
                        <dt>First Name:</dt>
                            <dd><input class="input-medium" type="text" name="employeeFirstName" value="${sessionScope.editEmployee.firstName}"></dd>
                            
                        <dt>Last Name:</dt>
                            <dd><input class="input-medium" type="text" name="employeeLastName" value="${sessionScope.editEmployee.lastName}"></dd>

                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="employeeEmail" value="${sessionScope.editEmployee.email}"></dd>
                            
                        <dt>Password:</dt>
                            <dd><input class="input-medium" type="password" name="employeePassword" value="${sessionScope.editEmployee.password}"></dd>
                            
                        <dt>Phone:</dt>
                            <dd><input class="input-medium" type="text" name="employeePhone" value="${sessionScope.editEmployee.telephone}"></dd>
                            
                        <dt>Address:</dt>
                            <dd><input class="input-medium" type="text" name="employeeAddress" value="${sessionScope.editEmployee.address}"></dd>
                            
                        <dt>City:</dt>
                            <dd><input class="input-medium" type="text" name="employeeCity" value="${sessionScope.editEmployee.city}"></dd>

                        <dt>State:</dt>
                            <dd>
                                <select class="selectpicker" data-width="164px" name="employeeState" id="state">
                                    <option value="AL" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "AL" ? "selected" : ""}>Alabama</option>
                                    <option value="AK" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "AK" ? "selected" : ""}>Alaska</option>
                                    <option value="AZ" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "AZ" ? "selected" : ""}>Arizona</option>
                                    <option value="AR" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "AR" ? "selected" : ""}>Arkansas</option>
                                    <option value="CA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "CA" ? "selected" : ""}>California</option>
                                    <option value="CO" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "CO" ? "selected" : ""}>Colorado</option>
                                    <option value="CT" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "CT" ? "selected" : ""}>Connecticut</option>
                                    <option value="DE" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "DE" ? "selected" : ""}>Delaware</option>
                                    <option value="DC" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "DC" ? "selected" : ""}>District Of Columbia</option>
                                    <option value="FL" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "FL" ? "selected" : ""}>Florida</option>
                                    <option value="GA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "GA" ? "selected" : ""}>Georgia</option>
                                    <option value="HI" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "HI" ? "selected" : ""}>Hawaii</option>
                                    <option value="ID" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "ID" ? "selected" : ""}>Idaho</option>
                                    <option value="IL" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "IL" ? "selected" : ""}>Illinois</option>
                                    <option value="IN" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "IN" ? "selected" : ""}>Indiana</option>
                                    <option value="IA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "IA" ? "selected" : ""}>Iowa</option>
                                    <option value="KS" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "KS" ? "selected" : ""}>Kansas</option>
                                    <option value="KY" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "KY" ? "selected" : ""}>Kentucky</option>
                                    <option value="LA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "LA" ? "selected" : ""}>Louisiana</option>
                                    <option value="ME" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "ME" ? "selected" : ""}>Maine</option>
                                    <option value="MD" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MD" ? "selected" : ""}>Maryland</option>
                                    <option value="MA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MA" ? "selected" : ""}>Massachusetts</option>
                                    <option value="MI" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MI" ? "selected" : ""}>Michigan</option>
                                    <option value="MN" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MN" ? "selected" : ""}>Minnesota</option>
                                    <option value="MS" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MS" ? "selected" : ""}>Mississippi</option>
                                    <option value="MO" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MO" ? "selected" : ""}>Missouri</option>
                                    <option value="MT" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "MT" ? "selected" : ""}>Montana</option>
                                    <option value="NE" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NE" ? "selected" : ""}>Nebraska</option>
                                    <option value="NV" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NV" ? "selected" : ""}>Nevada</option>
                                    <option value="NH" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NH" ? "selected" : ""}>New Hampshire</option>
                                    <option value="NJ" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NJ" ? "selected" : ""}>New Jersey</option>
                                    <option value="NM" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NM" ? "selected" : ""}>New Mexico</option>
                                    <option value="NY" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NY" ? "selected" : ""}>New York</option>
                                    <option value="NC" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "NC" ? "selected" : ""}>North Carolina</option>
                                    <option value="ND" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "ND" ? "selected" : ""}>North Dakota</option>
                                    <option value="OH" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "OH" ? "selected" : ""}>Ohio</option>
                                    <option value="OK" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "OK" ? "selected" : ""}>Oklahoma</option>
                                    <option value="OR" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "OR" ? "selected" : ""}>Oregon</option>
                                    <option value="PA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "PA" ? "selected" : ""}>Pennsylvania</option>
                                    <option value="RI" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "RI" ? "selected" : ""}>Rhode Island</option>
                                    <option value="SC" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "SC" ? "selected" : ""}>South Carolina</option>
                                    <option value="SD" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "SD" ? "selected" : ""}>South Dakota</option>
                                    <option value="TN" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "TN" ? "selected" : ""}>Tennessee</option>
                                    <option value="TX" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "TX" ? "selected" : ""}>Texas</option>
                                    <option value="UT" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "UT" ? "selected" : ""}>Utah</option>
                                    <option value="VT" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "VT" ? "selected" : ""}>Vermont</option>
                                    <option value="VA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "VA" ? "selected" : ""}>Virginia</option>
                                    <option value="WA" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "WA" ? "selected" : ""}>Washington</option>
                                    <option value="WV" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "WV" ? "selected" : ""}>West Virginia</option>
                                    <option value="WI" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "WI" ? "selected" : ""}>Wisconsin</option>
                                    <option value="WY" ${sessionScope.editEmployee.stateAbrv.stateAbrv == "WY" ? "selected" : ""}>Wyoming</option>
                                </select>
                            </dd>      
                            
                        <dt>Zip Code:</dt>
                			<dd><input class="input-medium" type="text" name="employeeZipCode" value="${sessionScope.editEmployee.zipCode}"></dd>
                            
                        <dt>Start Date:</dt>
                			<dd><input class="input-medium" type="text" name="employeeStartDate" value="${sessionScope.editEmployee.employee.startDate}"></dd>    
                            
                        <dt>Employee Type:</dt>
                			<dd>
                            	<select class="selectpicker" data-width="164px"  name="employeeType" id="state">
                                    <option value="Admin" ${sessionScope.editEmployee.employee.employeeType == "Manager" ? "selected" : ""}>Admin</option>
                                    <option value="Rep" ${sessionScope.editEmployee.employee.employeeType == "Customer Rep" ? "selected" : ""}>Customer Rep</option>
                                </select>
                            </dd>     
                            
                        <dt>Hourly Wage:</dt>
                			<dd><input class="input-medium" type="text" name="employeeHourlyWage" value="${sessionScope.editEmployee.employee.hourlyRate}"></dd>      
                            
                        <dt></dt>
                        <dd><button class="btn btn-success" type="submit">Save</button></dd>

                    </dl>
               </form>
           </div>
            
        </div> <!-- container div end -->
	</body>
</html>
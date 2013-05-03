<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
                
                
                <link href="css/customer_settings_style.css" rel="stylesheet" media="screen" />
                <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
                
                
                <link href="css/bootstrap-select.css" rel="stylesheet" media="screen" />
                <script src="js/bootstrap-select.js"></script>
                
                <script>
                    $(document).ready( function() {
                        $('.selectpicker').selectpicker();
                    });
                    
                    // MAKE SURE EVERYTHING IS LOADED BEFORE YOU ACCESS IT
                    $(document).ready( function() {
                        
                        // Function that checks whether a differnet plan was selected
                        $("#plan").change(function() {
                            
                            var planSelected = $("#plan option:selected").val();
                            
                            if (planSelected=="1") {
                                $("#moviespermonth").val("2");
                                $("#maxmoviesout").val("1");
                                $("#price").val("$10.00");
                            }
                            else if (planSelected=="2") {
                                $("#moviespermonth").val("Unlimited");
                                $("#maxmoviesout").val("1");
                                $("#price").val("$15.00");
                            }
                            else if (planSelected=="3") {
                                $("#moviespermonth").val("Unlimited");
                                $("#maxmoviesout").val("2");
                                $("#price").val("$20.00");
                            }
                            else if (planSelected=="4") {
                                $("#moviespermonth").val("Unlimited");
                                $("#maxmoviesout").val("Unlimited");
                                $("#price").val("$25.00");
                            }
                        });
                        
                    });
                </script>
	</head>

<body>


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
                        <li class=""><a href="HistoryServlet">History</a></li>
                        <li class="active"><a href="#">Settings</a></li>
                        <li class=""><a href="SupportServlet">Support</a></li>
                  </ul>
              </div>
            </div>
            
            
            
           <!-- PERSONAL INFO -->
           <div id="personal-info-frame">
               <form action="SaveCustomerSettingsServlet" method="post">
                            <h3>Personal Info</h3>

                    <dl class="dl-horizontal">

                        <dt>First Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerName" value="${person.firstName}"></dd>
                            
                        <dt>Last Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerName" value="${person.lastName}"></dd>

                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="customerEmail" value="${person.email}"></dd>
                            
                        <dt>Password:</dt>
                            <dd><input class="input-medium" type="password" name="customerPassword" value="password"></dd>
                            
                        <dt>Phone:</dt>
                            <dd><input class="input-medium" type="text" name="customerPhone" value="Phone"></dd>
                            
                        <dt>Address:</dt>
                            <dd><input class="input-medium" type="text" name="customerAddress" value="Address"></dd>
                            
                        <dt>City:</dt>
                            <dd><input class="input-medium" type="text" name="customerCity" value="City"></dd>

                        <dt>State:</dt>
                            <dd><input class="input-medium" type="text" name="customerState" value="State"></dd>    
                            
                        <dt>Zip Code:</dt>
                	<dd>
                            <select class="selectpicker" name="customerZipCode" id="zipcode">
                                <option selected value="1">RI</option>
                            </select>
                        </dd>                           
                            
                        <dt>Credit Card Number:</dt>
                            <dd><input class="input-medium" type="text" name="customerCardNumber" value="${customer.creditCardNumber}"></dd>

                        <dt></dt>
                        <dd><button class="btn btn-success" type="submit">Save</button></dd>

                    </dl>
               </form>
           </div>
           
           
           
			<!-- DIVIDER -->
            <hr class="featurette-divider">
           
           
           
           <!-- ACCOUNT TYPE -->
           <div id="account-type-frame">
           		<h3>Account Type</h3>
				
                <dl class="dl-horizontal">
                	<dt>Plan:</dt>
                	<dd>
                            <select class="selectpicker" name="plan" id="plan">
                                <option selected value="1">Bronze</option>
                                <option value="2">Silver</option>
                                <option value="3">Gold</option>
                                <option value="4">Platinum</option>
                            </select>
                        </dd>
                    
                    <dt># Movies/month:</dt>
                	<dd><input id="moviespermonth" class="input-medium" disabled type="text" value="2"></dd>
                        
                    <dt>Max Movies Out:</dt>
                	<dd><input id="maxmoviesout" class="input-medium" disabled type="text" value="1"></dd>
                    
                    <dt>Price/month:</dt>
                	<dd><input id="price" class="input-medium" disabled type="text" value="$10.00"></dd>
                    
                    <dt></dt>
                    <dd><button class="btn btn-success" type="button">Save</button></dd>
                  
                </dl>
           </div>
           
            </div>
        </div> <!-- container div end -->
	</body>
</html>
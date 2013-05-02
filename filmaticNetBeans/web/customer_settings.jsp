<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
                <link href="css/customer_settings_style.css" rel="stylesheet" media="screen" />
                <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
                
                <script>
                    // MAKE SURE EVERYTHING IS LOADED BEFORE YOU ACCESS IT
                    $(document).ready( function() {
                        
                        // Function that checks whether a differnet plan was selected
                        $("#plan").change(function() {
//                          // FIRST PLAN WAS SELECTED
                            if($(this)[0].value=="1") {
                                alert ("yolo");
                            }
                            // SECOND PLAN
                            else if($(this)[1].value=="2") {
                                
                            }
                            // THIRD PLAN
                            else if($(this)[2].value=="3") {
                                
                               
                            }
                        });
                        
                    });
                </script>
	</head>

<body>


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

                            <dt>Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerName" value="${person.firstName} ${person.lastName}"></dd>

                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="customerEmail" value="${person.email}"></dd>

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
                            <select class="selectpicker" name="plan" id="plan" style="">
                                <option value="1">1/month</option>
                                <option value="2">2/month</option>
                                <option value="3">Unlimited</option>
                            </select>
                        </dd>
                    
                    <dt># Movies/month:</dt>
                	<dd><input class="input-medium" type="text" value="Unlimited"></dd>
                    
                    <dt>Price/month:</dt>
                	<dd><input class="input-medium" type="text" value="$15"></dd>
                    
                    <dt></dt>
                    <dd><button class="btn btn-success" type="button">Save</button></dd>
                  
                </dl>
           </div>
           
            </div>
        </div> <!-- container div end -->
	</body>
</html>
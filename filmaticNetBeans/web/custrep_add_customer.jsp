<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Customer Representative Edit Customer</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/custrep_edit_customer_style.css" rel="stylesheet" media="screen" />
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
            
            
            
            <!-- CUSTOMER REP EDIT CUSTOMER-->
           <div id="personal-info-frame">
               <form action="AddNewCustomerServlet" method="post">
                    <h3>Add Customer</h3>
                    <h4><u>Personal Info</u></h4>

                    <dl class="dl-horizontal">

                        <dt>First Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerFirstName"></dd>
                            
                        <dt>Last Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerLastName"></dd>

                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="customerEmail"></dd>
                            
                        <dt>Password:</dt>
                            <dd><input class="input-medium" type="password" name="customerPassword"></dd>
                            
                        <dt>Phone:</dt>
                            <dd><input class="input-medium" type="text" name="customerPhone"></dd>
                            
                        <dt>Address:</dt>
                            <dd><input class="input-medium" type="text" name="customerAddress"></dd>
                            
                        <dt>City:</dt>
                            <dd><input class="input-medium" type="text" name="customerCity"></dd>

                        <dt>State:</dt>
                            <dd>
                                <select class="selectpicker" data-width="164px" name="customerState" id="state">
                                    <option value="AL" >Alabama</option>
                                    <option value="AK" >Alaska</option>
                                    <option value="AZ" >Arizona</option>
                                    <option value="AR" >Arkansas</option>
                                    <option value="CA" >California</option>
                                    <option value="CO" >Colorado</option>
                                    <option value="CT" >Connecticut</option>
                                    <option value="DE" >Delaware</option>
                                    <option value="DC" >District Of Columbia</option>
                                    <option value="FL" >Florida</option>
                                    <option value="GA" >Georgia</option>
                                    <option value="HI" >Hawaii</option>
                                    <option value="ID" >Idaho</option>
                                    <option value="IL" >Illinois</option>
                                    <option value="IN" >Indiana</option>
                                    <option value="IA" >Iowa</option>
                                    <option value="KS" >Kansas</option>
                                    <option value="KY" >Kentucky</option>
                                    <option value="LA" >Louisiana</option>
                                    <option value="ME" >Maine</option>
                                    <option value="MD" >Maryland</option>
                                    <option value="MA" >Massachusetts</option>
                                    <option value="MI" >Michigan</option>
                                    <option value="MN" >Minnesota</option>
                                    <option value="MS" >Mississippi</option>
                                    <option value="MO" >Missouri</option>
                                    <option value="MT" >Montana</option>
                                    <option value="NE" >Nebraska</option>
                                    <option value="NV" >Nevada</option>
                                    <option value="NH" >New Hampshire</option>
                                    <option value="NJ" >New Jersey</option>
                                    <option value="NM" >New Mexico</option>
                                    <option value="NY" selected>New York</option>
                                    <option value="NC" >North Carolina</option>
                                    <option value="ND" >North Dakota</option>
                                    <option value="OH" >Ohio</option>
                                    <option value="OK" >Oklahoma</option>
                                    <option value="OR" >Oregon</option>
                                    <option value="PA" >Pennsylvania</option>
                                    <option value="RI" >Rhode Island</option>
                                    <option value="SC" >South Carolina</option>
                                    <option value="SD" >South Dakota</option>
                                    <option value="TN" >Tennessee</option>
                                    <option value="TX" >Texas</option>
                                    <option value="UT" >Utah</option>
                                    <option value="VT" >Vermont</option>
                                    <option value="VA" >Virginia</option>
                                    <option value="WA" >Washington</option>
                                    <option value="WV" >West Virginia</option>
                                    <option value="WI" >Wisconsin</option>
                                    <option value="WY" >Wyoming</option>
                                </select>
                            </dd>      
                            
                        <dt>Zip Code:</dt>
                	<dd><input class="input-medium" type="text" name="customerZipCode"></dd>                           

                    </dl>
           </div>
           
           
           
			<!-- DIVIDER -->
            <hr class="featurette-divider">
           
           
           
           <!-- ACCOUNT TYPE -->
           <div id="account-type-frame">
               
                    <h4><u>Account Type</u></h4>
				
                    <dl class="dl-horizontal">
                            <dt>Plan:</dt>
                            <dd>
                                <select class="selectpicker" data-width="164px" name="customerPlan" id="plan">
                                    <option value="1" >Bronze</option>
                                    <option value="2" selected>Silver</option>
                                    <option value="3" >Gold</option>
                                    <option value="4" >Platinum</option>
                                </select>
                            </dd>

                        <dt># Movies/month:</dt>
                            <dd><input id="moviespermonth" class="input-medium" disabled type="text"></dd>

                        <dt>Max Movies Out:</dt>
                            <dd><input id="maxmoviesout" class="input-medium" disabled type="text"></dd>

                        <dt>Price/month:</dt>
                            <dd><input id="price" class="input-medium" disabled type="text"></dd>

                        <dt>Credit Card Number:</dt>
                            <dd><input class="input-medium" type="text" name="customerCardNumber"></dd>    

                        <dt></dt>
                        <dd><button class="btn btn-success" type="submit">Add Customer</button></dd>

                    </dl>
               </form>
           </div>
                
        </div> <!-- container div end -->
	</body>
</html>
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
                            <dd><input class="input-medium" type="text" name="customerFirstName" value="${person.firstName}"></dd>
                            
                        <dt>Last Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerLastName" value="${person.lastName}"></dd>

                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="customerEmail" value="${person.email}"></dd>
                            
                        <dt>Password:</dt>
                            <dd><input class="input-medium" type="password" name="customerPassword" value="${person.password}"></dd>
                            
                        <dt>Phone:</dt>
                            <dd><input class="input-medium" type="text" name="customerPhone" value="${person.telephone}"></dd>
                            
                        <dt>Address:</dt>
                            <dd><input class="input-medium" type="text" name="customerAddress" value="${person.address}"></dd>
                            
                        <dt>City:</dt>
                            <dd><input class="input-medium" type="text" name="customerCity" value="${person.city}"></dd>

                        <dt>State:</dt>
                            <dd>
                                <select class="selectpicker" name="customerState" id="state">
                                    <option value="AL" selected=${person.stateAbrv == "AL" ? "selected" : ""}>Alabama</option>
                                    <option value="AK" selected=${person.stateAbrv == "AK" ? "selected" : ""}>Alaska</option>
                                    <option value="AZ" selected=${person.stateAbrv == "AZ" ? "selected" : ""}>Arizona</option>
                                    <option value="AR" selected=${person.stateAbrv == "AR" ? "selected" : ""}>Arkansas</option>
                                    <option value="CA" selected=${person.stateAbrv == "CA" ? "selected" : ""}>California</option>
                                    <option value="CO" selected=${person.stateAbrv == "CO" ? "selected" : ""}>Colorado</option>
                                    <option value="CT" selected=${person.stateAbrv == "CT" ? "selected" : ""}>Connecticut</option>
                                    <option value="DE" selected=${person.stateAbrv == "DE" ? "selected" : ""}>Delaware</option>
                                    <option value="DC" selected=${person.stateAbrv == "DC" ? "selected" : ""}>District Of Columbia</option>
                                    <option value="FL" selected=${person.stateAbrv == "FL" ? "selected" : ""}>Florida</option>
                                    <option value="GA" selected=${person.stateAbrv == "GA" ? "selected" : ""}>Georgia</option>
                                    <option value="HI" selected=${person.stateAbrv == "HI" ? "selected" : ""}>Hawaii</option>
                                    <option value="ID" selected=${person.stateAbrv == "ID" ? "selected" : ""}>Idaho</option>
                                    <option value="IL" selected=${person.stateAbrv == "IL" ? "selected" : ""}>Illinois</option>
                                    <option value="IN" selected=${person.stateAbrv == "IN" ? "selected" : ""}>Indiana</option>
                                    <option value="IA" selected=${person.stateAbrv == "IA" ? "selected" : ""}>Iowa</option>
                                    <option value="KS" selected=${person.stateAbrv == "KS" ? "selected" : ""}>Kansas</option>
                                    <option value="KY" selected=${person.stateAbrv == "KY" ? "selected" : ""}>Kentucky</option>
                                    <option value="LA" selected=${person.stateAbrv == "LA" ? "selected" : ""}>Louisiana</option>
                                    <option value="ME" selected=${person.stateAbrv == "ME" ? "selected" : ""}>Maine</option>
                                    <option value="MD" selected=${person.stateAbrv == "MD" ? "selected" : ""}>Maryland</option>
                                    <option value="MA" selected=${person.stateAbrv == "MA" ? "selected" : ""}>Massachusetts</option>
                                    <option value="MI" selected=${person.stateAbrv == "MI" ? "selected" : ""}>Michigan</option>
                                    <option value="MN" selected=${person.stateAbrv == "MN" ? "selected" : ""}>Minnesota</option>
                                    <option value="MS" selected=${person.stateAbrv == "MS" ? "selected" : ""}>Mississippi</option>
                                    <option value="MO" selected=${person.stateAbrv == "MO" ? "selected" : ""}>Missouri</option>
                                    <option value="MT" selected=${person.stateAbrv == "MT" ? "selected" : ""}>Montana</option>
                                    <option value="NE" selected=${person.stateAbrv == "NE" ? "selected" : ""}>Nebraska</option>
                                    <option value="NV" selected=${person.stateAbrv == "NV" ? "selected" : ""}>Nevada</option>
                                    <option value="NH" selected=${person.stateAbrv == "NH" ? "selected" : ""}>New Hampshire</option>
                                    <option value="NJ" selected=${person.stateAbrv == "NJ" ? "selected" : ""}>New Jersey</option>
                                    <option value="NM" selected=${person.stateAbrv == "NM" ? "selected" : ""}>New Mexico</option>
                                    <option value="NY" selected=${person.stateAbrv == "NY" ? "selected" : ""}>New York</option>
                                    <option value="NC" selected=${person.stateAbrv == "NC" ? "selected" : ""}>North Carolina</option>
                                    <option value="ND" selected=${person.stateAbrv == "ND" ? "selected" : ""}>North Dakota</option>
                                    <option value="OH" selected=${person.stateAbrv == "OH" ? "selected" : ""}>Ohio</option>
                                    <option value="OK" selected=${person.stateAbrv == "OK" ? "selected" : ""}>Oklahoma</option>
                                    <option value="OR" selected=${person.stateAbrv == "OR" ? "selected" : ""}>Oregon</option>
                                    <option value="PA" selected=${person.stateAbrv == "PA" ? "selected" : ""}>Pennsylvania</option>
                                    <option value="RI" selected=${person.stateAbrv == "RI" ? "selected" : ""}>Rhode Island</option>
                                    <option value="SC" selected=${person.stateAbrv == "SC" ? "selected" : ""}>South Carolina</option>
                                    <option value="SD" selected=${person.stateAbrv == "SD" ? "selected" : ""}>South Dakota</option>
                                    <option value="TN" selected=${person.stateAbrv == "TN" ? "selected" : ""}>Tennessee</option>
                                    <option value="TX" selected=${person.stateAbrv == "TX" ? "selected" : ""}>Texas</option>
                                    <option value="UT" selected=${person.stateAbrv == "UT" ? "selected" : ""}>Utah</option>
                                    <option value="VT" selected=${person.stateAbrv == "VT" ? "selected" : ""}>Vermont</option>
                                    <option value="VA" selected=${person.stateAbrv == "VA" ? "selected" : ""}>Virginia</option>
                                    <option value="WA" selected=${person.stateAbrv == "WA" ? "selected" : ""}>Washington</option>
                                    <option value="WV" selected=${person.stateAbrv == "WV" ? "selected" : ""}>West Virginia</option>
                                    <option value="WI" selected=${person.stateAbrv == "WI" ? "selected" : ""}>Wisconsin</option>
                                    <option value="WY" selected=${person.stateAbrv == "WY" ? "selected" : ""}>Wyoming</option>
                                </select>
                            </dd>      
                            
                        <dt>Zip Code:</dt>
                	<dd><input class="input-medium" type="text" name="customerZipCode" value="${person.zipCode}"></dd>                           
                        
                        <dt></dt>
                        <dd><button class="btn btn-success" type="submit">Save</button></dd>

                    </dl>
               </form>
           </div>
           
           
           
			<!-- DIVIDER -->
            <hr class="featurette-divider">
           
           
           
           <!-- ACCOUNT TYPE -->
           <div id="account-type-frame">
               <form action="SaveCustomerOptionsServlet" method="post">
                    <h3>Account Type</h3>
				
                    <dl class="dl-horizontal">
                            <dt>Plan:</dt>
                            <dd>
                                <select class="selectpicker" name="plan" id="plan">
                                    <option value="1" ${customer.accountType == "1" ? "selected" : ""}>Bronze</option>
                                    <option value="2" ${customer.accountType == "2" ? "selected" : ""}>Silver</option>
                                    <option value="3" ${customer.accountType == "3" ? "selected" : ""}>Gold</option>
                                    <option value="4" ${customer.accountType == "4" ? "selected" : ""}>Platinum</option>
                                </select>
                            </dd>

                        <dt># Movies/month:</dt>
                            <dd><input id="moviespermonth" class="input-medium" disabled type="text" value="2"></dd>

                        <dt>Max Movies Out:</dt>
                            <dd><input id="maxmoviesout" class="input-medium" disabled type="text" value="1"></dd>

                        <dt>Price/month:</dt>
                            <dd><input id="price" class="input-medium" disabled type="text" value="$10.00"></dd>

                        <dt>Credit Card Number:</dt>
                            <dd><input class="input-medium" type="text" name="customerCardNumber" value="${customer.creditCardNumber}"></dd>    

                        <dt></dt>
                        <dd><button class="btn btn-success" type="submit">Save</button></dd>

                    </dl>
               </form>
           </div>
           
            </div>
        </div> <!-- container div end -->
	</body>
</html>
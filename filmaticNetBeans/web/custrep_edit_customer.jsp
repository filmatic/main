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
               <form action="SaveCustomerDetailsServlet" method="post">
                    <h3>Edit Customer</h3>
                    <h4><u>Personal Info</u></h4>

                    <dl class="dl-horizontal">
                        <input type="hidden" name="customerId" value="${sessionScope.editCustomer.personId}"></input>
                        <dt>First Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerFirstName" value="${sessionScope.editCustomer.firstName}"></dd>
                            
                        <dt>Last Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerLastName" value="${sessionScope.editCustomer.lastName}"></dd>

                        <dt>E-mail:</dt>
                            <dd><input class="input-medium" type="text" name="customerEmail" value="${sessionScope.editCustomer.email}"></dd>
                            
                        <dt>Password:</dt>
                            <dd><input class="input-medium" type="password" name="customerPassword" value="${sessionScope.editCustomer.password}"></dd>
                            
                        <dt>Phone:</dt>
                            <dd><input class="input-medium" type="text" name="customerPhone" value="${sessionScope.editCustomer.telephone}"></dd>
                            
                        <dt>Address:</dt>
                            <dd><input class="input-medium" type="text" name="customerAddress" value="${sessionScope.editCustomer.address}"></dd>
                            
                        <dt>City:</dt>
                            <dd><input class="input-medium" type="text" name="customerCity" value="${sessionScope.editCustomer.city}"></dd>

                        <dt>State:</dt>
                            <dd>
                                <select class="selectpicker" data-width="164px" name="customerState" id="state">
                                    <option value="AL" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "AL" ? "selected" : ""}>Alabama</option>
                                    <option value="AK" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "AK" ? "selected" : ""}>Alaska</option>
                                    <option value="AZ" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "AZ" ? "selected" : ""}>Arizona</option>
                                    <option value="AR" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "AR" ? "selected" : ""}>Arkansas</option>
                                    <option value="CA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "CA" ? "selected" : ""}>California</option>
                                    <option value="CO" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "CO" ? "selected" : ""}>Colorado</option>
                                    <option value="CT" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "CT" ? "selected" : ""}>Connecticut</option>
                                    <option value="DE" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "DE" ? "selected" : ""}>Delaware</option>
                                    <option value="DC" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "DC" ? "selected" : ""}>District Of Columbia</option>
                                    <option value="FL" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "FL" ? "selected" : ""}>Florida</option>
                                    <option value="GA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "GA" ? "selected" : ""}>Georgia</option>
                                    <option value="HI" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "HI" ? "selected" : ""}>Hawaii</option>
                                    <option value="ID" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "ID" ? "selected" : ""}>Idaho</option>
                                    <option value="IL" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "IL" ? "selected" : ""}>Illinois</option>
                                    <option value="IN" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "IN" ? "selected" : ""}>Indiana</option>
                                    <option value="IA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "IA" ? "selected" : ""}>Iowa</option>
                                    <option value="KS" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "KS" ? "selected" : ""}>Kansas</option>
                                    <option value="KY" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "KY" ? "selected" : ""}>Kentucky</option>
                                    <option value="LA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "LA" ? "selected" : ""}>Louisiana</option>
                                    <option value="ME" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "ME" ? "selected" : ""}>Maine</option>
                                    <option value="MD" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MD" ? "selected" : ""}>Maryland</option>
                                    <option value="MA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MA" ? "selected" : ""}>Massachusetts</option>
                                    <option value="MI" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MI" ? "selected" : ""}>Michigan</option>
                                    <option value="MN" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MN" ? "selected" : ""}>Minnesota</option>
                                    <option value="MS" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MS" ? "selected" : ""}>Mississippi</option>
                                    <option value="MO" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MO" ? "selected" : ""}>Missouri</option>
                                    <option value="MT" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "MT" ? "selected" : ""}>Montana</option>
                                    <option value="NE" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NE" ? "selected" : ""}>Nebraska</option>
                                    <option value="NV" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NV" ? "selected" : ""}>Nevada</option>
                                    <option value="NH" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NH" ? "selected" : ""}>New Hampshire</option>
                                    <option value="NJ" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NJ" ? "selected" : ""}>New Jersey</option>
                                    <option value="NM" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NM" ? "selected" : ""}>New Mexico</option>
                                    <option value="NY" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NY" ? "selected" : ""}>New York</option>
                                    <option value="NC" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "NC" ? "selected" : ""}>North Carolina</option>
                                    <option value="ND" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "ND" ? "selected" : ""}>North Dakota</option>
                                    <option value="OH" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "OH" ? "selected" : ""}>Ohio</option>
                                    <option value="OK" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "OK" ? "selected" : ""}>Oklahoma</option>
                                    <option value="OR" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "OR" ? "selected" : ""}>Oregon</option>
                                    <option value="PA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "PA" ? "selected" : ""}>Pennsylvania</option>
                                    <option value="RI" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "RI" ? "selected" : ""}>Rhode Island</option>
                                    <option value="SC" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "SC" ? "selected" : ""}>South Carolina</option>
                                    <option value="SD" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "SD" ? "selected" : ""}>South Dakota</option>
                                    <option value="TN" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "TN" ? "selected" : ""}>Tennessee</option>
                                    <option value="TX" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "TX" ? "selected" : ""}>Texas</option>
                                    <option value="UT" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "UT" ? "selected" : ""}>Utah</option>
                                    <option value="VT" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "VT" ? "selected" : ""}>Vermont</option>
                                    <option value="VA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "VA" ? "selected" : ""}>Virginia</option>
                                    <option value="WA" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "WA" ? "selected" : ""}>Washington</option>
                                    <option value="WV" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "WV" ? "selected" : ""}>West Virginia</option>
                                    <option value="WI" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "WI" ? "selected" : ""}>Wisconsin</option>
                                    <option value="WY" ${sessionScope.editCustomer.stateAbrv.stateAbrv == "WY" ? "selected" : ""}>Wyoming</option>
                                </select>
                            </dd>      
                            
                        <dt>Zip Code:</dt>
                	<dd><input class="input-medium" type="text" name="customerZipCode" value="${sessionScope.editCustomer.zipCode}"></dd>                           
                        
                        <dt></dt>
                        <dd><button class="btn btn-success" type="submit">Save</button></dd>

                    </dl>
               </form>
           </div>
   
        </div> <!-- container div end -->
	</body>
</html>
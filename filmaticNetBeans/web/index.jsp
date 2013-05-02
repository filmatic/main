<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
                <link href="css/login_style.css" rel="stylesheet" media="screen" />
                <script src="http://code.jquery.com/jquery.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <link href="css/bootstrap-select.css" rel="stylesheet" media="screen" />
                <script src="js/bootstrap-select.js"></script>
                
                <script>
                    $(document).ready( function() {
                        $('.selectpicker').selectpicker();
                    });
                    
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

            <c:if test="${requestScope.invalidpw}">
                <div class="alert alert-error">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Error!</strong> Invalid username or password.
                </div>
            </c:if>
             
            <div id="login_wrapper">
                <div id="login_box">
                    <img id="logo" src="img/login_logo.jpg" alt="login" />
                    <form method="post" action="LoginServlet" name="LoginForm">
                        <div <c:if test="${requestScope.invalidpw}"> class="control-group error" </c:if> id="inputwrap">
                        <input id="username" value="${requestScope.username}"
                               name="username" type="text" placeholder="Username"><br />
                        
                        <input id="password"
                               name="password" type="password" placeholder="Password"><br />
                        </div>
                        <button id="login" type="submit" class="btn btn-warning">Login</button><br />
                        
                        <div id="signup">
                            <a href="#myModal" role="button" data-toggle="modal">Not a member? Sign up here!</a>
                        </div>
                    </form>
                </div>
            </div>
                               
            <!-- Modal -->
            <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Register Form</h3>
                </div>
                
                <form method="POST" action="RegisterServlet" name="RegisterForm" id="RegisterForm">
                <div id="regbody" class="modal-body">
                    <dl class="dl-horizontal">
                        
                         <dt>E-mail (Login):</dt>
                            <dd><input class="input-medium" type="text" name="customerEmail" value=""></dd>
                         
                         <dt>Password:</dt>
                            <dd><input class="input-medium" type="text" name="customerPassword" value=""></dd>


                         <dt>Name:</dt>
                            <dd><input class="input-medium" type="text" name="customerName" value=""></dd>


                        <dt>Credit Card Number:</dt>
                            <dd><input class="input-medium" type="text" name="customerCardNumber" value=""></dd>

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

                    </dl>
                </div>
                               
                <div class="modal-footer" id="modal-footerz">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    <button class="btn btn-warning" type="submit">Register</button>
                </div>
                </form>   
                    
            </div>
            
	</body>
</html>
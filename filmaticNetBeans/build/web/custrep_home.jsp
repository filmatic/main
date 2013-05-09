<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Customer Representative Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/custrep_home_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

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
                        <li class="active"><a href="CustRepHomeServlet">Home</a></li>
                        <li class=""><a href="CustRepOrdersServlet">Orders</a></li>
                        <li class=""><a href="CustRepCustomersServlet">Customers</a></li>
                        <li class=""><a href="CustRepMailingListServlet">Mailing List</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- MOST ACTIVE CUSTOMERS -->
            <div>
            
            	<h3>Welcome Customer Representative!</h3>
                <h4>Click on "Orders" to approve incoming orders that customers have requested.</h4>
                
            </div>
            
                
        </div> <!-- container div end -->
	</body>
</html>
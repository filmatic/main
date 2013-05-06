<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Customer Representative Customers</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/custrep_customers_style.css" rel="stylesheet" media="screen" />
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
                        <li class=""><a href="CustRepHomeServlet">Home</a></li>
                        <li class=""><a href="CustRepOrdersServlet">Orders</a></li>
                        <li class="active"><a href="CustRepCustomersServlet">Customers</a></li>
                        <li class=""><a href="CustRepMailingListServlet">Mailing List</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- PENDING ORDERS -->
            <div>
            
            	<div style="overflow: hidden; margin-top:10px;">
                    <div style="float: left;">
                    	<h3>Customers</h3>
                    </div>
                    <div style="float: right;">
                    	<button style="height:30px; margin-top:18px;" class="btn btn-inverse" name="approve" value="1" type="submit">Add Customer</button>
                    </div>
		</div>
                
                
            	
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="number-column">#</th>
                      <th class="customerid-column">Customer Id</th>
                      <th class="">Name</th>
                      <th class="accttypeid-column">Account Type</th>
                      <th class="createdon-column">Created On</th>
                      <th class="rec-column"><!-- Recommendation button --></th>
                      <th class="remove-column"><!-- REMOVE button --></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>123213</td>
                      <td>My Super name</td>
                      <td>12345</td>
                      <td></td>
					  <td><button class="btn btn-info" name="approve" value="1" type="submit">Recommendations</button></td>
                      <td><button class="btn btn-danger" name="approve" value="1" type="submit"><i class="icon-remove icon-white"></i></button></td>
                    </tr>
                  </tbody>
                </table>
                
            </div>
                
        </div> <!-- container div end -->
	</body>
</html>
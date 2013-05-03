<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/customer_history_style.css" rel="stylesheet" media="screen" />
	</head>

<body>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>

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
                        <li class="active"><a href="#">History</a></li>
                        <li class=""><a href="SettingsServlet">Settings</a></li>
                        <li class=""><a href="SupportServlet">Support</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
           <!-- CUSTOMER HISTORY -->
           <div id="queue-frame">
           		<h3>History</h3>
           		
                <table class="table table-bordered table-condensed table-striped">  
                
                  <thead>
                    <tr>
                      <th class="number-column">#</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="rating-column">Rating</th>
                      <th class="order-date-column">Order Date</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Trouble in the Movie Queue</td>
                      <td>Documentary</td>
                      <td>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star-empty"></i>
                          <i class="icon-search icon-star-empty"></i>
                      </td>
                      <td>07/15/03</td>
                    </tr>
                    
                    <tr>
                      <td>2</td>
                      <td>Random Movie</td>
                      <td>Action</td>
                      <td>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star"></i>
                          <i class="icon-search icon-star-empty"></i>
                          <i class="icon-search icon-star-empty"></i>
                      </td>
                      <td>07/15/03</td>
                    </tr>
                  </tbody>
                  
                </table>
           </div>
           
            </div>
        </div> <!-- container div end -->
	</body>
</html>
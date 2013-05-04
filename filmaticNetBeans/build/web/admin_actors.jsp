<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Actors</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_actors_style.css" rel="stylesheet" media="screen" />
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
                        <li class=""><a href="AdminEmployeesServlet">Employees</a></li>
                        <li class=""><a href="AdminRentalsServlet">Rentals</a></li>
                        <li class=""><a href="AdminMoviesServlet">Movies</a></li>
                        <li class="active"><a href="">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- MOVIE RENTALS TABLE -->
            <div>
            
            	<h3>Actors</h3>
                
                <table class="table table-bordered table-condensed table-striped">  
                  <thead>
                    <tr>
                      <th class="number-column">#</th>
                      <th class="movieid-column">Movie Id</th>
                      <th>Title</th>
                      <th class="genre-column">Genre</th>
                      <th class="distfee-column">Dist. Fee</th>
                      <th class="numcopies-column"># Copies</th>
                      <th class="timesrated-column">Times Rated</th>
                      <th class="remove-column"><!-- Remove Button --></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>2222</td>
                      <td>Super TRoopers</td>
                      <td>Comedy</td>
                      <td>$10.00</td>
                      <td>5</td>
                      <td>2</td>
                      <td>
                      	<button class="btn btn-danger" type="submit" name="movieToRemove" value="2"><i class="icon-remove icon-white"></i></button>
                      </td>
                    </tr>
                  </tbody>
                  
                </table>
                
            </div>
            
        </div> <!-- container div end -->
	</body>
</html>
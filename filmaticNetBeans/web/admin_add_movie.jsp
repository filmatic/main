<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic - Admin Add Movie</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        <link href="css/admin_add_movie_style.css" rel="stylesheet" media="screen" />
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
                        <li class="active"><a href="">Movies</a></li>
                        <li class=""><a href="AdminActorsServlet">Actors</a></li>
                  </ul>
              </div>
            </div> 
            
            
            
            <!-- ADD MOVIE -->
           <div id="personal-info-frame">
               <form action="AddMovieServlet" method="post">
                    <h3>Add Movie</h3>

                    <dl class="dl-horizontal">

                        <dt>Title:</dt>
                            <dd><input class="input-medium" type="text" name="movieTitle"></dd>
                            
                        <dt>Genre:</dt>
                            <dd><input class="input-medium" type="text" name="movieGenre"></dd>

                        <dt>Distribution Fee:</dt>
                            <dd><input class="input-medium" type="text" name="movieDistributionFee"></dd>
                            
                        <dt># Copies:</dt>
                            <dd><input class="input-medium" type="text" name="movieCopies"></dd>
                            
                        <dt>Summary:</dt>
                            <dd><textarea rows="5" name="movieSummary"></textarea></dd>          
                            
                        <dt></dt>
                        	<dd><button class="btn btn-success" type="submit">Add Movie</button></dd>

                    </dl>
               </form>
           </div>
            
        </div> <!-- container div end -->
	</body>
</html>
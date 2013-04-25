<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/style.css" rel="stylesheet" media="screen" />
	</head>

	<body>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
        
        <div id="login_wrapper">
            <div id="login_box">
            	<img id="logo" src="img/login_logo.jpg" alt="login" />
            	<form method="post" action="LoginServlet" name="LoginForm">
                    <input id="username" name="username" type="text" placeholder="Username"><br />
                    <input id="password" name="password" type="password" placeholder="Password"><br />
                    <button type="submit" class="btn btn-warning">Login</button><br />
                </form>
            </div>
        </div>
	</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Filmatic</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link href="css/login_style.css" rel="stylesheet" media="screen" />
        
        <script type="text/javascript">
            
        </script>
        
	</head>

	<body>
            <script src="http://code.jquery.com/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            
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
                        <div id="signup"><p>Not a member? Sign up here!</p></div>
                    </form>
                </div>
            </div>
	</body>
</html>
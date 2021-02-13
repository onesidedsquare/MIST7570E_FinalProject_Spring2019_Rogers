<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>MIST7570E_FinalProject_Spring2019_Rogers</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/menu.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
  <div class="divider"></div>
  <c:import url="menu.jsp"/>
  <c:import url="sidebar.jsp"/>

  <div id="content">
    <h1>Log In</h1>
    ${requestScope.message}
    <blockquote>
		<form id="loginForm" action="Login" method="post">
			<input type="text" name="username" placeholder="Username" required/><br/>
			<input type="password" name="password" placeholder ="Password" required/><br/>
			<input type="submit" name="submit" value="Login"/><br/>
			${requestScope.errorMessage}
		</form>
	</blockquote>
  </div>
  <div class="divider"></div>
  <div id="footer" ></div>
  <div class="divider"></div>
</div>
</body>
</html>
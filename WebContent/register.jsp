<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page import="model.Constraints" %>
 
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
    <h1><span style="font-weight:bold; color:#B07E13;">Welcome to the Zymes Limes family!</span></h1>
    <h3>New User Registration</h3>
    <form name="addNewUser" action="Registration" method="post">
    	<blockquote>
    	<label>Username</label>
   		<input type="text" id="username" name="username"  maxlength="20" />
   		<br/>
   		<label>Password</label>
   		<input type="password" id="password_1" name="password_1"  maxlength="20"  />
   		<br/>
   		<label>Password(type again)</label>
   		<input type="password" id="password_1" name="password_2"  maxlength="20" />
   		<br/>
   		${errorMessage}
   		</blockquote>
   		<!-- <br/>
   		<blockquote>
   		<label>First Name</label>
   		<input type="text" name="first_name" />
   		<br/>
   		<label>Last Name</label>
   		<input type="text" name="last_name" />
   		<br/>
   		<label>Email</label>
   		<input type=\"text\" id\"orderQuanitity\" name=\"orderQuanitity\" maxlength=\"20\"/>
   		<br/>
   		<label>Telephone</label>
   		<input type="text" name="telephone" />
   		<br/>
   		</blockquote> -->
   		<br/>
   		&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" id="submit" name="submit" value="Register"/>
    </form>
	
  </div>
  <div class="divider"></div>
  <div id="footer" ></div>
  <div class="divider"></div>
</div>
</body>
</html>
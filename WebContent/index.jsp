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
   <c:choose>
	    <c:when test= "${sessionScope.SessionUser != null}">
	      	<h1>Welcome ${sessionScope.SessionUser.username}</h1>
	    </c:when>
	    <c:otherwise>
	     	<h1>Welcome to <span style="font-weight:bold; color:#B07E13;">ZYMES LIMES</span></h1>
	    </c:otherwise>
	</c:choose>
	 <c:choose>
	    <c:when test= "${requestScope.messageOrder != null}">
	      	<blockquote><h1> ${requestScope.messageOrder}</h1></blockquote>
	      	<br/>
	    </c:when>
	 </c:choose>
    <h3>Introduction</h3>
	    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Quisque malesuada arcu eu justo. Duis porttitor, turpis et malesuada vulputate, 
	    est erat accumsan tellus, id dictum magna enim eu ante. Vestibulum et nunc. Ut interdum, sem quis faucibus vehicula, quam tortor ultricies dui, 
	    vitae laoreet justo risus sit amet lorem. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed egestas quam molestie enim. Ut diam nisi, 
	    varius non, tristique eu, posuere sed, metus. Sed nisl. Vivamus hendrerit tempus urna. Aenean congue vehicula ipsum. Duis eu orci a mi fermentum 
	    accumsan. Quisque tincidunt erat. Phasellus porttitor risus eleifend sem. Mauris vitae lacus vel enim fermentum accumsan. </p>
  </div>
  <div class="divider"></div>
  <div id="footer" ></div>
  <div class="divider"></div>
</div>
</body>
</html>
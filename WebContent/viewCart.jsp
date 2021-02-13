<%@ page import="model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

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
  	<h3>View Order</h3>
	<table border="1">
		<tr>
			<td>Product</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total</td>
			<td>~</td>
		</tr>
		<tr>
			<td>Green Limes</td>
			<td>${sessionScope.SessionOrder.green_quantity}</td>
			<td><fmt:formatNumber value="${sessionScope.SessionGreenProduct.price}" type="currency" /></td>
			<td><fmt:formatNumber value="${sessionScope.SessionOrder.green_quantity * sessionScope.SessionGreenProduct.price}" type="currency" /></td>
			<td>
				<form name="RemoveFromCart" action="RemoveFromCart" method="post">
					<input type="hidden" id="remove" name="remove" value="${sessionScope.SessionGreenProduct.productID}"/>
					<input type="submit" id="submit" name="submit" value="Delete"/>
				</form>
			</td>
		</tr>
		<tr>
			<td>Yellow Limes</td>
			<td>${sessionScope.SessionOrder.yellow_quantity}</td>
			<td><fmt:formatNumber value="${sessionScope.SessionYellowProduct.price}" type="currency" /></td>
			<td><fmt:formatNumber value="${sessionScope.SessionOrder.yellow_quantity * sessionScope.SessionYellowProduct.price}" type="currency" /></td>
			<td>				
				<form name="RemoveFromCart" action="RemoveFromCart" method="post">
					<input type="hidden" id="remove" name="remove" value="${sessionScope.SessionYellowProduct.productID}"/>
					<input type="submit" id="submit" name="submit" value="Delete"/>
				</form>
			</td>
		</tr>
		<tr>
			<td>Orange Limes</td>
			<td>${sessionScope.SessionOrder.orange_quantity}</td>
			<td><fmt:formatNumber value="${sessionScope.SessionOrangeProdcut.price}" type="currency" /></td>
			<td><fmt:formatNumber value="${sessionScope.SessionOrder.orange_quantity * sessionScope.SessionOrangeProdcut.price}" type="currency" /></td>
			<td>				
				<form name="RemoveFromCart" action="RemoveFromCart" method="post">
					<input type="hidden" id="remove" name="remove" value="${sessionScope.SessionOrangeProdcut.productID}"/>
					<input type="submit" id="submit" name="submit" value="Delete"/>
				</form>
			</td>
		</tr>
		<tr>
			<td>Grape Limes</td>
			<td>${sessionScope.SessionOrder.grape_quantity}</td>
			<td><fmt:formatNumber value="${sessionScope.SessionGrapeProduct.price}" type="currency" /></td>
			<td><fmt:formatNumber value="${sessionScope.SessionOrder.grape_quantity * sessionScope.SessionGrapeProduct.price}" type="currency" /></td>
			<td>				
				<form name="RemoveFromCart" action="RemoveFromCart" method="post">
					<input type="hidden" id="remove" name="remove" value="${sessionScope.SessionGrapeProduct.productID}"/>
					<input type="submit" id="submit" name="submit" value="Delete"/>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan='3'>
			Total : 
			</td>
			<td colspan='2'>
			<fmt:formatNumber value="${(sessionScope.SessionOrder.green_quantity * sessionScope.SessionGreenProduct.price) + 
						(sessionScope.SessionOrder.yellow_quantity * sessionScope.SessionYellowProduct.price) + 
						(sessionScope.SessionOrder.orange_quantity * sessionScope.SessionOrangeProduct.price) + 
						(sessionScope.SessionOrder.grape_quantity * sessionScope.SessionGrapeProduct.price)}" type="currency" />
			</td>
		</tr>
	</table>
	<form name="Purchase" action="Purchase" method="post">
		<input type="submit" id="submit" name="submit" value="Purchase"/>
	</form>
	
	<c:choose>
	    <c:when test= "${sessionScope.SessionUser != null}">
	    	<form name="SaveForLater" action="SaveForLater" method="post">
	    		<input type="hidden" id="page" name="page" value="ViewCart"/>
				<input type="submit" id="submit" name="submit" value="Save For Later"/>
			</form>
	    </c:when>
	</c:choose>
	
  </div>
  <div class="divider"></div>
  <div id="footer" ></div>
  <div class="divider"></div>
</div>
</body>
</html>
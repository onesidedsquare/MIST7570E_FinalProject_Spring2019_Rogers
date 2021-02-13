
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ page import="model.Order"%>
<%@ page import="model.Product"%>
<%@ page import="model.Constraints" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>MIST7570E_FinalProject_Spring2019_Rogers</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/menu.css" rel="stylesheet" type="text/css" />
	<script>
	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	}
	
	</script>
</head>
<body>
<div id="container">
  <div class="divider"></div>
  <c:import url="menu.jsp"/>
  <c:import url="sidebar.jsp"/>

  <div id="content">
  	<h3>${message}</h3>
  		
	 <c:choose>
	    <c:when test= "${sessionScope.SessionOrder.green_quantity + sessionScope.SessionOrder.yellow_quantity + 
  		sessionScope.SessionOrder.orange_quantity + sessionScope.SessionOrder.grape_quantity > 0}">
	    	<h3>Cart (${sessionScope.SessionOrder.green_quantity + sessionScope.SessionOrder.yellow_quantity + 
  		sessionScope.SessionOrder.orange_quantity + sessionScope.SessionOrder.grape_quantity})</h3>
	    </c:when>
	</c:choose>

  	
    <form name="addToCart" action="addToCart" method="post">
    <table border='1'>
    	<tr>
			<td><img src="img/GR.jpg"/></td>
	    	<td>
		    	<h3>Product: ${sessionScope.SessionGreenProduct.productName}</h3>
		    	<p>A case contains ${sessionScope.SessionGreenProduct.quantity}</p>
		    	<p>Cost Per Case: <fmt:formatNumber value="${sessionScope.SessionGreenProduct.price}" type="currency" /></p>
		    	<input type="text" name="gr_amount" id="gr_amount" value="${sessionScope.SessionOrder.green_quantity}" 
		    		onkeypress="return isNumber(event)"  maxlength="4" />
		    	(Available ${sessionScope.SessionGreenProduct.inventory - sessionScope.SessionOrder.green_quantity})
		    	<p/>
		    	${requestScope.green_error}
		    	<input type="submit" id="submit" name="submit" value="Add to Cart"/>
	    	</td>
		</tr>
		<tr>
			<td><img src="img/YE.jpg"/></td>
	    	<td>
		    	<h3>Product: ${sessionScope.SessionYellowProduct.productName}</h3>
		    	<p>A case contains ${sessionScope.SessionYellowProduct.quantity}</p>
		    	<p>Cost Per Case: <fmt:formatNumber value="${sessionScope.SessionYellowProduct.price}" type="currency" /></p>
		    	<input type="text" name="ye_amount" id="ye_amount" value="${sessionScope.SessionOrder.yellow_quantity}" 
		    		onkeypress="return isNumber(event)"  maxlength="4" />
		    	(Available ${sessionScope.SessionYellowProduct.inventory - sessionScope.SessionOrder.yellow_quantity})
		    	<p/>
		    	${requestScope.yellow_error}
		    	<input type="submit" id="submit" name="submit" value="Add to Cart"/>
	    	</td>
		</tr>
		<tr>
			<td><img src="img/OR.jpg"/></td>
	    	<td>
		    	<h3>Product: ${sessionScope.SessionOrangeProdcut.productName}</h3>
		    	<p>A case contains ${sessionScope.SessionOrangeProdcut.quantity} </p>
		    	<p>Cost Per Case: <fmt:formatNumber value="${sessionScope.SessionOrangeProdcut.price}" type="currency" /></p>
		    	<input type="text" name="or_amount" id="or_amount" value="${sessionScope.SessionOrder.orange_quantity}" 
		    		onkeypress="return isNumber(event)"  maxlength="4" />
		    	(Available ${sessionScope.SessionOrangeProdcut.inventory - sessionScope.SessionOrder.orange_quantity})
		    	<p/>
		    	${requestScope.orange_error}
		    	<input type="submit" id="submit" name="submit" value="Add to Cart"/>
	    	</td>
		</tr>
		<tr>
			<td><img src="img/GP.jpg"/></td>
	    	<td>
		    	<h3>Product: ${sessionScope.SessionGrapeProduct.productName}</h3>
		    	<p>A case contains ${sessionScope.SessionGrapeProduct.quantity}</p>
		    	<p>Cost Per Case: <fmt:formatNumber value="${sessionScope.SessionGrapeProduct.price}" type="currency" /></p>
		    	<input type="text" name="gp_amount" id="gp_amount" value="${sessionScope.SessionOrder.grape_quantity}" 
		    		onkeypress="return isNumber(event)"  maxlength="4" />
		    	(Available ${sessionScope.SessionGrapeProduct.inventory - sessionScope.SessionOrder.grape_quantity})
		    	<p/>
		    	${requestScope.grape_error}
		    	<input type="submit" id="submit" name="submit" value="Add to Cart"/>
	    	</td>
		</tr>
	</table>
    </form>
	<c:choose>
	    <c:when test= "${sessionScope.SessionUser != null}">
	    	<form name="SaveForLater" action="SaveForLater" method="post">
	    		<input type="hidden" id="page" name="page" value="ReadProducts"/>
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
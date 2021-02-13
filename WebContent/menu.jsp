<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page import="model.Constraints" %>

<div id="menu-container">
    <div id="menu">
      <ul>
        <li><a href="index.jsp" class="top_parent">&nbsp; Homepage</a></li>
      </ul>
      <ul>
	        <c:choose>
			    <c:when test= "${sessionScope.SessionUser != null}">
			      <li><a href="Login?logout=true" class="top_parent">Logout (${sessionScope.SessionUser.username})</a></li>
			    </c:when>
			    <c:otherwise>
			    <li><a href="#" class="top_parent">&nbsp; Login/Register</a>
       			 <ul>
			      	<li><a href="login.jsp">&bull; Login</a></li>
	            	<li><a href="register.jsp">&bull; Register</a></li>
	             </ul>
        		</li>
			    </c:otherwise>
			</c:choose>
     
      </ul>
      <ul>
        <li><a href="ReadProducts" class="top_parent">&nbsp; Shop Limes</a></li>
      </ul>
      <ul>
        <li><a href="ViewCart" class="top_parent">&nbsp; View Cart</a></li>
      </ul>
      <ul>
        <li><a href="ViewPurchases" class="top_parent">&nbsp; View Purchases</a></li>
      </ul>
    </div>
  </div>
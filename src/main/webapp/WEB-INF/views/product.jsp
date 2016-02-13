<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2>${product.productCategory.name}</h2>

  <table border = "1" style="width: 100%;vertical-align: top;">
	  
	   <tr>
	   
	    
	    <td width = "100px">
	     <table border = "1" >
	     	<tr><th>${product.name}</th></tr>
			<tr><td><img src = "data:image/png;base64,${product.mainBytes}"  align = "middle"/></td></tr>
			<tr><td>size</td></tr>
			<tr><td>color</td></tr>
			<tr><td>${product.recommended}</td></tr>
			<tr><td>${product.about}</td></tr>
			<tr><td>${product.description}</td></tr>
			<tr><td>${product.features}</td></tr>
			
			<tr>
			 <td>
	  			<a href="<c:url value='user/addCart?productId=${product.productId}' />"><spring:message code="link.add.cart"/></a>
	  		 </td>
			</tr>
			
		 </table>
		</td>
		

		
		</tr>
	
  </table>
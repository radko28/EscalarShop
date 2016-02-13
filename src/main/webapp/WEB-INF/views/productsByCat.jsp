<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h3>${productCategory.name}</h3>

  <table border = "1" style="width: 100%;vertical-align: top;">
		
	    <c:forEach items="${products}" var="product" varStatus="status">
	    
	    
	    
	    <c:if test = "${status.index % 4 == 0}">
	    	<tr>
	    </c:if>
	    
	    <td width = "100px">
	     <table border = "1" >
	     	<tr><td>${status.index % 4}</td></tr>
			<tr><td><img src = "data:image/png;base64,${product.mainBytes}"  align = "middle"/></td></tr>
			<tr><td>
				<a href="<c:url value='/product?productId=${product.productId}' />">${product.name}</a>
			</td></tr>
			<tr><td>
				<a href="<c:url value='user/addCart?productId=${product.productId}' />"><spring:message code="link.add.cart"/></a>
			</td></tr>
			
		 </table>
		</td>
		

			<c:if test = "${status.index % 4 == 1 and status.last}">
				<td width = "100px"></td>
			</c:if>
		
			<c:if test = "${ (status.index % 4 == 1 or status.index % 4 == 2)  and status.last}">
				<td width = "100px"></td>
			</c:if>

		<c:if test = "${status.index % 4 == 3 or status.last}">
			</tr>
		</c:if>
		
   		</c:forEach>
   		
  </table>
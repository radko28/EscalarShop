<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<h3>
		<spring:message code="cart.legend"/>
	</h3>

  <table border = "1" style="width: 100%;vertical-align: top;">
	<tr style="background-color: gray;">
	  <th><spring:message code="table.order"/></th>
      <th><spring:message code="table.productname"/></th>
      <th><spring:message code="table.amount"/></th>
      <th><spring:message code="table.action"/></th>
    </tr>
	    <c:forEach items="${cartList}" var="cart" varStatus="status">
	   	<tr>
	     	<td>${status.index}</td>
			<td>${cart.authority}</td>
			<td>${cart.firstname}</td>
								
		  <td>
	  		<a href="<c:url value='/user/editCart?cartId=${cart.cartId}' />"><spring:message code="link.update"/></a> |
	  		<a href="<c:url value='/user/deleteCart?cartId=${cart.cartId}' />"><spring:message code="link.delete"/></a>
	  </td>
			
		</tr>
   		</c:forEach>
  </table>
   	
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<h3>
		<spring:message code="cart.legend"/>
	</h3>
 <form:form commandName="editCart" method="post">
  <table border = "1" style="width: 100%;vertical-align: top;">
	<tr style="background-color: gray;">
	  <th><spring:message code="table.order"/></th>
      <th><spring:message code="product.table.name"/></th>
      <th><spring:message code="cart.table.amount"/></th>
      <th><spring:message code="table.action"/></th>
    </tr>
	    <c:forEach items="${cartList}" var="cart" varStatus="status">
	   	<tr>
	     	<td>${status.index}</td>
			<td>${cart.productName}</td>
			<td><form:input path="amount"/></td>
								
		  <td>
		  	<input type="submit" name="editCart" value="<spring:message code="button.update" />"/>
	  		<a href="<c:url value='/user/deleteCart?cartId=${cart.cartId}' />"><spring:message code="link.delete"/></a>
	  </td>
			
		</tr>
   		</c:forEach>
  </table>
   	</form:form>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<h3>
		<spring:message code="users.legend"/>
	</h3>

  <table border = "1" style="width: 100%;vertical-align: top;">
	<tr style="background-color: gray;">
	  <th><spring:message code="users.table.username"/></th>
      <th><spring:message code="password"/></th>
      <th><spring:message code="users.table.authority"/></th>
      <th><spring:message code="users.table.firstname"/></th>
      <th><spring:message code="users.table.lastname"/></th>
       <th><spring:message code="users.table.cart"/></th>
 	  <th><spring:message code="users.table.enabled"/></th>
      <th><spring:message code="table.action"/></th>
    </tr>
	    <c:forEach items="${userList}" var="user" varStatus="status">
	   	<tr>
	   		<td>
	 			<a href="<c:url value='/admin/userDetail?userId=${user.userId}' />">${user.username}</a>
	     	</td>
	     	<td>${user.password}</td>
			<td>${user.authority}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td><a href="<c:url value='/admin/cart?userId=${user.userId}' />"><spring:message code="link.cart"/></a></td>
			<td>
				<input type="checkbox" ${user.enabled ==  true ? 'checked="checked"' : ""} />
			</td>							
		  <td>
	  		<a href="<c:url value='/admin/editUser?userId=${user.userId}' />"><spring:message code="link.edit"/></a> |
	  		<a href="<c:url value='/admin/deleteUser?userId=${user.userId}' />"><spring:message code="link.delete"/></a>
	  </td>
			
		</tr>
   		</c:forEach>
  </table>
    <p><a href="<c:url value="/admin/register"/>"><spring:message code="link.add" /></a></p>	
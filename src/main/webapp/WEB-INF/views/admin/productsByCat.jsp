<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h3>${productCategory.name}</h3>

  <table border = "1" style="width: 100%;vertical-align: top;">
	<tr style="background-color: gray;">
	  <th><spring:message code="product.table.name"/></th>
      <th><spring:message code="product.table.photo"/></th>
      <th><spring:message code="table.enabled"/></th>
      <th><spring:message code="table.action"/></th>
    </tr>
	    <c:forEach items="${products}" var="product" >
	   	<tr>
	   		<td>
	   			${product.name}
	     	</td>
	     	<td><img src = "data:image/png;base64,${product.mainBytes}"  align = "middle"/></td>
			<td>
				<input type="checkbox" ${product.enabled ==  true ? 'checked="checked"' : ""} />
			</td>							
		  <td>
	  		<a href="<c:url value='/admin/addEditProduct?productId=${product.productId}' />"><spring:message code="link.edit"/></a> |
	  		<a href="<c:url value='/admin/deleteProduct?productId=${product.productId}' />"><spring:message code="link.delete"/></a>
	  </td>
			
		</tr>
   		</c:forEach>
  </table>
    <p><a href="<c:url value='/admin/addEditProduct?productCatId=${productCategory.productCatId}&locale=en' />"><spring:message code="link.add" /></a></p>	


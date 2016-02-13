<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<h3>
		<spring:message code="category.legend"/>
	</h3>

  <table border = "1" style="width: 100%;vertical-align: top;">
	<tr style="background-color: gray;">
	  <th><spring:message code="category.table.name"/></th>
      <th><spring:message code="category.table.categoryType"/></th>
      <th><spring:message code="table.enabled"/></th>
      <th><spring:message code="table.action"/></th>
    </tr>
	    <c:forEach items="${categoryList}" var="productCategory" >
	   	<tr>
	   		<td>
   				<a href="<c:url value='/productsByCat?productCatId=${productCategory.productCatId}' />">${productCategory.name}</a>	   		
	     	</td>
	     	<td>${productCategory.categoryType}</td>
			<td>
				<input type="checkbox" ${productCategory.enabled ==  true ? 'checked="checked"' : ""} />
			</td>							
		  <td>
	  		<a href="<c:url value='/admin/addEditCategory?productCatId=${productCategory.productCatId}' />"><spring:message code="link.edit"/></a> |
	  		<a href="<c:url value='/admin/deleteCategory?productCatId=${productCategory.productCatId}' />"><spring:message code="link.delete"/></a>
	  </td>
			
		</tr>
   		</c:forEach>
  </table>
    <p><a href="<c:url value="/admin/addCategory"/>"><spring:message code="link.add" /></a></p>	

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>${legend}</h3>
 <form:form commandName="category" method="post">
   <table border = "1" style="width: 100%;vertical-align: top;">
	   <tr>
	    <td width = "100px">
	     <table border = "1" >
	     	<tr>
	     		<th><form:label	path="name"><spring:message code="category.table.name"/> *</form:label></th>
	     		<td><form:input path="name" /></td>
	     		<td><form:errors path="name" cssClass = "errortext" /></td>
	     	</tr>
	     	<tr>
	     		<th><spring:message code="category.table.categoryType"/> *</th>
				<td colspan="2">
					<form:select path="categoryType">
					  <form:options items="${categoryTypeList}" />
				    </form:select>
                 </td>
	     	</tr>
	     	<tr>
	     		<th>
	     			<form:label	for="enabled" path="enabled"><spring:message code="table.enabled"/></form:label>
	     		</th>
	     		<td colspan="2">
	     			<form:checkbox path="enabled" value = "checked" checked="${enabled}" />
	     		</td>
	     	</tr>
	     	<tr>
			 <td>
			 	<input type="submit" name="categoryAddEdit" value="<spring:message code="button.save" />"/>
	  			<a href="<c:url value='/admin/categoryList' />"><spring:message code="link.back"/></a>
	  		 </td>
			</tr>
		 </table>
		</td>
		</tr>
  </table>
  </form:form>
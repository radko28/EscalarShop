<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>${legend}</h3>
 <form:form commandName="product" method="post" enctype="multipart/form-data" >
 <form:hidden path="productId" />
 <input type="hidden" name="action" value="${createEdit}" />

  <table border = "1" style="width: 100%;vertical-align: top;">
	   <tr>
	    <td width = "200px">
	     <table border = "1" >
	     <tr><th><form:label for="name" path="name"><spring:message code="product.table.name"/> *</form:label></th><td><form:input path="name" size = "100"/></td></tr>
	      
	     <tr><th><form:label for="photo" path="photo"><spring:message code="product.table.photo"/> *</form:label></th>
	     	<td>
	     		<img src = "data:image/png;base64,${product.mainBytes}"  align = "middle"/>
	     		<form:input type="file" path="photo" size = "100"/>
	     	</td>
	     </tr>	
	     <tr><th><form:label for="detailPhoto" path="detailPhoto"><spring:message code="product.table.detailPhoto"/> *</form:label></th>
	     	<td>
				<img src = "data:image/png;base64,${product.detailBytes}"  align = "middle"/>	     	
	     		<form:input type="file" path="detailPhoto" size = "100"/>
	     	</td>
	     </tr>     
	     
	     	<tr>
				<th><spring:message code="product.table.recommended"/> *</th>
				<td>
					<form:select path="recommended">
					  <form:options items="${recommendedTypeList}" />
				    </form:select>
                 </td>
			</tr>
	     	<tr>
				<th><spring:message code="product.table.color"/> *</th>
				<td>
				<table>
		     	<tr>
					 <c:forEach items="${colorTypeList}" var="color" >
					 	<td><c:out value ="${color.name}" /></td>
					 	<td>
					 	<c:if test = "${color.checked  != 'checked'}">
					 		<form:checkbox path="formColors" value ="${color.id}"  />
					 	</c:if>
					 	<c:if test = "${color.checked  == 'checked'}">
					 		<form:checkbox path="formColors" value ="${color.id}"  checked="${color.checked}" />
					 	</c:if>
					 	</td>
					 	<td style="background: ${color.code}; color: ${color.code}">foo</td>
					</c:forEach>
					</tr>
				</table>
                 </td>
			</tr>
	     <tr><th><form:label for="about" path="about"><spring:message code="product.table.about"/> *</form:label></th>
	     	<td>
	     		<form:textarea cols = "60" rows = "3" path="about"/>
	     	</td>
	     </tr>			
		<tr><th><form:label for="description" path="description"><spring:message code="product.table.description"/> *</form:label></th>
			<td>
				<form:textarea cols = "60" rows = "3" path="description"/>
			</td>
		</tr>
 	     <tr><th><form:label for="features" path="features"><spring:message code="product.table.features"/> *</form:label></th>
 	     	<td>
 	     		<form:textarea cols = "60" rows = "3" path="features"/>
 	     	</td>
 	     </tr>
	     	<tr>
				<th><spring:message code="product.table.size"/> *</th>
				<td>
				<table>
				<tr>
					 <c:forEach items="${sizeTypeList}" var="size" >
					 	<td><c:out value ="${size.value}" /></td>
					 	<td>
					 	<c:if test = "${size.checked  != 'checked'}">
					 		<form:checkbox path="formSizes" value ="${size.id}"  />
					 	</c:if>
					 	<c:if test = "${size.checked  == 'checked'}">
					 		<form:checkbox path="formSizes" value ="${size.id}"  checked="${size.checked}" />
					 	</c:if>
					 	</td>
					</c:forEach>
					</tr>
				</table>
                 </td>
			</tr>
  		<tr><th><form:label	for="weight" path="weight"><spring:message code="product.table.weight"/> *</form:label></th><td><form:input path="weight"/></td></tr>
	     <tr><th><form:label for="enabled" path="enabled"><spring:message code="table.enabled"/> *</form:label></th>
	     	<td><form:checkbox path="enabled"/></td>
	     </tr>
	     	<tr>
				<th><spring:message code="product.table.productcategory"/> *</th>
				<td>
					<form:select path="categoryType">
					 <c:forEach items="${categoryTypeList}" var="category" varStatus="status">
						<c:choose>
            				<c:when test="${category.categoryType eq categoryInit.categoryType}">
                				<option value="${category.categoryType}" selected="true">${category.name}</option>
            				</c:when>
            				<c:otherwise>
                				<option value="${category.categoryType}" >${category.name}</option>
            				</c:otherwise>
        				</c:choose> 					 
    				</c:forEach >
				    </form:select>
                 </td>
			</tr>
 	     <tr><th><form:label for="price" path="price"><spring:message code="product.table.price"/> *</form:label></th><td><form:input path="price"/></td></tr>   	     
			<tr>
			 <td>
			 	<input type="submit" name="productAddEdit" value="<spring:message code="button.save" />"/>
	  			<a href="<c:url value='/admin/productList?productCatId=${productCatId}' />"><spring:message code="link.back"/></a>
	  		 </td>
			</tr>
		 </table>
		</td>
	</tr>
  </table>
  </form:form>
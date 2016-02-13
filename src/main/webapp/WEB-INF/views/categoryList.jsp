<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
  <table class="example"  >
	   <tr class = "tableHeader" >
			<th>Category List</th>
	   	</tr>
	    <c:forEach items="${categoryList}" var="productCategory" >
		<tr>
   			<td><a href="<c:url value='/productsByCat?productCatId=${productCategory.productCatId}' />">${productCategory.name}</a></td> 
		</tr>
   		</c:forEach>
   		
  </table>


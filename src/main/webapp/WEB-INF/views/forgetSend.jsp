<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div align = "center">
			<table>
			<tr>
				<td colspan='2' style="text-align: right;">
				<spring:message code="forget.success"/>
				</td>
			</tr>	
			<tr>
				<td colspan='2' style="text-align: right;">
				<a href="<c:url value='/login' />"><spring:message code="link.forget"/></a>
				</td>
			</tr>
		</table>

	</div>
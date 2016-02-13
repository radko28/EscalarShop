<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div align = "center">
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' method='POST'>

		<table>
			<tr>
				<td><spring:message code="login.loginname"/>:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td colspan='2' style="text-align: right;"><input name="submit" type="submit"
					value="<spring:message code="button.send"/>" />
				</td>
			</tr>
		</table>

	</form>
	</div>
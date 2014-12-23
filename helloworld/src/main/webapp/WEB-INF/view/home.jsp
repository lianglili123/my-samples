<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<h1>Hello world!</h1>
	<form:form modelAttribute="writer" action="sendEmail"
		commandName="writer" method="post">
		<c:out value="${writer.id }" />
		<br>
		<c:out value="${writer.name }" />
		<br>
		<c:out value="${writer.email }" />
		<br>
		<%-- 		<form:hidden path="writer"/> --%>
		<form:button>send a mail to this writer.</form:button>
		<c:choose>
			<c:when test="${empty isSent }"></c:when>
			<c:when test="${isSent}">A mail has been sent to <c:out
					value="${writer.name }"></c:out>.</c:when>
			<c:otherwise>No available mail address for <c:out
					value="${writer.name }"></c:out>.</c:otherwise>
		</c:choose>
	</form:form>
</body>
</html>
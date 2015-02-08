

<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>

<table class="table table-bordered table-hover table-striped">
	<tr>
		<th>User Name</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>
			<a href="<sp:url value="/users/${user.id}.html"/>">
			${user.name}
			</a>
			</td>
		</tr>
	</c:forEach>
</table>



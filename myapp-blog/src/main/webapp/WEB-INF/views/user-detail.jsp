<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>

<h1>${user.name}</h1>

<c:forEach items="${user.blogs}" var="blog">
	<p>${blog.name}</p><br>
	<a href="${blog.url}" >${blog.url}</a><br>
	<table class="table table-bordered table-hover table-striped">
		<tr>
			<th>Name</th>
			<th>URL</th>
		</tr>
		<c:forEach items="${blog.items}" var="item">
			<tr>
				<td>${item.title}</td>
				<td><a href="${item.link}" >${item.link}</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
		
	
</c:forEach>
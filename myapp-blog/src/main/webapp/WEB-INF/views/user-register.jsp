
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>
<br>
<spform:form class="form-horizontal" commandName="user">
	<div class="form-group">
		<label for="namelabel" class="col-sm-2 control-label">User
			Name:</label>
		<div class="col-sm-10">
			<spform:input class="form-control" path="name"></spform:input>
		</div>
	</div>
	<div class="form-group">
		<label for="emaillabel" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<spform:input class="form-control" path="email"></spform:input>
		</div>
	</div>
	<div class="form-group">
		<label for="emaillabel" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<spform:password class="form-control" path="email"></spform:password>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<input type="submit" value="Save" class="btn btn-default" /> 
		</div>
	</div>
</spform:form>


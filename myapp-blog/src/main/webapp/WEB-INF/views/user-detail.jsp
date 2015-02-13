<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>
<<script type="text/javascript">
	$(document).ready(function(){
		$('.nav-tabs a:first').tab('show')
	});
</script>

<h1>${user.name}</h1>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Add new blog</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body">
				<!-- Put all body content here -->
				<spform:form class="form-horizontal" commandName="blog">

					<div class="form-group">
						<label for="namelabel" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<spform:input class="form-control" path="name"></spform:input>
						</div>
					</div>
					<div class="form-group">
						<label for="namelabel" class="col-sm-2 control-label">Url:</label>
						<div class="col-sm-10">
							<spform:input class="form-control" path="url"></spform:input>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</spform:form>
				<!-- End body content -->
			</div>

		</div>
	</div>
</div>

<br><br>
<div role="tabpanel">

 <!-- Blog contents -->
	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			 <li role="presentation"><a href="#blog_${blog.id}" aria-controls="settings" role="tab" data-toggle="tab">${blog.name}</a></li>
			<!-- href is  #+Id of item in tab-content respectively -->
	</c:forEach>
	</ul>
	<!-- End Nav tabs -->
	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div class="tab-pane active" id="blog_${blog.id}">

				<p>${blog.name}</p>
				<a href="<sp:url value="/blog/remove/${blog.id}.html"/>"  class="btn btn-danger">Remove Blog</a>
				<br> <a href="${blog.url}">${blog.url}</a> <br>
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th>Name</th>
						<th>URL</th>
					</tr>
					<c:forEach items="${blog.items}" var="item">
						<tr>
							<td>${item.title}</td>
							<td><a href="${item.link}">${item.link}</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</div>
	<!-- End Tab panes -->
</div>
 <!-- End Blog contents -->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="spsecure"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<body>
<!-- This look for ""current" attribute in general.xml -->
	<tilesx:useAttribute name="current"/>
	  <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Java Blog</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="${current == 'index' ? 'active' : '' }"><a href="<sp:url value='/'/>">Home</a></li>
            <spsecure:authorize  access="hasRole('ROLE_ADMIN')">
            <li class="${current == 'users' ? 'active' : '' }"><a href="<sp:url value='/users.html'/>">Users</a></li>
            </spsecure:authorize>
            <li class="${current == 'register' ? 'active' : '' }"><a href="<sp:url value='/register.html'/>">Register</a></li>
            <spsecure:authorize access="! isAuthenticated()">
            <li class="${current == 'login' ? 'active' : '' }"><a href="<sp:url value='/login.html'/>">Log In</a></li>
            </spsecure:authorize>
            <spsecure:authorize access="isAuthenticated()">
           		 <li class="${current == 'user-account' ? 'active' : '' }"><a href="<sp:url value='/account.html'/>">My Account</a></li>
            </spsecure:authorize>
             <spsecure:authorize access="isAuthenticated()">
            <li><a href="<sp:url value='/logout'/>">Log Out</a></li>
            </spsecure:authorize>
            <li><a href="#contact">Contact</a></li>
           </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
       	<tiles:insertAttribute name="body" />
	<br>
	<center>
		<tiles:insertAttribute name="footer" />
	</center>
      </div>

    </div> <!-- /container -->
	
	
	
</body>
</html>
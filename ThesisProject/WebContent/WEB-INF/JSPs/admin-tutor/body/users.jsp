<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ALS | Users</title>
</head>
<body>
<jsp:include page="../header/admin_navigation_bar.jsp"></jsp:include>

<div class="span3">
	<p style="color: red">Page Under Construction</p>
</div>

<div class="container">
<!-- content -->

<div class="nav">
	<div id="tab" class="btn-group" data-toggle="buttons-radio">
  		<a href="#students" class="btn btn-large btn-primary active" data-toggle="tab">Students</a>
  		<a href="#tutors" class="btn btn-large btn-primary" data-toggle="tab">Tutors</a>
  		<a href="#admins" class="btn btn-large btn-primary" data-toggle="tab">Admin</a>
	</div>
</div>

<!-- Student Page -->
<div class="menu" id="students">
	<div class="accordion">
	
	<c:forEach var="users" items="${ userList }">
		<div class="accordion-group">	
		
			<!-- Student name -->
			<div class="accordion-heading country">
				<a class="accordion-toggle" data-toggle="collapse" href="#${ users.userName }">
					${ users.userName } 
					<!-- label for the user if exist or not -->
					<c:choose>
						<c:when test="${users.exist}">
							<span class="label label-success pull-right">Active</span>
						</c:when>
						<c:otherwise>
							<span class="label label-important pull-right">Deleted</span>
						</c:otherwise>
					</c:choose>
				</a>
			</div>
			
			<!-- Accordion body -->
			<div id="${users.userName}" class="accordion-body collapse">
				<div class="accordion-inner">
				
					<!-- Temporary variables for knowledge level until the implementation -->
					<c:set var="knowledge_level" value="33"/>
					<!-- Temporary loop until implementation is executed, should use forEach instead of forTokens -->
					<c:forTokens items="Math, English, Sibika" delims="," var="subject" >
					
					<strong><c:out value="${subject}" /></strong>
					
					<!-- Change color of the progressbar depending on the performance -->
					<c:choose>
						<c:when test="${ knowledge_level < 34 }">
							<div class="progress progress-danger active">
      							<div class="bar" style="width: 33%;"></div>
 							</div>
						</c:when>
						<c:when test="${ knowledge_level < 67 }">
							<div class="progress progress-warning active">
      							<div class="bar" style="width: 66%;"></div>
 							</div>
						</c:when>
						<c:otherwise>
							<div class="progress progress-success active">
      							<div class="bar" style="width:  83%;"></div>
  							</div>
						</c:otherwise>
					</c:choose>
					
					</c:forTokens>
					<!-- end of loop -->
				</div>
			</div>
			<!-- /Accordion body -->
			
			</div>
		</c:forEach>
		<!-- EOL for user list -->
		
	</div>
</div>
<!-- /Student Page -->

<!-- Tutors Page -->
<div id="tutors"></div>
<!-- /Tutors Page -->

<!-- Admins Page -->
<div id="admins"></div>
<!-- /Admins Page -->

<!-- /content -->
</div>

<!-- Imports -->
<jsp:include page="../../utilities/imports.jsp"></jsp:include>
</body>
</html>
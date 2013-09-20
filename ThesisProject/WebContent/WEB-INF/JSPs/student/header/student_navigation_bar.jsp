<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="nav navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
		<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
		</a>
		
		<a class="brand" href="#" name="top">ALS</a>
		<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
					<li><a href="#">Student tab</a></li>
					<li><a href="#">Under Construction</a></li>
				</ul>	
		</div>
		
		<div class="pull-right">
        	<ul class="nav pull-right">
        		<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome, ${sessionScope.username } | ${sessionScope.usertype }<b class="caret"></b></a>
        			<ul class="dropdown-menu">
        				<li><a href="#"><i class="icon-cog"></i> Preferences</a></li>
        				<li><a href="#"><i class="icon-envelope"></i> Contact Support</a></li>
        				<li class="divider"></li>
        				<li><a href="logout"><i class="icon-off"></i> Logout</a></li>
        			</ul>
        		</li>
        	</ul>
        </div>
		</div>
	</div>
</div>
<div class="nav-padding-custom" style="height:60px;">
</div>
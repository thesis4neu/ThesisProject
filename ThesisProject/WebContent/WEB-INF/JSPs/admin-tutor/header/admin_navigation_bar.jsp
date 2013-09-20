<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="nav navbar navbar-fixed-top">
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
					<li class="link" id="home" >
						<a href="admin?main=home"><i class="icon-home"></i> Home</a>
					</li>
					<li class="link" id="flt" >
						<a href="admin?main=flt"><i class="icon-pencil"></i> FLT</a>
					</li>
					<li class="link" id="modules">
						<a href="admin?main=modules"><i class="icon-file"></i> Modules</a>
					</li>
					<li class="link" id="manage_users" >
						<a href="admin?main=users"><i class="icon-user"></i> Manage Users</a>
					</li>
				</ul>	
		</div>
		
		<div class="pull-right">
        	<ul class="nav pull-right">
        		<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome, ${sessionScope.username } | ${sessionScope.usertype }<b class="caret"></b></a>
        			<ul class="dropdown-menu">
        				<li><a href="#"><i class="icon-cog"></i> Profile</a></li>
        				<li><a href="#"><i class="icon-envelope"></i> Contact Developer</a></li>
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


<!-- BZ 2 --> 
<script src="js/jquery-1.10.2.js"></script>
<script >

/* $(document).ready(function() {
    var pageTitle = window.location.pathname.replace( /^.*\/([^/]*)/ , "$1");

    $('.link a').each(function () {

        if ($(this).attr('href').toLowerCase() == pageTitle.toLocaleLowerCase())
            $(this).closest('li').addClass('active');
    });

}); */

/* var $lis = $('li').click(function(e) {
    $lis.filter(".active").removeClass("active");
    $(this).addClass('active');
}); */
</script>
	
	
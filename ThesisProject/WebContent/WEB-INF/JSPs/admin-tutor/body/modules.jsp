<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/sidebar-tree.css" rel="stylesheet" media="screen">
<title>ALS | Modules</title>
</head>
<body>
<jsp:include page="../header/admin_navigation_bar.jsp"></jsp:include>

<div class="container-fluid">
  <div class="row-fluid">
  <!--Sidebar container-->
    <div class="span2">
		
		<!-- Sidebar content -->
		<div class="menu">
			<div class="accordion">
			
				<!-- accordion header -->
				<div class="accordion-group">
					<div class="accordion-heading area">
						
						<!-- Concept | Header -->
						<a class="accordion-toggle" data-toggle="collapse" href="#area1">
							Concept
						</a> 
							
					</div>
					
					<!-- Topic | Header -->
					<div id="area1" class="accordion-body collapse">
						<div class="accordion-inner">
							<div class="accordion" id="equipamento1">
								<!-- accordion inner group -->
								<div class="accordion-group">								
									<div class="accordion-heading equipamento">
										<a class="accordion-toggle" data-toggle="collapse" data-parent="#equipamento1-1" href="#servico1-1-1">
											Topic
										</a>
									</div>
										<!-- Sub-topic -->
										<div id="servico1-1-1" class="accordion-body collapse">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li><a href="#"><i class="icon-chevron-right"></i>
														Sub-Topic 1
													</a></li>
													<li><a href="#"><i class="icon-chevron-right"></i>
														Sub-Topic 1
													</a></li>					
													<li><a href="#"><i class="icon-chevron-right"></i>
														Sub-Topic 1
													</a></li>
												</ul>
											</div>
										</div>
										<!-- /Sub-topic -->											
								</div>
								<!-- /accordion inner group -->
							</div>
						</div>
					</div>
					<!-- /Topic | Header -->
				</div>
					<!-- /accordion header -->
			</div>	
		</div>

	</div>
	
     <!--Body content-->
    <div class="span10">
     
      <p style="color: red">Page Under Construction</p>
      
    </div>
  </div>
</div>


<!-- Imports -->
<jsp:include page="../../utilities/imports.jsp"></jsp:include>
</body>
</html>
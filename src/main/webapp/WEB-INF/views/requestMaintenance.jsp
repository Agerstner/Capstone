
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${empty loggedInUser}">
	<%-- <jsp:forward page="login.jsp"/> --%>
	<%
		response.sendRedirect("login");
	%>
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Request Maintenance</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="" />

<!-- css -->
<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700"
	rel="stylesheet">
<link href="static/css/bootstrap.css" rel="stylesheet" />
<link href="static/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="static/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="static/css/jcarousel.css" rel="stylesheet" />
<link href="static/css/flexslider.css" rel="stylesheet" />
<link href="static/css/style.css" rel="stylesheet" />
<!-- Theme skin -->
<link href="static/skins/default.css" rel="stylesheet" />
<!-- boxed bg -->
<link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="ico/apple-touch-icon-144-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="ico/apple-touch-icon-114-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="ico/apple-touch-icon-72-precomposed.png" />
<link rel="apple-touch-icon-precomposed"
	href="ico/apple-touch-icon-57-precomposed.png" />
<link rel="shortcut icon" href="ico/favicon.png" />


</head>

<body>
	<div id="wrapper">
		<!-- toggle top area -->
		<div class="hidden-top">
			<div class="hidden-top-inner container">
				<div class="row">
					<div class="span12">
						<ul>
							<li><strong>We are available for any custom works
									this month</strong></li>
							<li>Main office: Springville center X264, Park Ave S.01</li>
							<li>Call us <i class="icon-phone"></i> (123) 456-7890 -
								(123) 555-7891
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end toggle top area -->
		<!-- start header -->
		<jsp:include page="header.jsp" />
		<!-- end header -->
		<section id="inner-headline">
			<div class="container">
				<div class="row">
					<div class="span4">
						<div class="inner-heading">
							<h2>Fix Me Up</h2>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section id="content">
			<div class="container">
				<div class="row">
					<div class="span6">
						<h3 class="text-center">${msg}</h3>

						<!-- #################	START OF MAINTENANCE FORM  #################     -->

						<form:form action="${action}" modelAttribute="reports"
							method="post" class="form-horizontal">

							<div class="control-group">
								<label class="control-label" for="type">Type*</label>
								<div class="controls">
									<select onchange="submitForm" onchange="this.form.submit()"
										name="type" class="form-control">
										<option value="Electrical">Electrical</option>
										<option value="Plumbing">Plumbing</option>
										<option value="Appliance">Appliance Issue</option>
										<option value="Physical Damage">Physical Damage</option>
										<option value="Pests">Pests</option>
									</select>
								</div>
							</div>
							
							
							<c:choose >							
							
								<c:when test="${param.type == 'Electrical'}">
									<input type="hidden" name="priority" value="High">
								</c:when>
								
								<c:when test="${param.type == 'Plumbing'}">
									<input type="hidden" name="priority" value="High">
								</c:when>
							
								<c:when test="${param.type == 'Physical Damage'}">
									<input type="hidden" name="priority" value="Low">
								</c:when>
								
							</c:choose>
							
							<!-- 	<input type="hidden" id="priority" name="priority" value=> -->

<!--   							<div class="form-group"> -->
<!--     								<label for="exampleFormControlTextarea1">Example textarea</label> -->
<!--    									 <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea> -->
<!--  							 </div> -->

							<input type="hidden" id="user" name="user"
								value="${loggedInUser.firstname} ${loggedInUser.lastname}">

							<input type="hidden" id="location" name="location"
								value="${loggedInUser.address}">

							

							<div class="control-group ${hidden}">
								<label class="control-label" for="details">Details*</label>
								<div class="controls">
									<form:input path="details"	placeholder="Please Describe the issue in more detail" />
								</div>	
							</div>
							
							
							
															
<%-- 							<div class="control-gorup ${hidden}"> --%>
<!-- 								<label class="control-label" for="image">Picture</label> -->
<!-- 								<div class="controls"> -->
<!-- 									<input type="file"  name="image"  /> -->
<!-- 								</div> -->
<!-- 							</div> -->
							
							
							
							
							
							
							
							
				        <!-- divider -->
							<div class="row">
								<div class="span4">
								<div class="hidden"></div>
								</div>
							</div>
						<!-- end divider -->
							
							
							
							<div class="control-group">
								<div class="controls">
									<button type="submit" id="submit" class="btn btn-danger">Submit</button>
									<a href="profile" class="btn btn-success">Cancel</a>
								</div>
							</div>

						</form:form>

						<!-- #################	END OF MAINTENANCE FORM  #################     -->

					</div>
					<div class="span6">

						<!-- start flexslider -->
						<div class="flexslider">
							<ul class="slides">
								<li><img src="static/img/works/full/image-01-full.jpg"
									alt="" /></li>
								<li><img src="static/img/works/full/image-02-full.jpg"
									alt="" /></li>
								<li><img src="static/img/works/full/image-03-full.jpg"
									alt="" /></li>
							</ul>
						</div>
						<!-- end flexslider -->
						
						
					</div>
				</div>

				<!-- divider -->
				<div class="row">
					<div class="span12">
						<div class="solidline"></div>
					</div>
				</div>

				<!-- end divider -->

			</div>
			
		</section>



		<jsp:include page="footer.jsp" />
		
	</div>
	<a href="#" class="scrollup"><i
		class="icon-chevron-up icon-square icon-32 active"></i></a>
	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="static/js/jquery.js"></script>
	<script src="static/js/jquery.easing.1.3.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/jcarousel/jquery.jcarousel.min.js"></script>
	<script src="static/js/jquery.fancybox.pack.js"></script>
	<script src="static/js/jquery.fancybox-media.js"></script>
	<script src="static/js/google-code-prettify/prettify.js"></script>
	<script src="static/js/portfolio/jquery.quicksand.js"></script>
	<script src="static/js/portfolio/setting.js"></script>
	<script src="static/js/jquery.flexslider.js"></script>
	<script src="static/js/jquery.nivo.slider.js"></script>
	<script src="static/js/modernizr.custom.js"></script>
	<script src="static/js/jquery.ba-cond.min.js"></script>
	<script src="static/js/jquery.slitslider.js"></script>
	<script src="static/js/animate.js"></script>

	<!-- Template Custom JavaScript File -->
	<script src="static/js/custom.js"></script>

</body>

</html>


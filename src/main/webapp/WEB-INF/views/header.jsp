
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<header>
	<div class="container">
		<!-- hidden top area toggle link -->
		<div id="header-hidden-link">
			<a href="#" class="toggle-link"
				title="Click me you'll get a surprise" data-target=".hidden-top"><i></i>Open</a>
		</div>
		<!-- end toggle link -->
		<div class="row nomargin">
			<div class="span12">
				<div class="headnav">
					<ul>
						<c:choose>
							<c:when test="${empty loggedInUser}">
								<li><a href="register"><i class="icon-user"></i>Sign
										Up</a></li>

								<!-- <li><a href="#mySignup" data-toggle="modal"><i class="icon-user"></i>Sign Up</a></li>
               -->
								<li><a href="#mySignin" data-toggle="modal">Sign in</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="logout">Logout</a></li>
								<li><a href="profile">My Profile</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<!-- Signup Modal -->
				<div id="mySignup" class="modal styled hide fade" tabindex="-1"
					role="dialog" aria-labelledby="mySignupModalLabel"
					aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 id="mySignupModalLabel">
							Create an <strong>account</strong>
						</h4>
					</div>
					<div class="modal-body">
						
					</div>
				</div>
				<!-- end signup modal -->
				<!-- Sign in Modal -->
				<div id="mySignin" class="modal styled hide fade" tabindex="-1"
					role="dialog" aria-labelledby="mySigninModalLabel"
					aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 id="mySigninModalLabel">
							Login to your <strong>account</strong>
						</h4>
					</div>
					<div class="modal-body">
						<form action="login" method="post" class="form-horizontal">
							<div class="control-group">
								<label class="control-label" for="email">Username</label>
								<div class="controls">
									<input type="text" id="email" name="email"
										placeholder="Username">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Password</label>
								<div class="controls">
									<input type="password" id="password" name="password"
										placeholder="Password">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn">Sign in</button>
								</div>
								<p class="aligncenter margintop20">
									Forgot password? <a href="#myReset" data-dismiss="modal"
										aria-hidden="true" data-toggle="modal">Reset</a>
								</p>
							</div>
						</form>
					</div>
				</div>
				<!-- end signin modal -->
				<!-- Reset Modal -->
				<div id="myReset" class="modal styled hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myResetModalLabel"
					aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 id="myResetModalLabel">
							Reset your <strong>password</strong>
						</h4>
					</div>
					<div class="modal-body">
						<form action="resetcode" class="form-horizontal" method="post">
							<div class="control-group">
								<label class="control-label" for="inputResetEmail">Email</label>
								<div class="controls">
									<input type="text" name="inputResetEmail" placeholder="Email">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn">Reset password</button>
								</div>
								<p class="aligncenter margintop20">We will send instructions
									on how to reset your password to your inbox</p>
							</div>
						</form>
					</div>
				</div>
				<!-- end reset modal -->
			</div>
		</div>
		<div class="row">
			<div class="span4">
				<div class="logo">
					<a href="index"> </a>
					<h1>Capstone</h1>
				</div>
			</div>
			<div class="span8">
				<div class="navbar navbar-static-top">
					<div class="navigation">
						<nav>
							<ul class="nav topnav">
								<li class="dropdown"><a href="index">Home <i
										class="icon-angle-down"></i></a>
									<ul class="dropdown-menu">
										<li><a href="about">About</a></li>
										<li><a href="service">Contact</a></li>
								    </ul>
								</li>
								<li><a href="about">About </a></li>
								<li><a href="service">Contact </a></li>
								<c:if test="${not empty loggedInUser}">
									<li><a href="users">Users</a></li>
									<li><a href="maintenanceRequests">Maintenance Requests</a></li>
									<li><a href="requestMaintenance">Request Maintenance</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
					<!-- end navigation -->
				</div>
			</div>
		</div>
	</div>
</header>
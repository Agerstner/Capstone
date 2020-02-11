<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="_profile" value="active"/>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Report Details</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
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
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
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
              <li><strong>We are available for any custom works this month</strong></li>
              <li>Main office: Springville center X264, Park Ave S.01</li>
              <li>Call us <i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- end toggle top area -->
    
    <!-- start header -->
    <jsp:include page="header.jsp"/>
 
    <!-- end header -->
    
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>Profile</h2>
            </div>
          </div>
<!--           <div class="span8"> -->
<!--             <ul class="breadcrumb"> -->
<!--               <li class="nav-item text-left"> -->
<%-- 			    <form class="form-search" action="search" method="post"> --%>
<!--                   <input name="name" placeholder="Type something" type="text" class="input-medium search-query"> -->
<!--                   <button type="submit" class="btn btn-square btn-theme">Search</button> -->
<%--                 </form> --%>
<!-- 			  </li> -->
<!--               <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li> -->
<!--               <li><a href="index">Home</a><i class="icon-angle-right"></i></li> -->
<!--               <li class="active">Profile</li> -->
<!--             </ul> -->
<!--           </div> -->
        </div>
      </div>
    </section>
    
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="span12">
            
                <p class="text-info"><small>${msg} ${sucess}</small></p>
            
                <ul class="nav nav-tabs bold">
                
                  <li class="active">
                  <a href="#one" data-toggle="tab">
                  <i class="icon-info-sign"></i> 
                  Pictures
                  </a></li>     
                               
                  <li class=""><a href="#three" data-toggle="tab">
                  Contact Info 
                  </a></li>
                  
                  <li class=""><a href="#two" data-toggle="tab">
                  <i class="font-icon-email"></i> Contact Me 
                  </a></li>    
                          
                </ul>
                
                
                <div class="tab-content">
                  <div class="tab-pane active" id="one"> 
                  <ul id="thumbs" class="portfolio">
                 
                 
                  <!-- Item Project and Filter Name -->                
                  <c:forEach var="item" items="${filenames}" >
                  <li class="item-thumbs span3 design" data-id="id-0" data-type="web">
                    
                    
                    <!-- Fancybox - Gallery Enabled - Title - Full Image -->
                    <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="${profiles.firstname} ${profiles.lastname}" href="static/img/users/${profiles.id}/${item}">
						<span class="overlay-img"></span>
						<span class="overlay-img-thumb font-icon-plus"></span>
					</a>
                   
                   
                    <!-- Thumb Image and Description -->
                    <img src="static/img/users/${profiles.id}/${item}" alt="Tel. ${profiles.phone}"
                    style="height:130px; width: auto;">
                  </li>
                  </c:forEach>
                 
                  </ul>                                
                  </div>
                  
                  
                  <div class="tab-pane" id="two">
                     <form action="dropaline" method="post" role="form" class="contactForm">
                     <div class="row">
		               <input type="hidden" name="from" value="${loggedInUser.email}" />
		               <input type="hidden" name="to" value="${profiles.email}">
                     <input type="hidden" name="fromname" value="${loggedInUser.firstname}">
		             <div class="span8 margintop10 form-group">
		               <textarea class="form-control" name="message" rows="7" data-rule="required" data-msg="Please write something for me" placeholder="Message"></textarea>
		                <p class="text-left">
		                   <button class="btn btn-large btn-theme margintop10" type="submit">Send message</button>
		                </p>
		              </div>
		         	 </div>
		            </form>
                  </div>
                  
                  
                  <div class="tab-pane" id="three">
                  <div class="span6">
		            <c:if test="${not empty profiles.image}">
					<img src="static/img/users/${profiles.id}/profile/${profiles.image}" 
						style="border-radius: 50%; height:100px; width: auto;">
					</c:if>
					<p>
					${profiles.firstname} ${profiles.lastname}<br>
                     ${profiles.phone} <br>${profiles.email}
                     
		            </p>
		          </div>          
                  </div>   
          </div>
        </div>
       </div>
       
       
      </div>
    </section>
     <jsp:include page="footer.jsp"/>
  </div>
  
       
 
  <a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
  
  
  
  
  <!-- ======================JavaScript======================== -->
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

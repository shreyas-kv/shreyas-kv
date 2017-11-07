<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<!-- spring url for static resources -->
<spring:url value="/resources/images" var="img" />
<spring:url value="/resources/PImages" var="img1" />

<head>
<title>SHREYAS MOBILES</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
#bgcolor {
	background-color: #616161
}
   
    
  .carousel-inner img {
      width: 70%; /* Set width to 100% */
      margin: auto;
      height: 50px;
  }
  
   .carousel-inner img { 
       width: 70%; /* Set width to 100% */ 
       margin: auto; 
       height: 50px; 
   } 
  


  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  

</style>
<body style="background-color: #9E9E9E">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="HomePage">SHREYAS MOBILES</a>
			</div>
			<ul class="nav navbar-nav navbar-left">
			
			
<!-- to make category,product,supplier pages visible to only admin -->
				<c:if test="${pageContext.request.userPrincipal.name!=null}">
					<security:authorize access="hasRole('ROLE_ADMIN')">
				<li> <a href="<c:url value="/CategoryForm"/>"> Category</a></li>
				<li> <a href="<c:url value="/SupplierForm"/>"> Supplier</a></li>
				<li> <a href="<c:url value="/ProductForm"/>"> Product</a></li>
				
				</security:authorize>
				</c:if>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="HomePage"><span
						class="glyphicon glyphicon-home"></span> Home</a></li>
				
				<c:if test="${pageContext.request.userPrincipal.name==null}">
				<li class="active"><a href="SignUp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li class="active"><a href="Login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
				
				<li class="active"><a href="ContactUs"><span
						class="glyphicon glyphicon-phone-alt"></span> Contact Us</a></li>
		
				<c:if test="${pageContext.request.userPrincipal.name!=null}">
				<li class="active"><a href="<c:url value='/ViewYourCart'/>"><span
						class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name!=null}">
				
					<li class="active"><a href="<c:url value="/j_spring_security_logout"/>"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
					</c:if>
			</ul>
		</div>
	</nav>

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

</style>
</head>

<body style="background:#616161; color:#FFFFFF">

<div class="container">
<div  align="center">
<h3>Order Confirmed!!</h3>
<h4>Delivered in 2 working days</h4>
<img src="${img}/Thanx.png" alt="Thank You" width=320 height=240>
</div>
</div>


</body>
</html>
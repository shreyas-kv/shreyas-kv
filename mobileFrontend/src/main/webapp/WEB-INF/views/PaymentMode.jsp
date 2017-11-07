<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css" var="css" />

<%@include file="head.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
 var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope, $http){
	 $http.get("http://localhost:8080/mobileFrontend/SendMail")
	 });
 </script>


<link rel="stylesheet" href="${css}/PaymentMode.css">
<div class="container">
	<div class="col-sm-3"></div>
	<div class="col-sm-6" >
	<div class="row">
		<div class="paymentCont">
						<div class="headingWrap">
								<h3 class="headingTop text-center">Select Your Payment Method</h3>	
								
						</div>
						<div class="paymentWrap">
							<div class="btn-group paymentBtnGroup btn-group-justified"  >
					            <label class="btn paymentMethod" data-target="#collapseOne" data-toggle="collapse" aria-expanded="false" aria-controls="collapseOne">
					            	<div class="method ez-cash"></div>
					                <input type="radio" name="options" checked> 
					            </label>
					            <label class="btn paymentMethod" data-target="#collapseTwo" data-toggle="collapse" aria-expanded="false" aria-controls="collapseTwo">
					            	<div class="method visa"></div>
					                <input type="radio" value="1"> 
					            </label>
					        </div>

						<div id="collapseOne" aria-expanded="false" class="collapse">
							<div class="well">Your one time password has been sent to
								your registered mail id.</div>
							Enter the OTP:
							<c:url value="/payment" var="p"/>
							<form method="post" action="${p}" commandName="otp" >
							<input ng-app="myApp" ng-controller="myCtrl"
								type="text" name="otp">
						</form>
						</div>
						
						
						<div id="collapseTwo" aria-expanded="false" class="collapse">
							  <%@include file="CardPay.jsp"%>							
						</div>

						</div>

						<br>
						<br>
						
						
						
						<div>
						
						</div> 
						<div class="footerNavWrap clearfix">
							<div class="btn btn-success pull-left btn-fyi"><span class="glyphicon glyphicon-chevron-left"></span> CONTINUE SHOPPING</div>
									
							<a href="<c:url value="/payment"/>" class="btn btn-success pull-right btn-fyi"  role="button" >CHECKOUT</a>			
						
						</div>
					</div>
		
	</div>
	</div>
</div>
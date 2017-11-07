<%@include file="head.jsp"%>

<div class="container">
	
	
		<font color="#E0E0E0"> <br> 
			
					
			
			


			<div class="col-sm-4" style="background-color: #616161">
			
				<h3><center>BILLING ADDRESS</center></h3>
				<div class="form-group">
					<label>Enter House No:</label>
					<form:input type="text" class="form-control" disabled="true"  path="user.billingAddress.b_hno" />
				</div>

				<div class="form-group">
					<label>Enter Street:</label>
					<form:input type="text" disabled="true" class="form-control"
						path="user.billingAddress.b_street" />
				</div>

				<div class="form-group">
					<label>Enter Locality:</label>
					<form:input type="text" disabled="true" class="form-control"
					 path="user.billingAddress.b_locality" />
				</div>
				<div class="form-group">
					<label> Enter City:</label>
					<form:input type="text" disabled="true" class="form-control"
						 path="user.billingAddress.b_city" />
				</div>
				<div class="form-group">
					<label>Enter State:</label>
					<form:input type="text" disabled="true" class="form-control"
						 path="user.billingAddress.b_state" />
				</div>
					<div class="form-group">
					<label>Enter Pincode:</label>
					<form:input type="text" disabled="true" class="form-control" path="user.billingAddress.b_pincode" />
				</div>
				
			
				
			</div>
			<div class="col-sm-1"></div>
						
			<div class="col-sm-4" style="background-color: #616161">
				
				
				<c:url value='/OrderConfirm' var="add" /> 
				<form:form action="${add}" method="post" commandName="shippingAddress">
				<h3><center>SHIPPING ADDRESS</center></h3>
				<div class="form-group">
					<label>Enter House No:</label>
					<form:input type="text" class="form-control" path="s_hno" />
				</div>

				<div class="form-group">
					<label>Enter Street:</label>
					<form:input type="text" class="form-control"
						path="s_street" />
				</div>

				<div class="form-group">
					<label>Enter Locality:</label>
					<form:input type="text" class="form-control"
					 path="s_locality" />
				</div>
				<div class="form-group">
					<label> Enter City:</label>
					<form:input type="text" class="form-control"
						 path="s_city" />
				</div>
				<div class="form-group">
					<label>Enter State:</label>
					<form:input type="text" class="form-control"
						 path="s_state" />
				</div>
					<div class="form-group">
					<label>Enter Pincode:</label>
					<form:input type="text" class="form-control" path="s_pincode" />
				</div>
				
				
			</div><br>	
			<div class="col-sm-1"></div>	
					<div class="col-sm-2" style="background-color: #616161">
					<center>
						<input type="submit" class="btn btn-success" value="Continue"/>
						<button type="reset" class="btn btn-danger">Reset</button>
					</center>
					</div>				
				</form:form> <br>

			</div>
			
			
			
			
				
				
			
			
		</font>
	
</div>
</body>
</html>







































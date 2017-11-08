<%@include file="head.jsp"%>

<div class="container">
	
	
		<font color="#E0E0E0"> <br> 
			
					
				<c:url value='/adduser' var="add" /> 
				<form:form action="${add}" method="post" commandName="user">
				
			<div class="col-sm-1"></div>
			<div class="col-sm-4" style="background-color: #616161">
			<br>
				<div class="form-group collapse">
					<label>User Id:</label>
					<form:input type="text" class="form-control" path="user_id" required="required"/>
				</div>

				<div class="form-group">
					<label>Enter Name:</label>
					<form:input type="text" class="form-control"
						placeholder="Name" path="user_name" required="required"/>
				</div>

				<div class="form-group">
					<label>Enter Mobile No:</label>
					<form:input type="text" class="form-control"
						placeholder="+91 98756 98756" path="user_phno" required="required"/>
				</div>
				<div class="form-group">
					<label> Enter Email:</label>
					<form:input type="email" class="form-control"
						placeholder="xyz@gmail.com" path="user_emailid" required="required"/>
				</div>
				<div class="form-group">
					<label>Enter Password:</label>
					<form:input type="password" class="form-control"
						placeholder="*********" path="user_password" required="required"/>
				</div>
<!-- 				<div class="form-group"> -->
<!-- 					<label>Enter Address:</label> -->
<%-- 					<form:input type="text" class="form-control" --%>
<%-- 						placeholder="Door no,Street Name,Area,City" path="user_address" /> --%>
<!-- 				</div> -->
				<div class="form-group">
					<label>Enter Role:</label>
					<form:input type="text" class="form-control" path="user_role" required="required"/>
				</div>
				
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-4" style="background-color: #616161"><br>
				<div class="form-group">
					<label>Enter House No:</label>
					<form:input type="text" class="form-control" path="billingAddress.b_hno" required="required"/>
				</div>

				<div class="form-group">
					<label>Enter Street:</label>
					<form:input type="text" class="form-control"
						path="billingAddress.b_street" required="required"/>
				</div>

				<div class="form-group">
					<label>Enter Locality:</label>
					<form:input type="text" class="form-control"
					 path="billingAddress.b_locality" required="required"/>
				</div>
				<div class="form-group">
					<label> Enter City:</label>
					<form:input type="text" class="form-control"
						 path="billingAddress.b_city" required="required"/>
				</div>
				<div class="form-group">
					<label>Enter State:</label>
					<form:input type="text" class="form-control"
						 path="billingAddress.b_state" required="required"/>
				</div>
					<div class="form-group">
					<label>Enter Pincode:</label>
					<form:input type="text" class="form-control" path="billingAddress.b_pincode" required="required"/>
				</div>
				
				<div>
					<center>
						<input type="submit" class="btn btn-success" value="Register"/>
						<button type="reset" class="btn btn-danger">Reset</button>
					</center>
				</div>
				<br>
			</div>
			<div class="col-sm-2"></div>
			
				
				
			
			</form:form> <br>
		</font>
	
</div>
</body>
</html>








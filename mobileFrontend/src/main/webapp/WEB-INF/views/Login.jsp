<%@include file="head.jsp"%>
	<div class="container">
		<div class="col-sm-4"></div>
		<div class="col-sm-4" style="background-color: #616161">
			<font color="#E0E0E0"> <br>
				
				<c:url value='/j_spring_security_check' var='add' />
				
				<form:form action="${add}" method="post" >
					<div class="form-group">
						<label for="email">Email address:</label> 
						<input type="email" class="form-control" placeholder="xyz@gmail.com" name="j_username" />
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> 
						<input type="password"
							class="form-control" placeholder="**********" name="j_password"/>
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<div>
						<center>
							<input type="submit" class="btn btn-default" value="Login">
							<button type="reset" class="btn btn-default">Reset</button>
						</center>
					</div>
					<center>
						<a href="#" class="btn btn-link" role="link">Forget Password?</a>
					</center>
				</form:form>
			</font>
		</div>
	</div>
</body>
</html>

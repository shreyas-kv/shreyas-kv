<%@include file="head.jsp"%>

<div class="container">
	<div class="col-sm-4"></div>
	<div class="col-sm-4" style="background-color: #616161">
		<font color="#E0E0E0"> <br> 
		
				<c:url value='/addsupplier' var="add" /> 
				<form:form action="${add}" method="post" commandName="supplier">

				<div class="form-group collapse">
					<label>Supplier Id:</label>
					<form:input type="text" class="form-control" path="sup_id" />
				</div>

				<div class="form-group">
					<label>Supplier Name:</label>
					<form:input type="text" class="form-control"
						placeholder="Name" path="sup_name" />
				</div>

				<div class="form-group">
					<label>Supplier Mobile No:</label>
					<form:input type="text" class="form-control"
						placeholder="+91 98756 98756" path="sup_phno" />
				</div>
				<div class="form-group">
					<label>Supplier Address:</label>
					<form:input type="text" class="form-control"
						placeholder="Door no,Street Name,Area,City" path="sup_addr" />
				</div>
				
				<div>
					<center>
						<input type="submit" class="btn btn-success" value="Register"/>
						<button type="reset" class="btn btn-danger">Reset</button>
					</center>
				</div>


			</form:form> <br>
		</font>
	</div>
</div>
      <br>
<div class="container">

<div class="col-sm-2"></div>
<div class="col-sm-8" style="background-color: #616161">
<br>
<font color="#E0E0E0">
<table class="table table-bordered">
	
    <thead>
      <tr>
        
        <th>Supplier name</th>
        <th>Supplier Mobile No</th>
      	<th>Supplier Address</th>
		<th>Edit/Delete</th>      
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${suppliers}" var="q">
  			<tr>
  				<td>${q.getSup_name()}</td>
  				<td>${q.getSup_phno()}</td>
  				<td>${q.getSup_addr()}</td>    
      			<td><a href="<c:url value='editSupplier/${q.getSup_id()}'/>" class="btn btn-primary btn-xs" role="button">Edit</a>
      			<a href="<c:url value='deleteSupplier/${q.getSup_id()}'/>" class="btn btn-danger btn-xs" role="button">Delete</a>
      			</td>
      		</tr>
      </c:forEach>
        
    </tbody>
  </table>
</div>
</div>
      
    </tbody>
  </table>
</div>
</div>

</body>
</html>








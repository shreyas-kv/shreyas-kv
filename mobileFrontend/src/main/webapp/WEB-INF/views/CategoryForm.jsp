<%@include file="head.jsp"%>

<div class="container">
	<div class="col-sm-4"></div>
	<div class="col-sm-4" style="background-color: #616161">
		<font color="#E0E0E0"> <br> 
		
				<c:url value='/addcategory' var="add" /> 
				<form:form action="${add}" method="post"
				commandName="category">

				<div class="form-group collapse" >
					<label>Category Id:</label>
					<form:input type="text" class="form-control" path="cat_id" />
				</div>

				<div class="form-group">
					<label>Category Name:</label>
					<form:input type="text" class="form-control" path="cat_name" />
				</div>

				<div class="form-group">
					<label>Category Description:</label>
					<form:input type="text" class="form-control" path="cat_desc" />
				</div>
				<div>
					<center>
						<input type="submit" class="btn btn-success" value="Register" />
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
        
        <th>Category Name</th>
        <th>Category Description</th>
		<th>Edit/Delete</th>      
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="q" >  <!--  categories is list of objects -->
      <tr>
        <td>${q.getCat_name()}</td>
        <td>${q.getCat_desc()}</td>
        <td><a href="<c:url value='editCategory/${q.getCat_id()}'/>" class="btn btn-primary btn-xs" role="button">Edit</a>
        <a href="<c:url value='deleteCategory/${q.getCat_id()}'/>" class="btn btn-danger btn-xs" role="button">Delete</a></td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>
</div>

</body>
</html>

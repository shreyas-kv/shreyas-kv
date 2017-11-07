<%@include file="head.jsp"%>

<div class="container">
	<div class="col-sm-4"></div>
	<div class="col-sm-4" style="background-color: #616161">
		<font color="#E0E0E0"> <br> 
		
				<c:url value='/addproduct' var="add" /> 
				<form:form action="${add}" method="post"
				commandName="product" enctype="multipart/form-data">

				<div class="form-group collapse" >
					<label>Product Id:</label>
					<form:input type="text" class="form-control" path="prod_id" />
				</div>

				<div class="form-group">
					<label>Product Name:</label>
					<form:input type="text" class="form-control" path="prod_name" />
				</div>

				<div class="form-group">
					<label>Product Quantity:</label>
					<form:input type="text" class="form-control" path="prod_qty" />
				</div>
				<div class="form-group">
					<label>Product Price:</label>
					<form:input type="text" class="form-control" path="prod_price" />
				</div>

				<div class="form-group">
					<label>Product Desc:</label>
					<form:input type="text" class="form-control" path="prod_desc" />
				</div>
				
				<div class="form-group">
					<label for="cat1">Category</label>
					<font color="#000000">
					<form:select path="category.cat_id" multiple="false">
						<c:forEach items="${categories}" var="d">
							<form:option value="${d.getCat_id()}" label="${d.getCat_name()}" />
						</c:forEach>
					</form:select>
					</font>
				</div>



				<div class="form-group">
					<label for="sel1">Supplier</label>
					<font color="#000000">
					<form:select path="supplier.sup_id" multiple="false">
						<c:forEach items="${suppliers}" var="d">
							<form:option value="${d.getSup_id()}" label="${d.getSup_name()}" />
						</c:forEach>
					</form:select>
					</font>
				</div>


				<form:input path="prod_img" type="file" name="image" value="upload file"/>


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
        <th>Product Image</th>
        <th>Product Name</th>
        <th>Product Quantity</th>
        <th>Product Price</th>
        <th>Product Description</th>
        
        <th>Category Name</th>
        <th>Supplier Name</th>
		<th>Edit/Delete</th>      
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${producties}" var="q" >  
      <tr>

        <td><img src="<c:url value='resources/PImages/${q.getProd_id()}.jpg'/>" , width=75px, height=50px ></td>
        <td>${q.getProd_name()}</td>
        <td>${q.getProd_qty()}</td>
        <td>${q.getProd_price()}</td>
        <td>${q.getProd_desc()}</td>

        <td>${q.getCategory().getCat_name()}</td>
        <td>${q.getSupplier().getSup_name()}</td>
        <td><a href="<c:url value='editProduct/${q.getProd_id()}'/>" class="btn btn-primary btn-xs" role="button">Edit</a>
        <a href="<c:url value='deleteProduct/${q.getProd_id()}'/>" class="btn btn-danger btn-xs" role="button">Delete</a></td>
      </tr>
      </c:forEach>
    	
      
    </tbody>
  </table>
</div>
</div>

</body>
</html>

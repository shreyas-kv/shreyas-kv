<%@include file="head.jsp"%>

<div class="col-sm-2"></div>
<div class="col-sm-8" style="background-color: #616161">
<br>

<font color="#E0E0E0">
<h1><center>Review Your Order</center></h1>
<br>
<table class="table">
	
    <thead>
      <tr>
        <th></th>
        <th>Number</th>
        <th>Street</th>
		<th>Locality</th>      
      	<th>City</th>
        <th>State</th>
		<th>Pin Code</th>
      </tr>
    </thead>
    <tbody>
    
      <tr>
      <td>BILLING ADDRESS</td>
        <td>${billingAddress.getB_hno()}</td>
        <td>${billingAddress.getB_street()}</td>
      	<td>${billingAddress.getB_locality()}</td>
        <td>${billingAddress.getB_city()}</td>
      	<td>${billingAddress.getB_state()}</td>
        <td>${billingAddress.getB_pincode()}</td>
      
      </tr>
     <tr">
      <td>SHIPPING ADDRESS</td>
        <td>${shippingAddress.getS_hno()}</td>
        <td>${shippingAddress.getS_street()}</td>
      	<td>${shippingAddress.getS_locality()}</td>
        <td>${shippingAddress.getS_city()}</td>
      	<td>${shippingAddress.getS_state()}</td>
        <td>${shippingAddress.getS_pincode()}</td>
      
      </tr>
      
    </tbody>
  </table>
  
  
  
  <font color="#E0E0E0">
<table class="table">
	
    <thead>
      <tr>
        <th>Product Image</th>
        <th>Product Name</th>
<!--         <th>Product Quantity</th> -->
        <th>Product Price</th>
<!--         <th>Product Total</th> -->
        
              
      </tr>
    </thead>
    <tbody>
    
    <c:if test="${product==null}">
    	<c:forEach items="${cartitemsList}" var="q" >  
      <tr>
      	<td><img src="<c:url value="resources/PImages/${q.getProduct().getProd_id()}.jpg"/>", width=125px, height=75px ></td>
        <td>${q.getProduct().getProd_name()}</td>
<%--         <td>${q.getProduct().getProd_qty()}</td> --%>
        <td>${q.getProduct().getProd_price()}</td>
<%--         <td>${q.getProduct().getProd_price() * q.getProduct().getProd_qty()}</td> --%>
        
      </tr>
     
      </c:forEach>
						<td>
							<h4 align="left">&nbsp&nbsp Total Items:
								${cart.getTot_items()}</h4>
							<h3 align="pull-right">Grand Total: ${cart.getTotal()}</h3>

						</td>
	</c:if>
    
    <c:if test="${product!=null}">
      <tr>
      	<td><img src="<c:url value="resources/PImages/${product.getProd_id()}.jpg"/>", width=125px, height=75px ></td>
        <td>${product.getProd_name()}</td>
        <td>${product.getProd_qty()}</td>
        <td>${product.getProd_price()}</td>
<%--         <td>${product.getProd_price() * product.getProd_qty()}</td> --%>
        
      </tr>
						<td>
							<h4 align="left">&nbsp&nbsp Total Items: ${1}</h4>
							<h3 align="pull-right">Grand Total: ${product.getProd_price() * product.getProd_qty()}</h3>

						</td>
					</c:if>

    	
    
    	
    	
    </tbody>
  
  </table>
  
  
  <br>
  
  <div class="col-sm-3">
  <a href="<c:url value="/previous"/>" class="btn btn-primary btn-lg"  role="button">Previous</a>
  </div> 
 
  <div class="col-sm-6">
  
  </div>
  <div class="col-sm-3">
  <a href="<c:url value="/pay"/>" class="btn btn-success btn-lg"  role="button">Continue To Payment</a>
  <br>
  <br>
  </div>
  
  
</div>
</div>

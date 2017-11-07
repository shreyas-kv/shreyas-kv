<%@ include file="head.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<spring:url value="/resources/PImages" var="img1" />
<div class="container">

<div class="col-sm-2"></div>
<div class="col-sm-8" style="background-color: #616161">
<br>
<font color="#E0E0E0">
<table class="table table-bordered">
	
    <thead>
      <tr>
        
        <th>Product Name</th>
        <th>Product Quantity</th>
        <th>Product Price</th>
        <th>Product Description</th>
        <th>Product Image</th>
        <th>Buy Now/Delete</th>      
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${cartItems}" var="q" >  
      <tr>
        <td>${q.getProduct().getProd_name()}</td>
        <td>${q.getProduct().getProd_qty()}</td>
        <td>${q.getProduct().getProd_price()}</td>
        <td>${q.getProduct().getProd_desc()}</td>
        <td><img src="<c:url value="resources/PImages/${q.getProduct().getProd_id()}.jpg"/>", width=75px, height=50px ></td>
        <td><a href="<c:url value='/Buy/${q.getProduct().getProd_id()}/${q.getCartItem_id()}'/>" class="btn btn-primary btn-xs" role="button">Buy Now</a>
         / <a href="<c:url value='deleteCart/${q.getCartItem_id()}'/>" class="btn btn-danger btn-xs" role="button">Delete</a></td>
      </tr>
      </c:forEach>
    	
    	
    </tbody>
  </table>
  
  <a href="<c:url value="/Removeall"/>" class="btn btn-danger btn-xs"  role="button" align="right">Remove All</a>
  <a href="<c:url value="/Buyall"/>" class="btn btn-primary btn-xs"  role="button" align="right">Buy All</a>
     <br>
</div>
</div>

</body>
</html>

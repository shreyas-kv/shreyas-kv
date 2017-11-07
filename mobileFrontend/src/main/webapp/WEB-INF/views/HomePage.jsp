<%@include file="head.jsp"%>

	<div class="container">
		<div class="form-group">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<form>
					<div class="input-group">
						<input type="text" class="form-control input-lg"
							placeholder="Want to search quicker?? Type it here">
						<div class="input-group-btn">
							<button class="btn btn-primary btn-lg" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
	
	<a href="<c:url value="/Thanku"/>"> Thnks </a>
	
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="${img}/c2.jpg" alt="iPhone7">
				</div>

				<div class="item">
					<img src="${img}/c1.jpg" alt="OnePlus3">
				</div>

				<div class="item">
					<img src="${img}/c3.jpg" alt="s7">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>


<nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Search By Category</a>
		</div>
		<ul class="nav navbar-nav ">
			<c:forEach var="catz" items="${categories}">
			<li class="active"><a href="<c:url value="/HomeCates/${catz.getCat_id()}"/>">${catz.getCat_name()}</a></li>
			
			
			
			</c:forEach>
		</ul>
	</div>
</nav>
<br>
<br>

<div class="container">

<c:forEach var="prods" items="${producties}">
<div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <img src="${img1}/${prods.getProd_id()}.jpg" />
                            <div class="caption">
                                <h4 class="pull-right">${prods.getProd_price()}</h4>
                                <h4>${prods.getProd_name()}</a>
                                </h4>
                                <h6>${prods.getProd_desc()}</h6>
                            <center>
                            <button type="input" class="btn btn-default ">
						<a href="<c:url value="/addCart/${prods.getProd_id()}"/> ">
						Add To Cart
						</a>
						</button>					
<!-- 						<button type="input" class="btn btn-default">			 -->
<%-- 							<a href="<c:url value="/Buy/${prods.getProd_id()}"/>">Buy Now</a> --%>
<!-- 						</button>		 -->
						</center>
						
                            
                           
                            
                            </div>
                            
                        </div>
                    </div>
                    </c:forEach>
</div>
<br>
<br>
<br>
<br>

</body>
</html>

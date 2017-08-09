<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">

		<!-- Include category.jsp -->
		<div class="col-md-3">
			<%@include file="category.jsp"%>
		</div>

		<!-- Display Actual products -->
		<div class="col-md-9">

			<!-- Adding bootstrap Bread crum for Navigation -->
			<div class="row">

				<div class="col-lg-12">

					<!-- User has clicked all prodcuts   -->
					<c:if test="${userClickedAllProduct==true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<!-- User has clicked category all prodcuts   -->
					<c:if test="${userClickedCategoryProduct==true}">
						<!-- Set CategoryId -->
						<script>
							window.categoryId = ${category.id};
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>

			<!-- List of products -->
			<div class="row">

				<div class="col-xs-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>


						</thead>

						<tfoot>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>


						</tfoot>

					</table>

				</div>

			</div>

		</div>

	</div>

</div>
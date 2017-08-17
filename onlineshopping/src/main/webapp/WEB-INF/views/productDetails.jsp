<div class="container">

	<div class="row">

		<!-- Desing navigation bar from bread crum -->

		<!-- Adding bootstrap Bread crum for Navigation -->
		<div class="row">

			<div class="col-lg-12">

				<ol class="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li><a href="${contextRoot}/show/all/products">All
							Products</a></li>
					<li class="active">${product.name}</li>
				</ol>
			</div>
		</div>

		<div class="row">

			<!-- Show product Image -->
			<div class="col-xs-12 col-sm-4">
				<div class="thumbnail">
					<img src="${images}/${product.code}.jpeg"
						class="img img-responsive singleProductImg" />
				</div>
			</div>
			<!-- Show Product Details -->
			<div class="col-xs-12 col-sm-8">

				<h3>${product.name}</h3>
				<hr />
				<h3>${product.description}</h3>
				<hr />
				<h3>${product.brand}</h3>
				<hr />
				<h4>
					Price : &#8377;<strong>${product.unitPrice} /-</strong>
				</h4>
				<hr />
				<h6>Qty. Available ${product.quantity}</h6>

				<!-- Add cart button -->
				<a href="${contextRoot} /cart/add/ ${product.id}/product"
					class="btn btn-success"> <span
					class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
				</a>'

				<!-- Add back button: SHow all product -->
				<a href="${contextRoot}/show/all/products">Back</a>
			</div>





		</div>

	</div>



</div>
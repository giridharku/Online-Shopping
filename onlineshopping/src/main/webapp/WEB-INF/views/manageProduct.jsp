<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Product</title>
</head>
<body>

	<div class="container">

		<div class="row">

			<div class="col-md-offset-2 col-md-8">

				<c:if test="${not empty createProductMsg}">
					<div class="alert alert-success">
						<strong>${createProductMsg} </strong><br />

					</div>
				</c:if>
			</div>
		</div>
		<div class="row">

			<div class="col-md-offset-2 col-md-8">


				<div class="panel panel-primary">


					<!-- Head title of page -->
					<div class="panel-heading">

						<h4>Product Management</h4>
					</div>


					<!-- Form Body -->

					<div class="panel-body">
						<sf:form class="form-horizontal" modelAttribute="product"
							action="${contextRoot}/manage/products" method="POST"
							enctype="multipart/form-data">

							<div class="form-group">
								<label class="control-label col-md-4" for="name">Product
									Name: </label>
								<div class="col-md-8">
									<sf:input type="text" class="form-control" id="name"
										path="name" placeholder="Enter Name" />
									<sf:errors cssClass="vlidationMsg" path="name" />
								</div>

							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="brand">Product
									Brand: </label>
								<div class="col-md-8">
									<sf:input type="text" class="form-control" id="brand"
										path="brand" placeholder="Enter Brand" />
									<sf:errors cssClass="vlidationMsg" path="brand" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="brand">Product
									Description: </label>
								<div class="col-md-8">
									<sf:textarea path="description" class="form-control"
										id="description"></sf:textarea>
									<sf:errors cssClass="vlidationMsg" path="description" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="price">Enter
									Unit Price: </label>
								<div class="col-md-8">
									<sf:input type="text" class="form-control" id="unitPrice"
										path="unitPrice" placeholder="Unit price" />
									<sf:errors cssClass="vlidationMsg" path="unitPrice" />

								</div>

							</div>

							<div class="form-group">

								<label class="control-label col-md-4" for="quantity">Quantity
									Available:</label>

								<div class="col-md-8">
									<sf:input type="number" class="form-control" id="quantity"
										path="quantity" placeholder="Enter Product Qty" />
									<sf:errors cssClass="vlidationMsg" path="quantity" />
								</div>

							</div>

							<div class="form-group">

								<label class="control-label col-md-4" for="quantity">Select
									Image:</label>

								<div class="col-md-8">
									<sf:input type="file" class="form-control" id="file"
										path="file" />
									<sf:errors cssClass="vlidationMsg" path="file" />
								</div>

							</div>

							<div class="form-group">

								<label class="control-label col-md-4" for="categoryId">Select
									Category:</label>

								<div class="col-md-8">
									<sf:select class="form-control" id="categoryId" path="id"
										items="${categoryList}" itemLabel="name" itemValue="id">
									</sf:select>
								</div>

							</div>

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
							</div>



						</sf:form>

					</div>

				</div>


			</div>

		</div>

	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>


<div class="container d-flex justify-content-center">

<div class="col-5">

<h1 class="mt-5">List of Products</h1>

<table class="table table-striped table-hover">

<thead>

<tr>

<th>Id</th>
<th>Name</th>
<th>Description</th>
<th>Price</th>
<th>Action</th>

</tr>

</thead>

<tbody>

<c:forEach var="producto" items="${ listOfProducts}">


<tr>

<td><c:out value="${producto.getProduct_id() }"></c:out></td>
<td><c:out value="${producto.getProduct_name() }"></c:out></td>
<td><c:out value="${producto.getDescription() }"></c:out></td>
<td><c:out value="${producto.getPrice() }"></c:out></td>
<td><a href="/catAdd/${producto.getProduct_id() }">add Category</a></td>

</tr>


</c:forEach>

</tbody>

</table>

<a href="/add/product" class="btn btn-success">Create</a>

</div>

<div class="col-2"></div>

<div class="col-5">

<h1 class="mt-5">List of Categories</h1>

<table class="table table-striped table-hover">

<thead>

<tr>

<th>Id</th>
<th>Name</th>
<td>Action</td>
</tr>
</thead>

<tbody>

<c:forEach var="categoria" items="${ listOfCategories}">


<tr>

<td><c:out value="${categoria.getCategory_id() }"></c:out></td>
<td><c:out value="${categoria.getCategory_name() }"></c:out></td>
<td><a href="/prodAdd/${categoria.getCategory_id() }">add Product</a></td>

</tr>

</c:forEach>


</tbody>

</table>

<a href="/add/category" class="btn btn-success">Create</a>

</div>

</div>



<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="./js/script.js" ></script>

</body>
</html>
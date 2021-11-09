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

		<div><a href="/">Go back</a></div>

			<h1 class="mt-5">
				Category: <span><c:out value="${currentCategory.getCategory_name() }"></c:out></span>
			</h1>

			<h2>Products</h2>

			<ul>

			<c:forEach var="CatProd" items="${listCategoryProduct }">
			
				<c:if test="${CatProd.getCategory_id().getCategory_id() == currentCategory.getCategory_id() }">
			
				<li><c:out value="${CatProd.getProduct_id().getProduct_name()}"></c:out></li>
			
				</c:if>

			</c:forEach>

			</ul>


		</div>

		<div class="col-2"></div>

		<div class="col-5">
		
		
	<form action="/agregarProd/${currentCategory.getCategory_id()}" method="POST">
		<label for="prodSelected" class="form-label mt-5">Add Category:</label>
		<select name="prodSelected" id="prodSelected" class="form-select">
		
		
		<c:forEach var="producto" items="${listProdNotSelected }">
			
		<option value="${producto.getProduct_id() }"><c:out value="${producto.getProduct_name() }"></c:out></option>
			
		</c:forEach>
		
		</select>
		
			<button type="submit" class="btn btn-primary mt-3">add</button>
		
		</form>
			
		</div>

	</div>


<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="./js/script.js" ></script>

</body>
</html>
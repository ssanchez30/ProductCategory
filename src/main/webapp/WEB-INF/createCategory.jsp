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

<div class="container">

<h1>New Category</h1>


<form action="/create/category" method="POST">

<label for="category_name" class="form-label">Name:</label>
<input type="text" class="form-control" id="category_name" name="category_name"/>


<button type="submit" class="btn btn-success">Add product</button>


</form>


</div>


<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="./js/script.js" ></script>

</body>
</html>
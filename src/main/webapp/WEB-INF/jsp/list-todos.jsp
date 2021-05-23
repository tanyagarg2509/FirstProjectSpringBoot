<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Todo's For ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<h1>Your Todos:</h1>

	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a type="button" href="/update-todo?id=${todo.id}" class="btn btn-primary">Update</a></td>
						<td><a type="button" href="/delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<div>
			<a class="button" href="/add-todo"> Add More Todos</a>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
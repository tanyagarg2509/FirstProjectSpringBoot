<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>Your Todos:</h1>
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
					<td><fmt:formatDate value="${todo.targetDate}"
							pattern="dd/MM/yyyy" /></td>
					<td>${todo.done}</td>
					<td><a type="button" href="/update-todo?id=${todo.id}"
						class="btn btn-primary">Update</a></td>
					<td><a type="button" href="/delete-todo?id=${todo.id}"
						class="btn btn-warning">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div>
		<a class="button" href="/add-todo"> Add More Todos</a>
	</div>
</div>
<%@ include file="common/footer.jspf" %>

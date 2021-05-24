<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<span style="color: red"><h6>${errorMessage}</h6></span>
	<form  method="POST">
		<fieldset class="form-group">
			<label>Name:</label> 
			<input class="form-control" type="text" name="name" />
		</fieldset>
		<fieldset class="form-group">
			<label>Password:</label> 
			<input  class="form-control" type="password" name="pswd" />
		</fieldset>
		<input type="submit" name="submit">
	</form>
</div>

<%@ include file="common/footer.jspf"%>
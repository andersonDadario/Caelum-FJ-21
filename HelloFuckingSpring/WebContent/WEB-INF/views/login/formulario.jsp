<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<c:if test="${ not empty erro }">
			<p>${erro}</p>
		</c:if>
		<form action="efetuaLogin" method="post">
				User: <input type="text" name="login" /><br>
				Pass: <input type="password" name="senha" /><br>
				<input type="submit" value="Login!" />
		</form>
	</body>
</html>
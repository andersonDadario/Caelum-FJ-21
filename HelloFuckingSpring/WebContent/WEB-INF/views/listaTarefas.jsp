<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<c:forEach var="tarefa" items="${lista}">
		<c:if test="${tarefa.finalizado eq true}">
			<p style="color:green;">${tarefa.id}/${tarefa.descricao}</p>
		</c:if>
		
		<c:if test="${tarefa.finalizado eq false}">
			<p style="color:red;">${tarefa.id}/${tarefa.descricao}</p>
		</c:if>
	</c:forEach>
</html>
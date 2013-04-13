<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
	<!--
		// JavaServer Pages Standard Tag Library (JSTL)
	-->
	<head>
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/jquery-ui.js" type="text/javascript"></script>
		<link href="css/jquery.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<!-- 
			// Import  -> Renderiza HTML, resolve problema do Namespace
			// Include -> Sem
		 -->
		<!-- c:import url="welcome.jsp" /-->
		<c:if test="${not empty obrigado}">
				<b>Registro adicionado com sucesso!</b>
				<hr/>
		</c:if>
		<br/>/* JSTL */<br/>
		<table>
			<jsp:useBean class="br.com.caelum.agenda.dao.ContatoDao" id="dao" />
			<c:forEach items="${dao.lista}" var="contato" varStatus="i">
				<tr bgcolor="${i.count%2==0?'#CDCDCD':'#F1F1F1'}">
					<td>
						<c:if test="${empty contato.email}">
							${contato.nome}
						</c:if>
						
						<c:if test="${not empty contato.email}">
							<a href="${contato.email}">${contato.nome}</a>
						</c:if>
					</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time}"/></td>
				</tr>
			</c:forEach>
		</table>
		<h1>Inserir Contato</h1>
		<form action="oimundo" method="post">
			Nome <input type="text" name="nome" /><br/>
			Email <input type="text" name="email" /><br/>
			Data <caelum:campoData id="data_nascimento" /><br/>
			<input type="hidden" name="opcode" value="AdicionaContato" />
			<input type="submit" value="Enviar" />
		</form>
	</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!--
	// JavaServer Pages Standard Tag Library (JSTL)
-->

<html>
	<body>
		<!-- 
			// Import  -> Renderiza HTML, resolve problema do Namespace
			// Include -> Sem
		 -->
		<c:import url="welcome.jsp" />
		<br/>/* JSTL */<br/>
		<table>
			<jsp:useBean class="br.com.caelum.agenda.dao.ContatoDao" id="dao" />
			<c:forEach items="${dao.lista}" var="contato" varStatus="i">
				<tr bgcolor="${i.count%2==0?'#CDCDCD':'#F1F1F1'}">
					<td>
						<c:if test="${empty contato.email}">
							<i>n&atilde;o fornecido</i>
						</c:if>
						
						<c:if test="${not empty contato.email}">
							<a href="${contato.email}">${contato.email}</a>
						</c:if>
					</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
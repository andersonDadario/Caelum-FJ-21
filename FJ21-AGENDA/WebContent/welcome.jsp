/* Scriptlet */
<%@page import="java.util.*,
	br.com.caelum.agenda.dao.*,
	br.com.caelum.agenda.modelo.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
	<% String a = new String("Anderson"); %>
	<p>Ola <%=a%></p>
	<table>

	<% ContatoDao dao = new ContatoDao();
		List<Contato> lista = dao.getLista();
		for(Contato c : lista){
	%>
		<tr>
			<td><%=c.getNome()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getEndereco()%></td>
			<td><%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento().getTime())%>
			</td>
		</tr>
	<%
		}
	%>

	</table>
	<form action="mostrar_idade.jsp" method="get">
		Idade: <input type="text" name="idade" /> 
		<input type="submit" value="Enviar" />
	</form>
</html>
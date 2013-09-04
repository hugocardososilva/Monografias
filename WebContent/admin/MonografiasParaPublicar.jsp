<%@page import="com.banco.ConexaoMonografia"%>
<%@page import="com.classes.Monografia"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
ConexaoMonografia m= new ConexaoMonografia();
ArrayList<Monografia> lista = new ArrayList<Monografia>();
lista= m.ListarMonografias();
pageContext.setAttribute("lista", lista);

%>
<h2>Lista de Monografias</h2>
<table id="monografia">
<tr>
<td>Código</td>
<td>Nome</td>
<td>Curso</td>
<td>Instituição</td>
<td>Nota</td>
<td>Arquivo</td>
<td>Publicar</td>
<td>Excluir</td>
</tr>
<c:forEach items="${lista}" var="item">
<tr>
<td><c:out value="${item.id}"/>
<td><c:out value="${item.nome}"/>
</td>
<td><c:out value="${item.nomeCurso}"/>
</td>
<td><c:out value="${item.nomeInstituicao}"/>
</td>
<td><c:out value="${item.nota}"/>

</td>
<td>
	<a href="arquivo/<c:out value="${item.arquivo}"/>"/><c:out value="${item.arquivo}"/></a></br>
</td>
<td>
<c:choose>
	<c:when test="${item.cod_admin == 0 }">
		<a href="PublicarMonografia.do?cod=<c:out value="${item.id}"/>"/>Publicar</a></br>
 	</c:when>  
	<c:otherwise> 
		<p>Publicado</p>
	</c:otherwise>
</c:choose>
</td>
<td>
	<a href="ExcluirMonografia.do?exc=<c:out value="${item.id}"/>"/>Excluir</a>
</td>
</tr>
</c:forEach>

</table>
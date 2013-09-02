<%@page import="com.banco.ConexaoMonografia"%>
<%@page import="com.classes.Monografia"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
ConexaoMonografia m= new ConexaoMonografia();
ArrayList<Monografia> lista = new ArrayList<Monografia>();
lista= m.ListarMonografiasPublicadas();
pageContext.setAttribute("lista", lista);

%>
<h2>Lista de Monografias</h2>
<table id="monografia" border="1px">
<tr>
<td>Código</td>
<td>Nome</td>
<td>Curso</td>
<td>Instituição</td>
<td>Nota</td>
<td>Arquivo</td>
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
<td><a href="arquivo/<c:out value="${item.arquivo}"/>"/><c:out value="${item.arquivo}"/></a></br>
</td>
</tr>
</c:forEach>

</table>
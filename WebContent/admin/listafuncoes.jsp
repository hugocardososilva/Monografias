<%@page import="com.classes.Funcao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.banco.ConexaoFuncao"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
ConexaoFuncao f= new ConexaoFuncao();
ArrayList<Funcao> lista = new ArrayList<Funcao>();
lista= f.ListarFuncao();
pageContext.setAttribute("lista", lista);

%>

<table>
<c:forEach items="${lista}" var="item">
<tr>
<td><c:out value="${item.codigo}"/>
<td><c:out value="${item.privilegios}"/>
</td>
<td><c:out value="${item.descricao}"/>
</td>
</tr>
</c:forEach>
</table>






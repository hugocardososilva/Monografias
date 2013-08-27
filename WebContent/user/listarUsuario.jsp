<%@page import="java.util.ArrayList"%>
<%@page import="com.banco.ConexaoFuncao"%>
<%@page import="com.banco.ConexaoUsuario"%>
<%@page import="com.classes.Usuario"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
ConexaoUsuario con = new ConexaoUsuario();
ArrayList<Usuario> lista = new ArrayList<Usuario>();
lista= con.ListarUsuario();
pageContext.setAttribute("lista", lista);
%>
<table>
<c:forEach items="${lista}" var="item">
<tr>
<td><c:out value="${item.idUsuario}"/></td>
<td><c:out value="${item.login}"/></td>
<td><c:out value="${item.email}"/></td>
</tr>
</c:forEach>
</table>

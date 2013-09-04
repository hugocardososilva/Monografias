<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div id="header">
<a id="logo" href="/Monografias/index.jsp"></a>
 


<nav id= "menu">
<ul>

<c:choose>	
<c:when test="${user eq null }">
<li>Bem vindo, Visitante.</li>
</c:when>
 <c:otherwise>
   	<li>Bem Vindo, ${user.login}</li>
   	</c:otherwise>

</c:choose>
<li><a href="<c:url value='/cadastrousuario.jsp'/>">Cadastre-se</a></li>
<li><a href="<c:url value='/Suporte.jsp'/>">Suporte</a></li>



</ul>
</nav>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.banco.*"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de monografias</title>
</head>
<body>


<div id="body">
<div id= "header">
<div class="logo">
</div>
</div>
<c:choose>	
<c:when test="${user eq null }">
<div id="content">
<div id="mensagem"> ${mensagem }</div>
<c:import url="menusidebar.jsp" />
<h2>Bem-Vindo ${user.login}</h2>
<h2>Banco de dados de monografia</h2>
<p>Para acessar o conteúdo do site, é necessario ser cadastrado</p>
</div>
</div>


        
    
     </c:when>
    <c:otherwise>
       <jsp:forward page="/user/user.jsp" />
    </c:otherwise>
 
</c:choose>





</body>
</html>
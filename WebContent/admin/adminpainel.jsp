<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Erro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="../style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Painel Administrativo</title>
</head>
<body id="body">

<c:import url="/header.jsp" />
<c:choose>	
<c:when test="${admin eq null }">
<c:import url="/admin/menuadminsidebar.jsp"/>
<p id= "red"><c:out value="${mensagem}" default=""/></p></br>

<h2>Bem vindo.</h2></br>
        <h3>Para acessar o Painel administrativo, efetue o login no formulário ao lado.</h3>

        
    </c:when>
    <c:otherwise>
   	
    	<c:import url="/admin/menuadminsidebar.jsp"/>

      <p id= "red"> <c:out value="${mensagem}" default=""/></p></br>
	
		<c:import url="/admin/MonografiasParaPublicar.jsp" />
    </c:otherwise>
  </c:choose>



</body>
</html>
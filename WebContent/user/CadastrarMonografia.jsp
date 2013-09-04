<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Erro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  <script
 src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
 type="text/javascript"></script>
<script
 src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
 type="text/javascript"></script>
<script
 src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"
 type="text/javascript"></script>
<script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script>
<script src="/resources/scripts/date.js" type="text/javascript"></script>
 
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="../style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Monografia</title>
</head>
<body id="body">
<c:import url="/header.jsp" />
<c:choose>	
<c:when test="${user eq null }">
<c:import url="/user/UserSidebar.jsp" />
        <h2>Bem vindo </h2>
	<h1>Você precisa fazer o login antes de continuar</h1>
	

    </c:when>
    <c:otherwise>
   	
    	<c:import url="/user/UserSidebar.jsp" />
    	<h1>Bem Vindo, ${user.login}</h1>
       <p id= "red"><c:out value="${mensagem}" default=""/></p></br>
       <div id= "form">
       <form id="FormularioCadUser"action="\Monografias\CadastrarMonografia.do?ref=cadastrarMonografia" method="POST">
		<p>
			<label for="nome">Título da monografia:</label>
			<input type="text" name="nome">
		</p>
		<p>
			<label for="nomeInstituicao">Nome da Instituição:</label><input type="text" name="nomeInstituicao">
		</p>
		<p>
		<label for="matricula">	Matricula:</label> <input type="text" name="matricula">
		</p>
		<p>
			<label for="nota">Nota:</label> <input type="text" name="nota">
		</p>
		<p>
			<label for="nomeCurso">Curso:</label> <input type="text" name="nomeCurso">
		</p>
		<p>
			<label for="arquivo">Arquivo:</label> <input id="filechoose" type="file" name="arquivo">
		</p>
		<p>
			<input type="submit" value="Cadastrar">
		</p>



	</form>
	
		</div>
    </c:otherwise>
  </c:choose>



</body>
</html>
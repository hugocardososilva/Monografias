<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Erro.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="../style.css">

<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body id="body">
<c:import url="/header.jsp" />
<c:import url="/user/UserSidebar.jsp" />

	<form action="\Monografias\CadastrarUsuario.do?ref=cadastrar" method="POST">
		<p>
			Nome de Usuário: <input type="text" name="login">
		</p>
		<p>
			Senha:<input type="password" name="senha">
		</p>
		<p>
			Repetir senha: <input type="password" name="senha2">
		</p>
		<p>
			CPF: <input type="text" name="cpf">
		</p>
		<p>
			Endereço: <input type="text" name="endereco">
		</p>
		<p>
			Instituição de ensino: <input type="text" name="instituicao">
		</p>
		<p>
			Email: <input type="text" name="email">
		</p>
		<p>
			Nível Educacional: <input type="text" name="nivel">
		</p>
		<p>
			<input type="submit" value="Cadastrar">
		</p>



	</form>

</body>
</html>
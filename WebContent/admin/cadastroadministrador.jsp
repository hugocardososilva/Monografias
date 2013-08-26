<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CadastraAdmin.do?ref=cadastrarAdmin" method="POST">
		<p>
			Nome de Usuário: <input type="text" name="nome">
		</p>
		<p>
			Senha:<input type="password" name="senha">
		</p>
		<p>
			Repetir senha: <input type="password" name="senha2">
		</p>
		
		<p>
			Endereço: <input type="text" name="endereco">
		</p>
		
		<p>
			Email: <input type="text" name="email">
		</p>
		<p>
		<c:forEach var="funcao" items="${ConexaoFuncao}" >
			Função <select name="funcao" size="4" multiple>
					<option value="1">Domingo</option>
					<option value="2" selected>Segunda</option>
					<option value="3">Terça</option>
					<option value="4">Quarta</option>
		</select>
		</c:forEach>
		</p>
		<p>
			<input type="submit" name="Cadastrar">
		</p>



	</form>

</body>
</html>
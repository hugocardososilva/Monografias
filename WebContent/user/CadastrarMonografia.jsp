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

<form action="\Monografias\CadastrarMonogradia.do?ref=cadastrarMonografia" method="POST">
		<p>
			Título da monografia: <input type="text" name="nome">
		</p>
		<p>
			Nome da Instituição:<input type="text" name="nomeInstituicao">
		</p>
		<p>
			Matricula <input type="text" name="matricula">
		</p>
		<p>
			Nota: <input type="text" name="nota">
		</p>
		<p>
			Curso: <input type="text" name="nomeCurso">
		</p>
		<p>
			Arquivo: <input type="text" name="instituicao">
		</p>
		<p>
			<input type="submit" value="Cadastrar">
		</p>



	</form>

</body>
</html>
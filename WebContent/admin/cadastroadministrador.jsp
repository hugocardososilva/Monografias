
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
pageContext.setAttribute("funcao", lista);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="\Monografias\CadastrarAdmin.do?ref=cadastrarAdmin" method="POST">
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
			Telefone: <input type="text" name="telefone">
		</p>
		<p>
			Email: <input type="text" name="email">
		</p>
		<p>
		Função <select name="funcao" size="4" multiple>
		<c:forEach var="item" items="${funcao}" >
			
					<option value="${item.codigo}">${item.privilegios}</option>
					
		
		</c:forEach>
		</select>
		</p>
		<p>
			<input type="submit" value="Cadastrar">
		</p>



	</form>

</body>
</html>
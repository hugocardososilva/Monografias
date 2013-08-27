<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

</head>

<div id="sidebar">


<form action="\Monografias\LogarAdmin.do?ref=logar" method="post">
<p>
			Email: <input type="text" name="email">
		</p>
		<p>
			Senha:<input type="password" name="senha">
		</p>
		<input type="submit" value="Logar">
		
</form>
<p>
<a href="<c:url value='admin/cadastroadministrador.jsp'/>">Cadastrar novo Administrador</a></br>
<a href="<c:url value='admin/cadastrarfuncao.jsp'/>">Cadastrar Função</a>
</p>
</div>
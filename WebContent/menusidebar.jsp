<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="sidebar">

<a href="<c:url value='user/cadastrousuario.html'/>">Clique para cadastrar</a>
<form action="LogarUsuario.do?ref=logar" method="post">
<p>
			Nome de Usuário: <input type="text" name="login">
		</p>
		<p>
			Senha:<input type="password" name="senha">
		</p>
		<input type="submit" value="Logar">
</form>

</div>


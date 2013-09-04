<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

</head>

<div id="sidebar">
<p>Painel Administrativo
</p>


<p>
<c:choose>
	<c:when test="${admin == null }">
		<form action="\Monografias\LogarAdmin.do?ref=logar" method="post">
			<p>
			Email: <input type="text" name="email">
			</p>
			<p>
			Senha:<input type="password" name="senha">
			</p>
				<input type="submit" value="Logar">
		
		</form>
		</br>
		<li>
		<a href="<c:url value='/user/user.jsp'/>">Logar como Usuário</a></br>
		</li>
 	</c:when>  
	<c:otherwise> 
		<p>Bem Vindo ${admin.email}</p>
		<li>
		<a href="<c:url value='/LogoffUsuario.do'/>">Fazer Logoff</a></br>
		</li>
		<li>
<a href="<c:url value='/admin/cadastroadministrador.jsp'/>">Cadastrar novo Administrador</a></br>
</li>
<li>
<a href="<c:url value='/admin/cadastrarfuncao.jsp'/>">Cadastrar Função</a>
</li>
	</c:otherwise>
</c:choose></br>
</br>
</br>

</p>
</div>
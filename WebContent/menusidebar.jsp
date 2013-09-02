<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:choose>
<c:when test="${admin == null}">
		<div id="sidebar">

<li><a href="<c:url value='user/cadastrousuario.html'/>">Clique para cadastrar</a>
</li>
<form action="LogarUsuario.do?ref=logar" method="post">
<p>
			Nome de Usuário: <input type="text" name="login">
		</p>
		<p>
			Senha:<input type="password" name="senha">
		</p>
		<input type="submit" value="Logar">
		
</form>
</br></br></br>
	<li>
		<a href="<c:url value='admin/adminpainel.jsp'/>">Área Restrita</a>
	</li>
	</div>
</c:when>
<c:otherwise>
	<c:import url="admin/menuadminsidebar.jsp"/>
	</div>
</c:otherwise>
</c:choose>



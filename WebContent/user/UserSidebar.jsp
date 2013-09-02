<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <div id="sidebar">
	
    
    
    <c:choose>
<c:when test="${user == null}">
		


<form action="/Monografias/LogarUsuario.do?ref=logar" method="post">
<p>
			Nome de Usuário: <input type="text" name="login">
		</p>
		<p>
			Senha:<input type="password" name="senha">
		</p>
		<input type="submit" value="Logar">
		
</form>
</br></br></br>
<li><a href="<c:url value='user/cadastrousuario.html'/>">Clique para cadastrar</a>
</li>
	<li>
		<a href="<c:url value='admin/adminpainel.jsp'/>">Área Restrita</a>
	</li>
	
</c:when>
<c:otherwise>
	<li>
		<a href="<c:url value='user/CadastrarMonografia.jsp'/>">Cadastrar Monografia</a></br>
	</li>
	<li>
		<a href="<c:url value='LogoffUsuario.do'/>">Fazer Logoff</a>
	</li>
	<li>
		<a href="<c:url value='admin/adminpainel.jsp'/>">Área Restrita</a></br>
	</li>
    
	
</c:otherwise>
</c:choose>
  </div>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura"%>

<c:import url="/WEB-INF/jsp/header.jsp" /><br>
<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">

	<label for="nome">Nome:</label> <input type="text" id="nome"
		name="usuario.nome" class="form-control" />
	<alura:validationMenssage name="usuario.nome" />

	<label for="email">E-mail:</label> <input type="text"
		name="usuario.email" id="email" class="form-control"
		value="${usuario.email}" />
	<alura:validationMenssage name="usuario.email" />

	<label for="login">Login:</label> <input type="text"
		name="usuario.login" id="login" class="form-control"
		value="${usuario.login}" />
	<alura:validationMenssage name="usuario.login" />

	<label for="senha">Senha:</label> <input type="password"
		name="usuario.senha" id="senha" class="form-control" />
	<alura:validationMenssage name="usuario.senha" />

	<input type="submit" value="Cadastrar" class="btn" />
</form>
<c:import url="/WEB-INF/jsp/footer.jsp" />
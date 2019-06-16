<%@ page language="java" import="bd.BD,bd.core.*,bd.daos.*, bd.dbos.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>WIKI</title>

</head>
<body>
	<!--DETECTA USUARIO LOGADO-->
	<%


		MeuResultSet tema = BD.TEMAS.getTemas();
		MeuResultSet tema2 = BD.TEMAS.getTemas();
		MeuResultSet tema3 = BD.TEMAS.getTemas();
	%>
	
	
<section class="container-fluid">


		<!-- Menu -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">WikiLearn</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<section class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Entrar </a>
						<section class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Login</a>
							<section class="dropdown-divider"></section>
							<a class="dropdown-item" href="#">Cadastrar</a>
							<section class="dropdown-sectionider"></section>
							<a class="dropdown-item" href="#">Upgrade conta</a>
						</section></li>
					<li class="nav-item active"><a class="nav-link" href="#">Conta
							Premium <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">Contato
							<span class="sr-only">(current)</span>
					</a></li>

					<li class="nav-item active"><a class="nav-link" href="#">Sobre
							<span class="sr-only">(current)</span>
					</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Buscar" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
				</form>
			</section>
		</nav>

		<!-- Login -->

	</section>
	<section class="col-md-8 order-md-1">
		<h4 class="mb-3">Formu�rio para cadastro de usu�rio</h4>
		<form class="needs-validation" method="get" action="Cadastro_usuario"
			novalidate>
			<section class="row">
				<section class="col-md-6 mb-3">
					<label for="firstName">Primeiro nome</label> <input type="text"
						class="form-control" id="firstName" name="firstName"
						placeholder="" value="" required>
					<section class="invalid-feedback">Por favor entre com o
						seu primeiro nome.</section>
				</section>
				<section class="col-md-6 mb-3">
					<label for="lastName">Sobrenome </label> <input type="text"
						class="form-control" id="lastName" name="lastName" placeholder=""
						value="" required>
					<section class="invalid-feedback">Por favor entre com o
						seu sobrenome.</section>
				</section>
			</section>

			<section class="mb-3">
				<label for="username">Nome de usu�rio</label>
				<section class="input-group">
					<section class="input-group-prepend">
						<span class="input-group-text">#</span>
					</section>
					<input type="text" class="form-control" id="username"
						name="username" placeholder="Nome de usu�rio" required>
					<section class="invalid-feedback" style="width: 100%;">
						Nome de usu�rio obrigat�rio</section>
				</section>
			</section>

			<section class="mb-3">
				<label for="email">Email <span class="text-muted">(Obrigat�rio)</span></label>
				<input type="email" class="form-control" id="email" name="email"
					placeholder="teste@exemplo.com" required>
				<section class="invalid-feedback">Por favor entre com um
					valor v�lido conforme indicado</section>
			</section>
			<section class="mb-3">
				<label for="password">Senha</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="8 digitos no minimo" required>
				<section class="invalid-feedback">Por favor entre com uma
					senha valida.</section>
			</section>
			<section class="row">
				<section class="col-md-3 mb-3">
					<label for="data_nascimento">Data Nascimento</label> <input
						type="date" class="form-control" id="data_nascimento"
						name="data_nascimento" placeholder="" value="" required>
					<section class="invalid-feedback">Por favor entre com
						data valida.</section>
				</section>

			</section>

	<section class="row">
		<section class="col mb-3">
		<label for="data_nascimento">Deseja postar materiais/artigos na plataforma</label>
			<section class="form-check">
			  <input class="form-check-input" type="checkbox" name="publica" value="1" id="publica">
			  <label class="form-check-label" for="defaultCheck1">
			    SIM
			  </label>
			</section>
		</section>
	</section>
			
			<h5 class="mb-3">Cadastro de curr�culo</h5>
			<h6 class="mb-3">Nesta parte do cadastro voc� deve informar os
				seus conhecimentos na �rea de tecnologia</h6>
			<label for="information">Informar 2 assuntos de maior
				conhecimento na �rea de tecnologia</label>
			<section class="row">
				
				<select name="assunto1" id="assunto1" class="custom-select col-md-4" id="inputGroupSelect02">
						<option  selected>Escolha o tema da publica��o...</option>
						<%
								while (tema2.next()) {
							%><option  value="<%=tema2.getString("ID")%>"><%=tema2.getString("TEMA")%> </option>
							<%} %>
					</select>
				<select name="assunto2" id="assunto2" class="custom-select col-md-4" id="inputGroupSelect02">
						<option  selected>Escolha o tema da publica��o...</option>
						<%
								while (tema3.next()) {
							%><option  value="<%=tema3.getString("ID")%>"><%=tema3.getString("TEMA")%> </option>
							<%} %>
					</select>

			</section>
			
				<section class="form-group">
					<label for="exampleFormControlTextarea1">Descri��o</label>
					<textarea name ="summary" class="form-control" id="summary"
						rows="4"></textarea>
				</section>


			<hr class="mb-4">
			<button class="btn btn-primary btn-lg btn-block mb-5" type="submit">Cadastrar</button>
		</form>



		<script src="valida_login.js"></script>
	</section>
</body>

</section>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</body>
</html>
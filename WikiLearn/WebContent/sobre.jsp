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

<title>SOBRE | WIKI</title>
<!-- Custom styles for this template -->
<link href="sobre.css" rel="stylesheet">

<style>
	.bd-placeholder-img {
	  font-size: 1.125rem;
	  text-anchor: middle;
	  -webkit-user-select: none;
	  -moz-user-select: none;
	  -ms-user-select: none;
	  user-select: none;
	}

	@media (min-width: 768px) {
	  .bd-placeholder-img-lg {
		font-size: 3.5rem;
	  }
	}
  </style>
</head>
<body>
	<!--DETECTA USUARIO LOGADO-->
	<%
		Usuario user = (Usuario) session.getAttribute("usuario");
		MeuResultSet resultado = BD.USUARIOS.getUsuarioLogado(user.getEmail());
		MeuResultSet tema = BD.TEMAS.getTemas();

		Usuario user_next = new Usuario(user.getEmail());
		HttpSession session_next = request.getSession();
		session.setAttribute("usuario", user);
	%>




	<!--DETECTA USUARIO LOGADO-->

	<section class="container-fluid">
			<!-- Menu -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="index_login.jsp">WikiLearn</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<section class="collapse navbar-collapse" id="navbarSupportedContent">
			
				<ul class="navbar-nav mr-auto">
					 <%
 	while (resultado.next()) {%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
  <%=resultado.getString("NICK")%><% 
 	}
 %>
					</a>
						<section class="dropdown-menu" aria-labelledby="navbarDropdown">
							
							<section class="dropdown-sectionider"></section>
							<a class="dropdown-item" href="index3.html">Sair</a>
						</section></li>

					<li class="nav-item active"><a class="nav-link" href="sugerir_tema.jsp">Sugerir tema <span class="sr-only">(current)</span>
					</a></li>
					
					<li class="nav-item active"><a class="nav-link"
						href="lista_tema.jsp">Temas<span class="sr-only">(current)</span>
					</a></li>
					<!-- Caso o usu�rio seja admin -->
					<% if (BD.USUARIOS.IsAdmin(user.getEmail())){ %>
					<li class="nav-item active"><a class="nav-link" href="avaliar_sugestao.jsp">Sugest�es tema<span class="sr-only">(current)</span></a></li>
					<%} %>
					
					<!-- Caso o usu�rio seja PUBLICADOR -->
					<% if (BD.USUARIOS.IsPublicador(user.getEmail())){ %>
					<li class="nav-item active"><a class="nav-link" href="material_user.jsp">Minhas Publica��es
							<span class="sr-only">(current)</span>
					</a></li>
					<%} %>
					<li class="nav-item active"><a class="nav-link" href="sobre.jsp">Sobre
							<span class="sr-only">(current)</span>
					</a></li>
					
						<!-- Caso o usu�rio seja PUBLICADOR -->
					<% if (BD.USUARIOS.IsPublicador(user.getEmail())){ %>
					<li class="nav-item active"><a class="nav-link"
						href="upload_file.jsp">Upload Material <span class="sr-only">(current)</span>
					</a></li>
					<%} %>
					
					<li class="nav-item active"><a class="nav-link"
						href="forum_inicial.jsp">F�rum<span class="sr-only">(current)</span>
					</a></li>
				</ul>
	
				<form class="form-inline my-2 my-lg-0" method="get" action= "material.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Buscar Tema" aria-label="Search" name="material">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
				</form>
			</section>
		</nav>
		
		
		
		
			<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-color">
			<div class="wiki col-md-4 p-lg-4 my-4">
				<img src="img/logo-transparent.png" class="image-logo" alt="">
				<p class="lead font-weight-normal font-color">Uma plataforma de aprendizagem compartilhada, onde voc� pode aprender novos assuntos, tirar suas d�vidas e ajudar na cria��o e manuten��o de conte�dos.</p>
			  <a class="btn btn-outline-secondary btn-color" href="#">Em breve</a>
			</div>
			<div class="imagem-wiki shadow-sm d-none d-md-block"></div>
			<!-- <div class="product-device shadow-sm d-none d-md-block"></div>
			<div class="product-device product-device-2 shadow-sm d-none d-md-block"></div> -->
		  </div>
		  
		  <div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
			<div class="bg-topicos-color mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			  <div class="my-3 py-3">
				<h2 class="display-5">T�picos preestabelecidos</h2>
				<p class="lead">Pesquise e estude em cima de t�picos sobre assuntos de seu interesse.</p>
			  </div>
			  <div class="bg-light shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"><img src="img/topicos.png"></div>
			</div>
			<div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
			  <div class="my-3 p-3">
				<h2 class="display-5">Crie novos conte�dos</h2>
				<p class="lead">Sinta-se a vontade para criar um novo t�pico ou assunto para um t�pico j� existente. </p>
			  </div>
			  <div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"><img src="img/crie-novos.png"></div>
			</div>
		  </div>
		  
		  <div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
			<div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
			  <div class="my-3 p-3">
				<h2 class="display-5">Tenha seus materiais de estudo a qualquer momento</h2>
				<p class="lead">Nossa plataforma permite que voc� baixe seus documentos em formato de pdf, para que voc� possa acess�-los offline.</p>
			  </div>
			  <div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"><img src="img/nuvem	.png"></div>
			</div>
			<div class="bg-nosso-forum-color mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
			  <div class="my-3 py-3">
				<h2 class="display-5">Nosso f�rum</h2>
				<p class="lead">Cada t�pico e assuntos desse t�pico possui seu pr�prio espa�o no nosso f�rum para tornar poss�vel que a nossa comunidade discuta sobre o assunto abordado.</p>
			  </div>
			  <div class="bg-light shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"><img src="img/nosso-forum.png" alt=""></div>
			</div>
		  </div>
		
		
		
		
		
		
		
		
		
		
		
		
</section>
<footer class="container py-5">
		<section class="row">
			<section class="col-12 col-md">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					fill="none" stroke="currentColor" stroke-linecap="round"
					stroke-linejoin="round" stroke-width="2" class="d-block mb-2"
					role="img" viewBox="0 0 24 24" focusable="false">
					<title>Product</title><circle cx="12" cy="12" r="10" />
					<path
						d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" /></svg>
				<small class="d-block mb-3 text-muted">&copy; WikiLearn</small>
			</section>
			<section class="col-6 col-md">
				<h5>Novidades</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Novos conteudos</a></li>
					<li><a class="text-muted" href="#"></a></li>
					<li><a class="text-muted" href="#">Team feature</a></li>
					<li><a class="text-muted" href="#">Stuff for developers</a></li>
					<li><a class="text-muted" href="#">Another one</a></li>
					<li><a class="text-muted" href="#">Last time</a></li>
				</ul>
			</section>
			<section class="col-6 col-md">
				<h5>Resources</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Resource</a></li>
					<li><a class="text-muted" href="#">Resource name</a></li>
					<li><a class="text-muted" href="#">Another resource</a></li>
					<li><a class="text-muted" href="#">Final resource</a></li>
				</ul>
			</section>
			<section class="col-6 col-md">
				<h5>Resources</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Business</a></li>
					<li><a class="text-muted" href="#">Education</a></li>
					<li><a class="text-muted" href="#">Government</a></li>
					<li><a class="text-muted" href="#">Gaming</a></li>
				</ul>
			</section>
			<section class="col-6 col-md">
				<h5>Sobre</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Equipe desenvolvedora</a></li>
					<li><a class="text-muted" href="#">Localiza��o</a></li>
					<li><a class="text-muted" href="#">Termos legais</a></li>
				</ul>
			</section>
		</section>
	</footer>
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
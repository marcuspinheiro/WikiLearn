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
							<a class="dropdown-item" href="index.html">Sair</a>
						</section></li>

					<li class="nav-item active"><a class="nav-link" href="sugerir_tema.jsp">Sugerir tema <span class="sr-only">(current)</span>
					</a></li>
					
					<li class="nav-item active"><a class="nav-link"
						href="lista_tema.jsp">Temas<span class="sr-only">(current)</span>
					</a></li>
					<!-- Caso o usuário seja admin -->
					<% if (BD.USUARIOS.IsAdmin(user.getEmail())){ %>
					<li class="nav-item active"><a class="nav-link" href="avaliar_sugestao.jsp">Sugestões tema<span class="sr-only">(current)</span></a></li>
					<%} %>
					
					<!-- Caso o usuário seja PUBLICADOR -->
					<% if (BD.USUARIOS.IsPublicador(user.getEmail())){ %>
					<li class="nav-item active"><a class="nav-link" href="material_user.jsp">Minhas Publicações
							<span class="sr-only">(current)</span>
					</a></li>
					<%} %>
					<li class="nav-item active"><a class="nav-link" href="#">Sobre
							<span class="sr-only">(current)</span>
					</a></li>
					
						<!-- Caso o usuário seja PUBLICADOR -->
					<% if (BD.USUARIOS.IsPublicador(user.getEmail())){ %>
					<li class="nav-item active"><a class="nav-link"
						href="upload_file.jsp">Upload Material <span class="sr-only">(current)</span>
					</a></li>
					<%} %>
					
					<li class="nav-item active"><a class="nav-link"
						href="forum_inicial.jsp">Forúm<span class="sr-only">(current)</span>
					</a></li>
				</ul>
	
				<form class="form-inline my-2 my-lg-0" method="get" action= "material.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Buscar Tema" aria-label="Search" name="material">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
				</form>
			</section>
		</nav>


		<!-- Carousel -->
		<section class="bd-example mb-5">
		  <section id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
		    <ol class="carousel-indicators">
		      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
		      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
		      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		    </ol>
		    <section class="carousel-inner">
		      <section class="carousel-item active">
		        <img src="img/imagem3.jpg" class="d-block w-100" alt="...">
		        <section class="carousel-caption d-none d-md-block">
		          <h5 class="text-dark">O conteúdo em suas mãos</h5>
		          <p class="text-dark">Uma forma moderna e fácil de compartilhar material.</p>
		        </section>
		      </section>
		      <section class="carousel-item">
		        <img src="img/imagem6.png" class="d-block w-100" alt="...">
		        <section class="carousel-caption d-none d-md-block">
		          <h5 class="text-dark">Segurança dos dados</h5>
		          <p class="text-dark">Segurança garantida no compartilhamento de dados.</p>
		        </section>
		      </section>
		      <section class="carousel-item">
		        <img src="img/imagem5.png" class="d-block w-100" alt="..." href="sobre.html">
		        <section class="carousel-caption d-none d-md-block">
		          <h5 class="text-dark">Conheça a plataforma</h5>
		          <p class="text-dark">Veja como obter um melhor uso da plataforma.</p>
		        </section>
		      </section>
		    </section>
		    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
		      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
		      <span class="carousel-control-next-icon" aria-hidden="true"></span>
		      <span class="sr-only">Next</span>
		    </a>
		  </section>
		</section>

		<!-- Cards -->

		<section class="row">
			<section class="col">

				<section class="card" style="width: 18rem;">
					<img class="d-block img-fluid"
						src="img/imagem3.jpg" alt="first_slide">
					<section class="card-body">
						<h5 class="card-title">O conteúdo em suas mãos</h5>
						<p class="card-text">Uma forma moderna e fácil de compartilhar material.</p>
						<a href="sobre.html" class="btn btn-primary">Veja mais</a>
					</section>
				</section>

			</section>
			<section class="col">

				<section class="card" style="width: 18rem;">
					<img class="d-block img-fluid"
						src="img/imagem6.png" alt="first_slide">
					<section class="card-body">
						<h5 class="card-title">Segurança dos dados</h5>
						<p class="card-text">Segurança garantida no compartilhamento de dados.</p>
						<a href="sobre.html" class="btn btn-primary">Veja mais</a>
					</section>
				</section>

			</section>
			<section class="col">

				<section class="card" style="width: 18rem;">
					<img class="d-block img-fluid"
						src="img/imagem5.png" alt="first_slide">
					<section class="card-body">
						<h5 class="card-title">Conheça a plataforma</h5>
						<p class="card-text">Veja como obter um melhor uso da plataforma.</p>
						<a href="sobre.html" class="btn btn-primary">Veja mais</a>
					</section>
				</section>

			</section>
		</section>

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
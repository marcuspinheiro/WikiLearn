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
		MeuResultSet resultado2 = BD.USUARIOS.getUsuarioLogado(user.getEmail());

		MeuResultSet tema = BD.TEMAS.getTemas();

		MeuResultSet tema2 = BD.TEMAS.getTemas();
		
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
					<li class="nav-item active"><a class="nav-link" href="sobre.jsp">Sobre
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

		<!-- Upload file -->

		<section class="col-md-8 order-md-1">
			<h4 class="mb-3 text-center">Formuário para cadastro de usuário</h4>



			<form method="post" action="uploadServlet" enctype="multipart/form-data">
				<section class="row col-md-3 mb-20">
					<label for="firstName">Propietário</label> <input type="text"
						class="form-control" id="nome" name="nome" placeholder=""
						value="<%while (resultado2.next()) {%> <%=resultado2.getString("NICK")%><%}%>"
						required readonly>
				</section>
				<section>
					<label for="titulo">Titulo</label> <input type="text"
						class="form-control mb-4 col-md-3" id="titulo" name="titulo"
						placeholder="" value="" required>
					<section class="invalid-feedback">Por favor entre com o
						titulo da publicação.</section>
				</section>



				<section class="input-group ">
				
					<select name="option" id="option" class="custom-select col-md-4" id="inputGroupSelect02">
						<option  selected>Escolha o tema da publicação...</option>
						<%
								while (tema2.next()) {
							%><option  value="<%=tema2.getString("ID")%>"><%=tema2.getString("TEMA")%> </option>
							<%} %>
					</select>
					<section class="input-group-append mb-4">
						<label class="input-group-text" for="inputGroupSelect02">Options</label>
					</section>
				</section>


				<section class="form-group">
					<label for="exampleFormControlFile1">Arquivo</label> <input
						type="file" class="form-control-file" id="photo" name="photo">
				</section>


				<section class="form-group">
					<label for="exampleFormControlTextarea1">Descrição</label>
					<textarea name ="descricao" class="form-control" id="exampleFormControlTextarea1"
						rows="3"></textarea>
				</section>
		<input type="hidden" id = "codigo" name="codigo" value="0">
				<input type="hidden" name="acao" id ="acao" value="1">
				<button class="btn btn-primary btn-lg btn-block col-md-3"
					type="submit">Cadastrar</button>
			</form>



			<script src="valida_login.js"></script>
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
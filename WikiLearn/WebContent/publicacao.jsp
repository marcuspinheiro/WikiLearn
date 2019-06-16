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
		MeuResultSet resultado3 = BD.USUARIOS.getUsuarioLogado(user.getEmail());
		MeuResultSet tema = BD.TEMAS.getTemas();
		
		String codigo = request.getParameter("codigo");
		
		MeuResultSet publicacao = BD.MATERIAIS.getPublicacao(codigo);
		MeuResultSet publicacao_data = BD.MATERIAIS.getPublicacao_data(codigo);
		MeuResultSet publicacao_descricao = BD.MATERIAIS.getPublicacao_descricao(codigo);
		MeuResultSet publicacao_avaliacao = BD.MATERIAIS.getPublicacao_avaliacao(codigo);
		MeuResultSet publicacao_autor = BD.MATERIAIS.getPublicacao_autor(codigo);
		MeuResultSet publicacao_tema = BD.MATERIAIS.getPublicacao_tema(codigo);
		MeuResultSet publicacao_file_name =  BD.MATERIAIS.getPublicacao_file_name(codigo);
		MeuResultSet publicacao_codigo =  BD.MATERIAIS.getPublicacao_codigo(codigo);
		MeuResultSet publicacao_codigo2 =  BD.MATERIAIS.getPublicacao_codigo(codigo);
		MeuResultSet publicacao_codigo3 =  BD.MATERIAIS.getPublicacao_codigo(codigo);
		
		MeuResultSet nota = BD.AVALIACAO_MATERIAIS.getNota(user.getEmail(), Integer.parseInt(codigo));
		
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
							<a class="dropdown-item" href="login.html">Meu Perfil</a>
							<section class="dropdown-divider"></section>
							<a class="dropdown-item" href="#">Upgrade de conta</a>
							<section class="dropdown-sectionider"></section>
							<a class="dropdown-item" href="index.html">Sair</a>
						</section></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Materiais </a>
						<section class="dropdown-menu" aria-labelledby="navbarDropdown">
							<%
					 	while (tema.next()) {
					 		%><a class="dropdown-item" name="material" href="#"><% 
					 %> <%=tema.getString("TEMA")%> 
					 </a><% }
					 %>
							<section class="dropdown-sectionider"></section></li>
					<li class="nav-item active"><a class="nav-link" href="sugerir_tema.jsp">Sugerir tema <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">Contato
							<span class="sr-only">(current)</span>
					</a></li>

					<li class="nav-item active"><a class="nav-link" href="#">Sobre
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="upload_file.jsp">Upload <span class="sr-only">(current)</span>
					</a></li>
				</ul>
	
				<form class="form-inline my-2 my-lg-0" method="get" action= "material.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Buscar Tema" aria-label="Search" name="material">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
				</form>
			</section>
		</nav>



<h1 class="text-center"><%
 	while (publicacao.next()) {
 %> <%=publicacao.getString("TITULO")%> <%
 	}
 %></h1>

 <form class = "mb-5" method="get" action="downloadFiles">

			 <%
			 	while (publicacao_codigo.next()) {
			 %>  
			 <input type="hidden" id = "codigo" name="codigo" value="<%=publicacao_codigo.getString("ID")%>">
			 <%
			 	}
			 %>
			 
			<h4>Descrição:</h4>
			
			<section class="shadow-sm p-3 mb-5 bg-white rounded">
			<p><%
			 	while (publicacao_descricao.next()) {
			 %> <%=publicacao_descricao.getString("DESCRICAO")%> <%
			 	}
			 %></p>
			 </section>
			 
			<h4>Data Publicação:</h4>
			<section class="shadow-sm p-3 mb-5 bg-white rounded">
			<p>
			<%
			 	while (publicacao_data.next()) {
			 %> <%=publicacao_data.getString("DATA_PUBLICACAO")%> <%
			 	}
			 %> 
			 </section>
			 
			<h4>Tema Publicação:</h4> 
			<section class="shadow-sm p-3 mb-5 bg-white rounded">
			<p>
			<%
			 	while (publicacao_tema.next()) {
			 %> <%=publicacao_tema.getString("TEMA")%> <%
			 	}
			 %>
			 </p>
			 </section>
			 
			<h4>Nome Arquivo: </h4> 
			<section class="shadow-sm p-3 mb-5 bg-white rounded">
			<p>
			<%
			while (publicacao_file_name.next()) {
			 %> <%=publicacao_file_name.getString("FILE_NAME")%> <%
			 	}
			 %></p>
			 </section>
			 
			 
			 
			<h4>Avaliação Atribuida:</h4>
			<section class="shadow-sm p-3 mb-5 bg-white rounded">
			<p>
			<%
			 	while (publicacao_avaliacao.next()) {
			 %> <%=publicacao_avaliacao.getString("NOTA")%> <%
			 	}
			 %> 
			 
			 </p>
			 </section>
			 <input type="submit" value="download">  
 </form>
 
 <%while(resultado3.next() && publicacao_codigo3.next()) {

 
	if (!BD.AVALIACAO_MATERIAIS.JaValidou(resultado3.getString("NICK"), Integer.parseInt(publicacao_codigo3.getString("ID")))) {%>
		 <!-- Validar publicação -->
			 <form class = "mb-5" method="get" action="Avaliar_publicacao">
			 <%
					 	while (publicacao_codigo2.next()) {
					 %>  
					 <input type="hidden" id = "codigo" name="codigo" value="<%=publicacao_codigo2.getString("ID")%>">
					 <%
					 	}
					 %>
					 
				 <%
					 	while (resultado2.next()) {
					 %>  
					 <input type="hidden" id = "nick" name="nick" value="<%=resultado2.getString("NICK")%>">
					 <%
					 	}
					 %>	 
			 <h4>Avaliar Publicação:</h4>
				<section class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1">
				  <label class="form-check-label" for="inlineRadio1">1</label>
				</section>
				<section class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="2">
				  <label class="form-check-label" for="inlineRadio2">2</label>
				</section>
				<section class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="3">
				  <label class="form-check-label" for="inlineRadio3">3</label>
				</section>
				<section class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" value="4">
				  <label class="form-check-label" for="inlineRadio4">4</label>
				</section>
				<section class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio5" value="5">
				  <label class="form-check-label" for="inlineRadio5">5</label>
				</section>
				<br>
				<br>
				
				<p><input type="submit" value="Enviar"> </p>
			  </form>
  <%} else {
	  
	  %>
	  <h4>Avaliar Publicação:</h4>
	  <label class="text-danger"> Você já votou. Você atribuiu nota  <% 	while (nota.next()) {
			 %> <%=nota.getString("NOTA")%> <%
			 	}
			 %> para a esta publicação</label>
  <% } %>
  
 <% }%> 
  
  
 <h4>Currículo do Propietário:</h4>
 			<section class="shadow-sm p-3 mb-5 bg-white rounded">
				<p>Dono:<%
			 	while (publicacao_autor.next()) {
			 %> <%=publicacao_autor.getString("NICK")%> <%
			 	}
			 %> </p>
				<p>Currículo</p>
			</section>
 
 <% if (BD.MATERIAIS.IsPropietario(user.getEmail())){%>
 
 	<form class="mb-5" method="get" action="">
 		<input type="submit" value="Editar">
 	</form>
 	
 	<form class="mb-5" method="get" action="">
 		<input type="submit" value="Deletar">
 	</form>
 
 
 <%} %>
 
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
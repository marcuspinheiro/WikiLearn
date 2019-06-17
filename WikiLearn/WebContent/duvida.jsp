<%@ page language="java" import="bd.BD,bd.core.*,bd.daos.*, bd.dbos.*, java.util.*"
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
		if(resultado.first())
			user.setId(resultado.getInt("id"));
		
		int idPostagem = Integer.parseInt(request.getParameter("idPostagem"));
		
		Postagem postagem = BD.POSTAGENS.consultaPostagem(idPostagem);
		
		boolean userDono = false;
		
		if(user.getId() == postagem.getDono().getId())
		{
			userDono = true;
		}
	    System.out.println(user.getId() +"==" +postagem.getDono().getId());
		
		List<Comentario> listComentarios = BD.COMENTARIOS.listarComentarios(postagem);
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



<h1 class="text-center">
  <%=postagem.getPergunta()%> 
</h1>


<h3>Autor: % <%=postagem.getDono().getNick()%> 
 	
</h3>

<h4>Data:
 <%=postagem.getData()%> 
 	
  </h4>
  <h4>Status:
 <%=postagem.rStatus()%> 
 	
  </h4>
  <% if(userDono){%>
  
  		  <% if(!postagem.isEncerrado()) { %>
  		<form class="encerrar" method="get" action="encerrarPostagem.jsp">

			
				<input type="hidden" name="idPostagem" id="idPostagem"
				value="<%=idPostagem%>"> 
				<input type="submit" class="btn btn-danger" value="Encerrar">

			</section>

		</form>
		 <% } %>
	
	  
<% } %>
  		
			<% for (int i = 0; i < listComentarios.size(); i++) {%>

			<div class="shadow-sm p-3 mb-5 bg-white rounded">
				<p><%=listComentarios.get(i).getDono().getNick()%> Disse: </p>
				<p><%=listComentarios.get(i).getComentario()%> </p>
			</div>

		<%
			}
		%>
		
		  <% if(!postagem.isEncerrado()) { %>
				<form class="inserirComentario" method="get" action="inserir_comentario.jsp">

						<section>
							<p class="text-secondary">Digite seu comentario:</p>
							<input type="hidden" name="idPostagem" id = "idPostagem" value="<%=idPostagem%>">
							<textarea required="required" maxlength="5000" minlength = "1" class="form-control" placeholder="Digite seu comentário..." name="comentario" id = "comentario"
								rows="3"></textarea>
							<br /> <input type="submit" value="Comentar"> 
							
						</section>

					</form>
		<% }%>

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
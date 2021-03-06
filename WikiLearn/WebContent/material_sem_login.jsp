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
		String material = request.getParameter("material");
		MeuResultSet tema_escolhido = BD.TEMAS.getTemas(material); 
		MeuResultSet tema_escolhido2 = BD.TEMAS.getTemas(material); 
		MeuResultSet tema_pagina = BD.MATERIAIS.getPublicacoes(material);

	%>




	<!--DETECTA USUARIO LOGADO-->

	<section class="container-fluid">
			<!-- Menu -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="index3.html">WikiLearn</a>
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
							<a class="dropdown-item" href="login.html">Login</a>
							<section class="dropdown-divider"></section>
							<a class="dropdown-item" href="cadastro_usuario.jsp">Cadastrar</a>
							<section class="dropdown-sectionider"></section>
						</section></li>
						
											<li class="nav-item active"><a class="nav-link"
						href="lista_tema_sem_login.jsp">Temas<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="sobre.html">Contato
							<span class="sr-only">(current)</span>
					</a></li>

					<li class="nav-item active"><a class="nav-link" href="sobre.html">Sobre
							<span class="sr-only">(current)</span>
					</a></li>
				</ul>
				
				<form class="form-inline my-2 my-lg-0" method="get" action= "material_sem_login.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Buscar Tema" aria-label="Search" name="material">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
				</form>
			</section>
		</nav>



<h1 class="text-center">Trend Topics <%
 	while (tema_escolhido.next()) {
 %> <%=tema_escolhido.getString("TEMA")%> <%
 	}
 %></h1>
 
 
 
 
 <section class="album py-5 bg-light">
    <section class="container">
      <section class="row mb-5">
      


<%
 	while (tema_pagina.next()) {
 %>

       <form class="publicacao" method="get" action="publicacao_sem_login.jsp">

					<section class="card text-black bg-light" style="width: 18rem;">
						<section class="card-body">
							<h5 class="card-title"><%=tema_pagina.getString("TITULO")%></h5>
							<p class="card-text"><%=tema_pagina.getString("DESCRICAO")%></p>
							<input type="hidden" name="codigo" id="codigo" value="<%=tema_pagina.getString("ID")%>" readonly="true">
							<input type="submit" value="Ver publica��o">
						
						</section>
					</section>
				</form>

              
            <%
 	}
 %>   
              
              
              
              

        
        
        
        
      </section>
      
    </section>
  </section>
 
 
      <section>
      
	      <form class="relatorio" method="get" action="relatorio_sem_login.jsp">
	      	<input type="hidden" name="tema" id ="tema" value="<% while (tema_escolhido2.next()) {%> <%=tema_escolhido2.getString("TEMA")%> <%}%>">
	      	<input type="submit" value="Ver rel�torio">
	      </form>
	      
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
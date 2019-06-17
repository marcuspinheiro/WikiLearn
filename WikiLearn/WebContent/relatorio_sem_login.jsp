<%@ page language="java" import="bd.BD,bd.core.*,bd.daos.*, bd.dbos.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt">
<head>

<script src="https://code.jquery.com/jquery-2.1.4.js" integrity="sha256-siFczlgw4jULnUICcdm9gjQPZkw/YPDqhQ9+nAOScE4=" crossorigin="anonymous"></script>
<script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>

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
		
		String tema_relatorio = request.getParameter("tema");
		
		MeuResultSet relatorio = BD.MATERIAIS.getPublicacao_relatorio(tema_relatorio);
		MeuResultSet tema_escolhido = BD.TEMAS.getTemas(tema_relatorio); 

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

		
		
		
<h1 class="text-center">Relatório de <%
 	while (tema_escolhido.next()) {
 %> <%=tema_escolhido.getString("TEMA")%> <%
 	}
 %></h1>
		
<section id="relatorio">
		<%
			while (relatorio.next()) {
			 %>
		<section class="shadow-sm p-3 mb-5 bg-white rounded">
			<p>Título: <%=relatorio.getString("TITULO")%> </p>
			<p>Tema: <%=relatorio.getString("TEMA")%> </p>
			<p>Nota: <%=relatorio.getString("NOTA")%> </p>
			<p>Data Publicação: <%=relatorio.getString("DATA_PUBLICACAO")%> </p>
			<input type="hidden" value= "______________________________________________________________________________________________________">
			
			 </section>
		
		<%
			 	}
			 %>
</section>
<button id="btGerarPDF">gerar PDF</button>
<script>

	var doc = new jsPDF();
	   
	   var imgData = new Image();
	imgData.src = "http://1.bp.blogspot.com/_NiOrby0FW3k/SosVz0roVhI/AAAAAAAACAc/J5VBZivDyHg/S1600-R/IkaroBrasilLogo.PNG";
	
	doc.addImage(imgData, 'JPEG',65,60,80,60);
	doc.setFontSize(10);
	doc.text(39, 284, '_____________________________________________________________________');
	doc.text(95, 290, 'Equipe WikiLearn.');
	
	doc.addPage();
	var specialElementHandlers = {
	   '#editor': function (element, renderer) {
	       return true;
	   }
	};
	
	$('#btGerarPDF').click(function () {
	   doc.fromHTML($('#relatorio').html(), 15, 15, {
	       'width': 170,
	           'elementHandlers': specialElementHandlers
	   });
	
	   doc.save('WikiLearn.pdf');
	});

</script>	
		
		
		
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
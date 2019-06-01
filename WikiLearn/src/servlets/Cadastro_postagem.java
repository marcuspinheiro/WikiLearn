package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import bd.dbos.Postagem;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro_postagem")
public class Cadastro_postagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro_postagem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String duvida = request.getParameter("duvida");			
			
				
			Postagem p = new Postagem();
			p.setPergunta(duvida);

			
			BD.POSTAGENS.inserir(p);
		
//			BD.postagem_CURRICULUMS.incluir(email, assunto1, assunto2, descricao);
			
			response.sendRedirect("sucesso.html");//fazer html para sucesso
			
			
			
		}catch(Exception erro){
			
			response.sendRedirect("erro.html");//fazer html para erro
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

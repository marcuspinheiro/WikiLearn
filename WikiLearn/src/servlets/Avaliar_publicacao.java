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
 * Servlet implementation class Avaliar_publicacao
 */
@WebServlet("/Avaliar_publicacao")
public class Avaliar_publicacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Avaliar_publicacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		try {
			
			String nota = request.getParameter("inlineRadioOptions");			
			int codigo = Integer.parseInt(request.getParameter ("codigo"));

				
			System.out.println(nota);
			
			
			BD.MATERIAIS.avaliacao(codigo, nota);
			
			response.sendRedirect("sucesso.html");//fazer html para sucesso
			
			
			
		}catch(Exception erro){
			
			response.sendRedirect("erro.html");//fazer html para erro
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;

/**
 * Servlet implementation class aceite_sugestao
 */
@WebServlet("/aceite_sugestao")
public class aceite_sugestao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aceite_sugestao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {
						
						String tema = request.getParameter("tema");			
						String descricao = request.getParameter("descricao");		
			
						BD.TEMAS.incluir(tema, descricao);
						
						BD.SUGESTOES.atualizar_insercao(tema, descricao);
						
						response.sendRedirect("avaliar_sugestao.jsp");//fazer html para sucesso
						
						
						
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

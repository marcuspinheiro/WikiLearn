package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import bd.dbos.Usuario;

/**
 * Servlet implementation class deletar_postagem
 */
@WebServlet("/deletar_postagem")
public class deletar_postagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletar_postagem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
try {
			
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			
			BD.MATERIAIS.delete(codigo);
			
			System.out.println("Deletou a postagem");
			response.sendRedirect("material_user.jsp");//fazer html para sucesso
			
			
			
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

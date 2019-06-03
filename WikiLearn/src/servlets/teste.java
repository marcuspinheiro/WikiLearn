package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class teste
 */
@WebServlet("/teste")
public class teste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

try {
			
			//comeca o login
			
			System.out.println("Entrou Marcus");
	
			String nome = request.getParameter("nome");
			String titulo = request.getParameter("titulo");
			String option = request.getParameter("option");
			String photo = request.getParameter("photo");
			String descricao = request.getParameter("descricao");
			
				
			System.out.println(nome);
			System.out.println(titulo);
			System.out.println(option);
			System.out.println(photo);
			System.out.println(descricao);
	
			response.sendRedirect("sucesso.html");

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

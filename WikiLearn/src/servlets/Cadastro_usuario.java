package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import bd.dbos.Usuario;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro_usuario")
public class Cadastro_usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro_usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String nome = request.getParameter("firstName") +" " +request.getParameter("lastName");
			String email = request.getParameter("email");
			String senha = request.getParameter("password");
			String data_nascimento = request.getParameter("data_nascimento");
			String nick = request.getParameter("username");
			String assunto1 = request.getParameter("assunto1");
			String assunto2 = request.getParameter("assunto2");
			String descricao = request.getParameter("summary");
			String publica = request.getParameter("publica");
			
			System.out.println("Teste aqui:" + publica);
			
			
			
			if (BD.USUARIOS.cadastrado(email))
			{
				response.sendRedirect("erro.jsp");
			}else {

			Usuario l = new Usuario(nome, email, senha, data_nascimento, nick);
			
			System.out.println(l.toString());
			
			if (Integer.parseInt(publica) == 1) {
				BD.USUARIOS.incluir(l, Integer.parseInt(publica));
				BD.USUARIO_CURRICULUMS.incluir(assunto1, assunto2, descricao, email);
			}else 
			{
				BD.USUARIOS.incluir(l, 0);
				BD.USUARIO_CURRICULUMS.incluir(assunto1, assunto2, descricao, email);
			}
			
	
			
			response.sendRedirect("login.html");//fazer html para sucesso
			
			}	
			
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

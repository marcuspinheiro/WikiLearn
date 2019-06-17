package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bd.BD;
import bd.dbos.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//comeca o login
			
			String email = request.getParameter("email");
			String senha = request.getParameter("password");
			
				
			System.out.println("Login: email= " + email + " senha= "+ senha);
			 
			
			if (BD.USUARIOS.login(email, senha))
			{
				
				Usuario user = new Usuario(email);
				HttpSession session = request.getSession();
				session.setAttribute("usuario", user);
				
				response.sendRedirect("index_login.jsp");//fazer html para sucesso
				
				
			}else {
				response.sendRedirect("login.html");
			}
			
		}catch(Exception erro){
			
			response.sendRedirect("login.html");//fazer html para erro
			
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

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Index_Logado")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String email;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index(String email)throws Exception {
        
    	if (email==null || email.equals(""))
		throw new Exception ("Email nao fornecido");	
    	
    	this.email = email;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			String email = request.getParameter("email");
			

	        MeuResultSet resultado = BD.USUARIOS.getUsuarioLogado(email);
	     	out.println("<!DOCTYPE html>");
        	out.println("<html>");  
        	out.println("<head> <meta charset=\"ISO-8859-1\"> <title>Cadastro de livros</title></head> <body>");  
	        while(resultado.next()){
	   
	        	out.println(resultado.getInt("EMAIL"));
	        }
	        out.println("</body></html>");
			
		}catch(Exception e) {
			response.sendRedirect("erro.html");
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

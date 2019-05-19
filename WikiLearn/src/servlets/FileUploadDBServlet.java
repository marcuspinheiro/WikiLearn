package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bd.BD;

import bd.dbos.Material;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
     
    // database connection settings

     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
       
    	try {
    	
    	String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
        System.out.println("Marcus");
        
        
        
        
        
        BD.MATERIAIS.incluir(inputStream, firstName);
//		BD.USUARIO_CURRICULUMS.incluir(email, assunto1, assunto2, descricao);
		
		response.sendRedirect("sucesso.html");//fazer html para sucesso

		
		
	}catch(Exception erro){
		
		response.sendRedirect("erro.html");//fazer html para erro
		
	}
    }
}
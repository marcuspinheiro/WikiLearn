package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BD;
import bd.core.MeuResultSet;

/**
 * Servlet implementation class downloadFiles
 */
@WebServlet("/downloadFiles")
public class downloadFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static final int BUFFER_SIZE = 4096; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downloadFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			
			 
			MeuResultSet	result = BD.MATERIAIS.getFile();
		
    	
    	
        if (result.next()) {
            // gets file name and file blob data
            String fileName = result.getString("FILE_NAME");
            Blob blob = result.getBlob("FILE_BYTE");
            InputStream inputStream = blob.getBinaryStream();
            int fileLength = inputStream.available();
             
            System.out.println("fileLength = " + fileLength);

            ServletContext context = getServletContext();

            // sets MIME type for the file download
            String mimeType = context.getMimeType(fileName);
            if (mimeType == null) {        
                mimeType = "application/octet-stream";
            }              
             
            // set content properties and header attributes for the response
            response.setContentType(mimeType);
            response.setContentLength(fileLength);
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileName);
            response.setHeader(headerKey, headerValue);

            // writes the file to the client
            OutputStream outStream = response.getOutputStream();
             
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
             
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
             
            inputStream.close();
            outStream.close();             
        } else {
            // no file found
            response.getWriter().print("File not found for the id: " );  
        }
        
        
		} catch(Exception erro){
			
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

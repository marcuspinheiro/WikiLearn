package bd.daos;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Comentario;
import bd.dbos.Postagem;
import bd.dbos.Usuario;
import log.Log;

public class Avaliacao_materiais {

	private Log log = new Log();

	 public void incluir (String nick, int codigo, int nota) throws Exception
	    {
	       

	        try
	        {
			

	            String sql;

	            sql = "INSERT INTO AVALIACAO_MATERIAL " +
	                  "(USUARIO_ID, MATERIAL_ID, NOTA) "+
	                  "SELECT ID, ?, ? " +
	                  "FROM USUARIO " +
	                  "WHERE USUARIO.NICK = ?  ";
	            
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);
				
	            BD.COMANDO.setInt(1, codigo);
	            BD.COMANDO.setInt(2, nota);
	            BD.COMANDO.setString (3, nick);

	            BD.COMANDO.executeUpdate ();
	            BD.COMANDO.commit        ();
	            
	            
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao inserir sugestões");
	        }
	    }
	
	
	 public boolean JaValidou (String nick, int codigo) throws Exception
	    {
	        boolean retorno = false;

	        try
	        {
	            String sql;

	            sql = "SELECT * " +
	                  "FROM AVALIACAO_MATERIAL " +
	            	  "INNER JOIN USUARIO ON USUARIO.ID = AVALIACAO_MATERIAL.USUARIO_ID "+
	            	  "INNER JOIN MATERIAL ON MATERIAL.ID = MATERIAL_ID "+
	                  "WHERE USUARIO.NICK =? AND MATERIAL.ID =?";

	            
	            
	            BD.COMANDO.prepareStatement (sql);

	            BD.COMANDO.setString (1, nick);
	            BD.COMANDO.setInt(2, codigo); 

	            this.log.printSql(sql);
	            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

	            retorno = resultado.first(); 
	            
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao procurar usuario");
	        }

	        return retorno;
	    }
	
	 
	 public MeuResultSet getNota(String email, int codigo) throws Exception
	    {
	        MeuResultSet resultado = null;

	        try
	        {
	            String sql;

	            sql = "SELECT AVALIACAO_MATERIAL.NOTA " +
	                  "FROM AVALIACAO_MATERIAL " +
	            	  "INNER JOIN USUARIO ON USUARIO.ID = AVALIACAO_MATERIAL.USUARIO_ID "+
	                  "WHERE USUARIO.EMAIL = '"+email+"' AND AVALIACAO_MATERIAL.MATERIAL_ID = "+codigo;
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);
	            
	            
	       
	            
	            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao recuperar usuario");
	        }

	        return resultado;
	    }
	 
	
}

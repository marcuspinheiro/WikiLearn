package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
import log.Log;


public class Sugestoes {

	
	private Log log = new Log();
	
	
	 public void incluir (String nick, String sugestao, String descricao) throws Exception
	    {
	       

	        try
	        {
			

	            String sql;

	            sql = "INSERT INTO SUGESTAO " +
	                  "(USUARIO_ID, TEMA_SUGESTAO, DESCRICAO, STATUS) "+
	                  "SELECT ID, '"+sugestao+"', '"+descricao+"', '0' " +
	                  "FROM USUARIO WHERE NICK = REPLACE('"+nick+"', ' ','')";
	            
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);
				

	            BD.COMANDO.executeUpdate ();
	            BD.COMANDO.commit        ();
	            
	            
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao inserir sugestões");
	        }
	    }

	
	    public MeuResultSet getSugestao() throws Exception
	    {
	        MeuResultSet resultado = null;

	        try
	        {
	            String sql;

	            sql = "SELECT SUGESTAO.TEMA_SUGESTAO, SUGESTAO.DESCRICAO, USUARIO.NICK " +
	                  "FROM SUGESTAO " +
	            	  "INNER JOIN USUARIO ON USUARIO.ID = SUGESTAO.USUARIO_ID " +
	                  "WHERE MATERIAL.STATUS = 0";
	            
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

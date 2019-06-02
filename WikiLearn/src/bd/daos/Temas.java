package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
import log.Log;


public class Temas {

	
	private Log log = new Log();
	
	
	
    public MeuResultSet getTemas () throws Exception
    {
        MeuResultSet resultado = null;

       
        
        try
        {
            String sql;

            sql = "SELECT ID, TEMA " +
                  "FROM TEMA "+
            		"WHERE TEMA <> 'NENHUM'";
           
            this.log.printSql(sql);

            BD.COMANDO.prepareStatement (sql);
            
            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao listar temas");
        }

        return resultado;
    }
    
    
    
    public MeuResultSet getTemas (String tema) throws Exception
    {
        MeuResultSet resultado = null;

       
        
        try
        {
            String sql;

            sql = "SELECT TEMA " +
                  "FROM TEMA "+
            		"WHERE TEMA = '"+ tema +"'";
           
            this.log.printSql(sql);

            BD.COMANDO.prepareStatement (sql);
            
            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao listar temas");
        }

        return resultado;
    }
	
}

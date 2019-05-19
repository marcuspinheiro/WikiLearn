package bd.daos;


import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
import log.Log;
import java.io.InputStream;


public class Materiais {

	
	private Log log = new Log();
	
    public MeuResultSet getMateriais (int tema_id) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TITULO " +
                  "FROM MATERIAIS WHERE TEMA_ID = '" + tema_id + "'";
            
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
	
	
    public MeuResultSet getPublicacao (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TITULO, DATA_PUBLICACAO " +
                  "FROM MATERIAl WHERE ID = " + codigo;
            
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
    
    public MeuResultSet getPublicacao_data (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT   DATA_PUBLICACAO  " +
                  "FROM MATERIAl WHERE ID = " + codigo;
            
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
    
    public MeuResultSet getPublicacao_descricao (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT DESCRICAO  " +
                  "FROM MATERIAl WHERE ID = " + codigo;
            
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
    
    
    public MeuResultSet getPublicacao_avaliacao (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT NOTA  " +
                  "FROM MATERIAl WHERE ID = " + codigo;
            
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
    
    public MeuResultSet getPublicacao_autor (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT USUARIO.NICK  " +
                  "FROM MATERIAl " +
                  "INNER JOIN USUARIO ON USUARIO.ID = MATERIAL.USUARIO_ID "+
            		"WHERE MATERIAL.ID = " + codigo;
            
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
    
    
    public MeuResultSet getPublicacao_tema (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TEMA.TEMA  " +
                  "FROM MATERIAL " +
                  "INNER JOIN TEMA ON TEMA.ID = MATERIAL.TEMA_ID "+
            	  "WHERE MATERIAL.ID = " + codigo;
            
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
    
    
	 public void incluir (InputStream inputStream, String nome) throws Exception
	    {
	        

	        try
	        {
			

	            String sql;

	            sql = "INSERT INTO MATERIAL " +
	                  "(FILE_BYTE, TITULO) " +
	                  "VALUES " +
	                  "(?,?)";
	            
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);

	            BD.COMANDO.setBlob (1, inputStream);
	            BD.COMANDO.setString (2, nome);


				

	            BD.COMANDO.executeUpdate ();
	            BD.COMANDO.commit        ();
	            
	            
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao inserir usuario");
	        }
	    }
    
    public MeuResultSet getPublicacoes (String tema) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT MATERIAL.TITULO, MATERIAL.DESCRICAO, MATERIAL.ID  FROM MATERIAl "+
            	  "INNER JOIN TEMA ON TEMA.ID = MATERIAL.TEMA_ID " +
            	  "WHERE TEMA.TEMA = '"+ tema +"'";
            		
            
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
    
    
    public MeuResultSet getFile () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TITULO, FILE_BYTE  " +
                  "FROM MATERIAL " ;
            
            this.log.printSql(sql);

            BD.COMANDO.prepareStatement (sql);
            
            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar arquivo");
        }

        return resultado;
    }
    
	
}

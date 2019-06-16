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
    
    public MeuResultSet getPublicacao_file_name (String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT FILE_NAME  " +
                  "FROM MATERIAl " +
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
    
    
    public MeuResultSet getPublicacao_codigo(String codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT ID  " +
                  "FROM MATERIAl " +
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
    
    
    public MeuResultSet getPublicacao_relatorio (String tema) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TOP 10 MATERIAL.TITULO, TEMA.TEMA , MATERIAL.NOTA , MATERIAL.DATA_PUBLICACAO " +
                  "FROM MATERIAL " +
                  "INNER JOIN TEMA ON TEMA.ID = MATERIAL.TEMA_ID "+
            	  "WHERE TEMA.TEMA = LTRIM(RTRIM('" + tema+"')) " +
            	  "ORDER BY MATERIAL.NOTA DESC";
            
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
    
    
	 public void incluir (InputStream inputStream, String nome, String descricao, int tema_id, String email, String file_name) throws Exception
	    {
	        

	        try
	        {
			

	            String sql;

	            sql = "INSERT INTO MATERIAL " +
	                  "(FILE_BYTE, TITULO, DESCRICAO, DATA_PUBLICACAO, FILE_NAME, TEMA_ID, USUARIO_ID, NOTA, TOT_NOTA, TOT_AVALIACAO) " +
	                  "SELECT ?, ?, ?, getdate(), ?, ?,  USUARIO.ID, 0, 0, 0 "
	                  + "FROM USUARIO "
	                  + "WHERE USUARIO.NICK = REPLACE('"+ email+"',' ','')";
	                  
	                  
	                  
	    
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);

	            BD.COMANDO.setBlob (1, inputStream);
	            BD.COMANDO.setString (2, nome);
	            BD.COMANDO.setString (3, descricao);
	            BD.COMANDO.setString (4, file_name);
	            BD.COMANDO.setInt (5, tema_id);

				

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
    
    
    
    public MeuResultSet getPublicacoesUser (String email) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT MATERIAL.TITULO, MATERIAL.DESCRICAO, MATERIAL.ID  FROM MATERIAl "+
            	  "INNER JOIN TEMA ON TEMA.ID = MATERIAL.TEMA_ID " +
            	  "INNER JOIN USUARIO ON USUARIO.ID = MATERIAL.USUARIO_ID " +
            	  "WHERE USUARIO.EMAIL = '"+ email +"'";
            		
            
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
    
    
    public void avaliacao (int codigo, String nota) throws Exception
    {
       

       
        try
        {
            String sql;

            sql = "UPDATE MATERIAL " +
            	  "SET NOTA = (TOT_NOTA + "+nota+") / (TOT_AVALIACAO + 1)" +
                  ", TOT_AVALIACAO= TOT_AVALIACAO + 1 " +
            	  ", TOT_NOTA = TOT_NOTA + "+nota+ " "+
                  "WHERE ID = " + codigo;

            this.log.printSql(sql);
            
            BD.COMANDO.prepareStatement (sql);
            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de usuario");
        }
    }
    
    public boolean IsPropietario (String email) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAL " +
                  "INNER JOIN USUARIO ON USUARIO.ID = MATERIAL.USUARIO_ID " +
                  "WHERE USUARIO.EMAIL =? AND PUBLICADOR =1";

            
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);
         

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
    
    public MeuResultSet getFile (int codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT FILE_NAME, FILE_BYTE  " +
                  "FROM MATERIAL " +
            	  "WHERE ID = " + codigo;
            
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

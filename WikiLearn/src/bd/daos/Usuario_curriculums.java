package bd.daos;

import java.sql.SQLException;


import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
import log.Log;

public class Usuario_curriculums {

	private Log log = new Log();
	
	public void incluir (String atributo1, String atributo2, String descricao, String email) throws Exception
    {
        

        try
        {
		

            String sql;

            sql = "INSERT INTO USUARIO_CURRICULUM " +
                  "(USUARIO_ID, ASSUNTO1 ,ASSUNTO2,DESCRICAO) " +
                  "SELECT ID, ?, ?, ? " +
                  "FROM USUARIO " +
                  "WHERE EMAIL = ?";
            
            
            this.log.printSql(sql);

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, atributo1);
            BD.COMANDO.setString (2, atributo2);
            BD.COMANDO.setString (3, descricao);
            BD.COMANDO.setString (4, email);


			

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
            
            
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir usuario");
        }
    }

	
	 public MeuResultSet getCurriculum (int codigo) throws Exception
	    {
	        MeuResultSet resultado = null;

	        try
	        {
	        	
	            String sql;

	            sql = "SELECT USUARIO_CURRICULUM.DESCRICAO, USUARIO.NICK  " +
	                    "FROM USUARIO_CURRICULUM "
	                    + "INNER JOIN USUARIO ON USUARIO.ID = USUARIO_CURRICULUM.USUARIO_ID "
	                    + "INNER JOIN MATERIAL ON MATERIAL.USUARIO_ID = USUARIO.ID "
	                    + "WHERE MATERIAL.ID = ?";
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);
	           
	            BD.COMANDO.setInt (1, codigo);

	            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao recuperar usuario");
	        }

	        return resultado;
	    }
	 
   
	
    public MeuResultSet getCurriculumTema1 (int codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TEMA .TEMA  " +
                  "FROM USUARIO_CURRICULUM "
                  + "INNER JOIN USUARIO ON USUARIO.ID = USUARIO_CURRICULUM.USUARIO_ID "
                  + "INNER JOIN MATERIAL ON MATERIAL.USUARIO_ID = USUARIO.ID "
                  + "INNER JOIN TEMA ON TEMA.ID = USUARIO_CURRICULUM.ASSUNTO1 "
                  + "WHERE MATERIAL.ID = ?";

            BD.COMANDO.prepareStatement (sql);
            
            BD.COMANDO.setInt(1, codigo);


            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar USUARIO");
        }

        return resultado;
    }
    
    
    public MeuResultSet getCurriculumTema2 (int codigo) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT TEMA .TEMA "+
                  "FROM USUARIO_CURRICULUM "
                  + "INNER JOIN USUARIO ON USUARIO.ID = USUARIO_CURRICULUM.USUARIO_ID "
                  + "INNER JOIN MATERIAL ON MATERIAL.USUARIO_ID = USUARIO.ID "
                  + "INNER JOIN TEMA ON TEMA.ID = USUARIO_CURRICULUM.ASSUNTO2 "
                  + "WHERE MATERIAL.ID = ?";
            
            BD.COMANDO.prepareStatement (sql);
            
            BD.COMANDO.setInt(1, codigo);


            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar USUARIO");
        }

        return resultado;
    }
	
}

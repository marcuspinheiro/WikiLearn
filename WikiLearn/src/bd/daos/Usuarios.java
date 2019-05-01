package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
import log.Log;


public class Usuarios {

	private Log log = new Log();
	
	 public boolean login (String email, String senha) throws Exception
	    {
	        boolean retorno = false;

	        try
	        {
	            String sql;

	            sql = "SELECT * " +
	                  "FROM USUARIO " +
	                  "WHERE EMAIL =? AND SENHA =?";

	            
	            
	            BD.COMANDO.prepareStatement (sql);

	            BD.COMANDO.setString (1, email);
	            BD.COMANDO.setString (2, senha);

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
	 
	 public boolean cadastrado (String email) throws Exception
	    {
	        boolean retorno = false;

	        try
	        {
	            String sql;

	            sql = "SELECT * " +
	                  "FROM USUARIO " +
	                  "WHERE EMAIL =? ";
	            
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


	
	 public void incluir (Usuario usuario) throws Exception
	    {
	        if (usuario==null)
	            throw new Exception ("Usuario nao fornecido");

	        try
	        {
			

	            String sql;

	            sql = "INSERT INTO USUARIO " +
	                  "(NOME,EMAIL,SENHA,DATA_NASCIMENTO, NICK) " +
	                  "VALUES " +
	                  "(?,?,?,?,?)";
	            
	            
	            this.log.printSql(sql);

	            BD.COMANDO.prepareStatement (sql);

	            BD.COMANDO.setString (1, usuario.getNome ());
	            BD.COMANDO.setString (2, usuario.getEmail ());
	            BD.COMANDO.setString (3, usuario.getSenha ());
	            BD.COMANDO.setString (4, usuario.getData_nascimento ());
	            BD.COMANDO.setString (5, usuario.getNick());


				

	            BD.COMANDO.executeUpdate ();
	            BD.COMANDO.commit        ();
	            
	            
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao inserir usuario");
	        }
	    }


	    public void excluir (String email) throws Exception
	    {
	        if (!cadastrado (email))
	            throw new Exception ("Nao cadastrado");

	        try
	        {
	            String sql;

	            sql = "DELETE FROM USUARIO " +
	                  "WHERE EMAIL=?";

	            BD.COMANDO.prepareStatement (sql);

	            BD.COMANDO.setString (1, email);

	            BD.COMANDO.executeUpdate ();
	            BD.COMANDO.commit        ();        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao excluir usuario");
	        }
	    }
	
	    
	    public void alterar (Usuario usuario) throws Exception
	    {
	        if (usuario==null)
	            throw new Exception ("Usuario nao fornecido");

	        if (!cadastrado (usuario.getEmail()))
	            throw new Exception ("Nao cadastrado");

	        try
	        {
	            String sql;

	            sql = "UPDATE USUARIO " +
	                  "SET NOME=? " +
	                  "SET EMAIL=? " +
	                  "SET SENHA=? " +
	                  "SET DATA_NASCIMENTO=? " +
	                  "SET INSTITUICAO_ID=? " +
	                  "SET PAIS_ID=? " +
	                  "SET ESTADO_ID=? " +
	                  "SET CIDADE_ID=? " +
	                  "WHERE HIERARQUIA = ?";

	            BD.COMANDO.prepareStatement (sql);


	            BD.COMANDO.setString (1, usuario.getNome ());
	            BD.COMANDO.setString (2, usuario.getEmail ());
	            BD.COMANDO.setString (3, usuario.getSenha ());
	            BD.COMANDO.setString (4, usuario.getData_nascimento ());

	            

	            BD.COMANDO.executeUpdate ();
	            BD.COMANDO.commit        ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao atualizar dados de usuario");
	        }
	    }
	
	    
	  

	    public MeuResultSet getUSUARIO () throws Exception
	    {
	        MeuResultSet resultado = null;

	        try
	        {
	            String sql;

	            sql = "SELECT * " +
	                  "FROM USUARIO";

	            BD.COMANDO.prepareStatement (sql);

	            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao recuperar USUARIO");
	        }

	        return resultado;
	    }
	    
	    public MeuResultSet getUsuarioLogado (String email) throws Exception
	    {
	        MeuResultSet resultado = null;

	        try
	        {
	            String sql;

	            sql = "SELECT * " +
	                  "FROM USUARIO WHERE EMAIL = '" + email+ "'";

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

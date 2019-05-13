package bd;

import bd.core.*;
import bd.daos.*;

public class BD
{
    public static final MeuPreparedStatement COMANDO;
    public static final Usuarios USUARIOS; //um como esse para cada classe DAO
    public static final Temas TEMAS;
    public static final Materiais MATERIAIS; 
    public static final Sugestoes SUGESTOES;


    static
    {
    	MeuPreparedStatement comando = null;
     	Usuarios usuarios  = null; //um como esse para cada classe DAO
     	Temas temas = null;
     	Materiais materiais = null;
     	Sugestoes sugestoes = null;

    	try
        {
           
    		//Servidor PUCC
    		 comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://fs5:1433;databasename=poo201813",
            "poo201813", "Jheqk6");

    		//SERVIDOR AZURE
    		/*comando =
    		new MeuPreparedStatement (
    	            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    	            "jdbc:sqlserver://projetod.database.windows.net:1433;databasename=poo201813",
    	            "MarcusPinheiro", "Projetod!");*/
    		
    		
            usuarios = new Usuarios (); //um como esse para cada classe DAO
            temas = new Temas ();
            materiais = new Materiais();
            sugestoes = new Sugestoes();
            
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
        USUARIOS  = usuarios; //um como esse para cada classe DAO
        TEMAS = temas;
        MATERIAIS = materiais; 
        SUGESTOES = sugestoes;
    }
}
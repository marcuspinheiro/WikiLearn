package bd.daos;

import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PostagemDAO {

	public void inserir(Postagem postagem) {

		try {

			String query;

			query = "INSERT INTO Postagem(fk_usuario,datta,encerrada,pergunta) Values(?,?,?,?)";
			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setInt(1, postagem.getDono().getId());
			BD.COMANDO.setTimestamp(2, new Timestamp(postagem.getTime()));
			BD.COMANDO.setBoolean(3, postagem.isEncerrado());
			BD.COMANDO.setString(4, postagem.getPergunta());
			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();

		} catch (SQLException erro) {
			System.err.println("Erro ao inserir postagem" + erro.getMessage());
		}
	}
	public void alterarStatusPostagem(int idPostagem, int status) {

		try {

			String query;

			query = "update postagem set encerrada = ? where id = ?";
			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setInt(1, status);
			BD.COMANDO.setInt(2, idPostagem);
			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();

		} catch (SQLException erro) {
			System.err.println("Erro ao atualizar status da postagem" + erro.getMessage());
		}
	}


	public List<Postagem> listarPostagens() {
		List<Postagem> lista = new ArrayList<Postagem>();

		MeuResultSet resultado = null;

		try {

			String query;
			
			query = "SELECT p.id as idPostagem, u.id as idUser, datta, pergunta, email, nick FROM Postagem p "
				 + " inner join usuario u on p.fk_usuario = u.id"
				 + " order by datta desc; ";
			BD.COMANDO.prepareStatement(query);

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			while (resultado.next()) {
				Postagem objP = new Postagem();
				Usuario user = new Usuario();
				objP.setIdPostagem(resultado.getInt("idPostagem"));
				objP.setData(resultado.getTimestamp("datta"));
				objP.setPergunta(resultado.getString("pergunta"));
				user.setEmail(resultado.getString("email"));
				user.setNick(resultado.getString("nick"));
				user.setId(resultado.getInt("idUser"));
				objP.setDono(user);
				lista.add(objP);
			}

		} catch (SQLException erro) {
			System.err.println("Erro ao listar postagens: " + erro.getMessage());

		}
		return lista;

	}

	public Postagem consultaPostagem(int id) {
		Postagem objP = null;

		MeuResultSet resultado = null;

		try {

			String query;

			query = "SELECT p.id as idPostagem, u.id as idUser, datta, pergunta, email, nick,encerrada FROM Postagem p "
					 + " inner join usuario u on p.fk_usuario = u.id"
					 + " where p.id= ?";
			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setInt(1, id);

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			if (resultado.next()) {
				Usuario objU = new Usuario();
				objP = new Postagem();
				
				objP.setIdPostagem(resultado.getInt("idPostagem"));
				objP.setPergunta(resultado.getString("pergunta"));
				objP.setData(resultado.getTimestamp("datta"));
				objP.setEncerrado(resultado.getInt("encerrada") == 0 ? false : true);
				objU.setNick(resultado.getString("nick"));
				objU.setId(resultado.getInt("idUser"));
				objP.setDono(objU);
			}

		} catch (SQLException ex) {
			System.err.println("Erro ao consultar postagem" + ex.getMessage());

		}

		return objP;

	}

	/*
	public static List<Postagem> listarPostagens() {
		List<Postagem> lista = new ArrayList<Postagem>();

		try {

			Connection conexao1 = ConexaoDB.getConnection();
			String Query = "SELECT * FROM Postagem order by datta desc; ";
			PreparedStatement BD.COMANDO = conexao1.prepareStatement(Query);
			// JOptionPane.showMessageDialog(null,"Dados inseridos com êxido");
			ResultSet resul = BD.COMANDO.executeQuery();

			while (resul.next()) {
				Postagem objP = new Postagem();

				objP.setIdPostagem(resul.getInt("idPostagem"));
				objP.setData(resul.getTimestamp("datta"));
				objP.setPergunta(resul.getString("pergunta"));

				lista.add(objP);
			}
			BD.COMANDO.close();

			// conexao1.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro" + ex.toString());

		} finally {
			ConexaoDB.closeConnection();
		}
		return lista;

	}

	
	public static boolean encerrarPostagem(Postagem postagem) {

		boolean result = false;

		try {

			Connection conexao1 = ConexaoDB.getConnection();
			String Query = "UPDATE postagem set encerrada = ? where idPostagem = ?";
			PreparedStatement BD.COMANDO = conexao1.prepareStatement(Query);
			BD.COMANDO.setBoolean(1, postagem.isEncerrado());
			BD.COMANDO.setInt(2, postagem.getIdPostagem());

			// JOptionPane.showMessageDialog(null,"Dados inseridos com êxido");
			BD.COMANDO.execute();
			result = true;
			BD.COMANDO.close();
			// conexao1.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro" + ex.toString());

		} finally {
			ConexaoDB.closeConnection();
		}

		return result;
	}
	
	*/

}

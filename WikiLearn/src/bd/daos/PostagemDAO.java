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

			query = "INSERT INTO Postagem(datta,encerrada,pergunta) Values(?,?,?)";
			BD.COMANDO.prepareStatement(query);
			//BD.COMANDO.setString(1, postagem.getDono().getNome());
			BD.COMANDO.setTimestamp(1, new Timestamp(postagem.getTime()));
			BD.COMANDO.setBoolean(2, postagem.isEncerrado());
			BD.COMANDO.setString(3, postagem.getPergunta());
			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();

		} catch (SQLException erro) {
			System.err.println("Erro ao inserir comentário" + erro.getMessage());
		}
	}

	public static List<Postagem> listarPostagens(Usuario usuario) {
		List<Postagem> lista = new ArrayList<Postagem>();

		MeuResultSet resultado = null;

		try {

			String query;

			query = "SELECT * FROM Postagem WHERE apelido = ? order by datta desc; ";
			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setString(1, usuario.getNome());

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			while (resultado.next()) {
				Postagem objP = new Postagem();

				objP.setIdPostagem(resultado.getInt("idPostagem"));
				objP.setDono(usuario);
				objP.setData(resultado.getTimestamp("datta"));
				objP.setPergunta(resultado.getString("pergunta"));

				lista.add(objP);
			}

		} catch (SQLException erro) {
			System.err.println("Erro ao inserir comentário" + erro.getMessage());

		}
		return lista;

	}

	public Postagem consultaPostagem(int id) {
		Postagem objP = null;

		MeuResultSet resultado = null;

		try {

			String query;

			query = "SELECT * FROM Postagem WHERE idPostagem = ?";
			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setInt(1, id);

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			if (resultado.next()) {
				Usuario objU = new Usuario();
				objP = new Postagem();
				objP.setIdPostagem(resultado.getInt("idPostagem"));
				objP.setPergunta(resultado.getString("pergunta"));
				objP.setData(resultado.getTimestamp("datta"));
				objP.setEncerrado(resultado.getBoolean("encerrada"));
				objU.setNome(resultado.getString("apelido"));
				objP.setDono(objU);
			}
			BD.COMANDO.close();

		} catch (SQLException ex) {
			System.err.println("Erro ao inserir comentário" + ex.getMessage());

		}

		return objP;//comentario teste

	}

	/*
	public static List<Postagem> listarPostagens() {
		List<Postagem> lista = new ArrayList<Postagem>();

		try {

			Connection conexao1 = ConexaoDB.getConnection();
			String Query = "SELECT * FROM Postagem order by datta desc; ";
			PreparedStatement BD.COMANDO = conexao1.prepareStatement(Query);
			// JOptionPane.showMessageDialog(null,"Dados inseridos com Ãªxido");
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

			// JOptionPane.showMessageDialog(null,"Dados inseridos com Ãªxido");
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


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

public class ComentarioDAO {

	private Log log = new Log();

	public void inserir(Comentario comentario) {

		try {
			String query;

			query = "INSERT INTO Comentario(comentario,datta,apelido,idPostagem) Values(?,?,?,?)";
			this.log.printSql(query);

			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setString(1, comentario.getComentario());
			BD.COMANDO.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			BD.COMANDO.setString(3, comentario.getDono().getNome());
			BD.COMANDO.setInt(4, comentario.getPostagem().getIdPostagem());
			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();

		} catch (SQLException erro) {
			System.err.println("Erro ao inserir comentário" + erro.getMessage());
		}

	}

	public List<Comentario> listarComentarios(Postagem postagem) {
		List<Comentario> lista = new ArrayList<Comentario>();

		MeuResultSet resultado = null;

		try {

			String query;

			query = "select idComentario, t1.apelido, comentario, t1.datta, t1.idPostagem "
					+ "	from comentario t1 \n"
					+ " inner join postagem t2 on (t1.idpostagem = t2.idpostagem)\n"
					+ " where t1.idPostagem = ? "
					+ "	order by t1.idpostagem desc;";
			this.log.printSql(query);

			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setInt(1, postagem.getIdPostagem());

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			while (resultado.next()) {
				Comentario objC = new Comentario();

				Usuario objU = new Usuario();
				objU.setNome(resultado.getString("apelido"));

				objC.setDono(objU);
				objC.setIdComentario(resultado.getInt("idComentario"));
				objC.setComentario(resultado.getString("comentario"));
				objC.setData(resultado.getTimestamp("datta"));
				lista.add(objC);

			}

		} catch (SQLException erro) {
			System.err.println("Erro ao inserir comentário" + erro.getMessage());

		}

		return lista;

	}
}

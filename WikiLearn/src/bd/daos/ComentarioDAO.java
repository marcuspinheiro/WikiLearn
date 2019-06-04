
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

			query = "INSERT INTO Comentario(comentario,datta,fk_usuario,fk_postagem) Values(?,?,?,?)";
			this.log.printSql(query);

			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setString(1, comentario.getComentario());
			BD.COMANDO.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			BD.COMANDO.setInt(3, comentario.getDono().getId());
			BD.COMANDO.setInt(4, comentario.getIdPostagem());
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

			query = "select t1.fk_usuario, comentario, t1.datta, t1.fk_postagem, nick "
					+ "	from comentario t1 \n"
					+ " inner join postagem t2 on (t1.fk_postagem = t2.id) "
					+ " inner join usuario u on t1.fk_usuario = u.id"
					+ " where t1.fk_postagem = ? "
					+ "	order by t1.datta asc;";
			this.log.printSql(query);

			BD.COMANDO.prepareStatement(query);
			BD.COMANDO.setInt(1, postagem.getIdPostagem());

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			while (resultado.next()) {
				Comentario objC = new Comentario();

				Usuario objU = new Usuario();
				objU.setNick(resultado.getString("nick"));;
				objC.setDono(objU);
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

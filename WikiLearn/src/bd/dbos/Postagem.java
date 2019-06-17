package bd.dbos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bia
 */
public class Postagem {

	private Usuario dono;
	private String pergunta;
	private List<Comentario> comentarios;
	private Date data;
	private long time;
	private boolean encerrado;
	private int idPostagem;

	// falso = aberto true = fechado
	public Postagem() {
		this.data = new Date();
		this.time = System.currentTimeMillis();
		this.encerrado = false;
		comentarios = new ArrayList<Comentario>();

		/*
		 * Comentario c = new Comentario(); c.setComentario("text"); comentarios.add(c);
		 */
	}

	public Usuario getDono() {
		return dono;
	}

	/**
	 * @param dono
	 *            the dono to set
	 */
	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	/**
	 * @return the pergunta
	 */
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * @param pergunta
	 *            the pergunta to set
	 */
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	/**
	 * @return the visitas
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	
	/**
	 * @param comentarios
	 *            the comentarios to set
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}


	/**
	 * @return the idPostagem
	 */
	public int getIdPostagem() {
		return idPostagem;
	}
	

	/**
	 * @param idPostagem
	 *            the idPostagem to set
	 */
	public void setIdPostagem(int idPostagem) {
		this.idPostagem = idPostagem;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the encerrado
	 */
	public boolean isEncerrado() {
		return encerrado;
	}

	public void setEncerrado(boolean enc) {
		this.encerrado = enc;
	}

	public String getRespostasFormatadas() {
		StringBuilder sb = new StringBuilder();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		for (Comentario c : comentarios) {
			sb.append(c.getDono().getNome());
			sb.append(" disse: \n");
			sb.append(c.getComentario());
			sb.append("\n");
			sb.append(dateFormat.format(c.getData()));
			sb.append("\n");

		}
		return sb.toString();

	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	
	public String rStatus() {
		if(this.isEncerrado())
			return "Fechada";
		else
			return "Aberta";
	}

}

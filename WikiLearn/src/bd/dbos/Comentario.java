package bd.dbos;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bia
 */
public class Comentario {
	private String comentario;
	private Date data;
	private Postagem postagem;
	private Usuario dono;
	private int idComentario;
	private int idPostagem;

	public Comentario() {
		this.data = new Date();
	}

	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @return the postagem
	 */
	public Postagem getPostagem() {
		return postagem;
	}

	/**
	 * @param postagem
	 *            the postagem to set
	 */
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	/**
	 * @return the dono
	 */
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

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	public int getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(int idPostagem) {
		this.idPostagem = idPostagem;
	}
	

}

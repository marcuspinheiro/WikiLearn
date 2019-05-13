package bd.dbos;

import java.util.Date;


public class Material {
	
	
	private int usuario_id;
	private int tema_id;
	private String titulo;
	private String descricao;
	private Date data_publicacao;
	private int positvo;
	private int negativo;
	private float nota;
	
	
	
	public Material(int usuario_id, int tema_id, String titulo, String descricao, Date data_publicacao, int positvo,
			int negativo, float nota) {
		
		this.usuario_id = usuario_id;
		this.tema_id = tema_id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_publicacao = data_publicacao;
		this.positvo = positvo;
		this.negativo = negativo;
		this.nota = nota;
	}


	
	
	
	public int getUsuario_id() {
		return usuario_id;
	}



	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}



	public int getTema_id() {
		return tema_id;
	}



	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Date getData_publicacao() {
		return data_publicacao;
	}



	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}



	public int getPositvo() {
		return positvo;
	}



	public void setPositvo(int positvo) {
		this.positvo = positvo;
	}



	public int getNegativo() {
		return negativo;
	}



	public void setNegativo(int negativo) {
		this.negativo = negativo;
	}



	public float getNota() {
		return nota;
	}



	public void setNota(float nota) {
		this.nota = nota;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_publicacao == null) ? 0 : data_publicacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + negativo;
		result = prime * result + Float.floatToIntBits(nota);
		result = prime * result + positvo;
		result = prime * result + tema_id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + usuario_id;
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (data_publicacao == null) {
			if (other.data_publicacao != null)
				return false;
		} else if (!data_publicacao.equals(other.data_publicacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (negativo != other.negativo)
			return false;
		if (Float.floatToIntBits(nota) != Float.floatToIntBits(other.nota))
			return false;
		if (positvo != other.positvo)
			return false;
		if (tema_id != other.tema_id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		return true;
	}





	@Override
	public String toString() {
		
		String ret;
		
		ret = "Material [usuario_id=" + usuario_id + ", tema_id=" + tema_id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", data_publicacao=" + data_publicacao + ", positvo=" + positvo + ", negativo=" + negativo
				+ ", nota=" + nota + "]";
		return ret;
	}
	
	
	
	
	
	
}

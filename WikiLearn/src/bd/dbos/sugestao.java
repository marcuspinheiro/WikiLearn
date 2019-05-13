package bd.dbos;

public class sugestao {

	
	
	private int usuario_id;
	private String tema_sugestao;
	private String descricao;
	
	
	public sugestao(int usuario_id, String tema_sugestao, String descricao) {
		
		this.usuario_id = usuario_id;
		this.tema_sugestao = tema_sugestao;
		this.descricao = descricao;
	}


	public int getUsuario_id() {
		return usuario_id;
	}


	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}


	public String getTema_sugestao() {
		return tema_sugestao;
	}


	public void setTema_sugestao(String tema_sugestao) {
		this.tema_sugestao = tema_sugestao;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tema_sugestao == null) ? 0 : tema_sugestao.hashCode());
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
		sugestao other = (sugestao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tema_sugestao == null) {
			if (other.tema_sugestao != null)
				return false;
		} else if (!tema_sugestao.equals(other.tema_sugestao))
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		String ret;
		ret = "sugestao [usuario_id=" + usuario_id + ", tema_sugestao=" + tema_sugestao + ", descricao=" + descricao
				+ "]";
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

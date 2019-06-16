package bd.dbos;

public class Usuario_curriculum {

	
	private int usuario_id;
	private String assunto1;
	private String assunto2;
	private String descricao;
	
	
	
	public Usuario_curriculum(int usuario_id, String assunto1, String assunto2, String descricao) {

		this.usuario_id = usuario_id;
		this.assunto1 = assunto1;
		this.assunto2 = assunto2;
		this.descricao = descricao;
	}



	
	
	
	public int getUsuario_id() {
		return usuario_id;
	}






	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}






	public String getAssunto1() {
		return assunto1;
	}






	public void setAssunto1(String assunto1) {
		this.assunto1 = assunto1;
	}






	public String getAssunto2() {
		return assunto2;
	}






	public void setAssunto2(String assunto2) {
		this.assunto2 = assunto2;
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
		result = prime * result + ((assunto1 == null) ? 0 : assunto1.hashCode());
		result = prime * result + ((assunto2 == null) ? 0 : assunto2.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Usuario_curriculum other = (Usuario_curriculum) obj;
		if (assunto1 == null) {
			if (other.assunto1 != null)
				return false;
		} else if (!assunto1.equals(other.assunto1))
			return false;
		if (assunto2 == null) {
			if (other.assunto2 != null)
				return false;
		} else if (!assunto2.equals(other.assunto2))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		return true;
	}






	@Override
	public String toString() {
		String ret;
		ret=  "Usuario_curriculum [usuario_id=" + usuario_id + ", assunto1=" + assunto1 + ", assunto2=" + assunto2
				+ ", descricao=" + descricao + "]";
		
		return ret;
	}
	
	
	
	

	
	
	
	
	
	
	
	
}

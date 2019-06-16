package bd.dbos;

public class Avaliacao_material {
	
	private int usuario_id;
	private int material_id;
	private int nota;
	
	
	public Avaliacao_material(int usuario_id, int material_id, int nota) {
		
		this.usuario_id = usuario_id;
		this.material_id = material_id;
		this.nota = nota;
	}


	public int getUsuario_id() {
		return usuario_id;
	}


	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}


	public int getMaterial_id() {
		return material_id;
	}


	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + material_id;
		result = prime * result + nota;
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
		Avaliacao_material other = (Avaliacao_material) obj;
		if (material_id != other.material_id)
			return false;
		if (nota != other.nota)
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		String ret;
		ret = "Avaliacao_material [usuario_id=" + usuario_id + ", material_id=" + material_id + ", nota=" + nota + "]";
		return ret;
	}
	
	
	
	
	
	
	

}

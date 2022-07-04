package br.com.rfatctech.cleancar.core.entity;

import java.util.Objects;

public class MarcaVeiculoEntity {
	
	private Long codigo;
	private Long decricaoMarca;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getDecricaoMarca() {
		return decricaoMarca;
	}
	public void setDecricaoMarca(Long decricaoMarca) {
		this.decricaoMarca = decricaoMarca;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcaVeiculoEntity other = (MarcaVeiculoEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}

	

}

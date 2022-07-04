package br.com.rfatctech.cleancar.core.entity;

import java.util.Objects;

public class CorEntity {
	private Long codigo;
	private String descricaoCor;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricaoCor() {
		return descricaoCor;
	}
	public void setDescricaoCor(String descricaoCor) {
		this.descricaoCor = descricaoCor;
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
		CorEntity other = (CorEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}

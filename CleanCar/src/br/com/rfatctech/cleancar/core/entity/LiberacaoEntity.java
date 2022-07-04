package br.com.rfatctech.cleancar.core.entity;

import java.util.Objects;

public class LiberacaoEntity {
	
	private Long codigo;
	private UsuarioEntity usuario;
	private GrupoUsuarioEntity recurso;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	public GrupoUsuarioEntity getRecurso() {
		return recurso;
	}
	public void setRecurso(GrupoUsuarioEntity recurso) {
		this.recurso = recurso;
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
		LiberacaoEntity other = (LiberacaoEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}

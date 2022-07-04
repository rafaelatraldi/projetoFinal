package br.com.rfatctech.cleancar.core.entity;

import java.util.Objects;

public class VeiculoEntity {

	private Long codigo;
	private String modelo;
	private String placa;
	private int ano;
	private CorEntity cor;
	private MarcaVeiculoEntity marca;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public CorEntity getCor() {
		return cor;
	}
	public void setCor(CorEntity cor) {
		this.cor = cor;
	}
	public MarcaVeiculoEntity getMarca() {
		return marca;
	}
	public void setMarca(MarcaVeiculoEntity marca) {
		this.marca = marca;
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
		VeiculoEntity other = (VeiculoEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}

package com.classes;

public class Funcao {
	int codigo;
	String privilegio, descicao;
	public Funcao(int codigo, String privilegio, String descicao) {
		super();
		this.codigo = codigo;
		this.privilegio = privilegio;
		this.descicao = descicao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}
	public String getDescicao() {
		return descicao;
	}
	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}
	

}
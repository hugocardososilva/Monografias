package com.classes;

public class Administrator {
	String senha, endereco, email, nome; 
	int codigo, telefone;
	Funcao funcao;
	public Administrator(String senha, String endereco, String email,
			String nome, int codigo, int telefone, Funcao funcao) {
		super();
		this.senha = senha;
		this.endereco = endereco;
		this.email = email;
		this.nome = nome;
		this.codigo = codigo;
		this.telefone = telefone;
		this.funcao = funcao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	

}

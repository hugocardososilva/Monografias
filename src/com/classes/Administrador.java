package com.classes;

import java.util.ArrayList;

import com.banco.ConexaoFuncao;

public class Administrador {
	String senha, endereco, email, nome; 
	int codigo, telefone;
	ArrayList<String> funcoes;
	
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
	public ArrayList<String> getFuncoes() {
		return funcoes;
	}
	public void setFuncoes(ArrayList<String> funcoes) {
		this.funcoes = funcoes;
	}
	
}

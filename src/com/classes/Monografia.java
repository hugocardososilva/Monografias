package com.classes;

public class Monografia {
	double nota;
	int codigo;
	String nome, matricula, arquivo;
	Curso curso;
	public Monografia(double nota, int codigo, String nome, String matricula,
			String arquivo, Curso curso) {
		super();
		this.nota = nota;
		this.codigo = codigo;
		this.nome = nome;
		this.matricula = matricula;
		this.arquivo = arquivo;
		this.curso = curso;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	

}

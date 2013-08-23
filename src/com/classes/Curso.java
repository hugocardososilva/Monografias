package com.classes;

public class Curso {
	String nome, turno, instituicao, turma;
	int codigo;
	public Curso(String nome, String turno, String instituicao, String turma,
			int codigo) {
		super();
		this.nome = nome;
		this.turno = turno;
		this.instituicao = instituicao;
		this.turma = turma;
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}

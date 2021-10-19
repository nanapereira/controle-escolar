package model;

import java.sql.SQLException;

import dao.ProfessorDao;

public class Professor {

	public int codProfessor;
	public String nomeProfessor;
	public boolean ativo;

	public int getCodProfessor() {
		return codProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Professor(String nomeProfessor, boolean ativo) {
		this.nomeProfessor = nomeProfessor;
		this.ativo = ativo;
	}

	public void incluirProfessor(Professor professor) throws ClassNotFoundException, SQLException {
		new ProfessorDao().save(professor);
	}

	public void alterarProfessor() {
		// TODO implement here
	}

	public void consultarProfessor() {
		// TODO implement here
	}

	public void alterarStatusProfessor() {
		// TODO implement here
	}

}
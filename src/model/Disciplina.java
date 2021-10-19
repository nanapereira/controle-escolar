package model;

import java.sql.SQLException;

import dao.DisciplinaDao;

public class Disciplina {

	public int codDisciplina;
	public int codProfessor;
	public String descDisciplina;
	public int cargaHoraria;
	public boolean ativa;

	public Disciplina(int codProfessor, String descDisciplina, int cargaHoraria, boolean ativa) {
		super();
		this.codProfessor = codProfessor;
		this.descDisciplina = descDisciplina;
		this.cargaHoraria = cargaHoraria;
		this.ativa = ativa;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public int getCodProfessor() {
		return codProfessor;
	}

	public void setCodProfessor(int codProfessor) {
		this.codProfessor = codProfessor;
	}

	public String getDescDisciplina() {
		return descDisciplina;
	}

	public void setDescDisciplina(String descDisciplina) {
		this.descDisciplina = descDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public void incluirDisciplina(Disciplina disciplina) throws ClassNotFoundException, SQLException {
		new DisciplinaDao().save(disciplina);
	}

	public void alterarDisciplina() {
		// TODO implement here
	}

	public void consultarDisciplina() {
		// TODO implement here
	}

	public void alterarStatusDisciplina() {
		// TODO implement here
	}

	public void calcularMedias() {
		// TODO implement here
	}

}
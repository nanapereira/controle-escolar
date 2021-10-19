package model;

import java.sql.SQLException;
import java.util.Date;

import dao.MatriculaDao;

public class Matricula {

	public int codMatricula;
	public int codAluno;
	public int codDisciplina;
	public Date dataMatricula;

	public Matricula(int codAluno, int codDisciplina, Date dataMatricula) {
		this.codAluno = codAluno;
		this.codDisciplina = codDisciplina;
		this.dataMatricula = dataMatricula;
	}

	public int getCodMatricula() {
		return codMatricula;
	}

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public void gerarMatricula(Matricula matricula) throws ClassNotFoundException, SQLException {
		new MatriculaDao().save(matricula);
	}

	public void excluirMatricula() {
		// TODO implement here
	}

	public void consultarMatricula() {
		// TODO implement here
	}

}
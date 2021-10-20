package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.AlunoDao;

public class Aluno {

	public int codAluno;
	public String nomeAluno;
	public String cpfAluno;
	public Date dataNascimento;
	public Date dataMatricula;
	public String nomePai;
	public String nomeMae;
	public String responsavel;
	public String foneResponsavel;
	public boolean matriculado;



	public Aluno(String nomeAluno, String cpfAluno, Date dataNascimento, Date dataMatricula, String nomePai,
			String nomeMae, String responsavel, String foneResponsavel, boolean matriculado) {
		super();
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.dataNascimento = dataNascimento;
		this.dataMatricula = dataMatricula;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.responsavel = responsavel;
		this.foneResponsavel = foneResponsavel;
		this.matriculado = matriculado;
	}



	public Aluno(int codAluno, String nomeAluno, String cpfAluno, Date dataNascimento, Date dataMatricula,
			String nomePai, String nomeMae, String responsavel, String foneResponsavel, boolean matriculado) {
		super();
		this.codAluno = codAluno;
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.dataNascimento = dataNascimento;
		this.dataMatricula = dataMatricula;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.responsavel = responsavel;
		this.foneResponsavel = foneResponsavel;
		this.matriculado = matriculado;
	}



	public Aluno() {

	}

	public int getCodAluno() {
		return codAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getFoneResponsavel() {
		return foneResponsavel;
	}

	public void setFoneResponsavel(String foneResponsavel) {
		this.foneResponsavel = foneResponsavel;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public void IncluirAluno(Aluno aluno) throws ClassNotFoundException, SQLException {
		new AlunoDao().save(aluno);
	}

	public void alterarAluno() {
		// TODO implement here
	}

	public ArrayList<Aluno> consultarAluno(String nomeAluno) throws ClassNotFoundException, SQLException {
		return new AlunoDao().findByName(nomeAluno);
	}

	public void alterarStatusAluno() {
		// TODO implement here
	}

}
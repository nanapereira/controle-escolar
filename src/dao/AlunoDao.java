package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aluno;

public class AlunoDao {

	private String sql;
	private ConexaoMysql conexao;

	public AlunoDao() throws ClassNotFoundException, SQLException {
		conexao = new ConexaoMysql();
	}

	public void save(Aluno aluno) throws SQLException {
		sql = "insert into aluno values (null,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pStatement = this.conexao.getConnection().prepareStatement(sql);
			pStatement.setString(1, aluno.getNomeAluno());
			pStatement.setString(2, aluno.getCpfAluno());
			pStatement.setObject(3, aluno.getDataNascimento());
			pStatement.setObject(4, aluno.getDataMatricula());
			pStatement.setString(5, aluno.getNomePai());
			pStatement.setString(6, aluno.getNomeMae());
			pStatement.setString(7, aluno.getResponsavel());
			pStatement.setString(8, aluno.getFoneResponsavel());
			pStatement.setBoolean(9, aluno.isMatriculado());
			pStatement.execute();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}

	public ArrayList<Aluno> findByName(String nomeAluno) throws SQLException {
		sql = "SELECT * FROM ALUNO WHERE nomeAluno LIKE '%" + nomeAluno + "%'";
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			while (resultSet.next()) {
				Aluno aluno = new Aluno(resultSet.getInt("codAluno"), resultSet.getString("nomeAluno"),
						resultSet.getString("cpfAluno"), resultSet.getDate("dataNascimento"),
						resultSet.getDate("dataMatricula"), resultSet.getString("nomePai"),
						resultSet.getString("nomeMae"), resultSet.getString("responsavel"),
						resultSet.getString("foneResponsavel"), resultSet.getBoolean("matriculado"));
				alunos.add(aluno);
			}
			return alunos;
		} catch (SQLException se) {
			throw se;
		}
	}
}
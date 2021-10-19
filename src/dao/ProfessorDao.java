package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Professor;

public class ProfessorDao {

	private String sql;
	private ConexaoMysql conexao;

	public ProfessorDao() throws ClassNotFoundException, SQLException {
		conexao = new ConexaoMysql();
	}

	public void save(Professor professor) throws SQLException {
		sql = "insert into professor values (null,?,?)";

		try {
			PreparedStatement pStatement = this.conexao.getConnection().prepareStatement(sql);
			pStatement.setString(1, professor.getNomeProfessor());
			pStatement.setBoolean(2, professor.isAtivo());
			pStatement.execute();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}

}
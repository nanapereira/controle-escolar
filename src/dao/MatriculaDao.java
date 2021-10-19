package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Matricula;

public class MatriculaDao {

	private String sql;
	private ConexaoMysql conexao;

	public MatriculaDao() throws ClassNotFoundException, SQLException {
		conexao = new ConexaoMysql();
	}

	public void save(Matricula matricula) throws SQLException {
		sql = "insert into matricula values (null,?,?,?)";

		try {
			PreparedStatement pStatement = this.conexao.getConnection().prepareStatement(sql);
			pStatement.setInt(1, matricula.getCodAluno());
			pStatement.setInt(2, matricula.getCodDisciplina());
			pStatement.setObject(3, matricula.getDataMatricula());
			pStatement.execute();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}
}

package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Disciplina;

public class DisciplinaDao {

	private String sql;
	private ConexaoMysql conexao;

	public DisciplinaDao() throws ClassNotFoundException, SQLException {
		conexao = new ConexaoMysql();
	}

	public void save(Disciplina disciplina) throws SQLException {
		sql = "insert into disciplina values (null,?,?,?,?)";

		try {
			PreparedStatement pStatement = this.conexao.getConnection().prepareStatement(sql);
			pStatement.setInt(1, disciplina.getCodProfessor());
			pStatement.setString(2, disciplina.getDescDisciplina());
			pStatement.setInt(3, disciplina.getCargaHoraria());
			pStatement.setBoolean(4, disciplina.isAtiva());
			pStatement.execute();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}
}
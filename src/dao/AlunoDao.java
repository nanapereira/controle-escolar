package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.Aluno;

public class AlunoDao {
	
	private String sql;
	private ConexaoMysql conexao;
	

	public AlunoDao() throws ClassNotFoundException, SQLException {
		conexao = new ConexaoMysql();
	}

	public void save(Aluno aluno) throws SQLException {
		sql = "insert into aluno values (?,?,?,?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pStatement = this.conexao.getConnection().prepareStatement(sql);
			pStatement.setString(1, aluno.getNomeAluno());
			pStatement.setString(2, aluno.getCpfAluno());
			pStatement.setObject(3, aluno.getDataNascimento());	
			

//		    public String nomeAluno;
//		    public String cpfAluno;
//		    public Date dataNascimento;
//		    public Date dataMatricula;
//		    public String nomePai;
//		    public String nomeMae;
//		    public String responsavel;
//		    public String foneResponsavel;
//		    public boolean matriculado;
//			
			
//			pStatement.setString(1, produto.getDescricao());
//			pStatement.setInt(2, produto.getQuantidade());
//			pStatement.setDouble(3, produto.getPreco());
//			pStatement.setBoolean(4, produto.isOnLine());
			pStatement.execute();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}

}

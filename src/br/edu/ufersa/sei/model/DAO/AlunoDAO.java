package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class AlunoDAO<VO extends AlunoVO> extends UsuarioDAO<VO> implements AlunoInterDAO{
	
	@Override
	public void inserir(VO vo) throws SQLException{
		String sql = "insert into aluno (matricula, idTurma, idUsu) values (?,?,?)";
		PreparedStatement ptst;
		
		try {
			super.inserir(vo);
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getMatricula());
			ptst.setLong(2, vo.getTurma().getIdTurma());
			ptst.setLong(3, vo.getIdUsu());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdAluno(generatedKeys.getLong(1));
			}else {
				throw new SQLException("A inserção falhou. Nenhum ID foi retornado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	} 

	@Override
	public void atualizar(VO vo) throws SQLException {
		String sql = "update aluno set matricula = ?, idTurma = ?, idUsu = ? where idAluno = ?";
		PreparedStatement ptst;
			
		try {
			super.atualizar(vo);
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getMatricula());
			ptst.setLong(2, vo.getTurma().getIdTurma());
			ptst.setLong(3, vo.getIdUsu());
			ptst.setLong(4, vo.getIdAluno());
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A atualização falhou. Nenhuma linha foi alterada.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deletar(VO vo) throws SQLException {
		String sql = "delete from aluno where idAluno = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdAluno());
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A deleção falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from aluno";  //vai mostrar só idAluno, mat., idTurma, idUsu
		PreparedStatement ptst;
		ResultSet rs = null;
		
 		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ResultSet buscarPorNome(VO vo) throws SQLException {
		String sql = "select u.nome, u.cpf, u.endereco, u.email, a.matricula from " + 
				     "usuario u, aluno a WHERE u.nome = ? and u.idUsu = a.idUsu;";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ResultSet buscarPorId(VO vo) throws SQLException {
		String sql = "select * from aluno where idUsu = ?"; 
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getIdUsu());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	//buscar alunos por turma
	@Override
	public ResultSet buscarPorTurma(TurmaVO vo) throws SQLException {
		String sql = "select u.nome, a.matricula from usuario u inner join aluno " + 
					 "on u.IdUsu = a.IdUsu where u.IdUsu IN " + 
				     "(select a.idUsu from aluno a where idTurma = ?)";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getIdTurma());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

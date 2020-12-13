package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.TurmaVO;

public class TurmaDAO extends BaseDAO<TurmaVO>{

	@Override
	public void inserir(TurmaVO vo) throws SQLException {
		String sql = "insert into turma (codturma, nome, sala, turno) values (?,?,?,?)";
		PreparedStatement ptst;
		
		try {		
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getCodTurma());
			ptst.setString(2, vo.getNome());
			ptst.setString(3, vo.getSala());
			ptst.setString(4, vo.getHorario());
			
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Nenhuma linha modificada, falha na inserção.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setIdTurma(generatedKeys.getLong("idTurma"));
			} else {
				throw new SQLException("Nenhum ID retornado, falha na inserção.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(TurmaVO vo) throws SQLException {
		String sql = "update turma set nome = ?, codturma = ?, sala = ?, turno = ? where idTurma = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCodTurma());
			ptst.setString(3, vo.getSala());
			ptst.setString(4, vo.getHorario());
			ptst.setLong(5, vo.getIdTurma());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(TurmaVO vo) throws SQLException {
		String sql = "delete from turma where idTurma = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdTurma());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from turma";
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
	public ResultSet buscarPorNome(TurmaVO vo) throws SQLException {
		String sql = "select * from turma where nome like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%"+vo.getNome()+"%");
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet buscarPorId(TurmaVO vo) throws SQLException {
		String sql = "select * from turma where idTurma = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdTurma());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorId(long id) throws SQLException {
		String sql = "select * from turma where idTurma = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, id);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

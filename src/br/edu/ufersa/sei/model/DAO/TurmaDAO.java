package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class TurmaDAO extends BaseDAO<TurmaVO> implements TurmaInterDAO{

	@Override
	public void inserir(TurmaVO vo) throws SQLException {
		String sql = "insert into turma (nome, codturma, sala, turno) values (?,?,?,?)";
		PreparedStatement ptst;
		
		try {
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCodTurma());
			ptst.setString(3, vo.getSala());
			ptst.setString(4, vo.getHorario());
			
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Nenhuma linha modificada, falha na inserção.");
			}
			
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				vo.setIdTurma(generatedKey.getLong("idTurma"));
				//System.out.println(vo.getIdTurma());
			} else {
				throw new SQLException("Nenhum ID retornado, falha na inserção.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(TurmaVO vo) throws SQLException {
		String sql = "update turma set nome = ?, codturma = ?, sala = ?, turno = ? where idTurma= ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCodTurma());
			ptst.setString(3, vo.getSala());
			ptst.setString(4, vo.getHorario());
			ptst.setLong(5, vo.getIdTurma());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A atualização falhou. Nenhuma linha foi alterada.");
			}
			
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
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A atualização falhou. Nenhuma linha foi alterada.");
			}
			
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
		String sql = "select * from turma where nome = ?";
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
	public ResultSet buscarPorId(TurmaVO vo) throws SQLException {
		String sql = "select * from turma where idTurma = ?";
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

	//buscar turma por prof
	@Override
	public ResultSet buscarPorProf(ProfessorVO vo) {		
		String sql = "select t.nome, t.codturma, t.sala, t.turno from turma t where t.idturma in" + 
					 "(select tp.idturma from turmaprof tp where idprof = ?)";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getIdProf());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

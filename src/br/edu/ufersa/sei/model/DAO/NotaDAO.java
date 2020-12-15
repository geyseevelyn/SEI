package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;

public class NotaDAO extends BaseDAO<NotaVO>{

	@Override
	public void inserir(NotaVO vo) throws SQLException{
		String sql = "insert into nota (idAluno, idDisc,n1, n2, n3, media, faltas) values (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, vo.getAluno().getIdAluno());
			ptst.setLong(2, vo.getDisc().getIdDisc());
			ptst.setDouble(3, vo.getN1());
			ptst.setDouble(4, vo.getN2());
			ptst.setDouble(5, vo.getN3());
			ptst.setDouble(6, vo.getMedia());
			ptst.setInt(7, vo.getFaltas());
			
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdNota(generatedKeys.getLong("idNota"));
			}else {
				throw new SQLException("A inserção falhou. Nenhum ID foi retornado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(NotaVO vo) throws SQLException {
		String sql = "update nota set n1 = ?, n2 = ?, n3 = ?, media = ?, faltas = ? " +
				     "where idAluno = ? and idDisc = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getN1());
			ptst.setDouble(2, vo.getN2());
			ptst.setDouble(3, vo.getN3());;
			ptst.setDouble(4, vo.getMedia());
			ptst.setInt(5, vo.getFaltas());
			ptst.setLong(6, vo.getAluno().getIdAluno());
			ptst.setLong(7, vo.getDisc().getIdDisc());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deletar(NotaVO vo) throws SQLException {
		String sql = "delete from nota where idAluno = ? and idDisc = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getAluno().getIdAluno());
			ptst.setLong(2, vo.getDisc().getIdDisc());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}				
			
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from nota"; //"select idDisc, n1, n2, n3, media, faltas from nota";
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
	public ResultSet buscarPorNome(NotaVO vo) {
		return null;
	}

	@Override
	public ResultSet buscarPorId(NotaVO vo) throws SQLException {
		String sql = "select * from nota where IdNota = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdNota());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarNotaAluno(AlunoVO avo, DisciplinaVO dvo) throws SQLException {
		String sql = "select * from nota where IdAluno = ? and IdDisc = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, avo.getIdAluno());
			ptst.setLong(2, dvo.getIdDisc());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listarNotasAluno(AlunoVO alu) throws SQLException {
		String sql = "select * from nota where idAluno = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
 		try {
 			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, alu.getIdAluno());
			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
}

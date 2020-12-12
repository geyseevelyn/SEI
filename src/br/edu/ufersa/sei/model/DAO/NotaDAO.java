package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.sei.model.VO.NotaVO;

public class NotaDAO extends BaseDAO<NotaVO>{

	@Override
	public void inserir(NotaVO vo) throws SQLException{
		String sql = "insert into notas (n1, n2, n3, faltas, idAluno, idDisc) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getN1());
			ptst.setDouble(2, vo.getN2());
			ptst.setDouble(3, vo.getN3());
			ptst.setInt(4, vo.getFaltas());
			ptst.setLong(5, vo.getAluno().getIdAluno());
			ptst.setLong(6, vo.getDisc().getIdDisc());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(NotaVO vo) throws SQLException {
		String sql = "update notas set n1 = ?, n2 = ?, n3 = ?, faltas = ? " +
				     "where idAluno = ? and idDisc = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, vo.getN1());
			ptst.setDouble(2, vo.getN2());
			ptst.setDouble(3, vo.getN3());;
			ptst.setInt(4, vo.getFaltas());
			ptst.setLong(5, vo.getAluno().getIdAluno());
			ptst.setLong(6, vo.getDisc().getIdDisc());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deletar(NotaVO vo) throws SQLException {
		String sql = "delete from notas where idAluno = ? and idDisc = ?";
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
	
	/*
	public void deletarNotas(AlunoVO avo, DisciplinaVO discvo) throws SQLException {
		String sql = "delete from notas where idAluno = ? and idDisc = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, avo.getIdAluno());
			ptst.setLong(2, discvo.getIdDisc());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A atualização falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/				
			
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from notas"; //"select idDisc, n1, n2, n3, media, faltas from notas";
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
		return null;
	}
}

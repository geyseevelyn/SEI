package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.DisciplinaVO;

public class DisciplinaDAO extends BaseDAO<DisciplinaVO> {

	@Override
	public void inserir(DisciplinaVO vo) throws SQLException {
		String sql = "insert into disciplina (codDisc, nome, IdProf, status) values (?,?,?,?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getCodDisc());
			ptst.setString(2, vo.getNome());
			ptst.setLong(3, vo.getProfDisc().getIdProf());
			ptst.setBoolean(4, vo.isStatus());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0) {
				throw new SQLException("Nenhuma linha modificada, falha na inserção.");
			}
			
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				vo.setIdDisc(generatedKey.getLong(1));
			} else {
				throw new SQLException("Nenhum ID retornado, falha na inserção.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(DisciplinaVO vo) throws SQLException {
		String sql = "update disciplina set codDisc = ?, nome = ?, IdProf = ?, status = ? where idDisc= ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getCodDisc());
			ptst.setString(2, vo.getNome());
			ptst.setLong(3, vo.getProfDisc().getIdProf());
			ptst.setBoolean(4, vo.isStatus());
			ptst.setLong(5, vo.getIdDisc());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A atualização falhou. Nenhuma linha foi alterada.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(DisciplinaVO vo)throws SQLException {
		String sql = "delete from disciplina where idDisc = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdDisc());
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
		String sql = "select * from disciplina";
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
	public ResultSet buscarPorNome(DisciplinaVO vo) throws SQLException {
		String sql = "select * from disciplina where nome = ?";
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
	public ResultSet buscarPorId(DisciplinaVO vo)  throws SQLException {
		String sql = "select * from disciplina where idDisc = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getIdDisc());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

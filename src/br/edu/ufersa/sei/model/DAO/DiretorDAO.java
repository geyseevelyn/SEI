package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.DiretorVO;

public class DiretorDAO<VO extends DiretorVO> extends UsuarioDAO<VO>{

	@Override
	public void inserir(VO vo) throws SQLException{
		try {
			super.inserir(vo);
			String sql = "insert into diretor (idUsu) values (?)";
			PreparedStatement ptst;
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, vo.getIdUsu());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdDir(generatedKeys.getLong(1));
			}else {
				throw new SQLException("A inserção falhou. Nenhum ID foi retornado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	}

	@Override
	public void atualizar(VO vo) throws SQLException {
		super.atualizar(vo);
		String sql = "update diretor set idUsu = ? where idDir = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdUsu());
			ptst.setLong(2, vo.getIdDir());
			
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
		String sql = "delete from diretor where idDir = ?";
		PreparedStatement psts;
		
		try {
			psts = getConnection().prepareStatement(sql);
			psts.setLong(1, vo.getIdDir());
			psts.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscarPorId(VO vo) throws SQLException {
		String sql = "select * from diretor where idDir = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getIdDir());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}

package br.edu.ufersa.sei.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO> implements UsuarioInterDAO<VO>{

	@Override
	public void inserir(VO vo) throws SQLException{
		String sql = "insert into Usuario (nome, cpf, endereco, email, login, senha) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCpf());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getEmail());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setIdUsu(generatedKeys.getLong(1));
			}else {
				throw new SQLException("A inserção falhou. Nenhum ID foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	} 

	@Override
	public void atualizar(VO vo) throws SQLException {
		String sql = "update usuario set nome = ?, cpf = ?, endereco = ?, email = ?, login = ?, senha = ? where idUsu = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCpf());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getEmail());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
			ptst.setLong(7, vo.getIdUsu());
			
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
		String sql = "delete from usuario where idUsu = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdUsu());
			
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
		String sql = "select * from usuario";  //mostra a senha
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
		String sql = "select * from usuario where nome like ?"; //mostra a senha
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
	public ResultSet buscarPorId(VO vo) throws SQLException {
		String sql = "select * from usuario where idUsu = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getIdUsu());
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet buscarPorLogin(VO vo) throws SQLException{
		String sql = "select * from usuario where login like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
			
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, "%"+vo.getLogin()+"%");
			rs = ptst.executeQuery();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

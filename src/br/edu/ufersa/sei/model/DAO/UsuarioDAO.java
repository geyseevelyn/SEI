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
	public void atualizar(VO vo) {
		//implementar
	}

	@Override
	public void deletar(VO vo) {
		//implementar
	}

	@Override
	public ResultSet listar() {
		//implementar
		return null;
	}

	@Override
	public ResultSet buscarPorNome(String nome) {
		//implementar
		return null;
	}
	
	@Override
	public UsuarioVO autenticar(VO user) {
		//implementar
		return null;
	}
}

package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> extends BaseInterDAO<VO>{
	public ResultSet buscarPorLogin(VO vo) throws SQLException;
}

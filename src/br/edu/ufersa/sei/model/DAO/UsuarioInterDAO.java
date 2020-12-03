package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> extends BaseInterDAO<VO>{
	public ResultSet buscarPorLogin(VO vo);
	//Buscar por login e talvez tirar o autenticar
}

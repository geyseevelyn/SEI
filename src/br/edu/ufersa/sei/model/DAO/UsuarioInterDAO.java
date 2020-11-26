package br.edu.ufersa.sei.model.DAO;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> extends BaseInterDAO<VO>{
	public UsuarioVO autenticar(UsuarioVO user);
}

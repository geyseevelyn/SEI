package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public interface UsuarioInterBO<VO> extends BaseInterBO<VO> {
	public UsuarioVO autenticar(UsuarioVO user);
}

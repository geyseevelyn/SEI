package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.exception.AutenticationException;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public interface UsuarioInterBO<VO extends UsuarioVO> extends BaseInterBO<VO> {
	public UsuarioVO autenticar(VO vo) throws AutenticationException;
}

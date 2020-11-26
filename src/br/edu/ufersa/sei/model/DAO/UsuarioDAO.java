package br.edu.ufersa.sei.model.DAO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> implements UsuarioInterDAO<VO>{

	@Override
	public void inserir(UsuarioVO vo) {
		//implementar
	}

	@Override
	public void atualizar(UsuarioVO vo) {
		//implementar
	}

	@Override
	public void deletar(VO vo) {
		//implementar
	}

	@Override
	public List<VO> listar() {
		//implementar
		return null;
	}

	@Override
	public VO buscar(VO vo) {
		//implementar
		return null;
	}
	
	@Override
	public UsuarioVO autenticar(UsuarioVO user) {
		//implementar
		return null;
	}
}

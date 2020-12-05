package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.VO.NotaVO;;

public class NotaBO extends BaseBO<NotaVO>{

	@Override
	public void cadastrar(NotaVO vo) {
		//implementar
	}

	@Override
	public void editar(NotaVO vo) {
		//implementar
	}

	@Override
	public void excluir(NotaVO vo) {
		//implementar
	}

	@Override
	public List<NotaVO> listar() {
		//implementar
		return null;
	}

	@Override
	public List<NotaVO> buscarPorNome(NotaVO vo) throws NotFoundException {
		//implementar
		return null;
	}

	@Override
	public NotaVO buscarPorId(NotaVO vo) throws NotFoundException {
		//implementar
		return null;
	}
}

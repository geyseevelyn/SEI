package br.edu.ufersa.sei.model.DAO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.NotaVO;

public class NotaDAO extends BaseDAO<NotaVO> implements NotaInterDAO{

	@Override
	public void inserir(NotaVO vo) {
		//implementar	
	}

	@Override
	public void atualizar(NotaVO vo) {
		//implementar
	}

	@Override
	public void deletar(NotaVO vo) {
		//implementar
	}

	@Override
	public List<NotaVO> listar() {
		//implementar
		return null;
	}

	@Override
	public NotaVO buscar(NotaVO vo) {
		//implementar
		return null;
	}

	@Override
	public void lancarNotas(AlunoVO aluno) {
		//implementar
	}

	@Override
	public void lancarFrequencia(AlunoVO aluno) {
		//implementar
	}
}

package br.edu.ufersa.sei.model.DAO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface AlunoInterDAO {
	public List<AlunoVO> buscarPorTurma(TurmaVO turma);
}

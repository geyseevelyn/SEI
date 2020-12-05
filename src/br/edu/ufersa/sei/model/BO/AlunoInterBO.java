package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface AlunoInterBO {
	public List<AlunoVO> buscarPorTurma(TurmaVO turma) throws InsertException;
}

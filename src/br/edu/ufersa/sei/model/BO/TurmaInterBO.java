package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface TurmaInterBO {
	public List<TurmaVO> buscarPorProf(ProfessorVO vo) throws InsertException;
}

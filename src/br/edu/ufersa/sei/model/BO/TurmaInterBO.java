package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;

public interface TurmaInterBO {
	public List<TurmaVO> buscarPorProf(ProfessorVO prof);
}

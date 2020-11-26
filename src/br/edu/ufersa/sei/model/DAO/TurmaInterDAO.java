package br.edu.ufersa.sei.model.DAO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface TurmaInterDAO {
	public List<TurmaVO> buscarPorProf(ProfessorVO prof);
}

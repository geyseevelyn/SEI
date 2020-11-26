package br.edu.ufersa.sei.model.DAO;

import br.edu.ufersa.sei.model.VO.AlunoVO;

public interface NotaInterDAO {
	public void lancarNotas(AlunoVO aluno);
	public void lancarFrequencia(AlunoVO aluno);
}

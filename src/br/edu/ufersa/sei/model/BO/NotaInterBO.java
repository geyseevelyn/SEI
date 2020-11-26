package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.AlunoVO;

public interface NotaInterBO {
	
	public void lancarNotas(AlunoVO aluno);
	public void lancarFrequencia(AlunoVO aluno);
}

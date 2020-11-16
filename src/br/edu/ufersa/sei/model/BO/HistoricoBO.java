package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.HistoricoVO;

public class HistoricoBO {
	//métodos
	
	public HistoricoVO exibirHist(AlunoVO aluno) {
		return aluno.getHist();
		//escrever pseudo-código
	}
}

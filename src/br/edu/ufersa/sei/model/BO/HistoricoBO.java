package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.HistoricoVO;

public class HistoricoBO {
	
	public HistoricoVO exibirHist(AlunoVO aluno) {
		return aluno.getHist();
		//Busca no banco de dados um aluno
	    //Se o aluno não existir, retorna um erro
		//Se existir, exibe o historico do aluno
	}
}

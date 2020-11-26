package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.HistoricoVO;

public class HistoricoBO implements HistoricoInterBO {

	@Override
	public List<HistoricoVO> exibirHist(AlunoVO aluno) {
		return aluno.getHist();
		//Busca no banco de dados um aluno
	    //Se o aluno não existir, retorna um erro
		//Se existir, exibe o historico do aluno
	}
}

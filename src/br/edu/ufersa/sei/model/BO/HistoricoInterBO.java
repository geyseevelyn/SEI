package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.HistoricoVO;

public interface HistoricoInterBO {
	public List<HistoricoVO> exibirHist(AlunoVO aluno);
}

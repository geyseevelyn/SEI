package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;

public interface AlunoInterBO {
	public List<AlunoVO> buscarPorTurma(long value);
}

package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class AlunoBO {
	
	//buscar alunos por turma
	public AlunoVO[] buscar(TurmaVO turma) {
		return turma.getAlunos();
	
	//escrever pseudo-código
	}
}

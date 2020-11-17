package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class AlunoBO {
	
	public AlunoVO buscar(AlunoVO aluno) {
		return aluno;
		
		//Busca no banco de dados um aluno
	    //Se o aluno não existir, retorna um erro
		//Se existir, retorna esse aluno
	}
	
	//buscar alunos por turma
	public AlunoVO[] buscar(TurmaVO turma) {
		return turma.getAlunos();
		
		//Busca no banco de dados uma turma
	    //Se a turma não existir, retorna um erro
		//Se existir, retorna os alunos matriculados nessa turma
	}
}

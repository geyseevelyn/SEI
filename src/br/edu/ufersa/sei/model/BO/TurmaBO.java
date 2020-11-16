package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;

public class TurmaBO {

	public void cadastrar(TurmaVO turma) {
		//escrever pseudo-código
	}
		
	public void editar(TurmaVO turma) {
		//escrever pseudo-código
	}
		
	public void excluir(TurmaVO turma) {
		//escrever pseudo-código
	}
		
	public TurmaVO buscar(TurmaVO turma) {
		return turma;
		//escrever pseudo-código
	}
		
	//buscar turma pro prof
	public TurmaVO[] buscar(ProfessorVO prof) {		
		return prof.getTurmas();
		//escrever pseudo-código
	}
}

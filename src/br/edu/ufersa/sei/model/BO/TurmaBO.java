package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;

public class TurmaBO {

	public void cadastrar(TurmaVO turma) {
		//Busca no banco de dados se a turma já existe
		//Se a turma já existir, retorna um erro
		//Se a turma não existir, solicita a inclusão no banco de dados
	}
		
	public void editar(TurmaVO turma) {
		//Busca no banco de dados se a turma já existe
		//Se a turma não existir, retorna um erro
		//Se a turma existir, solicita a edição e atualiza as informações da turma no banco de dados
	}
		
	public void excluir(TurmaVO turma) {
		//Busca no banco de dados se a turma já existe
		//Se a turma não existir, retorna um erro
		//Se a turma existir, apaga as informações da turma no banco de dados
	}
		
	public TurmaVO buscar(TurmaVO turma) {
		return turma;
		//Busca no banco de dados uma turma
	    //Se a turma não existir, retorna um erro
		//Se existir, retorna essa turma
	}
		
	//buscar turma pro prof
	public TurmaVO[] buscar(ProfessorVO prof) {		
		return prof.getTurmas();
		//Busca no banco de dados um professor
	    //Se o professor não existir, retorna um erro
		//Se existir, retorna as turmas que esse professor leciona 
	}
}

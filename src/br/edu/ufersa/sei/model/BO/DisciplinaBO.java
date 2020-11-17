package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.DisciplinaVO;

public class DisciplinaBO {

	public void cadastrar(DisciplinaVO disc) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina já existir, retorna um erro
		//Se a disciplina não existir, solicita a inclusão no banco de dados
	}
	
	public void editar(DisciplinaVO disc) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina não existir, retorna um erro
		//Se a disciplina existir, solicita a edição e atualiza as informações da disciplina no banco de dados
	}
	
	public void excluir(DisciplinaVO disc) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina não existir, retorna um erro
		//Se a disciplina existir, apaga as informações da disciplina no banco de dados
	}
	
	public void finalizar(DisciplinaVO disc) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina não existir, retorna um erro
		//Se a disciplina existir, muda o status de true para false
	}
	
	public DisciplinaVO buscar(DisciplinaVO disc) {
		return disc;
		//Busca no banco de dados uma disciplina
	    //Se a disciplina não existir, retorna um erro
		//Se existir, retorna essa disciplina
	}
}

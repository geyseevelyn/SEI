package br.edu.ufersa.sei.model.BO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;


public class TurmaBO extends BaseBO<TurmaVO> implements TurmaInterBO{
	
	@Override
	public void cadastrar(TurmaVO turma) {
		//Busca no banco de dados se a turma já existe
		//Se a turma já existir, retorna um erro
		//Se a turma não existir, solicita a inclusão no banco de dados
	}
	
	@Override
	public void editar(TurmaVO turma) {
		//Busca no banco de dados se a turma já existe
		//Se a turma não existir, retorna um erro
		//Se a turma existir, solicita a edição e atualiza as informações da turma no banco de dados
	}
	
	@Override
	public void excluir(TurmaVO turma) {
		//Busca no banco de dados se a turma já existe
		//Se a turma não existir, retorna um erro
		//Se a turma existir, apaga as informações da turma no banco de dados
	}
	
	@Override
	public List<TurmaVO> listar() {
		List<TurmaVO> turmas = new ArrayList<TurmaVO>();
		return turmas;
		// lista todas turmas
	}
	
	@Override
	public TurmaVO buscar(TurmaVO turma) {
		return turma;
		//Busca no banco de dados uma turma
	    //Se a turma não existir, retorna um erro
		//Se existir, retorna essa turma
	}
		
	//buscar turma por prof
	@Override
	public List<TurmaVO> buscarPorProf(ProfessorVO prof) {		
		return prof.getTurmas();
		//Busca no banco de dados um professor
	    //Se o professor não existir, retorna um erro
		//Se existir, retorna as turmas que esse professor leciona 
	}
}

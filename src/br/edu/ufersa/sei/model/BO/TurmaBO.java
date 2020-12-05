package br.edu.ufersa.sei.model.BO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;


public class TurmaBO extends BaseBO<TurmaVO> implements TurmaInterBO{
	
	@Override
	public void cadastrar(TurmaVO vo) {
		//Busca no banco de dados se a turma já existe
		//Se a turma já existir, retorna um erro
		//Se a turma não existir, solicita a inclusão no banco de dados
	}
	
	@Override
	public void editar(TurmaVO vo) {
		//Busca no banco de dados se a turma já existe
		//Se a turma não existir, retorna um erro
		//Se a turma existir, solicita a edição e atualiza as informações da turma no banco de dados
	}
	
	@Override
	public void excluir(TurmaVO vo) {
		//Busca no banco de dados se a turma já existe
		//Se a turma não existir, retorna um erro
		//Se a turma existir, apaga as informações da turma no banco de dados
	}
	
	@Override
	public List<TurmaVO> listar() {
		List<TurmaVO> turmas = new ArrayList<TurmaVO>();
		return turmas;
		// implementar
	}
	

	@Override
	public List<TurmaVO> buscarPorNome(TurmaVO vo) throws NotFoundException {
		// implementar
		return null;
	}

	@Override
	public TurmaVO buscarPorId(TurmaVO vo) throws NotFoundException {
		// implementar
		return null;
	}
	
	//buscar turma por prof
	@Override
	public List<TurmaVO> buscarPorProf(ProfessorVO vo) {		
		List<TurmaVO> turmas = new ArrayList<TurmaVO>();
		return turmas;
		//Busca no banco de dados um professor
	    //Se o professor não existir, retorna um erro
		//Se existir, retorna as turmas que esse professor leciona 
	}
}

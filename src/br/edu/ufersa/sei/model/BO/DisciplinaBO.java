package br.edu.ufersa.sei.model.BO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;

public class DisciplinaBO extends BaseBO<DisciplinaVO>{

	@Override
	public void cadastrar(DisciplinaVO vo) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina já existir, retorna um erro
		//Se a disciplina não existir, solicita a inclusão no banco de dados
	}
	
	@Override
	public void editar(DisciplinaVO vo) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina não existir, retorna um erro
		//Se a disciplina existir, solicita a edição e atualiza as informações da disciplina no banco de dados
	}
	
	@Override
	public void excluir(DisciplinaVO vo) {
		//Busca no banco de dados se a disciplina já existe
		//Se a disciplina não existir, retorna um erro
		//Se a disciplina existir, apaga as informações da disciplina no banco de dados
	}
	
	@Override
	public List<DisciplinaVO> listar(){
		List<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();
		return disciplinas; 
	}

	@Override
	public List<DisciplinaVO> buscarPorNome(DisciplinaVO vo) throws NotFoundException {
		//implementar
		return null;
	}

	@Override
	public DisciplinaVO buscarPorId(DisciplinaVO vo) throws NotFoundException {
		//implementar
		return null;
	}
}

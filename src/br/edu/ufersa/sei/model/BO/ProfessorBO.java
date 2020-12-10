package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.VO.ProfessorVO;

public class ProfessorBO<VO extends ProfessorVO> extends BaseBO<ProfessorVO>{

	@Override
	public void cadastrar(ProfessorVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(ProfessorVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(ProfessorVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProfessorVO> listar() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfessorVO> buscarPorNome(ProfessorVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorVO buscarPorId(ProfessorVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
		
	}

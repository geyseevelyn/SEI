package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;
import java.util.List;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class TurmaDAO extends BaseDAO<TurmaVO> implements TurmaInterDAO{

	@Override
	public void inserir(TurmaVO vo) {
		//implementar
	}

	@Override
	public void atualizar(TurmaVO vo) {
		//implementar
	}

	@Override
	public void deletar(TurmaVO vo) {
		//implementar
	}

	@Override
	public ResultSet listar() {
		//implementar
		return null;
	}

	@Override
	public ResultSet buscarPorNome(String nome) {
		//implementar
		return null;
	}

	@Override
	public List<TurmaVO> buscarPorProf(ProfessorVO prof) {		
		//implementar
		return null;
	}
}

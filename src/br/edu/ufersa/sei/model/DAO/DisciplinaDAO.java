package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.sei.model.VO.DisciplinaVO;

public class DisciplinaDAO extends BaseDAO<DisciplinaVO> implements DisciplinaInterDAO{

	@Override
	public void inserir(DisciplinaVO vo) {
		//implementar	
	}

	@Override
	public void atualizar(DisciplinaVO vo) {
		//implementar
	}

	@Override
	public void deletar(DisciplinaVO vo) {
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
	public void finalizar(DisciplinaVO disc) {
		//implementar
	}

	@Override
	public ResultSet buscarPorId(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}	
}

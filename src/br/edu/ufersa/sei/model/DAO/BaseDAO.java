package br.edu.ufersa.sei.model.DAO;

import java.util.List;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
	public abstract void inserir(VO vo);
	public abstract void atualizar(VO vo);
	public abstract void deletar(VO vo);
	public abstract List<VO> listar();
	public abstract VO buscar(VO vo);
}

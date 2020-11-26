package br.edu.ufersa.sei.model.DAO;

import java.util.List;

public interface BaseInterDAO<VO> {
	public void inserir(VO vo);
	public void atualizar(VO vo);
	public void deletar(VO vo);
	public List<VO> listar();
	public VO buscar(VO vo);

}

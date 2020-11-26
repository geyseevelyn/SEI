package br.edu.ufersa.sei.model.BO;

import java.util.List;

public abstract class BaseBO<VO> implements BaseInterBO<VO> {
	public abstract void cadastrar(VO vo);
	public abstract void editar(VO vo);
	public abstract void excluir(VO vo);
	public abstract List<VO> listar();
	public abstract VO buscar(VO vo);
}

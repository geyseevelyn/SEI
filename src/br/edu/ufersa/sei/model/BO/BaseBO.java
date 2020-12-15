package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;

public abstract class BaseBO<VO> implements BaseInterBO<VO> {
	public abstract void cadastrar(VO vo) throws InsertException;
	public abstract void editar(VO vo) throws InsertException;
	public abstract void excluir(VO vo) throws InsertException;
	public abstract List<VO> listar() throws InsertException;
	public abstract List<VO> buscarPorNome(VO vo) throws InsertException;
	public abstract VO buscarPorId(VO vo) throws NotFoundException;
}


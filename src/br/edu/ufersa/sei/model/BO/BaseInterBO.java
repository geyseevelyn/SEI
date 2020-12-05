package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;

public interface BaseInterBO<VO> {
	
	public void cadastrar(VO vo) throws InsertException;
	public void editar(VO vo) throws InsertException;
	public void excluir(VO vo) throws InsertException;
	public List<VO> listar() throws InsertException;
	public List<VO> buscarPorNome(VO vo) throws NotFoundException;
	public VO buscarPorId(VO vo) throws NotFoundException;
}


package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO<VO> {
	public void inserir(VO vo) throws SQLException;
	public void atualizar(VO vo) throws SQLException;
	public void deletar(VO vo) throws SQLException;
	public ResultSet listar() throws SQLException;
	public ResultSet buscarPorNome(String nome) throws SQLException;
	public ResultSet buscarPorId(long id) throws SQLException;

}

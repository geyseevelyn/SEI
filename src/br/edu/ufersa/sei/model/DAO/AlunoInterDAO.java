package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface AlunoInterDAO {
	public ResultSet buscarPorTurma(TurmaVO turma) throws SQLException; //buscar alunos por turma (id)
}

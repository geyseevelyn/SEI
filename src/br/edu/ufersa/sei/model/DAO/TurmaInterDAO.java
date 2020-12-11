package br.edu.ufersa.sei.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface TurmaInterDAO {
	public ResultSet buscarPorProf(ProfessorVO prof) throws SQLException;
	public void cadastrarDisicplinas(TurmaVO turma) throws SQLException;
}

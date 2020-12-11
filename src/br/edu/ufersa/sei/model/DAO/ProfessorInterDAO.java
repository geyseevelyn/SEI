package br.edu.ufersa.sei.model.DAO;

import java.sql.SQLException;

import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public interface ProfessorInterDAO {
	public void cadastrarTurmas(TurmaVO tur, ProfessorVO prof) throws SQLException;
}

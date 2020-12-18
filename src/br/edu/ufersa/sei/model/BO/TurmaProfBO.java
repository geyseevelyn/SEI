package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.TurmaProfDAO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

//Tabela TurmaProf (atribuir ou remover turmas de um professor)

public class TurmaProfBO extends BaseBO<TurmaVO>{
	
	private static TurmaProfDAO tpDAO = new TurmaProfDAO();

	public void cadastrarTurmasProf(TurmaVO turma, ProfessorVO prof) throws InsertException {
		try {
			tpDAO.cadastrarTurmasProf(turma, prof);

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void excluirTurmasProf(TurmaVO turma, ProfessorVO prof) throws InsertException {
		try {
			tpDAO.excluirTurmasProf(turma, prof);

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} 

	//buscar turmas de um professor
	public List<TurmaVO> buscarPorProf(ProfessorVO prof) throws NotFoundException { 
		List<TurmaVO> turmasProf = new ArrayList<TurmaVO>();

		try {
			ResultSet tpRS = tpDAO.buscarTurmasProf(prof);

			while(tpRS.next()) {
				TurmaVO tvo = new TurmaVO();

				tvo.setIdTurma(tpRS.getLong("idturma"));
				tvo.setCodTurma(tpRS.getString("codturma"));
				tvo.setNome(tpRS.getString("nome"));
				tvo.setSala(tpRS.getString("sala"));
				tvo.setHorario(tpRS.getString("turno"));

				turmasProf.add(tvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turmasProf;
	}

	@Override
	public void cadastrar(TurmaVO vo) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public void editar(TurmaVO vo) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(TurmaVO vo) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TurmaVO> listar() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurmaVO> buscarPorNome(TurmaVO vo) throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TurmaVO buscarPorId(TurmaVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

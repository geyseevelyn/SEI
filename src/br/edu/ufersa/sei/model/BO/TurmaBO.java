package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.TurmaDAO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class TurmaBO extends BaseBO<TurmaVO>{
	private static TurmaDAO tDAO = new TurmaDAO(); 
	private static ResultSet turRS = null;
	
	@Override
	public void cadastrar(TurmaVO vo) throws InsertException {
		try {
			turRS = tDAO.buscarPorId(vo);

			if(turRS.next()) {
				throw new InsertException("Turma já cadastrada no sistema");
			} else {
				tDAO.inserir(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void editar(TurmaVO vo) throws InsertException{
		try {
			 turRS = tDAO.buscarPorId(vo);
			
			if(turRS.next()) {
				vo.setIdTurma(turRS.getLong("idTurma")); 
				tDAO.atualizar(vo);
			} else {
				throw new InsertException("Turma informada não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void excluir(TurmaVO vo) throws InsertException{
		try {
			turRS = tDAO.buscarPorId(vo);
			
			if(turRS.next()) {
				vo.setIdTurma(turRS.getLong("idTurma")); 
				tDAO.deletar(vo);			
			} else {
				throw new InsertException("Turma Informada não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<TurmaVO> listar() throws InsertException {
		List<TurmaVO> turmas = new ArrayList<TurmaVO>();

		try {
			turRS = tDAO.listar();

			while(turRS.next()) {
				TurmaVO tvo = new TurmaVO();
				tvo.setIdTurma(turRS.getLong("idTurma"));
				tvo.setCodTurma(turRS.getString("codturma"));
				tvo.setNome(turRS.getString("nome"));
				tvo.setSala(turRS.getString("sala"));
				tvo.setHorario(turRS.getString("turno"));

				turmas.add(tvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turmas;
	}

	@Override
	public List<TurmaVO> buscarPorNome(TurmaVO vo) throws InsertException {
		List<TurmaVO> turmas = new ArrayList<TurmaVO>();

		try {
			turRS = tDAO.buscarPorNome(vo);

			while(turRS.next()) {
				TurmaVO tvo = new TurmaVO();

				tvo.setIdTurma(turRS.getLong("idTurma"));
				tvo.setCodTurma(turRS.getString("codturma"));
				tvo.setNome(turRS.getString("nome"));
				tvo.setSala(turRS.getString("sala"));
				tvo.setHorario(turRS.getString("turno"));

				turmas.add(tvo);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turmas;
	}

	@Override
	public TurmaVO buscarPorId(TurmaVO vo) throws NotFoundException {
		try {
			turRS = tDAO.buscarPorId(vo);

			if(turRS.next()) {
				TurmaVO tvo = new TurmaVO();

				tvo.setIdTurma(turRS.getLong("idTurma"));
				tvo.setCodTurma(turRS.getString("codturma"));
				tvo.setNome(turRS.getString("nome"));
				tvo.setSala(turRS.getString("sala"));
				tvo.setHorario(turRS.getString("turno"));

				return tvo;
			} else {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TurmaVO buscarPorId(long id) throws NotFoundException {
		try {
			turRS = tDAO.buscarPorId(id);

			if(turRS.next()) {
				TurmaVO tvo = new TurmaVO();

				tvo.setIdTurma(turRS.getLong("idTurma"));
				tvo.setCodTurma(turRS.getString("codturma"));
				tvo.setNome(turRS.getString("nome"));
				tvo.setSala(turRS.getString("sala"));
				tvo.setHorario(turRS.getString("turno"));

				return tvo;
			} else {
				throw new NotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

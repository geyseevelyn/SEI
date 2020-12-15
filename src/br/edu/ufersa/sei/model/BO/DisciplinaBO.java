package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.DisciplinaDAO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;

public class DisciplinaBO extends BaseBO<DisciplinaVO>{
	private static DisciplinaDAO discDAO = new DisciplinaDAO();
	private static ResultSet discRS = null;

	@Override
	public void cadastrar(DisciplinaVO vo) throws InsertException {
		try {
			discRS = discDAO.buscarPorId(vo);

			if(discRS.next()) {
				throw new InsertException("Disciplina já cadastrada no sistema");
			} else {
				discDAO.inserir(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void editar(DisciplinaVO vo) throws InsertException {
		try {
			discRS = discDAO.buscarPorId(vo);

			if(discRS.next()) {
				vo.setIdDisc(discRS.getLong("idDisc")); 
				discDAO.atualizar(vo);
			} else {
				throw new InsertException("Disciplina informada não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(DisciplinaVO vo) throws InsertException {
		try {
			discRS = discDAO.buscarPorId(vo);

			if(discRS.next()) {
				vo.setIdDisc(discRS.getLong("idDisc")); 
				discDAO.deletar(vo);			
			} else {
				throw new InsertException("Disciplina Informada não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<DisciplinaVO> listar() throws InsertException {
		List<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();

		try {
			discRS = discDAO.listar();

			while(discRS.next()) {
				DisciplinaVO dvo = new DisciplinaVO();

				dvo.setIdDisc(discRS.getLong("iddisc"));
				dvo.setCodigo(discRS.getString("coddisc"));
				dvo.setNome(discRS.getString("nome"));
				dvo.setStatus(discRS.getBoolean("status"));

				ProfessorVO pvo = new ProfessorVO();
				ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
				pvo = pbo.buscarPorId(discRS.getLong("idprof"));

				dvo.setProfDisc(pvo);

				disciplinas.add(dvo);  //preencher lista
			}
		} catch (SQLException | NotFoundException e) {
			e.printStackTrace();
		}
		return disciplinas; 
	}

	@Override
	public List<DisciplinaVO> buscarPorNome(DisciplinaVO vo) throws InsertException {
		List<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();
		//ProfessorVO pvo = new ProfessorVO();

		try {
			discRS = discDAO.buscarPorNome(vo);

			while(discRS.next()) {
				DisciplinaVO dvo = new DisciplinaVO();

				dvo.setIdDisc(discRS.getLong("iddisc"));
				dvo.setCodigo(discRS.getString("coddisc"));
				dvo.setNome(discRS.getString("nome"));
				dvo.setStatus(discRS.getBoolean("status"));

				ProfessorVO pvo2 = new ProfessorVO();
				ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
				try {
					pvo2 = pbo.buscarPorId(discRS.getLong("idprof"));

				} catch (NotFoundException e) {
					e.printStackTrace();
				}

				dvo.setProfDisc(pvo2);
				disciplinas.add(dvo);  
			}        	 	        	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplinas; 
	}

	@Override
	public DisciplinaVO buscarPorId(DisciplinaVO vo) throws NotFoundException {
		ProfessorVO pvo = new ProfessorVO();

		try {
			discRS = discDAO.buscarPorId(vo);

			if(discRS.next()) {
				DisciplinaVO vo2 = new DisciplinaVO();

				vo2.setIdDisc(discRS.getLong("iddisc"));
				vo2.setCodigo(discRS.getString("coddisc"));
				vo2.setNome(discRS.getString("nome"));
				vo2.setStatus(discRS.getBoolean("status"));
				pvo.setIdProf(discRS.getLong("idprof"));
				vo2.setProfDisc(pvo);

				return vo2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DisciplinaVO buscarPorIdProf(ProfessorVO vo) throws NotFoundException {
		ProfessorVO pvo = new ProfessorVO();

		try {
			discRS = discDAO.buscarPorIdProf(vo);

			if(discRS.next()) {
				DisciplinaVO dvo2 = new DisciplinaVO();

				dvo2.setIdDisc(discRS.getLong("iddisc"));
				dvo2.setCodigo(discRS.getString("coddisc"));
				dvo2.setNome(discRS.getString("nome"));
				dvo2.setStatus(discRS.getBoolean("status"));
				pvo.setIdProf(discRS.getLong("idprof"));
				dvo2.setProfDisc(pvo);

				return dvo2;
			} else throw new NotFoundException();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

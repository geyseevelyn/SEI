package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.TurmaDiscDAO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

//Tabela TurmaDisc (cadastrar, excluir, buscar disciplinas de uma turma)

public class TurmaDiscBO extends BaseBO<TurmaVO>{
	private static TurmaDiscDAO tdDAO = new TurmaDiscDAO();
	
	public void cadastrarDisicplinasTurma(TurmaVO turma, DisciplinaVO disc) throws InsertException {
		try {
			 tdDAO.cadastrarDisicplinasTurma(turma, disc);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void excluirDisicplinasTurma(TurmaVO turma, DisciplinaVO disc) throws InsertException {
		try {
			 tdDAO.excluirDisicplinasTurma(turma, disc);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} 
	
	//buscar disciplinas de uma turma
	public List<DisciplinaVO> buscarDiscTurma(TurmaVO turma) throws NotFoundException {  //TESTAR!!!
		List<DisciplinaVO> disciplinasTurma = new ArrayList<DisciplinaVO>();
		
		try {
			 ResultSet tdRS = tdDAO.buscarDiscTurma(turma);
			 
			 while(tdRS.next()) {
				 DisciplinaVO dvo = new DisciplinaVO();
				 ProfessorVO pvo = new ProfessorVO();
				 ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
			 
	        	 dvo.setCodigo(tdRS.getString("coddisc"));
	        	 dvo.setIdDisc(tdRS.getLong("iddisc"));
	        	 dvo.setNome(tdRS.getString("nome"));
	        	 dvo.setStatus(tdRS.getBoolean("status"));
	        	 pvo = pbo.buscarPorId(tdRS.getLong("idprof"));
	        	 dvo.setProfDisc(pvo);
	        	 
	        	 disciplinasTurma.add(dvo);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplinasTurma;
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

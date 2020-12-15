package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.BoletimDAO;
import br.edu.ufersa.sei.model.DAO.NotaDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;;

public class NotaBO extends BaseBO<NotaVO>{
	private static NotaDAO nDAO = new NotaDAO();
	private static BoletimDAO bDAO = new BoletimDAO();
	private static ResultSet nRS = null;

	@Override
	public void cadastrar(NotaVO vo) throws InsertException {
		try {
			nRS = nDAO.buscarNotaAluno(vo.getAluno(),vo.getDisc());  

			if(nRS.next()) {
				nDAO.atualizar(vo);
				//bDAO.atualizar(vo);
			} else {
				nDAO.inserir(vo);
				//bDAO.inserir(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(NotaVO vo) throws InsertException {
		try {
			 nDAO.atualizar(vo);
			 //bDAO.atualizar(vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(NotaVO vo) {
		try {
			 nDAO.deletar(vo);
			 bDAO.deletar(vo);
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<NotaVO> listar() throws InsertException {
		List<NotaVO> notas = new ArrayList<NotaVO>();
			
		try {
		      nRS = nDAO.listar();
		      AlunoVO avo = new AlunoVO();
		      DisciplinaVO discvo = new DisciplinaVO();
		        	
		         while(nRS.next()) {
		        	 NotaVO vo = new NotaVO();
					 
		        	 vo.setN1(nRS.getDouble("n1"));
		        	 vo.setN2(nRS.getDouble("n2"));
		        	 vo.setN3(nRS.getDouble("n3"));
		        	 vo.setFaltas(nRS.getInt("faltas"));
		        	 avo.setIdAluno(nRS.getLong("idaluno"));
		        	 discvo.setIdDisc(nRS.getLong("iddisc"));
		        	 vo.setAluno(avo);
		        	 vo.setDisc(discvo);
      	
		        	notas.add(vo);
		        }
			} catch (SQLException e) {
					e.printStackTrace();
			}
		    return notas;
	}
	
	public NotaVO buscarNotaAluno(NotaVO vo) throws NotFoundException {
        
		try {
	         nRS = nDAO.buscarNotaAluno(vo.getAluno(),vo.getDisc());
	         AlunoVO avo = new AlunoVO();
		     DisciplinaVO dvo = new DisciplinaVO();
		     
	         if(nRS.next()) {
	        	vo.setN1(nRS.getDouble("n1"));
	        	vo.setN2(nRS.getDouble("n2"));
	        	vo.setN3(nRS.getDouble("n3"));
	        	vo.setFaltas(nRS.getInt("faltas"));
	        	avo.setIdAluno(nRS.getLong("idaluno"));
	        	dvo.setIdDisc(nRS.getLong("iddisc"));
	        	vo.setIdNota(nRS.getLong("idnota"));
	        	vo.setAluno(avo);
	        	vo.setDisc(dvo);
	        	
	        	return vo;        
	        	
	        }
	         
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return null;
	}
	
	public List<NotaVO> listarNotaAluno(NotaVO vo) throws NotFoundException {
		List<NotaVO> notas = new ArrayList<NotaVO>();
		
		try {
			nRS = nDAO.buscarNotaAluno(vo.getAluno(),vo.getDisc());
			AlunoVO avo = new AlunoVO();
			DisciplinaVO dvo = new DisciplinaVO();

			while(nRS.next()) {
				vo.setN1(nRS.getDouble("n1"));
				vo.setN2(nRS.getDouble("n2"));
				vo.setN3(nRS.getDouble("n3"));
				vo.calcularMedia(nRS.getDouble("n1"), nRS.getDouble("n2"), nRS.getDouble("n3"));
				vo.setFaltas(nRS.getInt("faltas"));
				avo.setIdAluno(nRS.getLong("idaluno"));
				dvo.setIdDisc(nRS.getLong("iddisc"));
				vo.setIdNota(nRS.getLong("idnota"));
				vo.setAluno(avo);
				vo.setDisc(dvo);
				
				notas.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notas;
	}
	
	public List<NotaVO> listarNotasAluno(AlunoVO alu) throws InsertException {
		List<NotaVO> notas = new ArrayList<NotaVO>();

		try {
			nRS = nDAO.listarNotasAluno(alu);
			AlunoVO avo = new AlunoVO();
			DisciplinaVO dvo = new DisciplinaVO();
			DisciplinaBO dbo = new DisciplinaBO();
			try {
				dbo.buscarPorId(dvo);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}


			while(nRS.next()) {
				NotaVO vo = new NotaVO();

				vo.setN1(nRS.getDouble("n1"));
				vo.setN2(nRS.getDouble("n2"));
				vo.setN3(nRS.getDouble("n3"));
				vo.calcularMedia(nRS.getDouble("n1"), nRS.getDouble("n2"), nRS.getDouble("n3"));
				vo.setFaltas(nRS.getInt("faltas"));
				avo.setIdAluno(nRS.getLong("idaluno"));
				dvo.setIdDisc(nRS.getLong("iddisc"));
				try {
					dvo = dbo.buscarPorId(dvo);
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
				vo.setAluno(avo);
				vo.setDisc(dvo);


				notas.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notas;
	}
	
	@Override
	public List<NotaVO> buscarPorNome(NotaVO vo) throws InsertException {
		return null;
	}

	@Override
	public NotaVO buscarPorId(NotaVO vo) throws NotFoundException {
		return null;
	}
}

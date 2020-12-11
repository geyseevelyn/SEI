package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.ProfessorDAO;
import br.edu.ufersa.sei.model.DAO.UsuarioInterDAO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;

public class ProfessorBO<VO extends ProfessorVO> extends BaseBO<ProfessorVO>{
	private static UsuarioInterDAO<ProfessorVO> pDAO = new ProfessorDAO<ProfessorVO>();
	private static ResultSet pRS = null;

	@Override
	public void cadastrar(ProfessorVO vo) throws InsertException {
		try {
			pRS = pDAO.buscarPorId(vo);
		
			if(pRS.next()) {
				throw new InsertException("Professor já cadastrado no sistema");
			} else {
				pDAO.inserir(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void editar(ProfessorVO vo) throws InsertException {
		try {
			 pRS = pDAO.buscarPorId(vo);

				if(pRS.next()) {
					vo.setIdUsu(pRS.getLong("idUsu")); //testar isso
					pDAO.atualizar(vo);
				} else {
					throw new InsertException("Professor informado não existe!");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(ProfessorVO vo) throws InsertException {
		try {
			 pRS = pDAO.buscarPorId(vo);
			
			if(pRS.next()) {	
				vo.setIdUsu(pRS.getLong("idUsu")); 
				pDAO.deletar(vo);
			} else {
				throw new InsertException("Professor informado não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<ProfessorVO> listar() throws InsertException {
		List<ProfessorVO> profs = new ArrayList<ProfessorVO>();
		
		try {
	         pRS = pDAO.listar();
	        	
	         while(pRS.next()) {
	        	 ProfessorVO vo = new ProfessorVO();
				 
	        	 vo.setIdUsu(pRS.getLong("idusu"));
	        	 vo.setNome(pRS.getString("nome"));
	        	 vo.setCpf(pRS.getString("cpf"));
	        	 vo.setEndereco(pRS.getString("endereco"));
	        	 vo.setEmail(pRS.getString("email"));
	        	 vo.setLogin(pRS.getString("login"));
	        	 vo.setSenha(pRS.getString("senha"));
	        	 vo.setIdProf(pRS.getLong("idProf"));
    	
	        	 profs.add(vo);
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return profs;
	}

	@Override
	public List<ProfessorVO> buscarPorNome(ProfessorVO vo) throws NotFoundException {
		List<ProfessorVO> profs = new ArrayList<ProfessorVO>();
		
		try {
	         pRS = pDAO.buscarPorNome(vo);
	        	
	         while(pRS.next()) {
	        	 ProfessorVO vo2 = new ProfessorVO();
				 
	        	 vo2.setIdUsu(pRS.getLong("idUsu"));
	        	 vo2.setNome(pRS.getString("nome"));
	        	 vo2.setCpf(pRS.getString("cpf"));
	        	 vo2.setEndereco(pRS.getString("endereco"));
	        	 vo2.setEmail(pRS.getString("email"));
	        	 vo2.setIdProf(pRS.getLong("idProf"));
    	
	        	 profs.add(vo2);
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return profs;
	}

	@Override
	public ProfessorVO buscarPorId(ProfessorVO vo) throws NotFoundException {
		try {
	         pRS = pDAO.buscarPorId(vo);
	        	
	         if(pRS.next()) {
	        	ProfessorVO vo2 = new ProfessorVO();
				 
	        	vo2.setIdUsu(pRS.getLong("idusu"));
	        	vo2.setNome(pRS.getString("nome"));
	        	vo2.setCpf(pRS.getString("cpf"));
	        	vo2.setEndereco(pRS.getString("endereco"));
	        	vo2.setEmail(pRS.getString("email"));
	        	vo2.setLogin(pRS.getString("login"));
	        	vo2.setSenha(pRS.getString("senha"));
	            vo2.setIdProf(pRS.getLong("idaProf"));
    	 	        	
	        	return vo2;
	        } else throw new NotFoundException();
	         
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return null;
	}	
}

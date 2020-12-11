package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.AutenticationException;
import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.DiretorDAO;
import br.edu.ufersa.sei.model.DAO.ProfessorDAO;
import br.edu.ufersa.sei.model.DAO.UsuarioDAO;
import br.edu.ufersa.sei.model.DAO.UsuarioInterDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DiretorVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> implements UsuarioInterBO<UsuarioVO>{
	
	private static UsuarioInterDAO<UsuarioVO> usuDAO = new UsuarioDAO<UsuarioVO>();
	private static UsuarioInterDAO<ProfessorVO> profDAO = new ProfessorDAO<ProfessorVO>();
	private static UsuarioInterDAO<DiretorVO> dirDAO = new DiretorDAO<DiretorVO>();
	
	@Override
	public UsuarioVO autenticar(UsuarioVO vo) throws AutenticationException {
		
		try {
			 ResultSet usuRS = usuDAO.buscarPorLogin(vo);
			 //encontrou usuário
			 if(usuRS.next()) {
				 if(usuRS.getString("senha").equals(vo.getSenha())) {
					 //existe e senha ok. Descobrir se é aluno, prof ou diretor
					 
					 DiretorVO dir = new DiretorVO();
					 dir.setIdUsu(usuRS.getLong("idUsu"));
					 
					 ResultSet dirRS = dirDAO.buscarPorId(dir);
					 if(dirRS.next()) {
						 //é um diretor
						 dir.setLogin(vo.getLogin());
						 dir.setNome(usuRS.getString("nome"));
						 dir.setCpf(usuRS.getString("cpf"));
						 dir.setEndereco(usuRS.getString("endereco"));
						 dir.setEmail(usuRS.getString("email"));
						 return dir;
						 
					 } else {
						 
						 ProfessorVO prof = new ProfessorVO();
						 prof.setIdUsu(usuRS.getLong("idUsu"));
						 
						 ResultSet profRS = profDAO.buscarPorId(prof);
						 if(profRS.next()) {
							 //é um professor
							 prof.setLogin(vo.getLogin());
							 prof.setNome(usuRS.getString("nome"));
							 prof.setCpf(usuRS.getString("cpf"));
							 prof.setEndereco(usuRS.getString("endereco"));
							 prof.setEmail(usuRS.getString("email"));
							 return prof;
							 
						 } else {	
							 //tem que ser um aluno
							 AlunoVO alu = new AlunoVO();  //tem que preencher tudo?
							 alu.setIdUsu(usuRS.getLong("idUsu"));
							 return alu;
						 }
					 }
					 
				 } else throw new AutenticationException();
				 
			 } else throw new AutenticationException();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AutenticationException();
		}
	}

	@Override
	public void cadastrar(UsuarioVO vo) throws InsertException {
		try {
			ResultSet usuRS = usuDAO.buscarPorId(vo);
			
			if(usuRS.next()) {
				throw new InsertException("Usuário já existe!");
			} else {
				usuDAO.inserir(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void editar(UsuarioVO vo) throws InsertException {
		try {
			ResultSet usuRS = usuDAO.buscarPorLogin(vo);
			
			//pesquisar se existe
			if(usuRS.next()) {
				usuDAO.atualizar(vo);
			} else {
				throw new InsertException("Usuário informado não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void excluir(UsuarioVO vo) throws InsertException {
		try {
			ResultSet usuRS = usuDAO.buscarPorLogin(vo);
			
			if(usuRS.next()) {
				usuDAO.deletar(vo);
			} else {
				throw new InsertException("Usuário informado não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<UsuarioVO> listar() throws InsertException{
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		
		try {
	         ResultSet usuRS = usuDAO.listar();
	        	
	         while(usuRS.next()) {
	        	 UsuarioVO vo = new UsuarioVO();
				 
	        	 vo.setIdUsu(usuRS.getLong("idUsu"));
	        	 vo.setNome(usuRS.getString("nome"));
	        	 vo.setCpf(usuRS.getString("cpf"));
	        	 vo.setEndereco(usuRS.getString("endereco"));
	        	 vo.setEmail(usuRS.getString("email"));
	        	 vo.setLogin(usuRS.getString("login"));
	        	 vo.setSenha(usuRS.getString("senha"));
	        	 
	        	 usuarios.add(vo);
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return usuarios;
	}
	
	@Override
	public List<UsuarioVO> buscarPorNome(UsuarioVO vo) throws NotFoundException {
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		
		try {
			 ResultSet usuRS = usuDAO.buscarPorNome(vo);
			 
			 while(usuRS.next()) {
				 UsuarioVO vo2 = new UsuarioVO();
				 
				 vo2.setIdUsu(usuRS.getLong("idUsu"));
	        	 vo2.setNome(usuRS.getString("nome"));
	        	 vo2.setCpf(usuRS.getString("cpf"));
	        	 vo2.setEndereco(usuRS.getString("endereco"));
	        	 vo2.setEmail(usuRS.getString("email"));
	        	 vo2.setLogin(usuRS.getString("login"));
	        	 vo2.setSenha(usuRS.getString("senha"));
	        	 
	        	 usuarios.add(vo2);
			 }			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public UsuarioVO buscarPorId(UsuarioVO vo) throws NotFoundException {
		
		try {
			 ResultSet usuRS = usuDAO.buscarPorId(vo);
			 
			 if(usuRS.next()) {
				 UsuarioVO vo2 = new UsuarioVO();
				 
				 vo2.setIdUsu(usuRS.getLong("idUsu"));
	        	 vo2.setNome(usuRS.getString("nome"));
	        	 vo2.setCpf(usuRS.getString("cpf"));
	        	 vo2.setEndereco(usuRS.getString("endereco"));
	        	 vo2.setEmail(usuRS.getString("email"));
	        	 vo2.setLogin(usuRS.getString("login"));
	        	 vo2.setSenha(usuRS.getString("senha"));
	        	 return vo2;
			 } else {
				 throw new NotFoundException();
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

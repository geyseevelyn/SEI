package br.edu.ufersa.sei.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.AlunoDAO;
import br.edu.ufersa.sei.model.DAO.TurmaDAO;
import br.edu.ufersa.sei.model.DAO.UsuarioInterDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

//?
public class AlunoBO<VO extends AlunoVO> extends BaseBO<AlunoVO> implements AlunoInterBO{ 

	private static UsuarioInterDAO<AlunoVO> aluDAO = new AlunoDAO<AlunoVO>();

	@Override
	public void cadastrar(AlunoVO vo) throws InsertException {
		try {
			ResultSet aluRS = aluDAO.buscarPorId(vo);  // aluDAO.buscarPorLogin(vo) ??
			
			if(aluRS.next()) {
				throw new InsertException("Aluno já cadastrado no sistema");
			} else {
				aluDAO.inserir(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void editar(AlunoVO vo) throws InsertException {
		try {
			ResultSet aluRS = aluDAO.buscarPorId(vo);
			
			//pesquisar se existe
			if(aluRS.next()) {
				vo.setIdUsu(aluRS.getLong("idUsu")); //testar isso
				aluDAO.atualizar(vo);
			} else {
				throw new InsertException("Aluno informado não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(AlunoVO vo) throws InsertException {
		try {
			ResultSet aluRS = aluDAO.buscarPorLogin(vo);
			
			if(aluRS.next()) {
				vo.setIdUsu(aluRS.getLong("idUsu"));
				aluDAO.deletar(vo);
			} else {
				throw new InsertException("Aluno informado não existe!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<AlunoVO> listar() throws InsertException {
		List<AlunoVO> alunos = new ArrayList<AlunoVO>();
		
		try {
	         ResultSet aluRS = aluDAO.listar();
	         TurmaVO tvo = new TurmaVO();
	         //TurmaBO tbo = new TurmaBO();
	        	
	         while(aluRS.next()) {
	        	 AlunoVO vo = new AlunoVO();
				 
	        	 vo.setIdUsu(aluRS.getLong("idusu"));
	        	 vo.setIdAluno(aluRS.getLong("idaluno"));
	        	 vo.setMatricula(aluRS.getString("matricula"));
	        	 tvo.setIdTurma(aluRS.getLong("idturma")); //pegar o id da turma para setar
	        	 vo.setTurma(tvo); //testar
	        	 
//	        	 try {
//					vo.setTurma(tbo.buscarPorId(tvo));
//				} catch (NotFoundException e) {
//					e.printStackTrace();
//				}
	        	 
	        	ResultSet rs = aluDAO.buscarPorId(vo);
	        	
	        	while(rs.next()) {
	        		vo.setNome(rs.getString("nome"));
	        		vo.setCpf(rs.getString("cpf"));
	        		vo.setEndereco(rs.getString("endereco"));
	        		vo.setEmail(rs.getString("email"));
	        		vo.setLogin(rs.getString("login"));
	        		vo.setSenha(rs.getString("senha"));
	        	}
	        	 alunos.add(vo);  //preencher lista
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return alunos;
	}

	@Override
	public List<AlunoVO> buscarPorNome(AlunoVO vo) throws NotFoundException {
		List<AlunoVO> alunos = new ArrayList<AlunoVO>();
		
		try {
	         ResultSet aluRS = aluDAO.buscarPorNome(vo);
	         TurmaVO tvo = new TurmaVO();
	         //TurmaBO tbo = new TurmaBO();
	        	
	         while(aluRS.next()) {
	        	 AlunoVO vo2 = new AlunoVO();
				 
	        	 vo2.setIdUsu(aluRS.getLong("idusu"));
	        	 vo2.setMatricula(aluRS.getString("matricula"));
	        	 tvo.setIdTurma(aluRS.getLong("turma")); //pegar o id da turma para setar
	        	 vo2.setTurma(tvo); //testar
	        	 
//	        	 try {
//					vo.setTurma(tbo.buscarPorId(tvo));
//				} catch (NotFoundException e) {
//					e.printStackTrace();
//				}
	        	 
	        	ResultSet rs = aluDAO.buscarPorId(vo);
	        	
	        	while(rs.next()) {
	        		vo2.setNome(rs.getString("nome"));
	        		vo2.setCpf(rs.getString("cpf"));
	        		vo2.setEndereco(rs.getString("endereco"));
	        		vo2.setEmail(rs.getString("email"));
	        		vo2.setIdUsu(rs.getLong("idUsu"));
	        	}
	        	 alunos.add(vo2);  
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return alunos;
	}

	@Override
	public AlunoVO buscarPorId(AlunoVO vo) throws NotFoundException {
		try {
	         ResultSet aluRS = aluDAO.listar();
	         TurmaVO tvo = new TurmaVO();
	         //TurmaBO tbo = new TurmaBO();
	        	
	         while(aluRS.next()) {
	        	 AlunoVO vo2 = new AlunoVO();
				 
	        	 vo2.setIdUsu(aluRS.getLong("idusu"));
	        	 vo2.setIdAluno(aluRS.getLong("idaluno"));
	        	 vo2.setMatricula(aluRS.getString("matricula"));
	        	 tvo.setIdTurma(aluRS.getLong("idturma")); //pegar o id da turma para setar
	        	 vo2.setTurma(tvo); //testar
	        	 
//	        	 try {
//					vo.setTurma(tbo.buscarPorId(tvo));
//				} catch (NotFoundException e) {
//					e.printStackTrace();
//				}
	        	 
	        	ResultSet rs = aluDAO.buscarPorId(vo);
	        	
	        	while(rs.next()) {
	        		vo2.setNome(rs.getString("nome"));
	        		vo2.setCpf(rs.getString("cpf"));
	        		vo2.setEndereco(rs.getString("endereco"));
	        		vo2.setEmail(rs.getString("email"));
	        		vo2.setLogin(rs.getString("login"));
	        		vo2.setSenha(rs.getString("senha"));
	        	}
	        	return vo2;
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return null;
	}
	
	@Override
	public List<AlunoVO> buscarPorTurma(TurmaVO turma) throws InsertException {
		List<AlunoVO> alunos = new ArrayList<AlunoVO>();
	
		try {
			 TurmaDAO tdao = new TurmaDAO();
			 TurmaVO tvo = new TurmaVO();
			 ResultSet turRS = tdao.buscarPorId(turma);
			
			 while(turRS.next()) {
				 tvo.setIdTurma(turRS.getLong("idTurma"));
			 }
			 
			 AlunoVO vo2 = new AlunoVO();
	         ResultSet aluRS = aluDAO.buscarPorLogin(vo2);
	         
	         while(aluRS.next()) {	 
	        	 vo2.setIdUsu(aluRS.getLong("idusu"));
	        	 vo2.setMatricula(aluRS.getString("matricula"));
	        	  
	        	ResultSet rs = aluDAO.buscarPorId(vo2);
	        	while(rs.next()) {
	        		vo2.setNome(rs.getString("nome"));
	        		vo2.setIdUsu(rs.getLong("idUsu"));
	        	}
	        	 alunos.add(vo2);  
	        }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return alunos;
	}
 }
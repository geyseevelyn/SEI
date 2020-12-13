package br.edu.ufersa.sei.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.AlunoDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;

public class AlunoBO<VO extends AlunoVO> extends BaseBO<AlunoVO> implements AlunoInterBO{ 
	private static AlunoDAO<AlunoVO> aluDAO = new AlunoDAO<AlunoVO>();
	private static ResultSet aluRS = null;

	@Override
	public void cadastrar(AlunoVO vo) throws InsertException {
		try {
			aluRS = aluDAO.buscarPorId(vo);  // aluDAO.buscarPorLogin(vo) ??
			
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
			aluRS = aluDAO.buscarPorId(vo);
			
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
			aluRS = aluDAO.buscarPorId(vo);
			
			if(aluRS.next()) {
				vo.setIdUsu(aluRS.getLong("idUsu")); //testar isso
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
	         aluRS = aluDAO.listar();
	         //TurmaBO tbo = new TurmaBO();
	        	
	         while(aluRS.next()) {
	        	 AlunoVO vo = new AlunoVO();
	        	 TurmaVO tvo = new TurmaVO();
				 
	        	 vo.setIdUsu(aluRS.getLong("idusu"));
	        	 vo.setNome(aluRS.getString("nome"));
	        	 vo.setCpf(aluRS.getString("cpf"));
	        	 vo.setEndereco(aluRS.getString("endereco"));
	        	 vo.setEmail(aluRS.getString("email"));
	        	 vo.setLogin(aluRS.getString("login"));
	        	 vo.setSenha(aluRS.getString("senha"));
	        	 vo.setIdAluno(aluRS.getLong("idaluno"));
	        	 vo.setMatricula(aluRS.getString("matricula"));
	        	 vo.setTurma(tvo);
	        	 tvo.setIdTurma(aluRS.getLong("idturma"));
	        	// vo.getTurma().setIdTurma(aluRS.getLong("idturma"));; //pegar o id da turma para setá-la
	        	  //testar
	        	 
//	        	try {
//					vo.setTurma(tbo.buscarPorId(tvo));  //não está setando...
//				} catch (NotFoundException e) {
//					e.printStackTrace();
//				}	        	
	        	alunos.add(vo);
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
			
	         aluRS = aluDAO.buscarPorNome(vo);
	        	
	         while(aluRS.next()) {
	        	AlunoVO vo2 = new AlunoVO();
				 
	        	vo2.setIdUsu(aluRS.getLong("idUsu"));
        		vo2.setNome(aluRS.getString("nome"));
        		vo2.setCpf(aluRS.getString("cpf"));
        		vo2.setEndereco(aluRS.getString("endereco"));
        		vo2.setEmail(aluRS.getString("email"));
        		vo2.setLogin(aluRS.getString("login"));
        		vo2.setSenha(aluRS.getString("senha"));
	        	vo2.setMatricula(aluRS.getString("matricula"));
	        	
	        	TurmaVO tvo = new TurmaVO();
	        	TurmaBO tbo = new TurmaBO();
	        	try {
					tvo = tbo.buscarPorId(aluRS.getLong("idturma"));
					
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
	        	 vo2.setTurma(tvo);
	        	
	        	alunos.add(vo2);  
	        }        	 
	        	 
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return alunos;
	}

	@Override
	public AlunoVO buscarPorId(AlunoVO vo) throws NotFoundException {
        TurmaVO tvo = new TurmaVO();
        //TurmaBO tbo = new TurmaBO();
        
		try {
	         aluRS = aluDAO.buscarPorId(vo);
	        	
	         if(aluRS.next()) {
	        	AlunoVO vo2 = new AlunoVO();
				 
	        	vo2.setIdUsu(aluRS.getLong("idusu"));
	        	vo2.setNome(aluRS.getString("nome"));
	        	vo2.setCpf(aluRS.getString("cpf"));
	        	vo2.setEndereco(aluRS.getString("endereco"));
	        	vo2.setEmail(aluRS.getString("email"));
	        	vo2.setLogin(aluRS.getString("login"));
	        	vo2.setSenha(aluRS.getString("senha"));
	            vo2.setIdAluno(aluRS.getLong("idaluno"));
	        	vo2.setMatricula(aluRS.getString("matricula"));
	        	tvo.setIdTurma(aluRS.getLong("idturma")); //pegar o id da turma para setar
	        	vo2.setTurma(tvo); //testar
	        	 
//	        	try {
//					vo2.setTurma(tbo.buscarPorId(tvo));
//				} catch (NotFoundException e) {
//					e.printStackTrace();
//				}        	 	        	
	        	return vo2;
	        	
	        } else throw new NotFoundException();
	         
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return null;
	}
	
	//buscar alunos por turma
	@Override
	public List<AlunoVO> buscarAlunosPorTurma(TurmaVO turma) throws InsertException { 
		List<AlunoVO> alunos = new ArrayList<AlunoVO>();
	
		try {
			 TurmaVO tvo = new TurmaVO();			 
			 tvo.setNome(turma.getNome());
			 
			 
	         aluRS = aluDAO.buscarAlunosPorTurma(tvo);
	         
	         while(aluRS.next()) {	 
	        	 AlunoVO vo = new AlunoVO();
	        	         	 	        	        	 
	        	 vo.setIdUsu(aluRS.getLong("idusu"));
	        	 vo.setNome(aluRS.getString("nome"));
	        	 vo.setCpf(aluRS.getString("cpf"));
	        	 vo.setMatricula(aluRS.getString("matricula"));
	        	 vo.setEmail(aluRS.getString("email"));
	        	 vo.setLogin(aluRS.getString("login"));
	        	 vo.setSenha(aluRS.getString("senha"));
	        	 vo.setEndereco(aluRS.getString("endereco"));
	        	 //vo.setTurma(turma);
	        	 TurmaVO tvo2 = new TurmaVO();
	        	 TurmaBO tbo = new TurmaBO();
	        	 try {
					tvo2 = tbo.buscarPorId(aluRS.getLong("idturma"));
					
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
	        	 vo.setTurma(tvo2);
	        	 alunos.add(vo); 
	        }	 
		} catch (SQLException e) {
				e.printStackTrace();
		}
	    return alunos;
	}
 }
 
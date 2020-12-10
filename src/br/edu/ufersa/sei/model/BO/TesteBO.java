package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.DAO.BaseDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class TesteBO {

	public static void main(String[] args) {
		
		System.out.println(BaseDAO.getConnection());
		
		UsuarioBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
		UsuarioVO vo = new UsuarioVO();
		UsuarioVO vo2 = new UsuarioVO();
		UsuarioVO vo3 = new UsuarioVO();
		UsuarioVO vo4 = new UsuarioVO();
		
		//cadastrar pelo BO
		try {
			
			//setar novo usuário para ser cadastrado pelo BO
			vo.setCpf("777.888.999-56");
			vo.setNome("Mariana Lima");
			vo.setEmail("marilima@gmail.com");
			vo.setEndereco("Rua Projetada");
			vo.setLogin("mari77");
			vo.setSenha("ABDC1234");
			
			vo2.setCpf("367.548.966-78");
			vo2.setNome("Maria Luiza");
			vo2.setEmail("malu@gmail.com");
			vo2.setEndereco("Rua Pedro Miguel, 34");
			vo2.setLogin("maluks2");
			vo2.setSenha("maaluuzinha123");
			
			vo3.setCpf("675.548.966-01");
			vo3.setNome("Rafael Souza");
			vo3.setEmail("rafas@gmail.com");
			vo3.setEndereco("Rua Pedro Pereira, 334");
			vo3.setLogin("rafa_souza");
			vo3.setSenha("senha123");
			
			vo4.setIdUsu(new Long (18));  //tem q setar IdUsu pra dar certo os métodos do BO
			vo4.setCpf("999.543.443-03");
			vo4.setNome("Ana Lins");
			vo4.setEmail("ana_lins@gmail.com");
			vo4.setEndereco("Rua Mosenhor Bruno, 1024");
			vo4.setLogin("aninha12");
			vo4.setSenha("ahdbc456");
	
			//usuBO.cadastrar(vo); 	
			//usuBO.cadastrar(vo2);
			//usuBO.cadastrar(vo3);
			//usuBO.cadastrar(vo4);
			//usuBO.editar(vo4);
			//usuBO.excluir(vo4);
			
			TurmaVO turma = new TurmaVO();
			turma.setIdTurma(3);
			
			AlunoBO<AlunoVO> aluBO = new AlunoBO<AlunoVO>();
			
			AlunoVO avo = new AlunoVO();
			
			avo.setCpf("111.888.999-56");
			avo.setNome("José Lima");
			avo.setEmail("zelima@gmail.com");
			avo.setEndereco("Rua São Paulo");
			avo.setLogin("jose34");
			avo.setSenha("abc123");
			avo.setMatricula("2019030405");
			avo.setTurma(turma);
			avo.setIdUsu(61);  // NÃO ESTÁ PEGANDO AUTOMATICAMENTE
			
			//aluBO.cadastrar(avo);
			//aluBO.editar(avo);  //não está pegando o IdUsu
			//aluBO.excluir(avo);  //não está pegando o IdUsu
			
			//System.out.println(avo.getTurma().getIdTurma());
			//System.out.println(avo.getTurma().getIdTurma());
			
			
//			try {
//				List<AlunoVO> alunos = aluBO.listar();
//					
//				for(UsuarioVO alu : alunos) {
//					System.out.println(alu);
//				}
//			} catch (InsertException e) {
//					e.printStackTrace();
//			}	
				
//			try {
//				List<AlunoVO> alunos = aluBO.buscarPorNome(avo);
//				
//				for(UsuarioVO alu : alunos) {
//					System.out.println(alu);
//				}
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}	
			
//			try {
//				   System.out.println(aluBO.buscarPorId(avo));
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}	
	
			//buscar por turma
//			try {
//			List<AlunoVO> alunos = aluBO.buscarPorTurma();
//			
//			for(UsuarioVO alu : alunos) {
//				System.out.println(alu);
//			}
//			} catch (InsertException e) {
//			e.printStackTrace();
//			}	
			
		} catch (InsertException e) {
			System.out.println("FALHOU\n");
			e.printStackTrace();
		}
	
		// USUÁRIO
		/* 
		//listar 
		try {
			List<UsuarioVO> usuarios = usuBO.listar();
			
			for(UsuarioVO usu : usuarios) {
				System.out.println(usu);
			}
		} catch (InsertException e) {
			e.printStackTrace();
		}	
		
		// buscar por nome 
		try {
			
			List<UsuarioVO> usuarios = usuBO.buscarPorNome(vo3);
			
			for(UsuarioVO usu : usuarios) {
				System.out.println(usu);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	
    	//buscar por id 
		try {
			System.out.println(usuBO.buscarPorId(vo4));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		*/ 	
	}
}


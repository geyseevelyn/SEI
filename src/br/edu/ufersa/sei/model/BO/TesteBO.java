package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.DAO.BaseDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class TesteBO {

	public static void main(String[] args) {
		
		System.out.println(BaseDAO.getConnection());
		
		//UsuarioBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
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
		
			//TurmaBO tbo = new TurmaBO();
			TurmaVO turma2 = new TurmaVO();
			
			turma2.setCodTurma("T0908");
			turma2.setNome("2º ANO Bbbbbbbbbbbbb");
			turma2.setSala("Sala 25");
			turma2.setHorario("Tarde");
			
			//tbo.cadastrar(turma2);
			//tbo.editar(turma2);
			//System.out.println(turma2.getIdTurma() + "\n");
			
			//AlunoBO<AlunoVO> aluBO = new AlunoBO<AlunoVO>();
			AlunoVO avo2 = new AlunoVO();
			
			avo2.setCpf("222.888.999-56");
			avo2.setNome("Ana Muller");
			avo2.setEmail("amuller@gmail.com");
			avo2.setEndereco("Rua Santos Dummont, 34");
			avo2.setLogin("aninha23");
			avo2.setSenha("abc123");
			avo2.setMatricula("2020110405");
			avo2.setTurma(turma2);
			
			//aluBO.cadastrar(avo2);
			//aluBO.editar(avo);  //não está pegando o IdUsu
			//aluBO.excluir(avo);  //não está pegando o IdUsu
			
			//System.out.println(avo2.getTurma().getIdTurma() + "\n\n\n");
			
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
//				List<AlunoVO> alunos = aluBO.buscarPorNome(avo2);
//				
//				for(UsuarioVO alu : alunos) {
//					System.out.println(alu);
//				}
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}	
//			
//			try {
//				   System.out.println(aluBO.buscarPorId(avo2));
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}	
	
			//buscar por turma
//			try {
//			List<AlunoVO> alunos = aluBO.buscarPorTurma(turma2);
//
//				for(UsuarioVO alu : alunos) {
//				System.out.println(alu);
//				}
//			} catch (InsertException e) {
//				e.printStackTrace();
//			}	
			
			TurmaVO tvo = new TurmaVO();
			
			tvo.setCodTurma("T0808");
			tvo.setNome("8º ANO A");
			tvo.setSala("Sala 15");
			tvo.setHorario("Tarde");
			tvo.setIdTurma(26);
			
			//tbo.cadastrar(tvo);
			//tbo.editar(tvo);
			
			System.out.println(tvo.getIdTurma() + "\n");
			
//			try {
//				List<TurmaVO> turmas = tbo.listar();
//				
//				for(TurmaVO tur : turmas) {
//					System.out.println(tur);
//				}
//			} catch (InsertException e) {
//				e.printStackTrace();
//			}	
			
//			try {
//				List<TurmaVO> turmas = tbo.buscarPorNome(tvo);
//				
//				for(TurmaVO tur : turmas) {
//					System.out.println(tur);
//				}
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}	
			
//			try {
//				   System.out.println(tbo.buscarPorId(tvo));
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}	
		
		} catch (InsertException e) {
			System.out.println("FALHOU\n");
			e.printStackTrace();
		}
		
	}
}


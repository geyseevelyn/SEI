package br.edu.ufersa.sei.model.DAO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DiretorVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;
import java.sql.SQLException;

public class TesteDAO {
	public static void main(String[] args) {
		
		System.out.println(BaseDAO.getConnection());
		
		//UsuarioDAO<UsuarioVO> usuDao = new UsuarioDAO<UsuarioVO>();
		//AlunoDAO<AlunoVO> aDao = new AlunoDAO<AlunoVO>();
		//ProfessorDAO<ProfessorVO> pDao = new ProfessorDAO<ProfessorVO>();
		DiretorDAO<DiretorVO> dDao = new DiretorDAO<DiretorVO>();
		
		//UsuarioBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
		
		UsuarioVO vo = new UsuarioVO();
		UsuarioVO vo2 = new UsuarioVO();
		UsuarioVO vo3 = new UsuarioVO();

		AlunoVO avo = new AlunoVO();
		AlunoVO avo2 = new AlunoVO();
		
		ProfessorVO pvo = new ProfessorVO();
		ProfessorVO pvo2 = new ProfessorVO();
		
		DiretorVO dvo = new DiretorVO();
				
		try {
			vo.setNome("Joao Pedro");
			vo.setCpf("456.888.999-56");
			vo.setEmail("jp_soares@gmail.com");
			vo.setEndereco("Rua Virgilio Tavora, 345");
			vo.setLogin("jppj65");
			vo.setSenha("AA3456789");
			//vo.setIdUsu(new Long (1));
			
			vo2.setCpf("367.548.966-78");
			vo2.setNome("Maria Luiza");
			vo2.setEmail("malu@gmail.com");
			vo2.setEndereco("Rua Pedro Miguel, 34");
			vo2.setLogin("maluks2");
			vo2.setSenha("maaluuzinha123");
			//vo2.setIdUsu(new Long (2));
			
			vo3.setCpf("777.548.966-78");
			vo3.setNome("Karina Andrade");
			vo3.setEmail("karin@gmail.com");
			vo3.setEndereco("Rua Coronel Miguel, 34");
			vo3.setLogin("kkarinn");
			vo3.setSenha("karina16857");
			//vo3.setIdUsu(new Long (3));	
			
			//usuDao.inserir(vo);
			//usuDao.atualizar(vo);
			//usuDao.deletar(vo2);
	
			//usuDao.buscarPorNome();
			
			TurmaVO turma = new TurmaVO();
			turma.setIdTurma(2);
			
			avo.setNome("Beatriz Martins");
			avo.setCpf("234.534.093-09");
			avo.setEmail("bia_martins@gmail.com");
			avo.setEndereco("Rua Santos Dummont, 45");
			avo.setLogin("bia123");
			avo.setSenha("1234abc");
			avo.setMatricula("2019018976");
			avo.setTurma(turma);
			avo.setIdUsu(new Long(32));
			
			//aDao.inserir(avo);
			//aDao.atualizar(avo);
			//aDao.deletar(avo);
			
			avo2.setNome("Pedro Souza Silva");
			avo2.setCpf("111.534.093-09");
			avo2.setEmail("pedro@gmail.com");
			avo2.setEndereco("Rua Duque de Caixias, 450");
			avo2.setLogin("pedro123");
			avo2.setSenha("pe1234");
			avo2.setMatricula("2018090721");
			avo2.setTurma(turma);
			//avo2.getTurma().setIdTurma((2));  //tem que setar só IdTurma e nao o obj.
			//avo2.setIdUsu(new Long(1));
			
			//aDao.inserir(avo2);
			//aDao.atualizar(avo2);
			//aDao.deletar(avo2);
			
			pvo.setNome("João Castro");
			pvo.setCpf("202.486.987-20");
			pvo.setEmail("jolima@gmail.com");
			pvo.setEndereco("Rua São José, 765");
			pvo.setLogin("joao12");
			pvo.setSenha("lima1234");
			//pvo.setIdUsu(new Long(7));
			
			pvo2.setNome("Felipe Barbosa");
			pvo2.setCpf("089.333.937-01");
			pvo2.setEmail("jolima@gmail.com");
			pvo2.setEndereco("Rua da Paz, 1290");
			pvo2.setLogin("felipe");
			pvo2.setSenha("abc123");
			pvo2.setIdUsu(new Long(34));
			
			//pDao.inserir(pvo);
			//pDao.atualizar(pvo2); // idUsu = 7
			//pDao.deletar(pvo);  // idUsu = 7
			
			dvo.setNome("Weitinho Sales");
			dvo.setCpf("345.098.444-01");
			dvo.setEmail("weitinho@gmail.com");
			dvo.setEndereco("Rua Pedro Pereira, 345");
			dvo.setLogin("weitinho");
			dvo.setSenha("abc123");
			dvo.setIdUsu(new Long(38));
			
			dDao.inserir(dvo);
			//dDao.atualizar(dvo);
			//dDao.deletar(dvo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//BO
		
		// listar pelo BO
		/*
		try {
			
			List<UsuarioVO> usuarios = usuBO.listar();
			
			for(UsuarioVO usu : usuarios) {
				System.out.println(usu);
			}
		} catch (InsertException e) {
			e.printStackTrace();
		}*/
	}
}

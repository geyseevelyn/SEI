package br.edu.ufersa.sei.model.DAO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DiretorVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import java.sql.SQLException;

public class TesteDAO {
	public static void main(String[] args) {
		
		System.out.println(BaseDAO.getConnection());

		try {
			//TurmaDAO tDao = new TurmaDAO();
			
			TurmaVO tvo3 = new TurmaVO();
			TurmaVO tvo4 = new TurmaVO();
			
			tvo3.setNome("9º ANO A");
			tvo3.setCodTurma("T0109");
			tvo3.setSala("Sala 20");
			tvo3.setHorario("Manhã");
			tvo3.setIdTurma(3);
			
			//tDao.inserir(tvo3);
			
			System.out.println(tvo3.getIdTurma());
			
			tvo4.setNome("3º ANO b");
			tvo4.setCodTurma("T1000");
			tvo4.setSala("Sala 27");
			tvo4.setHorario("Tarde");
			
			//tDao.inserir(tvo4);
			//System.out.println(tvo4.getIdTurma());
			
			//UsuarioDAO<UsuarioVO> usuDao = new UsuarioDAO<UsuarioVO>();
			
//			UsuarioVO vo = new UsuarioVO();
//			UsuarioVO vo2 = new UsuarioVO();
//			UsuarioVO vo3 = new UsuarioVO();
//			UsuarioVO vo4 = new UsuarioVO();

//			vo.setNome("Joao Pedro");
//			vo.setCpf("456.888.999-56");
//			vo.setEmail("jp_soares@gmail.com");
//			vo.setEndereco("Rua Virgilio Tavora, 345");
//			vo.setLogin("jppj65");
//			vo.setSenha("AA3456789");
//			//vo.setIdUsu(new Long (1));
//			
//			vo2.setCpf("367.548.966-78");
//			vo2.setNome("Maria Luiza");
//			vo2.setEmail("malu@gmail.com");
//			vo2.setEndereco("Rua Pedro Miguel, 34");
//			vo2.setLogin("maluks2");
//			vo2.setSenha("maaluuzinha123");
//			//vo2.setIdUsu(new Long (2));
//			
//			vo3.setCpf("777.548.966-78");
//			vo3.setNome("Karina Andrade");
//			vo3.setEmail("karin@gmail.com");
//			vo3.setEndereco("Rua Coronel Miguel, 34");
//			vo3.setLogin("kkarinn");
//			vo3.setSenha("karina16857");
//			//vo3.setIdUsu(new Long (3));
		
			//usuDao.inserir(vo);
			//usuDao.atualizar(vo);
			//usuDao.deletar(vo2);
			
			AlunoDAO<AlunoVO> aDao = new AlunoDAO<AlunoVO>();
			ProfessorDAO<ProfessorVO> pDao = new ProfessorDAO<ProfessorVO>();
			//DiretorDAO<DiretorVO> dDao = new DiretorDAO<DiretorVO>();
			
			AlunoVO avo = new AlunoVO();
			AlunoVO avo2 = new AlunoVO();
			
			ProfessorVO pvo = new ProfessorVO();
			ProfessorVO pvo2 = new ProfessorVO();
			ProfessorVO pvo3 = new ProfessorVO();
			
			DiretorVO dvo = new DiretorVO();
			
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
			//avo.setIdUsu(new Long(32));
			
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
			
			pvo3.setNome("Luiza Souza");
			pvo3.setCpf("234.111.437-04");
			pvo3.setEmail("luizasouza@gmail.com");
			pvo3.setEndereco("Rua Pedro Pereira, 1290");
			pvo3.setLogin("luizasouza");
			pvo3.setSenha("abc123");
			pvo3.setIdProf(10);
			
			//pDao.inserir(pvo);
			//pDao.inserir(pvo3);
			//pDao.atualizar(pvo2); // idUsu = 7
			//pDao.deletar(pvo);  // idUsu = 7
			
			System.out.println(tvo3.getIdTurma() + "   " + pvo3.getIdProf());
			System.out.println(pvo3);
			
			dvo.setNome("Weitinho Sales");
			dvo.setCpf("345.098.444-01");
			dvo.setEmail("weitinho@gmail.com");
			dvo.setEndereco("Rua Pedro Pereira, 345");
			dvo.setLogin("weitinho");
			dvo.setSenha("abc123");
			
			//dDao.inserir(dvo);
			//dDao.atualizar(dvo);
			//dDao.deletar(dvo);
			
			//DisciplinaDAO discDao = new DisciplinaDAO();
			//NotaDAO nDao = new NotaDAO();
			
			DisciplinaVO discvo = new DisciplinaVO();
			DisciplinaVO discvo2 = new DisciplinaVO();
			DisciplinaVO discvo3 = new DisciplinaVO();
			
			NotaVO nvo = new NotaVO();
			NotaVO nvo2 = new NotaVO();
			NotaVO nvo3 = new NotaVO();
			
			TurmaVO tvo = new TurmaVO();
			TurmaVO tvo2 = new TurmaVO();
	
			pvo.setIdProf(8);
			pvo2.setIdProf(6);
			pvo3.setIdProf(10);
			
			discvo.setCodigo("POR1001");
			discvo.setNome("Português");
			discvo.setProfDisc(pvo);
			discvo.setStatus(true);
			discvo.setIdDisc(new Long(8));
			
			discvo2.setCodigo("MAT1002");
			discvo2.setNome("Matemática");
			discvo2.setProfDisc(pvo2);
			discvo2.setStatus(true);
			discvo2.setIdDisc(new Long(9));
			
			discvo3.setCodigo("BIO1004");
			discvo3.setNome("Biologia");
			discvo3.setProfDisc(pvo3);
			discvo3.setStatus(true);
			discvo3.setIdDisc(new Long(12));
			
			//discDao.inserir(discvo);
			//discDao.inserir(discvo2);
			//discDao.inserir(discvo3);
			//discDao.atualizar(discvo3);
			//discDao.deletar(discvo3);
			
			//tDao.cadastrarDisicplinas(tvo3, discvo2);
			//System.out.println(tvo3.getIdTurma() + "     " + discvo2.getIdDisc());
			//System.out.println(tvo3);
			
			avo.setIdAluno(14);
			avo2.setIdAluno(11);
			
			nvo.setN1(10.0);
			nvo.setN2(10.0);
			nvo.setN3(10.0);
			nvo.setFaltas(0);
			nvo.setAluno(avo);
			nvo.setDisc(discvo);
			
			nvo2.setN1(5.0);
			nvo2.setN2(6.0);
			nvo2.setN3(6.5);
			nvo2.setFaltas(3);
			nvo2.setAluno(avo2);
			nvo2.setDisc(discvo2);
			
			//nDao.inserir(nvo2);
			//nDao.atualizar(nvo2);
			//nDao.deletar(nvo2);
			//nDao.deletarNotas(avo2, discvo3);
			
			tvo.setNome("3º ANO B");
			tvo.setCodTurma("T0303");
			tvo.setSala("Sala 28");
			tvo.setHorario("Manhã");
			tvo.setIdTurma(4);
			
			tvo2.setNome("1º ANO B");
			tvo2.setCodTurma("T0102");
			tvo2.setSala("Sala 24");
			tvo2.setHorario("Tarde");
			tvo2.setIdTurma(5);
			
			//tDao.inserir(tvo3);
			//tDao.inserir(tvo2);
			//tDao.atualizar(tvo2);
			//tDao.deletar(tvo2);
			
			AlunoVO avo3 = new AlunoVO();	

			avo3.setNome("Joana Lopes");
			avo3.setCpf("037.334.593-01");
			avo3.setEmail("jolopes@gmail.com");
			avo3.setEndereco("Rua Santo Antônio, 435");
			avo3.setLogin("jojo23");
			avo3.setSenha("abc1234");
			avo3.setMatricula("2019048946");
			avo3.setTurma(turma);
			avo3.setIdAluno(25);
			
			//aDao.inserir(avo3);
			aDao.listar();
			
			//System.out.println(avo3.getIdAluno());
			
			nvo3.setN1(6.0);
			nvo3.setN2(7.0);
			nvo3.setN3(6.0);
			nvo3.setFaltas(4);
			nvo3.setAluno(avo3);
			nvo3.setDisc(discvo3);
			
			//nDao.inserir(nvo3);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

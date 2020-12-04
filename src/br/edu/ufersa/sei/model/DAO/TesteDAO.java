package br.edu.ufersa.sei.model.DAO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;
import java.sql.SQLException;

public class TesteDAO {
	public static void main(String[] args) {
		System.out.println(BaseDAO.getConnection());
				
		try {
			UsuarioDAO<UsuarioVO> usuDao = new UsuarioDAO<UsuarioVO>();
			UsuarioVO vo = new UsuarioVO();
			UsuarioVO vo2 = new UsuarioVO();
			UsuarioVO vo3 = new UsuarioVO();
			
			vo.setCpf("777.888.999-56");
			vo.setNome("Joao Pedro");
			vo.setEmail("jp_sadw@gmail.com");
			vo.setEndereco("Caverna");
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
			
			//usuDao.inserir(vo3);
			//usuDao.atualizar(vo2);
			//usuDao.deletar(vo3)
			
			//usuDao.listar();
			//usuDao.buscarPorNome();
			
			
			AlunoDAO<AlunoVO> aDao = new AlunoDAO<AlunoVO>();
			AlunoVO avo = new AlunoVO();
			AlunoVO avo2 = new AlunoVO();
			
			avo.setNome("Beatriz Souza");
			avo.setCpf("234.534.093-09");
			avo.setEmail("biasouza@gmail.com");
			avo.setEndereco("Rua Santos Dummont, 45");
			avo.setLogin("bia123");
			avo.setSenha("1234abc");
			avo.setMatricula("2019090721");
			//avo.setTurma();  //tem que setar só IdTurma e nao o obj.
			avo.setIdUsu(new Long(1));
			
			avo2.setNome("Pedro Souza");
			avo2.setCpf("111.534.093-09");
			avo2.setEmail("pedro@gmail.com");
			avo2.setEndereco("Rua Duque de Caixias, 450");
			avo2.setLogin("pedro123");
			avo2.setSenha("pe1234");
			avo2.setMatricula("2018090721");
			//avo2.getTurma().setIdTurma((long)2);  //tem que setar só IdTurma e nao o obj.
			//avo2.setIdUsu(new Long(1));
			
			//aDao.inserir(avo2);
			
			ProfessorDAO<ProfessorVO> pDao = new ProfessorDAO<ProfessorVO>();
			ProfessorVO pvo = new ProfessorVO();
			
			pvo.setNome("Pedro Marcos");
			pvo.setCpf("233.486.987-20");
			pvo.setEmail("pema@gmail.com");
			pvo.setEndereco("Rua Dragão do Mar, 124");
			pvo.setLogin("peixemar");
			pvo.setSenha("marpe1xe");
			//pvo.setIdUsu(new Long(1));
			
			pDao.inserir(pvo);
			//pDao.atualizar(pvo); // idUsu = 7
			//pDao.deletar(pvo);  // idUsu = 7
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}


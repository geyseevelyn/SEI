package br.edu.ufersa.sei.model.DAO;

//import br.edu.ufersa.sei.exception.InsertException;
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
			//usuDao.deletar(vo3);
			//usuDao.listar();
			usuDao.buscarPorNome("Maria Luiza");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}


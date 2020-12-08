package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class TesteBO {

	public static void main(String[] args) {
		
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
			
			vo4.setIdUsu(new Long (17));  //tem q setar IdUsu pra dar certo os métodos do BO
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
			usuBO.editar(vo4);
			//usuBO.excluir(vo4);
			
		} catch (InsertException e) {
			e.printStackTrace();
		}
			
		//listar (BO)
		
		/*
		try {
			List<UsuarioVO> usuarios = usuBO.listar();
			
			for(UsuarioVO usu : usuarios) {
				//System.out.println(usu);
			}
		} catch (InsertException e) {
			e.printStackTrace();
		}	
		
		// buscar por nome (BO)
		try {
			
			List<UsuarioVO> usuarios = usuBO.buscarPorNome(vo);
			
			for(UsuarioVO usu : usuarios) {
				//System.out.println(usu);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
    	//buscar por id  (BO)
		try {
			System.out.println(usuBO.buscarPorId(vo4));
		} catch (NotFoundException e) {
			e.printStackTrace();
		} */
	}
}


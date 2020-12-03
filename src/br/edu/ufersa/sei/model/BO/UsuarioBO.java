package br.edu.ufersa.sei.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.DAO.UsuarioDAO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> implements UsuarioInterBO<VO>{
	
	UsuarioDAO<UsuarioVO> usuDao = new UsuarioDAO<UsuarioVO>();
	
	public List<UsuarioVO> listarUsuarios() throws InsertException{
		
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
      
        try {
        		ResultSet usuRS = usuDao.listar();
        		while(usuRS.next()) {
        			UsuarioVO vo = new UsuarioVO();
			    
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
	public void cadastrar(UsuarioVO user) {
		//Busca no banco de dados se o usuário já existe
		//Se o usuário já existir, retorna um erro
		//Se o usuário não existir, solicita a inclusão no banco de dados
	}
	
	@Override
	public void editar(UsuarioVO user) {
		//Busca no banco de dados se o usuário já existe
		//Se o usuário não existir, retorna um erro
		//Se o usuário existir, solicita a edição e atualiza as informações do usuário no banco de dados
	}
	
	@Override
	public void excluir(UsuarioVO user) {
		//Busca no banco de dados se o usuário já existe
		//Se o usuário não existir, retorna um erro
		//Se o usuário existir, apaga as informações do usuário no banco de dados
	}
	
	@Override
	public List<VO> listar() {
		List<VO> usuarios = new ArrayList<VO>();
		return usuarios;
		//lista todos os usuários
	}
	
	@SuppressWarnings("unchecked")
	public UsuarioVO buscar(UsuarioVO user) {
		return user;
		//Busca no banco de dados um usuário
	    //Se o usuário não existir, retorna um erro
		//Se existir, retorna esse usuário
	}
	
	@Override
	public UsuarioVO autenticar(UsuarioVO user) {
		return user;
		//Busca no banco de dados de o login apresentados existem
		//Se o login não existir, apresenta um erro
		//Se o login existir, compara se a senha informada é a mesma senha contida no banco de dados para aquele login
		//Se a senha não estiver correta, aprsenta um erro
		//Se a senha tiver correta, o usuário é autenticado
	}
}

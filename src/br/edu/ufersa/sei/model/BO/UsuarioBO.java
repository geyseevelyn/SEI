package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class UsuarioBO {
	
	public void exibir(UsuarioVO user) {
		//Busca no banco de dados um usuário
		//Se o usuário não existir, retorna um erro
		//Se existir, exibe as informações desse usuário
	}
	
	public void cadastrar(UsuarioVO user) {
		//Busca no banco de dados se o usuário já existe
		//Se o usuário já existir, retorna um erro
		//Se o usuário não existir, solicita a inclusão no banco de dados
	}
	
	public void editar(UsuarioVO user) {
		//Busca no banco de dados se o usuário já existe
		//Se o usuário não existir, retorna um erro
		//Se o usuário existir, solicita a edição e atualiza as informações do usuário no banco de dados
	}
	
	public void excluir(UsuarioVO user) {
		//Busca no banco de dados se o usuário já existe
		//Se o usuário não existir, retorna um erro
		//Se o usuário existir, apaga as informações do usuário no banco de dados
	}
	
	public UsuarioVO buscar(UsuarioVO user) {
		return user;
		//Busca no banco de dados um usuário
	    //Se o usuário não existir, retorna um erro
		//Se existir, retorna esse usuário
	}
	
	public void autenticar(UsuarioVO user) {
		//Busca no banco de dados se o login apresentado existe
		//Se o login não existir, apresenta um erro
		//Se o login existir, compara se a senha informada é a mesma senha contida no banco de dados para aquele login
		//Se a senha não estiver correta, aprsenta um erro
		//Se a senha tiver correta, o usuário é autenticado
	}
}

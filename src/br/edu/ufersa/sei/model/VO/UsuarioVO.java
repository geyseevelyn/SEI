package br.edu.ufersa.sei.model.VO;

import br.edu.ufersa.sei.exception.InsertException;
import util.Validacao;

public class UsuarioVO {
	private long idUsu;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String login;
	private String senha;
	
	//getters and setters
	public long getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(long idUsu) throws InsertException {
		if(idUsu >= 0) {
			this.idUsu = idUsu;
		}else {
			throw new InsertException("Id Inválido!");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws InsertException {
		if(nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			throw new InsertException("Necessário informar Nome!");
		}			
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) throws InsertException {
		if(Validacao.isCpf(cpf)) {
			this.cpf = cpf;
		}else {
			throw new InsertException("CPF Inválido!");
		}
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) throws InsertException {
		if(endereco != null && !endereco.equals("")) {
			this.endereco = endereco;
		} else {
			throw new InsertException("Necessário informar Endereço!");
		}		
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) throws InsertException{
		if(Validacao.isEmail(email)) {
			this.email = email;
		}else {
			throw new InsertException("Email Inválido!");
		}
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) throws InsertException{
		if(Validacao.isLogin(login)) {
			this.login = login;
		}else {
			throw new InsertException("Login Inválido! \n(Login deve começar com uma letra,"
					+ " ter no mínimo 6 e no máximo 15 caracteres)\n");
		}	
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) throws InsertException {
		if(Validacao.isSenha(senha)) {
			this.senha = senha;
		}else {
			throw new InsertException("Senha Inválida! \n(Senha deve conter pelo menos "
					+ "uma letra, um número, no mínimo 6 e no máximo 15 caracteres)\n");
		}		
	}
	
	public String toString() {
		String saida;
		saida = "Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " +
		        endereco + "\nEmail: " + email + "\nLogin: " + login +
		        "\nSenha: " + senha + "\n";
		return saida;
	}
}

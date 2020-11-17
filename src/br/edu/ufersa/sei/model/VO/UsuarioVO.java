package br.edu.ufersa.sei.model.VO;

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

	public void setIdUsu(long idUsu) {
		if(idUsu >= 0) {
			this.idUsu = idUsu;
		}else {
			System.out.println("Id Inválido!");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Necessário informar Nome!");
		}			
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(Validacao.isCpf(cpf)) {
			this.cpf = cpf;
		}else {
			System.out.println("CPF Inválido!");
		}
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.equals("")) {
			this.endereco = endereco;
		} else {
			System.out.println("Necessário informar Endereço!");
		}		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(Validacao.isEmail(email)) {
			this.email = email;
		}else {
			System.out.println("Email Inválido!");
		}
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		if(login == null || login.equals("")) {
			System.out.println("Login Inválido!");
		}else {
			if(login.length() >= 6) {
				this.login = login;
			}else {
				System.out.println("Login deve ter no mínimo 6 caracteres!");
			}
		}
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha == null || senha.equals("")) {
			System.out.println("Senha Inválida!");
		}else {
			if(senha.length() >= 6) {
				this.senha = senha;
			}else {
				System.out.println("Senha deve ter no mínimo 6 caracteres!");
			}
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

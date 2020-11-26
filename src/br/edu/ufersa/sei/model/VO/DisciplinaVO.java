package br.edu.ufersa.sei.model.VO;

import util.Validacao;

public class DisciplinaVO {
	private String nome;
	private String codigo;
	private ProfessorVO profDisc;
	private boolean status; //ativa ou finalizada
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Necessário informar o nome da Disciplina!");
		}	
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		if(Validacao.isCodDisc(codigo)) {
			this.codigo = codigo;
		}else {
			System.out.println("Códido da Disciplina Inválido!");
		}		
	}
	
	public ProfessorVO getProfDisc() {
		return profDisc;
	}
	
	public void setProfDisc(ProfessorVO profDisc) {
		if(profDisc != null) {
			this.profDisc = profDisc;
		}else {
			System.out.println("Necessário informar Professor!");
		}
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toString() {
		String status;
		if (this.status)
			status = "Ativa";
		else
			status = "Finalizada";
		
		String saida;
		saida = "Disciplina: " + nome + "\nCódigo: " + codigo + "\nStatus: " +
		        status + "\nProfessor: " + profDisc.getNome();
		return saida;
	}
}

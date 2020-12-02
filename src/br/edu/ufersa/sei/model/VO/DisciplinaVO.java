package br.edu.ufersa.sei.model.VO;

import br.edu.ufersa.sei.exception.InsertException;
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
	
	public void setNome(String nome) throws InsertException{
		if(nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			throw new InsertException("Necessário informar o nome da Disciplina!");
		}	
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) throws InsertException{
		if(Validacao.isCodDisc(codigo)) {
			this.codigo = codigo;
		}else {
			throw new InsertException("Códido da Disciplina Inválido!");
		}		
	}
	
	public ProfessorVO getProfDisc() {
		return profDisc;
	}
	
	public void setProfDisc(ProfessorVO profDisc) throws InsertException {
		if(profDisc != null) {
			this.profDisc = profDisc;
		}else {
			throw new InsertException("Necessário informar Professor!");
		}
	}
	
	public boolean isStatus() {
		return status;
	}
	
	//precisa fazer exceção??
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

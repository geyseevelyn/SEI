package br.edu.ufersa.sei.model.VO;

import br.edu.ufersa.sei.exception.InsertException;
import util.Validacao;

public class DisciplinaVO {
	private long idDisc;
	private String codDisc;
	private String nome;
	private ProfessorVO profDisc;
	private boolean status; //ativa ou finalizada
	
	//getters and setters
	public long getIdDisc() {
		return idDisc;
	}

	public void setIdDisc(long idDisc) {
		if(idDisc >= 0) {
			this.idDisc = idDisc;
		}else {
			System.out.println("Id da Disciplina Inválido!");
		}
	}
	
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
	
	public String getCodDisc() {
		return codDisc;
	}
	
	public void setCodigo(String codDisc) throws InsertException{
		if(Validacao.isCodDisc(codDisc)) {
			this.codDisc = codDisc;
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
		saida = "Id: " + idDisc + "\nDisciplina: " + nome + "\nCódigo: " + codDisc + "\nStatus: " +
		        status + "\nId Professor: " + profDisc.getIdProf() + "\n";
		return saida;
	}

}

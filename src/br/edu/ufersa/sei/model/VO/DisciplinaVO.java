package br.edu.ufersa.sei.model.VO;

public class DisciplinaVO {
	private String nome;
	private String codigo;
	private ProfessorVO profDisc;
	private boolean status; //ativa ou finalizada
	//private NotaVO notas;
	
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
	
	// MELHORAR!!!
	public void setCodigo(String codigo) {
		if(codigo != null && !codigo.equals("")) {
			if(codigo.length() == 7) {
				this.codigo = codigo;
			}else {
				System.out.println("Códido da Disciplina Inválido!");
			}
		}else {
			System.out.println("Necessário informar Código da Disciplina!");
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
	
	// FAZER - public String toString(){}
}

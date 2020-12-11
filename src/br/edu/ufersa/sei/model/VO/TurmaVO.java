package br.edu.ufersa.sei.model.VO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import util.Validacao;

public class TurmaVO {
	private long idTurma;
	private String nome;
	private String codTurma;
	private String sala;
	private String horario; 
	private List<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();	
	
	//getters and setters
	
	public long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(long idTurma) throws InsertException {
		if(idTurma >= 0) {
			this.idTurma = idTurma;
		}else {
			throw new InsertException("Id da Turma Inválido!");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws InsertException{
		if(nome == null || nome.equals("")) {
			throw new InsertException("Necessário informar Nome da Turma!");
		}else {
			this.nome = nome;
		}
	}
	
	public String getCodTurma() {
		return codTurma;
	}
	
	public void setCodTurma(String codTurma) throws InsertException{
		if(Validacao.isCodTurma(codTurma)) {
			this.codTurma = codTurma;
		}else {
			throw new InsertException("Códido da Turma Inválido!");
		}	
	}

	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) throws InsertException{
		if(horario != null && !horario.equals("")) {
			this.horario = horario;
		} else {
			throw new InsertException("Horário Inválido!");
		}
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String sala) throws InsertException{
		if(sala == null || sala.equals("")) {
			throw new InsertException("Necessário informar Local!");
		}else {
			this.sala = sala;
		}	
	}
	
	public ArrayList<DisciplinaVO> getDisciplinas() {
		return (ArrayList<DisciplinaVO>)disciplinas;
	}
	
	public void setDisciplinas(ArrayList<DisciplinaVO> disciplinas) throws InsertException{
		if(disciplinas != null) {
			this.disciplinas = disciplinas;
		}else {
			throw new InsertException("Necessário informar Disciplinas");
		}		
	}
		
	public String toString() {
		String saida;
		saida = "Id: " + idTurma + "\nTurma: " + nome + "\nCódigo: " + codTurma + 
				"\nLocal: " + sala + "\nTurno: " + horario + "\n" +
				"Disciplinas: \n";
		
		for(DisciplinaVO disc : disciplinas) {
			saida += disc.toString();
		}
		return saida;
	}
}

package br.edu.ufersa.sei.model.VO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;

public class ProfessorVO extends UsuarioVO{
	private long idProf;
	private List<TurmaVO> turmas = new ArrayList<TurmaVO>();
	
	//getters and setters
	public long getIdProf() {
		return idProf;
	}

	public void setIdProf(long idProf) throws InsertException {
		if(idProf >= 0) {
			this.idProf = idProf;
		}else {
			throw new InsertException("Id do Professor Inválido!");
		}
	}

	public ArrayList<TurmaVO>getTurmas() {
		return (ArrayList<TurmaVO>)turmas;
	}

	public void setTurmas(ArrayList<TurmaVO> turmas) throws InsertException{
		if(turmas != null) {
			this.turmas = turmas;
		}else {
			throw new InsertException("Necessário informar Turmas!");
		}
	}
	
	public String toString() {
		String saida;
		saida = "Id: " + idProf + "\nNome: " + super.getNome() + "\nEmail: " + super.getEmail();
		//saida = super.toString() + "Id: " + idProf;
		
//		for(TurmaVO tur : turmas) {
//			saida += tur.toString();
//		}	
		return saida;
	}
}

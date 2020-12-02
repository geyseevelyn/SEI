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

	public List<TurmaVO> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaVO> turmas) throws InsertException{
		if(turmas != null) {
			this.turmas = turmas;
		}else {
			throw new InsertException("Necessário informar Turmas!");
		}
	}
	
	//toString()
	//TurmaVO[] 
}

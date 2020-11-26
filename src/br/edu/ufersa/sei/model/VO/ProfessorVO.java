package br.edu.ufersa.sei.model.VO;

import java.util.ArrayList;
import java.util.List;

public class ProfessorVO extends UsuarioVO{
	private long idProf;
	private List<TurmaVO> turmas = new ArrayList<TurmaVO>();
	
	//getters and setters
	public long getIdProf() {
		return idProf;
	}

	public void setIdProf(long idProf) {
		if(idProf >= 0) {
			this.idProf = idProf;
		}else {
			System.out.println("Id do Professor Inválido!");
		}
	}

	public List<TurmaVO> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaVO> turmas) {
		if(turmas != null) {
			this.turmas = turmas;
		}else {
			System.out.println("Necessário informar Turmas!");
		}
	}
	
	//toString()
	//TurmaVO[] 
}

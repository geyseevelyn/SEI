package br.edu.ufersa.sei.model.VO;

public class ProfessorVO extends UsuarioVO{
	private TurmaVO turmas[];
	
	public TurmaVO[] getTurmas() {
		return turmas;
	}

	public void setTurmas(TurmaVO[] turmas) {
		if(turmas != null) {
			this.turmas = turmas;
		}else {
			System.out.println("Necessário informar Turmas!");
		}
	}
	
	//toString(){}
	//TurmaVO[] ?
}

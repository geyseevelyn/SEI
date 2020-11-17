package br.edu.ufersa.sei.model.VO;

public class HistoricoVO {
	private AlunoVO aluno;
	private TurmaVO turma;
	private DisciplinaVO disc;
	private NotaVO notas;
	
	//getters and setters
	public AlunoVO getAluno() {
		return aluno;
	}
	public void setAluno(AlunoVO aluno) {
		if(aluno != null) {
			this.aluno = aluno;		
		}else {
			System.out.println("Necessário informar Aluno!");
		}
	}
	
	public TurmaVO getTurma() {
		return turma;
	}
	
	public void setTurma(TurmaVO turma) {
		if(turma != null) {
			this.turma = turma;
		}else {
			System.out.println("Necessário informar Turma!");
		}	
	}
	
	public DisciplinaVO getDisc() {
		return disc;
	}
	
	public void setDisc(DisciplinaVO disc) {
		if(disc != null) {
			this.disc = disc;
		}else {
			System.out.println("Necessário informar Disciplina!");
		}
	}
	
	public NotaVO getNotas() {
		return notas;
	}
	
	public void setNotas(NotaVO notas) {
		if (notas != null) {
			this.notas = notas;
		}else {
			System.out.println("Necessário informar Notas!");
		}
	}	
	
	//toString() ?
}

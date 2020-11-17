package br.edu.ufersa.sei.model.VO;

import util.Validacao;

public class AlunoVO extends UsuarioVO {;
	private String matricula;
	private TurmaVO turma;
	private NotaVO notas;
	private HistoricoVO hist;
		
	//getters and setters
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		if(Validacao.isMatricula(matricula)) {
			this.matricula = matricula;
		}else {
			System.out.println("Matrícula Inválida!");
		}	
	}
	
	public TurmaVO getTurma() {
		return turma;
	}
	
	public void setTurma(TurmaVO turma) {
		if(turma != null) {
			this.turma = turma;
		}else {
			System.out.println("Turma Inválida!");
		}
	}
	
	public NotaVO getNotas() {
		return notas;
	}

	public void setNotas(NotaVO notas) {
		if(notas != null) {
			this.notas = notas;
		}else {
			System.out.println("Notas Inválidas!");
		}
	}
	
	public HistoricoVO getHist() {
		return hist;
	}

	public void setHist(HistoricoVO hist) {
		if(hist != null) {
			this.hist = hist;
		}else {
			System.out.println("Histórico Inválido");
		}
	}
	
	@Override
	public String toString() {
		String saida;
		saida = super.toString() + "Matrícula: " + matricula + "\n";
		// TurmaVO, NotaVO, HistoricoVO ?
		return saida;
	}
}

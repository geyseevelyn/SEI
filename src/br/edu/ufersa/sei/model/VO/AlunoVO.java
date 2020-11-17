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
			System.out.println("Necessário informar Turma!");
		}
	}
	
	//PRECISA? já q n é por leitura do teclado, mas o professor que coloca as notas
	public NotaVO getNotas() {
		return notas;
	}

	public void setNotas(NotaVO notas) {
			this.notas = notas;
	}
	
	// PRECISA TER??? Pq historico vai ser gerado e não informado...
	public HistoricoVO getHist() {
		return hist;
	}

	public void setHist(HistoricoVO hist) {
		this.hist = hist;
	}
	
	@Override
	public String toString() {
		String saida;
		saida = super.toString() + "Matrícula: " + matricula + "\n";
		// TurmaVO, NotaVO, HistoricoVO
		return saida;
	}
}

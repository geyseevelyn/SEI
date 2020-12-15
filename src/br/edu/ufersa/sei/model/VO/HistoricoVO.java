package br.edu.ufersa.sei.model.VO;

public class HistoricoVO {
	private int ano;
	private AlunoVO aluno;
	private TurmaVO turma;
	private DisciplinaVO disc; //não seriam disciplinAS?
	private NotaVO notas;
	//situação?
	
	//getters and setters
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		if(ano >= 0) {
			this.ano = ano;
		}else {
			System.out.println("Ano Inválido!");
		}	
	}
	
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
	
	/*
	//tem que mostrar todas as disciplinas
	// media está mostrando zero
	public String toString() {
		String saida;
		saida = "Período Letivo: " + ano + "\nNome: " + aluno.getNome() 
				+ "\nMatrícula: " + aluno.getMatricula() + "\nTurma: " + turma.getNome() 
				+ " (" + turma.getCodigo() + ")" + "\nDisciplina: " + disc.getNome() 
				+ " (" + disc.getCodigo() + ")" + "\nNota: " + notas.getMedia() 
				+ "\nFrequência: " + notas.getFrequencia();
		
		return saida;
	}*/
}

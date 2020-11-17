package br.edu.ufersa.sei.model.VO;

public class NotaVO {
	private double n1;
	private double n2;
	private double n3;
	private double media;
	private int frequencia;
	private AlunoVO aluno;
	private DisciplinaVO disc;

	//getters and setters
	public double getN1() {
		return n1;
	}
	
	public void setN1(double n1) {
		if(n1 >= 0 && n1 <= 10) {
			this.n1 = n1;
		}else {
			System.out.println("Nota Inválida!");
		}
	}
	
	public double getN2() {
		return n2;
	}
	
	public void setN2(double n2) {
		if(n2 >= 0 && n2 <= 10) {
			this.n2 = n2;
		}else {
			System.out.println("Nota Inválida!");
		}
	}
	
	public double getN3() {
		return n3;
	}
	
	public void setN3(double n3) {
		if(n3 >= 0 && n3 <= 10) {
			this.n3 = n3;
		}else {
			System.out.println("Nota Inválida!");
		}
	}
	
	public double getMedia() {
			return media;	
	}
	
	//método para calcular média
	public double calcularMedia(double n1, double n2, double n3) {
		this.media = (n1 + n2 + n3) / 3.0;
		return media;
	}
	
	public int getFrequencia() {
		return frequencia;
	}
	
	public void setFrequencia(int frequencia) {
		if(frequencia>=0) {
			this.frequencia = frequencia;
		}else {
			System.out.println("Frequência Inválida!");
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

	public String toString() {
		String saida;
		double media = calcularMedia(n1,n2,n3);
		
		saida = "P1: " + n1 + "\nP2: " + n2 + "\nP3: " +
		        n3 + "\nMedia: " + media + "\nFrequência: " + frequencia;
		// aluno e disc ?
		return saida;
	}
}

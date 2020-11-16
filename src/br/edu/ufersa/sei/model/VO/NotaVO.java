package br.edu.ufersa.sei.model.VO;

public class NotaVO {
	private double n1;
	private double n2;
	private double n3;
	private double media;
	private int frequencia;

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
	
	// PRECISA TER???
	public double getMedia() {
			return media;
	}
		
	// FICA NO BO????
	//método para calcular média
	public double calcular(double n1, double n2, double n3) {
		this.media = (n1 + n2 + n3) / 3;
		return media;
	}	
}

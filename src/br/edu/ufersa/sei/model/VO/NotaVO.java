package br.edu.ufersa.sei.model.VO;

import java.text.DecimalFormat;

import br.edu.ufersa.sei.exception.InsertException;

public class NotaVO {
	private long idNota;
	private double n1;
	private double n2;
	private double n3;
	private double media;
	private int faltas;
	private AlunoVO aluno;
	private DisciplinaVO disc;
	
	//getters and setters

	public long getIdNota() {
		return idNota;
	}

	public void setIdNota(long idNota) {
		this.idNota = idNota;
	}
	
	public double getN1() {
		return n1;
	}
	
	public void setN1(double n1) throws InsertException{
		if(n1 >= 0 && n1 <= 10) {
			this.n1 = n1;
		}else {
			throw new InsertException("Nota Inválida!");
		}
	}
	
	public double getN2() {
		return n2;
	}
	
	public void setN2(double n2) throws InsertException{
		if(n2 >= 0 && n2 <= 10) {
			this.n2 = n2;
		}else {
			throw new InsertException("Nota Inválida!");
		}
	}
	
	public double getN3() {
		return n3;
	}
	
	public void setN3(double n3) throws InsertException {
		if(n3 >= 0 && n3 <= 10) {
			this.n3 = n3;
		}else {
			throw new InsertException("Nota Inválida!");
		}
	}
	
	public double getMedia() {
			return media;	
	}
	
	//precisa fazer exceção??
	//método para calcular média
	public double calcularMedia(double n1, double n2, double n3) {
		this.media = (n1 + n2 + n3) / 3.0;
		DecimalFormat formato = new DecimalFormat("#.##");
		formato.format(media);
		return media;
	}
	
	public int getFaltas() {
		return faltas;
	}
	
	public void setFaltas(int faltas) throws InsertException{
		if(faltas>=0) {
			this.faltas = faltas;
		}else {
			throw new InsertException("Frequência Inválida!");
		}
	}
	
	public AlunoVO getAluno() {
        return aluno;
    }
    public void setAluno(AlunoVO aluno) throws InsertException {
        if(aluno != null) {
            this.aluno = aluno;
        }else {
            throw new InsertException("Necessário informar Aluno!");
        }
    }

    public DisciplinaVO getDisc() {
        return disc;
    }

    public void setDisc(DisciplinaVO disc) throws InsertException{
        if(disc != null) {
            this.disc = disc;
        }else {
            throw new InsertException("Necessário informar Disciplina!");
        }
    }
	
	public String toString() {
		String saida;
		double media = calcularMedia(n1,n2,n3);
		
		saida = "Aluno: " + aluno.getNome() + "\nDisciplina: " + disc.getNome() + 
				" (" + disc.getCodDisc() + ")" + "\nP1: " + n1 + "\nP2: " + n2 +
				"\nP3: " + n3 + "\nMedia: " + media + "\nFaltas: " + faltas + "\n";
		
	    return saida;
	}
}

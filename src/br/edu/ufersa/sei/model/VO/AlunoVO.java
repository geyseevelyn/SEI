package br.edu.ufersa.sei.model.VO;

import br.edu.ufersa.sei.exception.InsertException;
import util.Validacao;

public class AlunoVO extends UsuarioVO {
	private long idAluno;
	private String matricula;
	private TurmaVO turma;
	//private NotaVO notas;
		
	//getters and setters
	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) throws InsertException{
		if(idAluno >= 0) {
			this.idAluno = idAluno;
		}else {
			throw new InsertException("Id do Aluno Inválido!");
		}
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) throws InsertException {
		if(Validacao.isMatricula(matricula)) {
			this.matricula = matricula;
		}else {
			throw new InsertException("Matrícula Inválida!");
		}	
	}
	
	public TurmaVO getTurma() {
		return turma;
	}
	
	public void setTurma(TurmaVO turma) throws InsertException{
		if(turma != null) {
			this.turma = turma;
		}else {
			throw new InsertException("Turma Inválida!");
		}
	}
	
	@Override
	public String toString() {
		String saida;
		saida = super.toString() + "Matrícula: " + matricula + 
		        "\nTurma: " + turma.getNome() + " (" + turma.getCodTurma()
		        + ")\n";
		return saida;
	}
}

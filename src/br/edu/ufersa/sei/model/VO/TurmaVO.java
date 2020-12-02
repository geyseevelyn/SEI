package br.edu.ufersa.sei.model.VO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import util.Validacao;

public class TurmaVO {
	private long idTurma;
	private String nome;
	private String codigo;
	private String local;
	private String horario; 
	private List<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();
	//private List<AlunoVO> alunos = new ArrayList<AlunoVO>();
	
	
	//getters and setters
	
	public long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(long idTurma) {
		if(idTurma >= 0) {
			this.idTurma = idTurma;
		}else {
			System.out.println("Id da Turma Inválido!");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws InsertException{
		if(nome == null || nome.equals("")) {
			throw new InsertException("Necessário informar Nome da Turma!");
		}else {
			this.nome = nome;
		}
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) throws InsertException{
		if(Validacao.isCodTurma(codigo)) {
			this.codigo = codigo;
		}else {
			throw new InsertException("Códido da Turma Inválido!");
		}	
	}

	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) throws InsertException{
		if(horario != null && !horario.equals("")) {
			this.horario = horario;
		} else {
			throw new InsertException("Horário Inválido!");
		}
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) throws InsertException{
		if(local == null || local.equals("")) {
			throw new InsertException("Necessário informar Local!");
		}else {
			this.local = local;
		}	
	}
	
	public List<DisciplinaVO> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<DisciplinaVO> disciplinas) throws InsertException{
		if(disciplinas != null) {
			this.disciplinas = disciplinas;
		}else {
			throw new InsertException("Necessário informar Disciplinas");
		}		
	}
	
	/*public List<AlunoVO> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<AlunoVO> alunos) throws InsertException{
		if(alunos != null) {
			this.alunos = alunos;
		}else {
			throw new InsertException("Necessário informar Alunos");
		}		
	}*/
		
	public String toString() {
		String saida;
		saida = "Turma: " + nome + "\nCódigo: " + codigo + "\nLocal: " +
		        local + "\nHorário: " + horario;
		return saida;
		// disciplinas[] e alunos[]
	}

}

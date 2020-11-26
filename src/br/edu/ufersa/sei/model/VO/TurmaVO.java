package br.edu.ufersa.sei.model.VO;

import java.util.ArrayList;
import java.util.List;

import util.Validacao;

public class TurmaVO {
	private String nome;
	private String codigo;
	private String local;
	private String horario; 
	private List<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();
	private List<AlunoVO> alunos = new ArrayList<AlunoVO>();
	
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.equals("")) {
			System.out.println("Necessário informar Nome da Turma!");
		}else {
			this.nome = nome;
		}
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		if(Validacao.isCodTurma(codigo)) {
			this.codigo = codigo;
		}else {
			System.out.println("Códido da Turma Inválido!");
		}	
	}

	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		if(horario != null && !horario.equals("")) {
			this.horario = horario;
		} else {
			System.out.println("Horário Inválido!");
		}
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		if(local == null || local.equals("")) {
			System.out.println("Necessário informar Local!");
		}else {
			this.local = local;
		}	
	}
	
	public List<DisciplinaVO> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<DisciplinaVO> disciplinas) {
		if(disciplinas != null) {
			this.disciplinas = disciplinas;
		}else {
			System.out.println("Necessário informar Disciplinas");
		}		
	}
	
	public List<AlunoVO> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<AlunoVO> alunos) {
		if(alunos != null) {
			this.alunos = alunos;
		}else {
			System.out.println("Necessário informar Alunos");
		}		
	}
	
	public String toString() {
		String saida;
		saida = "Turma: " + nome + "\nCódigo: " + codigo + "\nLocal: " +
		        local + "\nHorário: " + horario;
		return saida;
		// disciplinas[] e alunos[]
	}
}

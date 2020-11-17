package br.edu.ufersa.sei.model.VO;

import util.Validacao;

public class TurmaVO {
	private String nome;
	private String codigo;
	private String local;
	private String horario; 
	private DisciplinaVO disciplinas[];
	private AlunoVO alunos[];
	
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
	
	// MELHORAR!!!
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
	
	public DisciplinaVO[] getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(DisciplinaVO[] disciplinas) {
		if(disciplinas != null) {
			this.disciplinas = disciplinas;
		}else {
			System.out.println("Necessário informar Disciplinas");
		}		
	}
	
	public AlunoVO[] getAlunos() {
		return alunos;
	}
	
	public void setAlunos(AlunoVO[] alunos) {
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
		// disciplina [] e alunos[] ?
		return saida;
	}
}

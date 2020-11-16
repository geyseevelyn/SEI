package br.edu.ufersa.sei.model.VO;

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
		if(codigo == null || codigo.equals("")) {
			System.out.println("Necessário informar Código da Turma!");
		}else {
			if(codigo.charAt(0) == 'T' && codigo.length() == 5) { 
				this.codigo = codigo;
			}else {
				System.out.println("O Código deve começar com 'T' e conter 5 caracteres!");
			}
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
}

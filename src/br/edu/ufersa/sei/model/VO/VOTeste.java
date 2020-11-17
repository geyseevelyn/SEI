package br.edu.ufersa.sei.model.VO;

public class VOTeste {
	
	public static void main(String[] args) {
		UsuarioVO userVo;
		UsuarioVO alunoVo;
		userVo = new UsuarioVO();
		alunoVo = new AlunoVO();
		
		userVo.setNome("Esse é o do tipo UserVO");
		userVo.setEmail("geyseod@alunos.ufersa.edu.br");
		
		alunoVo.setNome("Esse é o do tipo AlunoVO");
		alunoVo.setEmail("aLEXNICOL@alunos.ufersa.edu.br");
		//alunoVo.setMatricula("1223456780"); //pq não deu certo?
		 
	
		//System.out.println(userVo.toString());
		//System.out.println(alunoVo.toString());
		
		
		AlunoVO aluno = new AlunoVO();
		DisciplinaVO disc = new DisciplinaVO();
		DiretorVO dir = new DiretorVO();
		NotaVO nota = new NotaVO();
		ProfessorVO prof = new ProfessorVO();
		TurmaVO turma = new TurmaVO();
		
		disc.setNome("Biologia");
		disc.setCodigo("BIO1234");
		disc.setStatus(true);
		
		//System.out.println(disc.toString());
		
		aluno.setCpf("012.687.894-52");
		aluno.setNome("Joao Pedro");
		aluno.setEmail("jpdelicia@gmail.com");
		aluno.setEndereco("Rua Dilmãe, Nº 13");
		aluno.setMatricula("1234567890");
		
		System.out.println(aluno.toString());
		
		dir.setCpf("954.555.348-29");
		dir.setNome("Weitinho");
		dir.setEmail("weitinhotop@gmail.com");
		dir.setEndereco("Rua Facislaine, Nº 17");
		dir.setLogin("weitinhodir");
		dir.setSenha("deusefiel");
		
		//System.out.println(dir.toString());
		
		nota.setN1(9);
		nota.setN2(7.1);
		nota.setN3(6.7);
		nota.setFrequencia(8);
		
		//System.out.println(nota.toString());
		
		prof.setCpf("987.789.987-65");
		prof.setNome("Xuxa Meneguel");
		prof.setEmail("xoudaxuxa@gmail.com");
		prof.setEndereco("Rua Xuxa, Nº 88");
		prof.setLogin("xuxinha");
		prof.setSenha("sashinha89");
		
		//System.out.println(prof.toString());
		
		turma.setNome("1º Ano");
		turma.setCodigo("T1100");
		turma.setHorario("Sex/Sab/Domingo 10:00~12:00");
		turma.setLocal("Sala 1");
		
		//System.out.print(turma.toString());
		
		
	}
}

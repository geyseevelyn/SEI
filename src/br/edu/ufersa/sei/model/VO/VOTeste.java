package br.edu.ufersa.sei.model.VO;

public class VOTeste {
	
	public static void main(String[] args) {
		UsuarioVO userVo;
		UsuarioVO alunoVo;
		userVo = new UsuarioVO();
		alunoVo = new AlunoVO();
		
		userVo.setNome("Esse é o do tipo UserVO");
		alunoVo.setNome("Esse é o do tipo AlunoVO");
		//alunoVo.setMatricula("1223456780"); //pq não deu certo?
		
	
		System.out.println(userVo.toString());
		System.out.println(alunoVo.toString());
		
		/*
		UsuarioVO profVo;
		UsuarioVO dirVo;
		profVo = new ProfessorVO();
		dirVo = new DiretorVO();
		
		profVo.setNome("Esse é o tipo ProfVO");
		dirVo.setNome("Esse é o tipo DirVO");
		
		System.out.println(profVo.toString());
		System.out.println(dirVo.toString());
		*/
		
	}
}

package br.edu.ufersa.sei.model.BO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;

public class AlunoBO extends UsuarioBO<AlunoVO> implements AlunoInterBO{
	
	//buscar alunos por turma
	@Override
	public List<AlunoVO> buscarPorTurma(long value) {
		List<AlunoVO> listAluno = new ArrayList<AlunoVO>();
		return listAluno;
		//Busca no banco de dados uma turma
	    //Se a turma não existir, retorna um erro
		//Se existir, retorna os alunos matriculados nessa turma
	}
}

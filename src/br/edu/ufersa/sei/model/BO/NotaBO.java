package br.edu.ufersa.sei.model.BO;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;

public class NotaBO {
	
	public void lancarNotas(NotaVO notas, AlunoVO aluno, DisciplinaVO disc) {
		//Cadastra, edita e exclui a nota no banco de dados
		//Ao alterar uma nota, chama-se o método calcularMedia() novamente
	}
	
	public void lancarFrequencia(NotaVO notas, AlunoVO aluno, DisciplinaVO disc) {
		//Cadastra, edita e exclui a frequencia no banco de dados
	}
}

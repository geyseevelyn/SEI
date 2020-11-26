package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.NotaVO;;

public class NotaBO extends BaseBO<NotaVO> implements NotaInterBO{

	@Override
	public void cadastrar(NotaVO vo) {
		//implementar
		
	}

	@Override
	public void editar(NotaVO vo) {
		//implementar
	}

	@Override
	public void excluir(NotaVO vo) {
		//implementar
	}

	@Override
	public List<NotaVO> listar() {
		//implementar
		return null;
	}

	@Override
	public NotaVO buscar(NotaVO vo) {
		//implementar
		return null;
	}

	@Override
	public void lancarNotas(AlunoVO aluno) {
		//Cadastra, edita e exclui a nota no banco de dados
		//Ao alterar uma nota, chama-se o método calcularMedia() novamente
	}
	
	@Override
	public void lancarFrequencia(AlunoVO aluno) {
		//Cadastra, edita e exclui a frequencia no banco de dados
	}
}

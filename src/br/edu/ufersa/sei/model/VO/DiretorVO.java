package br.edu.ufersa.sei.model.VO;

import br.edu.ufersa.sei.exception.InsertException;

public class DiretorVO extends UsuarioVO{
	private int idDir;

	//getters and setters
	public long getIdDir() {
		return idDir;
	}


	public void setIdDir(int idDir) throws InsertException {
		if(idDir >= 0) {
			this.idDir = idDir;
		}else {
			throw new InsertException("Id do Diretor Inválido!");
		}
	}
}

package br.edu.ufersa.sei.model.VO;

public class DiretorVO extends UsuarioVO{
	private long idDir;

	//getters and setters
	public long getIdDir() {
		return idDir;
	}

	public void setIdDir(long idDir) {
		if(idDir >= 0) {
			this.idDir = idDir;
		}else {
			System.out.println("Id do Diretor Inválido!");
		}
	}
}

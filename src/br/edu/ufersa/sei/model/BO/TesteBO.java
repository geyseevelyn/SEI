package br.edu.ufersa.sei.model.BO;

import java.util.List;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.VO.UsuarioVO;

public class TesteBO {

	public static void main(String[] args) {
		
		UsuarioBO<UsuarioVO> uBo = new UsuarioBO<UsuarioVO>();
		
		try {
			List<UsuarioVO> usuarios = uBo.listarUsuarios();
			
			for(UsuarioVO usu : usuarios) {
				System.out.println(usu);
			}
		} catch (InsertException e) {
			e.printStackTrace();
		}
	}

}

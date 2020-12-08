package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class DiretorController implements Initializable {
	
	//Componentes da Tela Principal Diretor
	
    public void goToTurmasDir(ActionEvent event) throws Exception {
    	Telas.telaGerenciarTurmasDiretor();
    }
	
    public void goToDiscDir(ActionEvent event) throws Exception {
    	Telas.telaGerenciarDiscDiretor();
    }
	
    public void goToPessoasDir(ActionEvent event) throws Exception {
    	Telas.telaGerenciarPessoaDiretor();
    }
    
    public void goToGenrenciarAluno(ActionEvent event) throws Exception {
    	Telas.telaGerenciarAlunoDiretor();
    }
    
    public void goToGerenciarProf(ActionEvent event) throws Exception {
    	Telas.telaGerenciarProfDiretor(); 
    }
    
    public void goToBuscarDir(ActionEvent event) throws Exception {
    	//Telas.
    }

	public void voltar(ActionEvent event) throws Exception{
		Telas.telaPrincipalDiretor();
	}
	
	public void sair(ActionEvent event) throws Exception{
		Telas.telaLogin();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}

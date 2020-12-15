package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class PrincipalDiretorController implements Initializable {		 
	
	//navegação do menu
    public void goToGerenciarTurmas(ActionEvent event) throws Exception {
    	Telas.telaGerenciarTurmas();
    }
	
    public void goToGerenciarDisciplinas(ActionEvent event) throws Exception {
    	Telas.telaGerenciarDisciplinas();
    }
	
    public void goToGerenciarPessoas(ActionEvent event) throws Exception {
    	Telas.telaGerenciarPessoas();
    }
    
    public void goToGenrenciarAluno(ActionEvent event) throws Exception {
    	Telas.telaGerenciarAluno();
    }
    
    public void goToGerenciarProf(ActionEvent event) throws Exception {
    	Telas.telaGerenciarProf(); 
    }
    
    public void goToBuscar(ActionEvent event) throws Exception {
    	Telas.telaBuscarDiretor();
    }

	public void voltar(ActionEvent event) throws Exception{
		Telas.telaPrincipalDiretor();
	}
	
	public void sair(ActionEvent event) throws Exception{
		Telas.telaLogin();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}

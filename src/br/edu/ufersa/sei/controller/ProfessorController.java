package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class ProfessorController implements Initializable {

	//Componentes da Tela Principal Professor
	
	//Componentes de todas as telas de professor
    @FXML
    private Button minhasTurmas;
    @FXML
    private Button notas;

    public void goToTurmaProf(ActionEvent event) throws Exception {
    	Telas.telaTurmaProf();
    }
  
    public void goToNotaProf(ActionEvent event) throws Exception{
    	Telas.telaNotaProf();
    }

	public void voltar(ActionEvent event) throws Exception {
		Telas.telaPrincipalProf();;
	}
	
	public void sair(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}
}

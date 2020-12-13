package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


public class PrincipalProfController implements Initializable {
	
	//Componentes de todas as telas de professor
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}

	//navegação do menu
	public void goToTurmasProf(ActionEvent event) throws Exception {
		Telas.telaTurmasProf();
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

}

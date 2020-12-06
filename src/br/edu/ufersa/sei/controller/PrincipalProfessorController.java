package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class PrincipalProfessorController implements Initializable{

	//Componentes da Tela Principal Professor

	public void voltarProf(ActionEvent event) throws Exception{
		Telas.telaPrincipalProf();;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
}

package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class PrincipalDiretorController implements Initializable{
	
	//Componentes da Tela Principal Diretor
	
	public void voltarDiretor(ActionEvent event) throws Exception{
		Telas.telaPrincipalDiretor();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}

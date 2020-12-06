package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class PrincipalAlunoController implements Initializable{
	
	//Componentes da Tela Principal Aluno
	
	public void voltarAluno(ActionEvent event) throws Exception{
		Telas.telaPrincipalAluno();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}

}

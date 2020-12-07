package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class LoginAlunoController implements Initializable {
	
	//Componentes da Tela de Login

	@FXML
	private TextField login;
	@FXML
	private TextField senha;
	
	public void entrar(ActionEvent event) throws Exception{
		Telas.telaPrincipalAluno();
	}
	
	public void sair(ActionEvent event) throws Exception{
		Telas.telaLoginAluno();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}
}

package br.edu.ufersa.sei.controller;


import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlunoController implements Initializable {

	//Componentes da Tela de Login

		@FXML
		private TextField login;
		@FXML
		private TextField senha;
		
		public void entrar() throws Exception{
			try {
			Telas.telaPrincipalAluno();
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		//Componentes da Tela Principal Aluno
	    @FXML
	    private Label matricula;
	    @FXML
	    private Label cpf;
	    @FXML
	    private Label nome;
	    @FXML
	    private Label turno;
	    @FXML
	    private Label turma;
	    @FXML
	    private Label email;
	    @FXML
	    public void sair() throws Exception{
			Telas.telaLoginAluno();
		}
		
		public void voltarAluno() throws Exception{
			Telas.telaPrincipalAluno();
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub	
		}
}

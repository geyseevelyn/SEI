package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AlunoController implements Initializable {

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
	
	//Componentes de todas as telas de aluno
	@FXML
	private Button meuPerfil;
	@FXML
	private Button minhasDisciplinas;
	@FXML
	private Button minhasNotas;
	@FXML
	private Button sair;
	    
	public void goToDisciplina(ActionEvent event) throws Exception {
		Telas.telaDisciplinaAluno();
	}
		
	public void goToNota(ActionEvent event) throws Exception {
		Telas.telaNotaluno();
	}
	    
	public void voltarAluno() throws Exception {
		Telas.telaPrincipalAluno();
	}
	    
	public void sair() throws Exception {
		Telas.telaLogin();
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
	}
}

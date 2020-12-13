package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PrincipalAlunoController implements Initializable {

	//Componentes da Tela Principal Aluno
	@FXML private Label matricula;
	@FXML private Label cpf;
	@FXML private Label nome;
	@FXML private Label turno;
	@FXML private Label turma;
	@FXML private Label email;
	
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		carregarPerfilAluno();	
//	}
//	
//	public void carregarPerfilAluno() {
//		AlunoVO avo = new AlunoVO();
//		txf_nome.setText(avo.getNome());
//		txf_matricula.setText(avo.getMatricula());
//		txf_endereco.setText(avo.getEndereco());
//		txf_email.setText(avo.getEmail());
//		txf_turma.setText(avo.getTurma().getNome());
//		txf_turno.setText(avo.getTurma().getHorario());
//	};
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			//cpf.setText(Telas.getUser().getCpf());
	}
	    
	public void goToDisciplinas(ActionEvent event) throws Exception {
		Telas.telaDisciplinasAluno(); 
	}
		
	public void goToNotas(ActionEvent event) throws Exception {
		Telas.telaNotasAluno();
	}
	    
	public void voltarAluno() throws Exception {
		Telas.telaPrincipalAluno();
	}
	    
	public void sair() throws Exception {
		Telas.telaLogin();
	}
}

package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrincipalAlunoController implements Initializable{

	//Componentes da Tela Principal Aluno	
	 @FXML private TextField txf_nome;
	 @FXML private TextField txf_matricula;
	 @FXML private TextField txf_endereco;
	 @FXML private TextField txf_email;
	 @FXML private TextField txf_turma;
	 @FXML private TextField txf_turno;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarPerfilAluno();	
	}
	
	public void carregarPerfilAluno() {
		AlunoVO avo = new AlunoVO();
		txf_nome.setText(avo.getNome());
		txf_matricula.setText(avo.getMatricula());
		txf_endereco.setText(avo.getEndereco());
		txf_email.setText(avo.getEmail());
		txf_turma.setText(avo.getTurma().getNome());
		txf_turno.setText(avo.getTurma().getHorario());
	};
	
	@FXML private Button meuPerfil;
	@FXML private Button minhasDisciplinas;
	@FXML private Button minhasNotas;
	@FXML private Button sair;
	    
	public void goToDisciplina(ActionEvent event) throws Exception {
		Telas.telaDisciplinaAluno();
	}
		
	public void goToNota(ActionEvent event) throws Exception {
		Telas.telaNotaluno();
	}
	    
	public void voltar() throws Exception {
		//Telas.telaPrincipalAluno();
	}
	    
	public void sair() throws Exception {
		Telas.telaLogin();
	}

}

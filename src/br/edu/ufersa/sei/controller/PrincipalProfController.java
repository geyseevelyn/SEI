package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PrincipalProfController implements Initializable {
	
	//Componentes de todas as telas de professor
	@FXML private TextField tfCpf;
	@FXML private TextField tfEndereco;
	@FXML private TextField tfEmail;
	@FXML private TextField tfDisc;
	@FXML private Label nome;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarPerfilProf();
	}
	
	public void carregarPerfilProf() {
		ProfessorVO pvo = Telas.getUserProf();
		DisciplinaBO dbo = new DisciplinaBO();
		nome.setText(pvo.getNome());
		tfCpf.setText(pvo.getCpf());
		tfEndereco.setText(pvo.getEndereco());
		tfEmail.setText(pvo.getEmail());
		try {
			DisciplinaVO dvo = dbo.buscarPorIdProf(pvo);
			tfDisc.setText(dvo.getNome());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
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

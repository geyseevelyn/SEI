package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.TurmaBO;
import br.edu.ufersa.sei.model.BO.TurmaProfBO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class GerenciarProfTurmasController implements Initializable{
	
	@FXML private TextField tfNomeProfessor;
	@FXML private ComboBox<TurmaVO> cbTurmas;
	
	@FXML private TableView<TurmaVO> tvTurmaProf;
	@FXML private TableColumn<TurmaVO, String> colCodigo;
	@FXML private TableColumn<TurmaVO, String> colTurma;
	@FXML private TableColumn<TurmaVO, String> colTurno;
	@FXML private TableColumn<TurmaVO, String> colSala;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarInformacoes();
		carregarCBTurmas();
		carregarTabelaTurmasProf();
	}
	
    public void atribuir(ActionEvent event) {
    	TurmaProfBO tpbo = new TurmaProfBO();
    	TurmaVO tvo = cbTurmas.getSelectionModel().getSelectedItem();
    	try {
			tpbo.cadastrarTurmasProf(tvo, Telas.getProf());
			carregarTabelaTurmasProf();
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }
    
    public void remover(ActionEvent event) {
    	TurmaProfBO tpbo = new TurmaProfBO();
    	TurmaVO tvo = tvTurmaProf.getSelectionModel().getSelectedItem();
    	try {
			tpbo.excluirTurmasProf(tvo, Telas.getProf());
			carregarTabelaTurmasProf();
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }
	
	public void carregarInformacoes() {
		ProfessorVO pvo = Telas.getProf();
		tfNomeProfessor.setText(pvo.getNome());
	}
	
	public void carregarCBTurmas() {
		 TurmaBO tbo = new TurmaBO ();
		try {
			cbTurmas.setItems(FXCollections.observableArrayList(tbo.listar()));
		} catch (InsertException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarTabelaTurmasProf() {
		TurmaProfBO tpbo = new TurmaProfBO();
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("codTurma"));
		colTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colTurno.setCellValueFactory(new PropertyValueFactory<>("horario"));
		colSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
    	 		
    	try {
			tvTurmaProf.setItems(FXCollections.observableArrayList(tpbo.buscarPorProf(Telas.getProf())));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}	

	public void goToAtribuirTurmas(MouseEvent event) throws Exception {
		Telas.telaGerenciarProfTurmas();
	}
}

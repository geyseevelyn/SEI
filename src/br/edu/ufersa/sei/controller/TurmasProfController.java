package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.AlunoBO;
import br.edu.ufersa.sei.model.BO.TurmaBO;
import br.edu.ufersa.sei.model.BO.TurmaProfBO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TurmasProfController implements Initializable {
	
	@FXML private ComboBox<TurmaVO> cbTurma;	
    @FXML private TableView<TurmaVO> tvTurma;
    @FXML private TableColumn<TurmaVO, String> colCodigo;
    @FXML private TableColumn<TurmaVO, String> colTurma;
    @FXML private TableColumn<TurmaVO, String> colTurno;
    @FXML private TableColumn<TurmaVO, String> colSala;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaTurma();
	}
	
	public void carregarTabelaTurma() {
		TurmaProfBO tpbo = new TurmaProfBO();
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("codTurma"));
		colTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colTurno.setCellValueFactory(new PropertyValueFactory<>("horario"));
		colSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
    	 		
    	try {
			tvTurma.setItems(FXCollections.observableArrayList(tpbo.buscarPorProf(Telas.getUserProf())));
		} catch (Exception e) {
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

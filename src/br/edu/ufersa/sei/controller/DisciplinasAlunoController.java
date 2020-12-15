package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.TurmaDiscBO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class DisciplinasAlunoController implements Initializable {
	
	@FXML private TableView<DisciplinaVO> tvDiscAluno;

	@FXML private TableColumn<DisciplinaVO, String> colCodigo;

	@FXML private TableColumn<DisciplinaVO, String> colDisc;

	@FXML private TableColumn<DisciplinaVO, String> colProf;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaDisc();
	}
	
	public void carregarTabelaDisc() {
		List<DisciplinaVO> disc = new ArrayList<>();
		AlunoVO avo = Telas.getUserAlu();
		TurmaDiscBO tdbo = new TurmaDiscBO();
		try {
			disc = tdbo.buscarDiscTurma(avo.getTurma());
		} catch (NotFoundException e1) {
			e1.printStackTrace();
		}
		
		colDisc.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("codDisc"));
		colProf.setCellValueFactory(new Callback<CellDataFeatures<DisciplinaVO, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(TableColumn.CellDataFeatures<DisciplinaVO , String> p) {
				return new SimpleObjectProperty<String>("" + p.getValue().getProfDisc().getNome());
			}
		});
		
		tvDiscAluno.setItems(FXCollections.observableArrayList(disc));
	}
	
	public void goToDisciplinas(ActionEvent event) throws Exception {
		Telas.telaDisciplinasAluno(); 
	}
		
	public void goToNotas(ActionEvent event) throws Exception {
		Telas.telaNotasAluno();
	}
	    
	public void voltar() throws Exception {
		Telas.telaPrincipalAluno();
	}
	    
	public void sair() throws Exception {
		Telas.telaLogin();
	}

}

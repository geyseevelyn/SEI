package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.TurmaDiscBO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class GerenciarTurmaDiscController implements Initializable{
	
	
	@FXML private TextField tfNomeTurma;
    @FXML private TableView<DisciplinaVO> tvTurmaDisc;
    @FXML private TableColumn<DisciplinaVO, String> colCodigo;
    @FXML private TableColumn<DisciplinaVO, String> colDisciplina;
    @FXML private TableColumn<DisciplinaVO, String> colProf;
    @FXML private ComboBox<DisciplinaVO> cbDisc;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarInformacoes();
		carregarTabelaTurmaDisc();
		carregarCBDisc();
	}
	
	public void atribuir(ActionEvent event) {
		TurmaDiscBO tdbo = new TurmaDiscBO();
    	DisciplinaVO dvo = cbDisc.getSelectionModel().getSelectedItem();
    	try {
			tdbo.cadastrarDisicplinasTurma(Telas.getTurma(), dvo);
			carregarTabelaTurmaDisc();
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }
    
    public void remover(ActionEvent event) {
    	TurmaDiscBO tdbo = new TurmaDiscBO();
    	DisciplinaVO dvo = tvTurmaDisc.getSelectionModel().getSelectedItem();
    	try {
			tdbo.excluirDisicplinasTurma(Telas.getTurma(), dvo);
			carregarTabelaTurmaDisc();
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }
	
	public void carregarInformacoes() {
		TurmaVO tvo = Telas.getTurma();
		tfNomeTurma.setText(tvo.getNome());
	}
	
	public void carregarCBDisc() {
		DisciplinaBO dbo = new DisciplinaBO();
		try {
			cbDisc.setItems(FXCollections.observableArrayList(dbo.listar()));
		} catch (InsertException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarTabelaTurmaDisc() {
			TurmaDiscBO tdbo = new TurmaDiscBO();
			colDisciplina.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colCodigo.setCellValueFactory(new PropertyValueFactory<>("codDisc"));
			colProf.setCellValueFactory(new Callback<CellDataFeatures<DisciplinaVO, String>, ObservableValue<String>>() {
				public ObservableValue<String> call(TableColumn.CellDataFeatures<DisciplinaVO , String> p) {
					return new SimpleObjectProperty<String>("" + p.getValue().getProfDisc().getNome());
				}
			});
			
			try {
				tvTurmaDisc.setItems(FXCollections.observableArrayList(tdbo.buscarDiscTurma(Telas.getTurma())));
			} catch (NotFoundException e) {
				e.printStackTrace();
			}  	 		
		}
	}

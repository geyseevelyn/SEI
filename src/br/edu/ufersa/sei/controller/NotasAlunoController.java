package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.BO.NotaBO;
import br.edu.ufersa.sei.model.VO.NotaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class NotasAlunoController implements Initializable{
	
	@FXML private TableColumn<NotaVO, String> colDisc;
	@FXML private TableColumn<NotaVO, Double> colN1;
	@FXML private TableColumn<NotaVO, Double> colN2;
	@FXML private TableColumn<NotaVO, Double> colN3;
	@FXML private TableColumn<NotaVO, Double> colMedia;
	@FXML private TableColumn<NotaVO, Integer> colFaltas;
	@FXML private TableView<NotaVO> tvNotas;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaNotas();
	}
	
	public void carregarTabelaNotas() {
		List<NotaVO> notas = new ArrayList<>();
		 
		 colN1.setCellValueFactory(new PropertyValueFactory<>("n1"));
		 colN2.setCellValueFactory(new PropertyValueFactory<>("n2"));
		 colN3.setCellValueFactory(new PropertyValueFactory<>("n3"));
		 colMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
		 colMedia.setCellFactory(tc -> new TableCell<NotaVO,Double>() {
			    @Override
			    protected void updateItem(Double media, boolean empty) {
			        super.updateItem(media, empty) ;
			        if (empty) {
			            setText(null);
			        } else {
			            setText(String.format("%.1f", media.doubleValue()).replace(",", "."));
			        }
			    }
			});
		 colFaltas.setCellValueFactory(new PropertyValueFactory<>("faltas"));
		 colDisc.setCellValueFactory(new Callback<CellDataFeatures<NotaVO, String>, ObservableValue<String>>() {
    		 public ObservableValue<String> call(TableColumn.CellDataFeatures<NotaVO , String> a) {
    			 return new SimpleObjectProperty<String>("" + a.getValue().getDisc().getNome());
    	     }
    	});
		 NotaBO nbo = new NotaBO();
	    	try {
				notas = nbo.listarNotasAluno(Telas.getUserAlu());
			} catch (InsertException e) {
				e.printStackTrace();
			}  	
	    	tvNotas.setItems(FXCollections.observableArrayList(notas));
	}
	
	 
	public void goToBoletim(ActionEvent event) throws Exception {
		Telas.telaBoletim();
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

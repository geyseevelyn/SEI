package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.NotaBO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CadastarNotaController implements Initializable{	
    
    @FXML private TextField tfNome;
    @FXML  private TextField tfN1;
    @FXML private TextField tfN2;
    @FXML private TextField tfN3;
    @FXML private TextField tfFaltas;
	
	@FXML private TableView<NotaVO> tvNota;
    @FXML private TableColumn<NotaVO, Double> colN1;
    @FXML private TableColumn<NotaVO, Double> colN2;
    @FXML private TableColumn<NotaVO, Double> colN3;    
    @FXML private TableColumn<NotaVO, Double> colMedia;
    @FXML private TableColumn<NotaVO, Integer> colFaltas;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarInformacoes();		
		carregarTabelaNota();
	}
	
	public void cadastrarNota(ActionEvent event) throws Exception{
		 NotaBO nbo = new NotaBO();
		 NotaVO nvo = new NotaVO();
		 DisciplinaVO dvo = new DisciplinaVO();
		 DisciplinaBO dbo = new DisciplinaBO();
		 
		 try {
			 //Tem q setar a disciplina
			 nvo.setAluno(Telas.getAlu());
			 dvo = dbo.buscarPorIdProf(Telas.getUserProf());
			 nvo.setDisc(dvo);
			 nvo.setN1(Double.parseDouble(tfN1.getText()));
			 nvo.setN2(Double.parseDouble(tfN2.getText()));
			 nvo.setN3(Double.parseDouble(tfN3.getText()));
			 nvo.setFaltas(Integer.parseInt(tfFaltas.getText()));
			 nvo.calcularMedia(nvo.getN1(), nvo.getN2(), nvo.getN3());
			 nbo.cadastrar(nvo);  //chama o BO

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 } 	
		 carregarInformacoes();
		 carregarTabelaNota();
	 }
	
	public void editar(ActionEvent event) throws Exception{
		 NotaBO nbo = new NotaBO();
		 NotaVO nvo = new NotaVO();
		 DisciplinaVO dvo = new DisciplinaVO();
		 DisciplinaBO dbo = new DisciplinaBO();
		 
		 try {
			 //Tem q setar a disciplina
			 nvo.setAluno(Telas.getAlu());
			 dvo = dbo.buscarPorIdProf(Telas.getUserProf());
			 nvo.setDisc(dvo);
			 nvo.setN1(Double.parseDouble(tfN1.getText()));
			 nvo.setN2(Double.parseDouble(tfN2.getText()));
			 nvo.setN3(Double.parseDouble(tfN3.getText()));
			 nvo.setFaltas(Integer.parseInt(tfFaltas.getText()));
			 nvo.calcularMedia(nvo.getN1(), nvo.getN2(), nvo.getN3());
			 nbo.editar(nvo);

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 } 	
	 }
	
	public void pegarLinhaNota() {
		if(tvNota.getSelectionModel().getSelectedItem() != null) {
		NotaVO nvo = tvNota.getSelectionModel().getSelectedItem();		
		nvo.getIdNota();

		tfN1.setText(""+nvo.getN1());
		tfN2.setText(""+nvo.getN2());
		tfN3.setText(""+nvo.getN3());
		tfFaltas.setText(""+nvo.getFaltas());
		}
		
		else {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText("Linha vazia!");
			 alert.setContentText("Você selecionou uma linha vazia");
			 alert.show();
		 } 
	}
	
	public void carregarInformacoes() {
		tfNome.setText(Telas.getAlu().getNome());
		NotaBO nbo = new NotaBO();
		NotaVO nvo = new NotaVO();
		DisciplinaVO dvo = new DisciplinaVO();
		DisciplinaBO dbo = new DisciplinaBO();
		try {
			nvo.setAluno(Telas.getAlu());
			dvo = dbo.buscarPorIdProf(Telas.getUserProf());
			nvo.setDisc(dvo);
			nvo = nbo.buscarNotaAluno(nvo);
			if (nvo != null) {
				tfN1.setText(""+nvo.getN1());
				tfN2.setText(""+nvo.getN2());
				tfN3.setText(""+nvo.getN3());
				tfFaltas.setText(""+nvo.getFaltas());
			}
			
		} catch (NotFoundException | InsertException e) {
			e.printStackTrace();
		}
		carregarTabelaNota();
	}
	
	
	
	public void carregarTabelaNota() {
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
		 NotaBO nbo = new NotaBO();
		 NotaVO nvo = new NotaVO();
		 DisciplinaVO dvo = new DisciplinaVO();
		 DisciplinaBO dbo = new DisciplinaBO();
	    	try {
	    		nvo.setAluno(Telas.getAlu());
				dvo = dbo.buscarPorIdProf(Telas.getUserProf());
				nvo.setDisc(dvo);
				notas = nbo.listarNotaAluno(nvo);
			} catch (InsertException | NotFoundException e) {
				e.printStackTrace();
			}  	
	    	tvNota.setItems(FXCollections.observableArrayList(notas));
	 }
	
	
}

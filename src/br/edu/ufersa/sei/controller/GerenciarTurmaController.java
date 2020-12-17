package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.BO.TurmaBO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenciarTurmaController implements Initializable{
	
	@FXML private TextField tfNome;
	@FXML private TextField tfCodigo;
	@FXML private TextField tfLocal;
	@FXML private TextField tfTurno;
	@FXML private TextField tfBuscaTurma;
	
	@FXML private TableView<TurmaVO> tvTurma;
	@FXML private TableColumn<TurmaVO, String> colCodigo;
	@FXML private TableColumn<TurmaVO, String> colTurma;
	@FXML private TableColumn<TurmaVO, String> colTurno;
	@FXML private TableColumn<TurmaVO, String> colSala;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaTurma();
	}

	public void cadastrarTurma(ActionEvent event) {
		TurmaBO tbo = new TurmaBO();
		TurmaVO tvo = new TurmaVO();
		 
		 try {
			 tvo.setNome(tfNome.getText());
			 tvo.setCodTurma(tfCodigo.getText());
			 tvo.setSala(tfLocal.getText());
			 tvo.setHorario(tfTurno.getText());

			 tbo.cadastrar(tvo);  //chama o BO
			 recarregarTelaGerenciarTurma();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 }
	}

	public void editarTurma(ActionEvent event) {
		TurmaBO tbo = new TurmaBO();
		TurmaVO tvo = new TurmaVO();
		 
		 try {
			 TurmaVO tvo2 = tvTurma.getSelectionModel().getSelectedItem();
			 tvo.setNome(tfNome.getText());
			 tvo.setCodTurma(tfCodigo.getText());
			 tvo.setSala(tfLocal.getText());
			 tvo.setHorario(tfTurno.getText());
			 tvo.setIdTurma(tvo2.getIdTurma());

			 tbo.editar(tvo);
			 recarregarTelaGerenciarTurma();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 }
	}
	
	public void removerTurma(ActionEvent event) {
		TurmaBO tbo = new TurmaBO();
    	TurmaVO tvo = tvTurma.getSelectionModel().getSelectedItem();
    	try {
			tbo.excluir(tvo);
			carregarTabelaTurma();
		} catch (InsertException e) {
			e.printStackTrace();
		}
	}

	public void recarregarTelaGerenciarTurma() {
		try {
			 Telas.telaGerenciarTurmas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregarTabelaTurma() {
		TurmaBO tpbo = new TurmaBO();
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("codTurma"));
		colTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colTurno.setCellValueFactory(new PropertyValueFactory<>("horario"));
		colSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
    	 		
    	try {
			tvTurma.setItems(FXCollections.observableArrayList(tpbo.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pegarLinhaTurma() {
		 if(tvTurma.getSelectionModel().getSelectedItem() != null) {

			 TurmaVO tvo = tvTurma.getSelectionModel().getSelectedItem();	
			 tvo.getIdTurma();

			 tfNome.setText(tvo.getNome());
			 tfCodigo.setText(tvo.getCodTurma());
			 tfTurno.setText(tvo.getHorario());
			 tfLocal.setText(tvo.getSala());

		 } else {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText("Linha vazia!");
			 alert.setContentText("Você selecionou uma linha vazia");
			 alert.show();
			 limparCampos();
		 }    	 
	 }
	
	public void limparCampos() {
		 tfNome.clear();
		 tfCodigo.clear();
		 tfTurno.clear();
		 tfLocal.clear();  
	 }
	
	public void buscarTurma(ActionEvent event) throws Exception{
    	TurmaBO tbo = new TurmaBO();
    	TurmaVO tvo = new TurmaVO();
		List<TurmaVO> turmas = new ArrayList<TurmaVO>();
		tvo.setNome(tfBuscaTurma.getText());
		 
		try {
		     turmas = tbo.buscarPorNome(tvo);
			 carregarTabelaBuscarTurma(turmas);
		} catch (InsertException e) {
			 e.printStackTrace();
		}
    }
	
	public void carregarTabelaBuscarTurma(List<TurmaVO> turmas) {		 	  
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("codTurma"));
		colTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colTurno.setCellValueFactory(new PropertyValueFactory<>("horario"));
		colSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
    	
    	tvTurma.setItems(FXCollections.observableArrayList(turmas));
		 
	 }
	
	//navegação do menu
	public void goToAtribuirDisc(ActionEvent event) throws Exception {

		if(tvTurma.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Nenhum Item Selecionado");
			alert.setContentText("Selecione uma turma na tabela");
			alert.show();

		}else{
			try {
				Telas.setTurma(tvTurma.getSelectionModel().getSelectedItem());
				Telas.telaGerenciarTurmaDisc();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    public void goToGerenciarTurmas(ActionEvent event) throws Exception {
    	Telas.telaGerenciarTurmas();
    }
	
    public void goToGerenciarDisciplinas(ActionEvent event) throws Exception {
    	Telas.telaGerenciarDisciplinas();
    }
	
    public void goToGerenciarPessoas(ActionEvent event) throws Exception {
    	Telas.telaGerenciarPessoas();
    }
    
    public void goToGenrenciarAluno(ActionEvent event) throws Exception {
    	Telas.telaGerenciarAluno();
    }
    
    public void goToGerenciarProf(ActionEvent event) throws Exception {
    	Telas.telaGerenciarProf(); 
    }
    
    public void goToBuscar(ActionEvent event) throws Exception {
    	Telas.telaBuscarDiretor();
    }

	public void voltar(ActionEvent event) throws Exception{
		Telas.telaPrincipalDiretor();
	}
	
	public void sair(ActionEvent event) throws Exception{
		Telas.telaLogin();
	}

}

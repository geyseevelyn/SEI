package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.AlunoBO;
import br.edu.ufersa.sei.model.BO.TurmaProfBO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class NotaProfController implements Initializable{
	
	@FXML private ComboBox<TurmaVO> cbTurmaAluno;
	
	@FXML private TableView<AlunoVO> tvAluno;
	@FXML private TableColumn<AlunoVO, String> colNomeAluno;
	@FXML private TableColumn<AlunoVO, String> colCpfAluno;
	@FXML private TableColumn<AlunoVO, String> colMatriculaAluno;
	@FXML private TableColumn<AlunoVO, String> colEmailAluno;
	@FXML private TableColumn<AlunoVO, String> colEnderecoAluno;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//carregarTabelaAluno();
		carregarCBTurmaAluno();
	}
	
//	public void carregarTabelaAluno() {
//    	List<AlunoVO> alunos = new ArrayList<>();
//  
//    	colNomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
//    	colCpfAluno.setCellValueFactory(new PropertyValueFactory<>("cpf"));
//    	colMatriculaAluno.setCellValueFactory(new PropertyValueFactory<>("matricula"));
//    	colEnderecoAluno.setCellValueFactory(new PropertyValueFactory<>("endereco"));
//    	colEmailAluno.setCellValueFactory(new PropertyValueFactory<>("email"));
//    	
//    	AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();   	
//    	try {
//			alunos = abo.listar();
//		} catch (InsertException e) {
//			e.printStackTrace();
//		}  	
//    	tvAluno.setItems(FXCollections.observableArrayList(alunos));	
//    }
	
	public void carregarCBTurmaAluno() {
		TurmaProfBO tpbo = new TurmaProfBO();
		try {
			cbTurmaAluno.setItems(FXCollections.observableArrayList(tpbo.buscarPorProf(Telas.getUserProf())));//Listar alternativa??
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarNotas() {
		//
	}
	
	public void selecionarTurma() {
		TurmaVO tvo = cbTurmaAluno.getSelectionModel().getSelectedItem();
		AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
		try {
			colNomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
	    	colCpfAluno.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	    	colMatriculaAluno.setCellValueFactory(new PropertyValueFactory<>("matricula"));
	    	colEnderecoAluno.setCellValueFactory(new PropertyValueFactory<>("endereco"));
	    	colEmailAluno.setCellValueFactory(new PropertyValueFactory<>("email"));
			tvAluno.setItems(FXCollections.observableArrayList(abo.buscarAlunosPorTurma(tvo)));
			
		} catch (InsertException e) {
			e.printStackTrace();
		}
	}
	
	public void goToCadastrarNota(ActionEvent event) throws Exception {

		if(tvAluno.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Nenhum Item Selecionado");
			alert.setContentText("Selecione um aluno na tabela");
			alert.show();

		}else{
			try {
				Telas.setAlu(tvAluno.getSelectionModel().getSelectedItem());
				Telas.telaCadastrarNota();

			} catch (Exception e) {
				e.printStackTrace();
			}
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

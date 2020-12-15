package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.BO.ProfessorBO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
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

public class GerenciarProfController implements Initializable {
		
	@FXML private TextField tfNome;
    @FXML private TextField tfCpf;
    @FXML  private TextField tfEmail;
    @FXML private TextField tfEndereco;    
    @FXML private TextField tfLogin;
    @FXML private TextField tfSenha;
    @FXML private TextField tfBuscaProf;
    
    @FXML private TableView<ProfessorVO> tvProf;
    @FXML private TableColumn<ProfessorVO, String> colNome;
    @FXML private TableColumn<ProfessorVO, String> colCpf;
    @FXML private TableColumn<ProfessorVO, String> colEmail;
    @FXML private TableColumn<ProfessorVO, String> colEndereco;
    //@FXML private TableColumn<ProfessorVO, Long> colDisc;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaProf();
	}
    
    public void carregarTabelaProf() {
    	List<ProfessorVO> professores = new ArrayList<>();
  
    	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    	
    	ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();   	
    	try {
			professores = pbo.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}  	
    	tvProf.setItems(FXCollections.observableArrayList(professores));
    }
    
    public void cadastrarProf(ActionEvent event) throws Exception{
    	ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
    	ProfessorVO pvo = new ProfessorVO();
		 
		 try {
			 pvo.setNome(tfNome.getText());
			 pvo.setCpf(tfCpf.getText());
			 pvo.setEndereco(tfEndereco.getText());
			 pvo.setEmail(tfEmail.getText());
			 pvo.setLogin(tfLogin.getText());
			 pvo.setSenha(tfSenha.getText());

			 pbo.cadastrar(pvo);  //chama o BO
			 recarregarTelaGerenciarProf();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 }
    }

    public void editarProf(ActionEvent event) throws Exception{
    	ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
    	ProfessorVO pvo = new ProfessorVO();
		 
		 try {
			 ProfessorVO pvo2 = tvProf.getSelectionModel().getSelectedItem();
			 pvo.setNome(tfNome.getText());
			 pvo.setCpf(tfCpf.getText());
			 pvo.setEndereco(tfEndereco.getText());
			 pvo.setEmail(tfEmail.getText());
			 pvo.setLogin(tfLogin.getText());
			 pvo.setSenha(tfSenha.getText());
			 pvo.setIdUsu(pvo2.getIdUsu());

			 pbo.editar(pvo);
			 recarregarTelaGerenciarProf();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 }
    }
        
    public void removerProf(ActionEvent event) {
    	ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
    	ProfessorVO pvo = new ProfessorVO();
    	 try {
			 ProfessorVO pvo2 = tvProf.getSelectionModel().getSelectedItem();
			 pvo.setIdUsu(pvo2.getIdUsu());
			 
			 pbo.excluir(pvo);
			 recarregarTelaGerenciarProf();
			 
    	 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 }	     	
    }
    
    public void pegarLinhaProf() {
		 if(tvProf.getSelectionModel().getSelectedItem() != null) {

			 ProfessorVO pvo = tvProf.getSelectionModel().getSelectedItem();	
			 pvo.getIdUsu();

			 tfNome.setText(pvo.getNome());
			 tfCpf.setText(pvo.getCpf());
			 tfEndereco.setText(pvo.getEndereco());
			 tfEmail.setText(pvo.getEmail());
			 tfLogin.setText(pvo.getLogin());
			 tfSenha.setText(pvo.getSenha());

		 } else {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText("Linha vazia!");
			 alert.setContentText("Você selecionou uma linha vazia");
			 alert.show();
			 limparCampos();
		 }    	 
	 }
    
    @FXML
    public void buscarProf(ActionEvent event) throws Exception{
    	ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO>();
    	ProfessorVO pvo = new ProfessorVO();
		List<ProfessorVO> professores = new ArrayList<ProfessorVO>();
		pvo.setNome(tfBuscaProf.getText());
		 
		try {
		     professores = pbo.buscarPorNome(pvo);
			 carregarTabelaBuscarProf(professores);
		} catch (InsertException e) {
			 e.printStackTrace();
		}
    }
    
    public void carregarTabelaBuscarProf(List<ProfessorVO> professores) {		 	  
    	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    	
    	tvProf.setItems(FXCollections.observableArrayList(professores));
		 
	 }
    
    public void recarregarTelaGerenciarProf() {
		 try {
			 Telas.telaGerenciarProf();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
    
    public void limparCampos() {
		 tfNome.clear();
		 tfCpf.clear();
		 tfEndereco.clear();
		 tfEmail.clear();
		 tfLogin.clear();
		 tfSenha.clear();	    
	 }	
		
	//navegação do menu
    public void goToAtribuirTurmas(ActionEvent event) throws Exception {
    	
		if(tvProf.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Nenhum Item Selecionado");
			alert.setContentText("Selecione um professor na tabela");
			alert.show();
			
    	}else{
			try {
		    	Telas.setProf(tvProf.getSelectionModel().getSelectedItem());
		    	Telas.telaGerenciarProfTurmas();
		    	
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

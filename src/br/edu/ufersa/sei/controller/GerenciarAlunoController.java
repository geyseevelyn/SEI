package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.AlunoBO;
import br.edu.ufersa.sei.model.BO.TurmaBO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class GerenciarAlunoController implements Initializable{
	
	//Elementos da tela gerenciar aluno
	 @FXML private TextField tfNomeAluno;
     @FXML private TextField tfCpfAluno;
     @FXML private TextField tfMatriculaAluno;
     @FXML private TextField tfEmailAluno;	 
	 @FXML private TextField tfEnderecoAluno;
	 @FXML private TextField tfLoginAluno;
	 @FXML private TextField tfSenhaAluno;
	
	 @FXML private ComboBox<TurmaVO> cbTurmaAluno;	 
	 @FXML private ComboBox<String> cbBusca;
	 @FXML private TextField tfBuscaAluno;
	 
	 @FXML private TableView<AlunoVO> tvAluno;
	 @FXML private TableColumn<AlunoVO, String> colNomeAluno;
	 @FXML private TableColumn<AlunoVO, String> colCpfAluno;
	 @FXML private TableColumn<AlunoVO, String> colMatriculaAluno;
	 @FXML private TableColumn<AlunoVO, String> colEmailAluno;
	 @FXML private TableColumn<AlunoVO, String> colEnderecoAluno;
	 @FXML private TableColumn<AlunoVO, String> colTurmaAluno;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaAluno();
		carregarCBTurmaAluno();
		carregarBuscarPor();
	}
	
    public void carregarTabelaAluno() {
    	List<AlunoVO> alunos = new ArrayList<>();
  
    	colNomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colCpfAluno.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	colMatriculaAluno.setCellValueFactory(new PropertyValueFactory<>("matricula"));
    	colEnderecoAluno.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	colEmailAluno.setCellValueFactory(new PropertyValueFactory<>("email"));
    	colTurmaAluno.setCellValueFactory(new Callback<CellDataFeatures<AlunoVO, String>, ObservableValue<String>>() {
    		 public ObservableValue<String> call(TableColumn.CellDataFeatures<AlunoVO , String> a) {
    			 return new SimpleObjectProperty<String>("" + a.getValue().getTurma().getIdTurma());
    	     }
    	});
    	
    	AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();   	
    	try {
			alunos = abo.listar();
		} catch (InsertException e) {
			e.printStackTrace();
		}  	
    	tvAluno.setItems(FXCollections.observableArrayList(alunos));	
    }
	
    public void carregarCBTurmaAluno() {
		 TurmaBO tbo = new TurmaBO ();
		try {
			cbTurmaAluno.setItems(FXCollections.observableArrayList(tbo.listar()));//Listar alternativa??
		} catch (InsertException e) {
			e.printStackTrace();
		} 
	}
    
	 //combobox 'buscar por'
	 public void carregarBuscarPor() {
		 ObservableList<String> buscarPorList = FXCollections.observableArrayList("Nome", "Turma");
		 cbBusca.setItems(buscarPorList);
	 }
    
	 public void cadastrarAluno(ActionEvent event) throws Exception{
		 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
		 AlunoVO avo = new AlunoVO();
		 //TurmaVO tvo = new TurmaVO();
		 
		 try {
			 avo.setNome(tfNomeAluno.getText());
			 avo.setCpf(tfCpfAluno.getText());
			 avo.setMatricula(tfMatriculaAluno.getText());
			 avo.setEndereco(tfEnderecoAluno.getText());
			 avo.setEmail(tfEmailAluno.getText());
			 avo.setLogin(tfLoginAluno.getText());
			 avo.setSenha(tfSenhaAluno.getText());
			 avo.setTurma(cbTurmaAluno.getSelectionModel().getSelectedItem());
			 avo.getTurma().getIdTurma();

			 abo.cadastrar(avo);  //chama o BO
			 recarregarTelaGerenciarAluno();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro cadastro
		 } 	
	 }

	 public void editarAluno(ActionEvent event) throws Exception{
		 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
		 AlunoVO avo = new AlunoVO();
	     //TurmaVO tvo = new TurmaVO();
		 try {
			  AlunoVO avo2 = tvAluno.getSelectionModel().getSelectedItem();
			  avo.setNome(tfNomeAluno.getText());
			  avo.setCpf(tfCpfAluno.getText());
			  avo.setMatricula(tfMatriculaAluno.getText());
			  avo.setEndereco(tfEnderecoAluno.getText());
			  avo.setEmail(tfEmailAluno.getText());
			  avo.setLogin(tfLoginAluno.getText());
			  avo.setSenha(tfSenhaAluno.getText());
			  avo.setTurma(cbTurmaAluno.getSelectionModel().getSelectedItem());
			  avo.getTurma().getIdTurma();
			  avo.setIdUsu(avo2.getIdUsu());

			  abo.editar(avo);
			  recarregarTelaGerenciarAluno();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro edição
		 } 	
	}
	    
	 public void removerAluno(ActionEvent event) throws Exception {
		 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
		 AlunoVO avo = new AlunoVO();
		 AlunoVO avo2 = tvAluno.getSelectionModel().getSelectedItem();
		 try {
			 avo.setIdUsu(avo2.getIdUsu());

			 abo.excluir(avo);
			 recarregarTelaGerenciarAluno();

		 } catch (Exception e) {
			 e.printStackTrace();
			 //label erro remoção
		 }	
	 }
	    
	 public void pegarLinhaAluno() {
		 if(tvAluno.getSelectionModel().getSelectedItem() != null) {

			 AlunoVO avo = tvAluno.getSelectionModel().getSelectedItem();		
			 avo.getTurma();
			 avo.getIdAluno();
			 avo.getIdUsu();

			 tfNomeAluno.setText(avo.getNome());
			 tfCpfAluno.setText(avo.getCpf());
			 tfMatriculaAluno.setText(avo.getMatricula());
			 tfEnderecoAluno.setText(avo.getEndereco());
			 tfEmailAluno.setText(avo.getEmail());
			 tfLoginAluno.setText(avo.getLogin());
			 tfSenhaAluno.setText(avo.getSenha());
			 cbTurmaAluno.getSelectionModel().select(avo.getTurma());

		 } else {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText("Linha vazia!");
			 alert.setContentText("Você selecionou uma linha vazia");
			 alert.show();
			 limparCampos();
		 }    	 
	 }
	 
	 public void buscarAluno(ActionEvent event) throws Exception {
		 String str = cbBusca.getSelectionModel().getSelectedItem();
		 
		 if(str == null) {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
			 alert.setHeaderText("Tipo de Busca não selecionado");
			 alert.setContentText("Você não selecionou o tipo de busca!");
			 alert.show();
		 } else {
			 if (str.equals("Turma")) {
				 //buscar aluno pela turma
				 if (tfBuscaAluno.getText() != null && !(tfBuscaAluno.getText().equals(""))) {
					 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
					 TurmaVO tvo = new TurmaVO();
					 List<AlunoVO> alunos = new ArrayList<AlunoVO>();
					 tvo.setNome(tfBuscaAluno.getText());
					 
					 try {
						 alunos = abo.buscarAlunosPorTurma(tvo);
						 carregarTabelaBuscarAluno(alunos);

					 } catch (InsertException e) {
						 e.printStackTrace();
					 }
				 } else {
					 carregarTabelaAluno();
				 }
			 } else {
				 //buscar aluno por nome
				 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
				 AlunoVO avo = new AlunoVO();
				 List<AlunoVO> alunos = new ArrayList<AlunoVO>();
				 avo.setNome(tfBuscaAluno.getText());
				 
				 try {
					 alunos = abo.buscarPorNome(avo);
					 carregarTabelaBuscarAluno(alunos);
				 } catch (NotFoundException e) {
					 e.printStackTrace();
				 }
			 }	    		
		 }
	 }
	 
	 public void carregarTabelaBuscarAluno(List<AlunoVO> alunos) {
		 colNomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
		 colCpfAluno.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		 colMatriculaAluno.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		 colEnderecoAluno.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		 colEmailAluno.setCellValueFactory(new PropertyValueFactory<>("email"));
		 colTurmaAluno.setCellValueFactory(new Callback<CellDataFeatures<AlunoVO, String>, ObservableValue<String>>() {
			 public ObservableValue<String> call(TableColumn.CellDataFeatures<AlunoVO , String> a) {
				 return new SimpleObjectProperty<String>("" + a.getValue().getTurma().getIdTurma());
			 }
		 });
		 //colTurmaAluno.setVisible(false);
		 tvAluno.setItems(FXCollections.observableArrayList(alunos));
	 }

	 public void recarregarTelaGerenciarAluno() {
		 try {
			 Telas.telaGerenciarAluno();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public void limparCampos() {
		 tfNomeAluno.setText("");
		 tfCpfAluno.setText("");
		 tfMatriculaAluno.setText("");
		 tfEnderecoAluno.setText("");
		 tfEmailAluno.setText("");
		 tfLoginAluno.setText("");
		 tfSenhaAluno.setText("");	    
	 }
	 
	 //navegação do menu
	 public void goToGerenciarTurmas(ActionEvent event) throws Exception {
		 Telas.telaGerenciarTurmas();
	 }
	 
	 public void goToGerenciarDisciplinas(ActionEvent event) throws Exception {
		 Telas.telaGerenciarDisciplinas();
	 }

	 public void goToGerenciarPessoas(ActionEvent event) throws Exception {
		 Telas.telaGerenciarPessoas();
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

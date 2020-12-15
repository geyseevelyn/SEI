package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.pdf.TextField;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.BO.UsuarioBO;
import br.edu.ufersa.sei.model.VO.UsuarioVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BuscarDiretorController implements Initializable {

	@FXML private ComboBox<String> cbBuscaTipo;
	@FXML private TextField tfBuscaTipo;

	@FXML private TableView<UsuarioVO> tvBuscaUsuario;
	@FXML private TableColumn<UsuarioVO, String> colNome;
	@FXML private TableColumn<UsuarioVO, String> colCpf;
	@FXML private TableColumn<UsuarioVO, String> colEndereco;
	@FXML private TableColumn<UsuarioVO, String> colEmail;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarBuscarTipo();
	}

	public void carregarBuscarTipo() {
		ObservableList<String> buscarPorList = FXCollections.observableArrayList("Alunos", "Professores");
		cbBuscaTipo.setItems(buscarPorList);
	}

	public void buscarTipoUsuario(ActionEvent event) throws InsertException {
		String str = cbBuscaTipo.getSelectionModel().getSelectedItem();

		if(str == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Tipo de busca não selecionado");
			alert.setContentText("Selecione o tipo de busca!");
			alert.show();

		} else {
			if (str.equalsIgnoreCase("Alunos")) {
				UsuarioBO<UsuarioVO> usubo = new UsuarioBO<UsuarioVO>();
				List<UsuarioVO> usuariosAlunos = new ArrayList<UsuarioVO>();

				usuariosAlunos = usubo.listarUsuariosAlunos();
				carregarTabelaBuscar(usuariosAlunos);

			} else {
				if (str.equalsIgnoreCase("Professores")) {
					UsuarioBO<UsuarioVO> usubo = new UsuarioBO<UsuarioVO>();
					List<UsuarioVO> usuariosProfs = new ArrayList<UsuarioVO>();

					usuariosProfs = usubo.listarUsuariosProfs();
					carregarTabelaBuscar(usuariosProfs);
				} else {
					try {
						Telas.telaBuscarDiretor();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}	
			}
		}		
	}

	 public void carregarTabelaBuscar(List<UsuarioVO> usuList) {
		 colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		 colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		 colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		 colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		 
		 tvBuscaUsuario.setItems(FXCollections.observableArrayList(usuList));
	 }

	 public void recarregarTelaGerenciarAluno() {
		 try {
			 Telas.telaGerenciarAluno();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

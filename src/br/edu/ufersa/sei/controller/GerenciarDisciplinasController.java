package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.ProfessorBO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
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

public class GerenciarDisciplinasController implements Initializable{
	
	///Elementos da tela gerenciar disciplinas
	@FXML private TextField tfNome;
    @FXML private TextField tfCodigo;
    
    @FXML private ComboBox<ProfessorVO> cbProf;
    @FXML private TextField tfBuscaDisc;
    
    @FXML private TableView<DisciplinaVO> tvDisc;
	@FXML private TableColumn<DisciplinaVO, Long> colId;
	@FXML private TableColumn<DisciplinaVO, String> colDisc; //nome
	@FXML private TableColumn<DisciplinaVO, String> colCod;
	@FXML private TableColumn<DisciplinaVO, Boolean> colStatus;
	@FXML private TableColumn<DisciplinaVO, String> colProf;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTabelaDisc();
		carregarCBDisc();
	}
	
	public void carregarTabelaDisc() {
		List<DisciplinaVO> disc = new ArrayList<>();
		
		colId.setCellValueFactory(new PropertyValueFactory<>("idDisc"));
		colDisc.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCod.setCellValueFactory(new PropertyValueFactory<>("codDisc"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		colProf.setCellValueFactory(new Callback<CellDataFeatures<DisciplinaVO, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(TableColumn.CellDataFeatures<DisciplinaVO , String> p) {
				return new SimpleObjectProperty<String>("" + p.getValue().getProfDisc().getIdProf());
			}
		});
		
		DisciplinaBO dbo = new DisciplinaBO();
		try {
			disc = dbo.listar();
		} catch (InsertException e) {
			e.printStackTrace();
		}
		tvDisc.setItems(FXCollections.observableArrayList(disc));
	}
	
	public void carregarCBDisc() {
		ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO> ();
		try {
			cbProf.setItems(FXCollections.observableArrayList(pbo.listarBox()));
		} catch (InsertException e) {
			e.printStackTrace();
		} 
	}

	public void cadastrarDisc(ActionEvent event) throws Exception{
		DisciplinaBO dbo = new DisciplinaBO();
		DisciplinaVO dvo = new DisciplinaVO();
		//ProfessorVO pvo = new ProfessorVO();
		try {
			dvo.setNome(tfNome.getText());
			dvo.setCodigo(tfCodigo.getText());
			dvo.setProfDisc(cbProf.getSelectionModel().getSelectedItem());
			dvo.getProfDisc().getIdProf();
			//long idprof = Long.parseLong(tfIdProf.getText());
			//dvo.getProfDisc().setIdProf(idprof);
			dvo.setStatus(false);

			dbo.cadastrar(dvo);
			recarregarTelaGerenciarDisc();

		} catch (Exception e) {
			e.printStackTrace();
			//label erro cadastro
		}
	}

	public void editarDisc(ActionEvent event) throws Exception {
		DisciplinaBO dbo = new DisciplinaBO();
		DisciplinaVO dvo = new DisciplinaVO();
		//ProfessorVO pvo = new ProfessorVO();

		try {
			DisciplinaVO dvo2 = tvDisc.getSelectionModel().getSelectedItem();
			//long iddisc = Long.parseLong(tfId.getText());
			//dvo.setIdDisc(iddisc);
			dvo.setIdDisc(dvo2.getIdDisc());
			dvo.setNome(tfNome.getText());
			dvo.setCodigo(tfCodigo.getText());
			dvo.setProfDisc(cbProf.getSelectionModel().getSelectedItem());
			dvo.getProfDisc().getIdProf();
			dvo.setStatus(false);

			dbo.editar(dvo);
			recarregarTelaGerenciarDisc();

		} catch (Exception e) {
			e.printStackTrace();
			//label erro edição
		}
	}

	public void removerDisc(ActionEvent event) throws Exception {
		DisciplinaBO dbo = new DisciplinaBO();
		DisciplinaVO dvo = new DisciplinaVO();
		try {
			DisciplinaVO dvo2 = tvDisc.getSelectionModel().getSelectedItem();
			dvo.setIdDisc(dvo2.getIdDisc());

			dbo.excluir(dvo);
			recarregarTelaGerenciarDisc();

		} catch (Exception e) {
			e.printStackTrace();
			//erro label remoção
		}
	}
	
	 public void pegarLinhaDisc() throws InsertException {
		 DisciplinaVO disc = tvDisc.getSelectionModel().getSelectedItem();
		 disc.getProfDisc();
		 disc.getIdDisc();
		 tfNome.setText(disc.getNome());
		 tfCodigo.setText(disc.getCodDisc());
		 cbProf.getSelectionModel().select(disc.getProfDisc());
	 }
    
    public void recarregarTelaGerenciarDisc() {
    	try {
    		Telas.telaGerenciarDisciplinas();
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

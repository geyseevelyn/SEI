package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.ProfessorBO;
import br.edu.ufersa.sei.model.DAO.AlunoDAO;
import br.edu.ufersa.sei.model.DAO.DisciplinaDAO;
import br.edu.ufersa.sei.model.DAO.UsuarioInterDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class DiretorController implements Initializable {		 
	
    public void goToTurmasDir(ActionEvent event) throws Exception {
    	Telas.telaGerenciarTurmasDiretor();
    }
	
    public void goToDiscDir(ActionEvent event) throws Exception {
    	Telas.telaGerenciarDiscDiretor();
    }
	
    public void goToPessoasDir(ActionEvent event) throws Exception {
    	Telas.telaGerenciarPessoaDiretor();
    }
    
    public void goToGenrenciarAluno(ActionEvent event) throws Exception {
    	Telas.telaGerenciarAlunoDiretor();
    }
    
    public void goToGerenciarProf(ActionEvent event) throws Exception {
    	Telas.telaGerenciarProfDiretor(); 
    }
    
    public void goToBuscarDir(ActionEvent event) throws Exception {
    	Telas.telaBuscarDiretor();
    }

	public void voltar(ActionEvent event) throws Exception{
		Telas.telaPrincipalDiretor();
	}
	
	public void sair(ActionEvent event) throws Exception{
		Telas.telaLogin();
	}
	
	@FXML private TextField tfId;
	
	@FXML private TextField tfNome;

    @FXML private TextField tfCodigo;

    //@FXML private TextField tfIdProf;
    
    @FXML private ComboBox<ProfessorVO> cbProf;
    
    @FXML private TableView<DisciplinaVO> tvDisc;

	@FXML private TableColumn<DisciplinaVO, Long> colId;

	@FXML private TableColumn<DisciplinaVO, String> colDisc;

	@FXML private TableColumn<DisciplinaVO, String> colCod;
	
	@FXML private TableColumn<DisciplinaVO, Boolean> colStatus;
	
	@FXML private TableColumn<DisciplinaVO, String> colProf;

    @FXML
    void cadastrarDisc(ActionEvent event) {
    	DisciplinaBO dbo = new DisciplinaBO();
    	DisciplinaVO dvo = new DisciplinaVO();
    	ProfessorVO pvo = new ProfessorVO();
    	try {
    		dvo.setNome(tfNome.getText());
    		dvo.setCodigo(tfCodigo.getText());
    		dvo.setProfDisc(cbProf.getSelectionModel().getSelectedItem());
    		dvo.getProfDisc().getIdProf();
//    		long idprof = Long.parseLong(tfIdProf.getText());
//    		dvo.getProfDisc().setIdProf(idprof);
    		dvo.setStatus(false);
			dbo.cadastrar(dvo);
			
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void editarDisc(ActionEvent event) {
    	DisciplinaBO dbo = new DisciplinaBO();
    	DisciplinaVO dvo = new DisciplinaVO();
    	ProfessorVO pvo = new ProfessorVO();
    	try {
    		long iddisc = Long.parseLong(tfId.getText());
    		dvo.setIdDisc(iddisc);
    		dvo.setNome(tfNome.getText());
    		dvo.setCodigo(tfCodigo.getText());
    		dvo.setProfDisc(cbProf.getSelectionModel().getSelectedItem());
    		dvo.getProfDisc().getIdProf();
    		dvo.setStatus(false);
			dbo.editar(dvo);
			
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void removerDisc(ActionEvent event) {
    	DisciplinaBO dbo = new DisciplinaBO();
    	DisciplinaVO dvo = new DisciplinaVO();
    	ProfessorVO pvo = new ProfessorVO();
    	try {
    		long iddisc = Long.parseLong(tfId.getText());
    		dvo.setIdDisc(iddisc);
    		dbo.excluir(dvo);
			
		} catch (InsertException e) {
			e.printStackTrace();
		}
    }
	 
	 public void carregarTabelaDisc() throws InsertException {
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
	    	disc = dbo.listar();
	    	//System.out.println(disc);
	    	tvDisc.setItems(FXCollections.observableArrayList(disc));
	    	
	    }
	 
	 public void carregarCBDisc () throws InsertException {
		 ProfessorBO<ProfessorVO> pbo = new ProfessorBO<ProfessorVO> ();
		try {
			cbProf.setItems(FXCollections.observableArrayList(pbo.listarBox()));
		} catch (InsertException e) {
			e.printStackTrace();
		} 
	 }
	 
	 @FXML
	 public void pegarLinhaDisc() throws InsertException {
		 DisciplinaVO disc = tvDisc.getSelectionModel().getSelectedItem();
		 ProfessorVO prof = new ProfessorVO();
		 disc.getProfDisc();
		 //disc.setProfDisc(prof);
		 String iddisc = Long.toString(disc.getIdDisc());
		 tfId.setText(iddisc);
		 tfNome.setText(disc.getNome());
		 tfCodigo.setText(disc.getCodDisc());
		 //String idprof = Long.toString(disc.getProfDisc().getIdProf());
		 //cbProf.set
//		 dvo.setProfDisc(cbProf.getSelectionModel().getSelectedItem());
		 cbProf.getSelectionModel().select(disc.getProfDisc());
		 //System.out.println(disc.getProfDisc());
 		 //cbProf.setItems((ObservableList<ProfessorVO>) prof);
// 		 long idprof = Long.parseLong(tfIdProf.getText());
// 		 dvo.getProfDisc().setIdProf(idprof);
	 }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}

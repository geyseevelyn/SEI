package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.AlunoBO;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.ProfessorBO;
import br.edu.ufersa.sei.model.BO.TurmaBO;
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
	
	//Disciplina
	//@FXML private TextField tfId;
	
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
    public void cadastrarDisc(ActionEvent event) {
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
			Telas.telaGerenciarDiscDiretor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void editarDisc(ActionEvent event) {
    	DisciplinaBO dbo = new DisciplinaBO();
    	DisciplinaVO dvo = new DisciplinaVO();
    	ProfessorVO pvo = new ProfessorVO();
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
			Telas.telaGerenciarDiscDiretor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    public void removerDisc(ActionEvent event) {
    	DisciplinaBO dbo = new DisciplinaBO();
    	DisciplinaVO dvo = new DisciplinaVO();
    	ProfessorVO pvo = new ProfessorVO();
    	try {
    		//long iddisc = Long.parseLong(tfId.getText());
    		DisciplinaVO dvo2 = tvDisc.getSelectionModel().getSelectedItem();
    		dvo.setIdDisc(dvo2.getIdDisc());
    		dbo.excluir(dvo);
    		Telas.telaGerenciarDiscDiretor();
			
		} catch (Exception e) {
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
		 disc.getProfDisc();
		 //disc.setProfDisc(prof);
		 disc.getIdDisc();
		 //String iddisc = Long.toString(disc.getIdDisc());
		 //tfId.setText(iddisc);
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
    
	 //Aluno
	 @FXML private TextField tfNomeAluno;

	 @FXML private TextField tfCpfAluno;

	 @FXML private TextField tfMatriculaAluno;

	 @FXML private TextField tfEmailAluno;
	 
	 @FXML private TextField tfEnderecoAluno;

	 @FXML private TextField tfLoginAluno;

	 @FXML private TextField tfSenhaAluno;
	 
	 @FXML private TextField tfBuscaAluno;

	 //@FXML private TextField tfTurmaAluno;
	 
	 @FXML private ComboBox<TurmaVO> cbTurmaAluno;

	 @FXML private TableView<AlunoVO> tvAluno;

	 @FXML private TableColumn<AlunoVO, String> colNomeAluno;

	 @FXML private TableColumn<AlunoVO, String> colCpfAluno;

	 @FXML private TableColumn<AlunoVO, String> colMatriculaAluno;

	 @FXML private TableColumn<AlunoVO, String> colEmailAluno;

	 @FXML private TableColumn<AlunoVO, String> colEnderecoAluno;

	 @FXML private TableColumn<AlunoVO, String> colTurmaAluno;

	 

	 @FXML
	 public void cadastrarAluno(ActionEvent event) {
		 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
    	 AlunoVO avo = new AlunoVO();
    	 TurmaVO tvo = new TurmaVO();
	    	try {
	    		avo.setNome(tfNomeAluno.getText());
	    		avo.setCpf(tfCpfAluno.getText());
	    		avo.setMatricula(tfMatriculaAluno.getText());
	    		avo.setEndereco(tfEnderecoAluno.getText());
	    		avo.setEmail(tfEmailAluno.getText());
	    		avo.setLogin(tfLoginAluno.getText());
	    		avo.setSenha(tfSenhaAluno.getText());
	    		//avo.setTurma(tvo);
	    		//long idturma = Long.parseLong(tfTurmaAluno.getText());
	    		avo.setTurma(cbTurmaAluno.getSelectionModel().getSelectedItem());
	    		avo.getTurma().getIdTurma();
	    		abo.cadastrar(avo);
	    		
	    		Telas.telaGerenciarAlunoDiretor();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 	
	    }

	    @FXML
	    public void editarAluno(ActionEvent event) {
	    	 AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
	    	 AlunoVO avo = new AlunoVO();
	    	 TurmaVO tvo = new TurmaVO();
		    	try {
//		    		long idaluno = Long.parseLong(tfId.getText());
//		    		avo.setIdAluno(iddisc);
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
		    		
		    		Telas.telaGerenciarAlunoDiretor();
					
				} catch (Exception e) {
					e.printStackTrace();
				} 	
	    }
	    
	    @FXML
	    public void removerAluno(ActionEvent event) {
	    	AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
	    	AlunoVO avo = new AlunoVO();
	    	AlunoVO avo2 = tvAluno.getSelectionModel().getSelectedItem();
	    	try {
				avo.setIdUsu(avo2.getIdUsu());
				abo.editar(avo);
	    		Telas.telaGerenciarAlunoDiretor();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		

	    }
	    
	    public void carregarTabelaAluno() throws InsertException {
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
	    	alunos = abo.listar();
	    	//System.out.println(disc);
	    	tvAluno.setItems(FXCollections.observableArrayList(alunos));
	    	
	    }
	    
	    public void pegarLinhaAluno() throws InsertException {
	    	 AlunoVO avo = tvAluno.getSelectionModel().getSelectedItem();
			 avo.getTurma();
			 avo.getIdAluno();
			 avo.getIdUsu();
			 //String iddisc = Long.toString(disc.getIdDisc());
			 //tfId.setText(iddisc);
			 tfNomeAluno.setText(avo.getNome());
			 tfCpfAluno.setText(avo.getCpf());
			 tfMatriculaAluno.setText(avo.getMatricula());
			 tfEnderecoAluno.setText(avo.getEndereco());
			 tfEmailAluno.setText(avo.getEmail());
			 tfLoginAluno.setText(avo.getLogin());
			 tfSenhaAluno.setText(avo.getLogin());
			 //tfTurmaAluno.setText(""+avo.getTurma().getIdTurma());
			 cbTurmaAluno.getSelectionModel().select(avo.getTurma());
			 //String idprof = Long.toString(disc.getProfDisc().getIdProf());
			 //cbProf.set
//			 dvo.setProfDisc(cbProf.getSelectionModel().getSelectedItem());
			 //cbProf.getSelectionModel().select(disc.getProfDisc());
			 //System.out.println(disc.getProfDisc());
	 		 //cbProf.setItems((ObservableList<ProfessorVO>) prof);
//	 		 long idprof = Long.parseLong(tfIdProf.getText());
//	 		 dvo.getProfDisc().setIdProf(idprof);
		 }
	    
	    public void carregarCBAluno() throws InsertException {
			 TurmaBO tbo = new TurmaBO ();
			try {
				cbTurmaAluno.setItems(FXCollections.observableArrayList(tbo.listar()));//Listar alternativa??
			} catch (InsertException e) {
				e.printStackTrace();
			} 
		 }
	    
	    public void buscarAluno() throws InsertException {
	    	if (tfBuscaAluno.getText() != null && !(tfBuscaAluno.getText().equals(""))) {
		    	AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
		    	TurmaVO tvo = new TurmaVO();
		    	List<AlunoVO> alunos = new ArrayList<AlunoVO>();
		    	tvo.setNome(tfBuscaAluno.getText());
		    	try {
					alunos = abo.buscarAlunosPorTurma(tvo);
					//System.out.println(abo.buscarAlunosPorTurma(tvo));
					carregarTabelaBuscarAluno(alunos);
					
				} catch (InsertException e) {
					e.printStackTrace();
				}
	    	} else {
	    		colTurmaAluno.setVisible(true);
	    		carregarTabelaAluno();
	    	}
	    		
	    }
	    
	    public void carregarTabelaBuscarAluno(List<AlunoVO> alunos) throws InsertException {
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
	    	colTurmaAluno.setVisible(false);
	    	tvAluno.setItems(FXCollections.observableArrayList(alunos));
	    	//System.out.println(alunos);
	    }
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}

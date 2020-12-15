package br.edu.ufersa.sei.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.AlunoBO;
import br.edu.ufersa.sei.model.BO.TurmaBO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PrincipalAlunoController implements Initializable {

	//Componentes da Tela Principal Aluno
	@FXML private Label matricula;
	@FXML private Label cpf;
	@FXML private Label nome;
	@FXML private Label turno;
	@FXML private Label turma;
	@FXML private Label email;
	@FXML private Label endereco;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarPerfilAluno();
	}
	
	public void carregarPerfilAluno() {
		TurmaBO tbo = new TurmaBO();
		TurmaVO tvo = new TurmaVO();
		AlunoBO<AlunoVO> abo = new AlunoBO<AlunoVO>();
		AlunoVO avo = Telas.getUserAlu();		
		matricula.setText(avo.getMatricula());
		nome.setText(avo.getNome());
		cpf.setText(avo.getCpf());
		endereco.setText(avo.getEndereco());
		email.setText(avo.getEmail());
		try {
			tvo = tbo.buscarPorId(avo.getTurma().getIdTurma());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		turma.setText("" + tvo.getNome());
		turno.setText(tvo.getHorario());
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

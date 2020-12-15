package br.edu.ufersa.sei.view;

import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.ProfessorVO;
import br.edu.ufersa.sei.model.VO.TurmaVO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	
	private static Stage primaryStage;
	private static AlunoVO userAlu;
	private static AlunoVO alu;
	private static ProfessorVO prof;
	private static ProfessorVO userProf;
	private static TurmaVO turma;

	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static ProfessorVO getUserProf() {
		return userProf;
	}

	public static void setUserProf(ProfessorVO userProf) {
		Telas.userProf = userProf;
	}

	public static AlunoVO getAlu() {
		return alu;
	}

	public static void setAlu(AlunoVO alu) {
		Telas.alu = alu;
	}

	public static TurmaVO getTurma() {
		return turma;
	}

	public static void setTurma(TurmaVO turma) {
		Telas.turma = turma;
	}

	public static ProfessorVO getProf() {
		return prof;
	}

	public static void setProf(ProfessorVO prof) {
		Telas.prof = prof;
	}

	public static AlunoVO getUserAlu() {
		return userAlu;
	}

	public static void setUserAlu(AlunoVO userAlu) {
		Telas.userAlu = userAlu;
	}
	
	public void start(Stage primaryStage) throws Exception {		
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		primaryStage.show();
		primaryStage.setResizable(false);
		telaLogin();
	}
	
	//LOGIN
	public static void telaLogin() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//DIRETOR
	public static void telaPrincipalDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarTurmas() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarTurmas.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarDisciplinas() throws Exception {	
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/telaGerenciarDisciplinas.fxml"));
		Parent root = loader.load();
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarPessoas() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarPessoas.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarAluno() throws Exception {	
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/telaGerenciarAluno.fxml"));
		Parent root = loader.load();
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarProf() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarProfTurmas() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarProfTurmas.fxml"));
		Scene cena = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(cena);
		secondaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		secondaryStage.setResizable(false);
		secondaryStage.show();
	}
	
	public static void telaGerenciarTurmaDisc() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarTurmaDisc.fxml"));
		Scene cena = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(cena);
		secondaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		secondaryStage.setResizable(false);
		secondaryStage.show();
	}
	
	public static void telaBuscarDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaBuscarDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//PROFESSOR
	public static void telaPrincipalProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	public static void telaTurmasProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaTurmasProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	public static void telaNotaProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaNotaProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	public static void telaCadastrarNota() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastrarNota.fxml"));
		Scene cena = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(cena);
		secondaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		secondaryStage.setResizable(false);
		secondaryStage.show();
	};
	
	//ALUNO
	public static void telaPrincipalAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
	}
	
	public static void telaDisciplinasAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDisciplinasAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaNotasAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaNotasAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaBoletim() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaBoletim.fxml"));
		Scene cena = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(cena);
		secondaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		secondaryStage.setResizable(false);
		secondaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch();
	}

}

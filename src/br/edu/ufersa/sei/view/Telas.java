package br.edu.ufersa.sei.view;

import br.edu.ufersa.sei.model.VO.UsuarioVO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	
	private static Stage primaryStage;
	private static UsuarioVO user; //??
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static UsuarioVO getUser() {
		return user;
	}

	public static void setUser(UsuarioVO user) {
		Telas.user = user;
	}
	
	public void start(Stage primaryStage) throws Exception {		
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		primaryStage.show();
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
		//GerenciarDisciplinasController gdc = loader.getController();
		//gdc.carregarTabelaDisc();
		//gdc.carregarCBDisc();
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
		//GerenciarAlunoController gc = loader.getController();
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		//gc.carregarTabelaAluno();
		//gc.carregarCBAluno();
		//gc.carregarBuscarPor();
	}
	
	public static void telaGerenciarProfDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarProfDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
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
	
	//ALUNO
	public static void telaPrincipalAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaDisciplinasAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDisciplinaAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaNotasAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaNotasAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void main(String[] args) {
		launch();
	}
}

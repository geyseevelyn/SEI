package br.edu.ufersa.sei.view;

import br.edu.ufersa.sei.controller.DiretorController;
import br.edu.ufersa.sei.model.VO.UsuarioVO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	
	private static UsuarioVO user;
	
	public static UsuarioVO getUser() {
		return user;
	}

	public static void setUser(UsuarioVO user) {
		Telas.user = user;
	}
	
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public void start(Stage primaryStage) throws Exception {		
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		primaryStage.show();
		telaLogin();
	}
	
	//Login principal
	public static void telaLogin() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//ALUNO

	public static void telaPrincipalAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaDisciplinaAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaDisciplinaAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaNotaluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaNotaAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}

	//PROFESSOR
	public static void telaPrincipalProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	public static void telaNotaProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaNotaProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	public static void telaTurmaProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaTurmaProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	//DIRETOR
	public static void telaPrincipalDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarTurmasDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarTurmasDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarDiscDiretor() throws Exception {	
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/telaGerenciarDiscDiretor.fxml"));
		Parent root = loader.load();
		DiretorController dc = loader.getController();
		dc.carregarTabelaDisc();
		dc.carregarCBDisc ();
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		
	}
	
	public static void telaGerenciarPessoaDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarPessoaDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaGerenciarAlunoDiretor() throws Exception {	
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/telaGerenciarAlunoDiretor.fxml"));
		Parent root = loader.load();
		DiretorController dc = loader.getController();
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		dc.carregarTabelaAluno();
		dc.carregarCBAluno();
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
	
	public static void main(String[] args) {
		launch();
	}
}

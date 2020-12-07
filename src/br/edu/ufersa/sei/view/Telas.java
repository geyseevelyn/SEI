package br.edu.ufersa.sei.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
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
	
	public static void telaLoginAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLoginAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaLoginDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLoginDiretor.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	public static void telaLoginprof() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLoginProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Principal Aluno
	public static void telaPrincipalAluno() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Principal Diretor
	public static void telaPrincipalDiretor() throws Exception {	
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAluno.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	
	//Principal Professor
	public static void telaPrincipalProf() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalProf.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	};
	
	public static void main(String[] args) {
		launch();
	}
}

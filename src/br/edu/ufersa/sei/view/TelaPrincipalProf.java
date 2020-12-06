package br.edu.ufersa.sei.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaPrincipalProf extends Application {
	
	public static void main(String [] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("VE/telaPrincipalProf.fxml"));
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("SEI - Sistema de Ensino Integrado");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
}

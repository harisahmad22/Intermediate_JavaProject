package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SetupTesterGUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		
		try {
			VBox root = loader.load(new FileInputStream("view/SetupView.fxml"));
			primaryStage.setScene(new Scene(root, 600, 475));
		} catch (FileNotFoundException e) {
			System.out.println("Can't open the FXML file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading FXML file");
			e.printStackTrace();
		}
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
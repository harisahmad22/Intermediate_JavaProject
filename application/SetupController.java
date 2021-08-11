package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SetupController {

    @FXML
    private Button buttonDifferentiate;

    @FXML
    private Button buttonRoots;

    @FXML
    private Button buttonEvaluate;

    @FXML
    private Button buttonQuit;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button buttonAdd;

    @FXML
    void evaluate(ActionEvent event){
    	FXMLLoader loader = new FXMLLoader();
		
		try {
			Stage stage = (Stage) buttonQuit.getScene().getWindow();
	    	stage.close();
			
			VBox root = loader.load(new FileInputStream("src/view/EvaluateView.fxml"));
			Stage EvaluateStage = new Stage();
			EvaluateStage.setScene(new Scene(root, 500, 475));
			EvaluateStage.show();

		} catch (FileNotFoundException e) {
			System.out.println("Can't open the FXML file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading FXML file");
			e.printStackTrace();
		}
    }

    @FXML
    void differentiate(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();

    	try {
    		Stage stage = (Stage) buttonQuit.getScene().getWindow();
    		stage.close();

    		VBox root = loader.load(new FileInputStream("src/view/DifferentiateView.fxml"));
    		Stage EvaluateStage = new Stage();
    		EvaluateStage.setScene(new Scene(root, 500, 475));
    		EvaluateStage.show();

    	} catch (FileNotFoundException e) {
    		System.out.println("Can't open the FXML file");
    		e.printStackTrace();
    	} catch (IOException e) {
    		System.out.println("Problem reading FXML file");
    		e.printStackTrace();
    	}
    }

    @FXML
    void add(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();

    	try {
    		Stage stage = (Stage) buttonQuit.getScene().getWindow();
    		stage.close();

    		VBox root = loader.load(new FileInputStream("src/view/AddView.fxml"));
    		Stage EvaluateStage = new Stage();
    		EvaluateStage.setScene(new Scene(root, 500, 475));
    		EvaluateStage.show();

    	} catch (FileNotFoundException e) {
    		System.out.println("Can't open the FXML file");
    		e.printStackTrace();
    	} catch (IOException e) {
    		System.out.println("Problem reading FXML file");
    		e.printStackTrace();
    	}
    }

    @FXML
    void multiply(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();

    	try {
    		Stage stage = (Stage) buttonQuit.getScene().getWindow();
    		stage.close();

    		VBox root = loader.load(new FileInputStream("src/view/MultiplyView.fxml"));
    		Stage EvaluateStage = new Stage();
    		EvaluateStage.setScene(new Scene(root, 500, 475));
    		EvaluateStage.show();

    	} catch (FileNotFoundException e) {
    		System.out.println("Can't open the FXML file");
    		e.printStackTrace();
    	} catch (IOException e) {
    		System.out.println("Problem reading FXML file");
    		e.printStackTrace();
    	}
    }

    @FXML
    void roots(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();

    	try {
    		Stage stage = (Stage) buttonQuit.getScene().getWindow();
    		stage.close();

    		VBox root = loader.load(new FileInputStream("src/view/RootsView.fxml"));
    		Stage EvaluateStage = new Stage();
    		EvaluateStage.setScene(new Scene(root, 500, 475));
    		EvaluateStage.show();

    	} catch (FileNotFoundException e) {
    		System.out.println("Can't open the FXML file");
    		e.printStackTrace();
    	} catch (IOException e) {
    		System.out.println("Problem reading FXML file");
    		e.printStackTrace();
    	}
    }

    @FXML
    void quit(ActionEvent event) {
    	Stage stage = (Stage) buttonQuit.getScene().getWindow();
    	stage.close();
    }

}

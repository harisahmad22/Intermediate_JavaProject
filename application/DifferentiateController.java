package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DifferentiateController {

    @FXML
    private TextArea userInput;

    @FXML
    private Label differentiateLayout;
    
    @FXML
    private Button buttonSubmit;

    @FXML
    private Button buttonClear;
    
    @FXML
    private Button buttonBack;

    @FXML
    void submit(ActionEvent event) {

    }

    @FXML
    void clear(ActionEvent event) {
    	userInput.clear();
    }
    
    @FXML
    void back(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		
		try {
			Stage stage = (Stage) buttonBack.getScene().getWindow();
	    	stage.close();
			
			VBox root = loader.load(new FileInputStream("src/view/SetupView.fxml"));
			Stage EvaluateStage = new Stage();
			EvaluateStage.setScene(new Scene(root, 600, 475));
			EvaluateStage.show();

		} catch (FileNotFoundException e) {
			System.out.println("Can't open the FXML file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading FXML file");
			e.printStackTrace();
		}
    }

}

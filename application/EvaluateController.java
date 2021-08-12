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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BasicCalculations;
import model.EssentialCalculations;

public class EvaluateController {

    @FXML
    private TextArea userInput1;

    @FXML
    private TextField userInput2;
    
    @FXML
    private Label polynomialLayout;
    
    @FXML
    private Label evaluateLayout;
    
    @FXML
    private Button buttonSubmit;

    @FXML
    private Button buttonClear;
    
    @FXML
    private Button buttonBack;

    private int poly1Value = 0;
    
    private EssentialCalculations essentials = new EssentialCalculations();
    
    
    @FXML
    void submit(ActionEvent event) {
    	int[] poly1 = new int[BasicCalculations.MAX_SIZE];
    	int x;
    	
    	// obtaining the user input and putting the input into an array split by a new line and a blank space
    	String polynomialValue = userInput1.getText();    	
    	String[] inputs = polynomialValue.split(" |\\\n");
    	int[] numberInputs = new int[inputs.length];
    	for (int index = 0; index < inputs.length; index++) 
    	{
    		numberInputs[index] = Integer.parseInt(inputs[index]);
    	}
    	
    	
    	// creating an array just for the coefficients(only the even number values)
		int[] coefficients = new int [(numberInputs.length)];
		for (int index = 0; index < inputs.length; index++) {
			if (index % 2 == 0) {
					coefficients[index] = numberInputs[index];
				}
			}
		
		// creating a new coefficient array without the 0 values that were obtained from the exponents
		// in the array
    	int targetIndex = 0;
    	for( int sourceIndex = 0;  sourceIndex < coefficients.length;  sourceIndex++ )
    	{
    	    if( coefficients[sourceIndex] != 0 )
    	        coefficients[targetIndex++] = coefficients[sourceIndex];
    	}
    	int[] newCoefficientsArray = new int[targetIndex];
    	System.arraycopy( coefficients, 0, newCoefficientsArray, 0, targetIndex );
    	
    	
    	
    	
    	// creating an array just for the exponents(only the odd number values)
    	int[] exponents = new int [(numberInputs.length)];
    	for (int index2 = 0; index2 < inputs.length; index2++) {
    		if (index2 % 2 == 1) {
    			exponents[index2] = numberInputs[index2];
    		}
    	}
    	
		// creating a new exponent array without the 0 values that were obtained from the coefficients
    	// in the array
    	targetIndex = 0;
    	for( int sourceIndex = 0;  sourceIndex < exponents.length;  sourceIndex++ )
    	{
    	    if( exponents[sourceIndex] != 0 )
    	        exponents[targetIndex++] = exponents[sourceIndex];
    	}
    	int[] newExponentsArray = new int[targetIndex];
    	System.arraycopy( exponents, 0, newExponentsArray, 0, targetIndex );
    	
    	
    	

    	// making sure the value entered for the unknown is valid
    	String xValue = userInput2.getText();
    	String numbersOnlyX = xValue.replaceAll("[^0-9]", "");
    	if (numbersOnlyX == "") {
    		x = 0;
    	}
    	else {
    		x = Integer.parseInt(numbersOnlyX);
    	}
    	
    	
    	int coefficient = 0;
    	int exponent = 0;
    	int index = 0;

    	// placing the coefficients and exponents into the polynomial array
    	while (index < newExponentsArray.length) {
    		coefficient = newCoefficientsArray[index];
    		exponent = newExponentsArray[index];

    		poly1[exponent] = coefficient;

    		index++;
    	}
    	
    	// multiply the array at every index value by the power of the unknown and adding it
    	for (int index2 = (BasicCalculations.MAX_SIZE - 1); index2 >= 0; index2--) {
			essentials.setStorage(essentials.getStorage() + poly1[index2] * Math.pow(x, index2));
			poly1Value = (int)essentials.getStorage();
		}	
    	
    	// putting the value of the evaluated polynomial into a string and setting the Label to that value;
    	String stringPoly1Value = Integer.toString(poly1Value);
    	evaluateLayout.setText(stringPoly1Value);
    	
    	String stringPoly1Format = null;
    	
    	// the calculation for displaying the polynomial layout
    	int max_exponent = -1; 
		for (int index3 = (BasicCalculations.MAX_SIZE - 1); index3 >= 0; index3--) { 
		        if (poly1[index3] != 0)
		        {
		            if (max_exponent < index3)
		            {
		                if (poly1[index3] == -1)
		                {
		                    max_exponent = index3;
		                    System.out.print("-");
		                }
		                else if (poly1[index3] == 1)
		                {
		                    max_exponent = index3;
		                }
		                else
		                {
		                    max_exponent = index3;
		                    stringPoly1Format = Integer.toString(poly1[max_exponent]);
		                }
		            }
		            else if (poly1[index3] == 1)
		            {
		            	stringPoly1Format = stringPoly1Format + (" + ");
		            }
		            else if (poly1[index3] == -1)
		            {
		            	stringPoly1Format = stringPoly1Format + (" - ");
		            }
		            else if (poly1[index3] > 0)
		            {
		            	stringPoly1Format = stringPoly1Format + (" + " + poly1[index3]);
		            }
		            else if (poly1[index3] < 0)
		            {
		            	stringPoly1Format = stringPoly1Format + (" - " + (poly1[index3] * -1));
		            }
		            if (index3 > 1 && index3 < 21)
		            {
		            	stringPoly1Format = stringPoly1Format + ("x^" + index3);
		            }
		            if (index3 == 1)
		            {
		            	stringPoly1Format = stringPoly1Format + ("x");
		            }
		            if (index3 == 0 && poly1[index3] == (-1))
		            {
		            	stringPoly1Format = Integer.toString(poly1[index3] * -1);
		            }
		            if (index3 == 0 && poly1[index3] == 1)
		            {
		            	stringPoly1Format = Integer.toString(poly1[index3]);
		            }
		        }
		        else if (max_exponent < index3 && index3 == 0)
		        {
		        	stringPoly1Format = "0";
		        }
		    }
		
		// setting the text for the label to show the polynomial layout
		polynomialLayout.setText(stringPoly1Format);
    }

    @FXML
    void clear(ActionEvent event) {
    	userInput1.clear();
    	userInput2.clear();
    }
    
    @FXML
    void back(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		
		try {
			Stage stage = (Stage) buttonBack.getScene().getWindow();
	    	stage.close();
			
			VBox root = loader.load(new FileInputStream("view/SetupView.fxml"));
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

	public int getPoly1Value() {
		return poly1Value;
	}

	public void setPoly1Value(int poly1Value) {
		this.poly1Value = poly1Value;
	}
}

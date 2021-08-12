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
import model.BasicCalculations;
import model.EssentialCalculations;

public class DifferentiateController {

    @FXML
    private TextArea userInput;

    @FXML
    private Label polynomialLayout;
    
    @FXML
    private Label differentiateLayout;
    
    @FXML
    private Button buttonSubmit;

    @FXML
    private Button buttonClear;
    
    @FXML
    private Button buttonBack;

    private EssentialCalculations essentials = new EssentialCalculations();
    
    /**
     * This method is responsible for displaying the inputed polynomial in the proper format to the user
     * and it also outputs the differentiated polynomial to the user in the proper format as well.
     * @param event
     */
    @FXML
    void submit(ActionEvent event) {
    	int[] poly1 = new int[BasicCalculations.MAX_SIZE];
    	int[] diffPoly = new int[BasicCalculations.MAX_SIZE];
    	
    	// obtaining the user input and putting the input into an array split by a new line and a blank space
    	String polynomialValue = userInput.getText();    	
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
    	
    	// the calculation for deriving the differentiated polynomial
    	for (int index2 = (BasicCalculations.MAX_SIZE - 1); index2 >= 0; index2--) {
			essentials.setBring_down((poly1[index2] * index2));
			
			if (index2 > 0) {
			essentials.setNew_exponent((index2 - 1));
			diffPoly[essentials.getNew_exponent()] = essentials.getBring_down();
			}
		}    	
  
    	
    	String stringDiffPolyFormat = null;
    	
    	// the calculation for displaying the polynomial layout
    	int max_exponent = -1; 
		for (int index3 = (BasicCalculations.MAX_SIZE - 1); index3 >= 0; index3--) { 
		        if (diffPoly[index3] != 0)
		        {
		            if (max_exponent < index3)
		            {
		                if (diffPoly[index3] == -1)
		                {
		                    max_exponent = index3;
		                    System.out.print("-");
		                }
		                else if (diffPoly[index3] == 1)
		                {
		                    max_exponent = index3;
		                }
		                else
		                {
		                    max_exponent = index3;
		                    stringDiffPolyFormat = Integer.toString(diffPoly[max_exponent]);
		                }
		            }
		            else if (diffPoly[index3] == 1)
		            {
		            	stringDiffPolyFormat = stringDiffPolyFormat + (" + ");
		            }
		            else if (diffPoly[index3] == -1)
		            {
		            	stringDiffPolyFormat = stringDiffPolyFormat + (" - ");
		            }
		            else if (diffPoly[index3] > 0)
		            {
		            	stringDiffPolyFormat = stringDiffPolyFormat + (" + " + diffPoly[index3]);
		            }
		            else if (diffPoly[index3] < 0)
		            {
		            	stringDiffPolyFormat = stringDiffPolyFormat + (" - " + (diffPoly[index3] * -1));
		            }
		            if (index3 > 1 && index3 < 21)
		            {
		            	stringDiffPolyFormat = stringDiffPolyFormat + ("x^" + index3);
		            }
		            if (index3 == 1)
		            {
		            	stringDiffPolyFormat = stringDiffPolyFormat + ("x");
		            }
		            if (index3 == 0 && diffPoly[index3] == (-1))
		            {
		            	stringDiffPolyFormat = Integer.toString(diffPoly[index3] * -1);
		            }
		            if (index3 == 0 && diffPoly[index3] == 1)
		            {
		            	stringDiffPolyFormat = Integer.toString(diffPoly[index3]);
		            }
		        }
		        else if (max_exponent < index3 && index3 == 0)
		        {
		        	stringDiffPolyFormat = "0";
		        }
		    }	
  
		
    	String stringPoly1Format = null;
    	
    	// the calculation for displaying the polynomial layout
    	int max_exponent2 = -1; 
		for (int index4 = (BasicCalculations.MAX_SIZE - 1); index4 >= 0; index4--) { 
		        if (poly1[index4] != 0)
		        {
		            if (max_exponent2 < index4)
		            {
		                if (poly1[index4] == -1)
		                {
		                    max_exponent2 = index4;
		                    System.out.print("-");
		                }
		                else if (poly1[index4] == 1)
		                {
		                    max_exponent2 = index4;
		                }
		                else
		                {
		                    max_exponent2 = index4;
		                    stringPoly1Format = Integer.toString(poly1[max_exponent2]);
		                }
		            }
		            else if (poly1[index4] == 1)
		            {
		            	stringPoly1Format = stringPoly1Format + (" + ");
		            }
		            else if (poly1[index4] == -1)
		            {
		            	stringPoly1Format = stringPoly1Format + (" - ");
		            }
		            else if (poly1[index4] > 0)
		            {
		            	stringPoly1Format = stringPoly1Format + (" + " + poly1[index4]);
		            }
		            else if (poly1[index4] < 0)
		            {
		            	stringPoly1Format = stringPoly1Format + (" - " + (poly1[index4] * -1));
		            }
		            if (index4 > 1 && index4 < 21)
		            {
		            	stringPoly1Format = stringPoly1Format + ("x^" + index4);
		            }
		            if (index4 == 1)
		            {
		            	stringPoly1Format = stringPoly1Format + ("x");
		            }
		            if (index4 == 0 && poly1[index4] == (-1))
		            {
		            	stringPoly1Format = Integer.toString(poly1[index4] * -1);
		            }
		            if (index4 == 0 && poly1[index4] == 1)
		            {
		            	stringPoly1Format = Integer.toString(poly1[index4]);
		            }
		        }
		        else if (max_exponent2 < index4 && index4 == 0)
		        {
		        	stringPoly1Format = "0";
		        }
		    }
		
		// setting the text for the label to show the differentiated polynomial layout
		differentiateLayout.setText(stringDiffPolyFormat);
		
		// setting the text for the label to show the inputed polynomial layout
		polynomialLayout.setText(stringPoly1Format);
    }

    /**
     * This method clears all user input in the textArea
     * @param event
     */
    @FXML
    void clear(ActionEvent event) {
    	userInput.clear();
    }
    
    /**
     * This method closes the current window and takes the user back to the setupView screen (menu screen)
     * @param event
     */
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

}

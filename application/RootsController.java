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

public class RootsController {

    @FXML
    private Label numOfRoots;

    @FXML
    private Label rootValue1;

    @FXML
    private Label rootValue2;
    
    @FXML
    private Label polynomialLayout;
    
    @FXML
    private TextArea userInput;
    
    @FXML
    private Button buttonSubmit;
    
    @FXML
    private Button buttonClear;
    
    @FXML
    private Button buttonBack;

    private EssentialCalculations essentials = new EssentialCalculations();
    
    /**
     * This method takes in a polynomial from the user and displays back:
     *  - the polynomial in the correct format
     *  - the number of roots in the polynomial
     *  - and the value of those roots if there are any
     * @param event
     */
    @FXML
    void submit(ActionEvent event) {
    	int[] poly1 = new int[BasicCalculations.MAX_SIZE];
    	
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
    	    		
    	int max_index = -1;
    	double a_quad = poly1[2];
    	double b_quad = poly1[1];
    	double c_quad = poly1[0];
    	double a_linear = poly1[1];
    	double b_linear = poly1[0];
    	double d = 0;

    	d = (Math.pow(b_quad,2) - (4 * a_quad * c_quad));

    	for (index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
    		if (max_index < index && poly1[index] != 0) {
    			max_index = index;
    		}
    	}

    	if (max_index == 1) {
    		essentials.setRoot_1((b_linear * -1) / a_linear);
    		essentials.setNum_RealRoots(1);
    	}
    	else if (max_index == 2) {
    		if (d > 0) {
    			essentials.setRoot_1((((-b_quad) + Math.sqrt(d)) / (2 * a_quad)));
    			essentials.setRoot_2((((-b_quad) - Math.sqrt(d)) / (2 * a_quad)));
    			essentials.setNum_RealRoots(2);
    		}
    		else if (d == 0) {
    			essentials.setRoot_1(((-b_quad) / (2 * a_quad)));
    			essentials.setNum_RealRoots(1);
    		}
    		else if (d < 0) {
    			essentials.setNum_RealRoots(0);
    		}
    		else {
    			essentials.setNum_RealRoots(-1);
    		}
    	}
    	essentials.getRoots_info()[0] = essentials.getNum_RealRoots();
    	if (essentials.getNum_RealRoots() > 0) {
    		if (essentials.getNum_RealRoots() == 1) {
    			essentials.getRoots_info()[1] = essentials.getRoot_1();
    		}
    		if (essentials.getNum_RealRoots() == 2) {
    			essentials.getRoots_info()[1] = essentials.getRoot_1();
    			essentials.getRoots_info()[2] = essentials.getRoot_2();
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
		
		// setting the text for the number of roots 
		String stringNumOfRoots = Integer.toString(essentials.getNum_RealRoots());
		numOfRoots.setText(stringNumOfRoots);
		
		// setting the value of the first root
		String stringRoot1 = Double.toString(essentials.getRoot_1());
		rootValue1.setText(stringRoot1);
    	
		// setting the value of the second root
		String stringRoot2 = Double.toString(essentials.getRoot_2());
		rootValue2.setText(stringRoot2);
		
		// setting the text for the label to show the polynomial layout
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


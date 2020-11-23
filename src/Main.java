import javax.swing.UIManager;

/**
 * main class of our calculator - MCV design is implemented
 * @author alireza
 *
 */
public class Main {
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		//setting the look and feel
	    try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception ignored){}
		
	    
		CalculatorGUI calculatorGUI = new CalculatorGUI();
		CalculatorLogic calculatorLogic = new CalculatorLogic();
		CalculatorController calculatorController = new CalculatorController(calculatorGUI, calculatorLogic);
		
		calculatorGUI.setVisible(true);
	}

}

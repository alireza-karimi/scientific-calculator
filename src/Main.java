import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		
	    try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception ignored){}
		
	    
		CalculatorGUI calculatorGUI = new CalculatorGUI();
		CalculatorLogic calculatorLogic = new CalculatorLogic();
		CalculatorController calculatorController = new CalculatorController(calculatorGUI, calculatorLogic);
		
		calculatorGUI.setVisible(true);
	}

}

import java.awt.*;
import javax.swing.*;

public class CalculatorGUI {
	
	JFrame calculatorFrame;
	JPanel usualButtons;
	JPanel scientificButtons;
	
	public CalculatorGUI(){
		calculatorFrame = new JFrame();
		calculatorFrame.setTitle("Alireza Calculator!");
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		calculatorFrame.setLocation(dim.width/4, dim.height/4);
		calculatorFrame.setSize(250, 350);
		calculatorFrame.setLayout(new BorderLayout());
		
		//creating usual buttons panel
		CreateUsualButtonsPanel();
		//creating scientific buttons panel
		CreateScientificButtonsPanel();
		//adding tabbed pane to frame
		AddTabbedPane();
		//adding display to frame
		addDisplay();
		
		calculatorFrame.setVisible(true);
	}
	
	private void CreateUsualButtonsPanel(){
		
		usualButtons = new JPanel();
		
		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		//operators
		JButton buttonAdd = new JButton("+");
		JButton buttonMinus = new JButton("-");
		JButton buttonMultiply = new JButton("*");
		JButton buttonDivide = new JButton("/");
		JButton buttonEqual = new JButton("=");
		JButton buttonRemainder = new JButton("%");
		
		JButton buttonClear = new JButton("AC");
		
		usualButtons.add(button0);
		usualButtons.add(button1);
		usualButtons.add(button2);
		usualButtons.add(button3);
		usualButtons.add(button4);
		usualButtons.add(button5);
		usualButtons.add(button6);
		usualButtons.add(button7);
		usualButtons.add(button8);
		usualButtons.add(button9);

		usualButtons.add(buttonAdd);
		usualButtons.add(buttonMinus);
		usualButtons.add(buttonMultiply);
		usualButtons.add(buttonDivide);
		usualButtons.add(buttonEqual);
		usualButtons.add(buttonRemainder);
		
		usualButtons.add(buttonClear);
		
	}
	
	private void CreateScientificButtonsPanel(){
		
		usualButtons = new JPanel();
		
		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		//operators
		JButton buttonAdd = new JButton("+");
		JButton buttonMinus = new JButton("-");
		JButton buttonMultiply = new JButton("*");
		JButton buttonDivide = new JButton("/");
		JButton buttonEqual = new JButton("=");
		JButton buttonRemainder = new JButton("%");
		JButton buttonSin = new JButton("sin");
		JButton buttonTan = new JButton("tan");
		JButton buttonExp = new JButton("exp");
		JButton buttonLog = new JButton("log");
		JButton buttonPi = new JButton("pi");
		JButton buttonE = new JButton("e");
		
		JButton buttonClear = new JButton("AC");
		JButton buttonShift = new JButton("shift");
		
		usualButtons.add(button0);
		usualButtons.add(button1);
		usualButtons.add(button2);
		usualButtons.add(button3);
		usualButtons.add(button4);
		usualButtons.add(button5);
		usualButtons.add(button6);
		usualButtons.add(button7);
		usualButtons.add(button8);
		usualButtons.add(button9);

		usualButtons.add(buttonAdd);
		usualButtons.add(buttonMinus);
		usualButtons.add(buttonMultiply);
		usualButtons.add(buttonDivide);
		usualButtons.add(buttonEqual);
		usualButtons.add(buttonRemainder);
		usualButtons.add(buttonSin);
		usualButtons.add(buttonTan);
		usualButtons.add(buttonExp);
		usualButtons.add(buttonLog);
		usualButtons.add(buttonPi);
		usualButtons.add(buttonE);
		
		usualButtons.add(buttonClear);
		usualButtons.add(buttonShift);

	}
	
	private void AddTabbedPane(){
		
	    JTabbedPane tp = new JTabbedPane();
	    
	    tp.add("usual",usualButtons);  
	    tp.add("scientifc",scientificButtons);
	    
	    calculatorFrame.add(tp, BorderLayout.CENTER); 
	   
	}
	
	private void addDisplay(){
		JTextArea display = new JTextArea(2, 5);
		display.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(display);
		
		calculatorFrame.add(scrollPane, BorderLayout.NORTH);
		
	}
	
	
}

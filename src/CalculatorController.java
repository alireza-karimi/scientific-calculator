import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.KeyStroke;

/**
 * controller class for calculator
 * @author alireza
 *
 */
public class CalculatorController {
	
	CalculatorGUI calculatorGUI;
	CalculatorLogic calculatorLogic;
	
	/**
	 * creating a new controller object
	 * @param calculatorGUI calculator UI
	 * @param calculatorLogic calculator model
	 */
	public CalculatorController(CalculatorGUI calculatorGUI, CalculatorLogic calculatorLogic){
		this.calculatorGUI = calculatorGUI;
		this.calculatorLogic = calculatorLogic;
		
		//passing listener objects to event listener methods in gui
		this.calculatorGUI.button0Listener(new ActionEventHandler());
		this.calculatorGUI.button1Listener(new ActionEventHandler());
		this.calculatorGUI.button2Listener(new ActionEventHandler());
		this.calculatorGUI.button3Listener(new ActionEventHandler());
		this.calculatorGUI.button4Listener(new ActionEventHandler());
		this.calculatorGUI.button5Listener(new ActionEventHandler());
		this.calculatorGUI.button6Listener(new ActionEventHandler());
		this.calculatorGUI.button7Listener(new ActionEventHandler());
		this.calculatorGUI.button8Listener(new ActionEventHandler());
		this.calculatorGUI.button9Listener(new ActionEventHandler());
		
		this.calculatorGUI.buttonAddListener(new ActionEventHandler());
		this.calculatorGUI.buttonMinusListener(new ActionEventHandler());
		this.calculatorGUI.buttonMultiplyListener(new ActionEventHandler());
		this.calculatorGUI.buttonDivideListener(new ActionEventHandler());
		this.calculatorGUI.buttonEqualListener(new ActionEventHandler());
		this.calculatorGUI.buttonRemainderListener(new ActionEventHandler());
		
		this.calculatorGUI.buttonClearListener(new ActionEventHandler());
		
		this.calculatorGUI.exitListener(new ActionEventHandler());
		this.calculatorGUI.copyListener(new ActionEventHandler());
		
		this.calculatorGUI.buttonPiListener(new ActionEventHandler());
		this.calculatorGUI.buttonEListener(new ActionEventHandler());
		this.calculatorGUI.buttonShiftListener(new ActionEventHandler());
		this.calculatorGUI.buttonSinListener(new ActionEventHandler());
		this.calculatorGUI.buttonTanListener(new ActionEventHandler());
		this.calculatorGUI.buttonExpListener(new ActionEventHandler());
		this.calculatorGUI.buttonLogListener(new ActionEventHandler());
		
		this.calculatorGUI.frameKeyListener(new KeyEventHandler());
	}
	
	/**
	 * action event handler class
	 * @author alireza
	 *
	 */
	class ActionEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			if(event.getActionCommand().equals("Exit")){
				System.exit(0);
			}
			else if(event.getActionCommand().equals("Copy")){
				
				StringSelection stringSelection = new StringSelection(calculatorGUI.getDisplay().getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				
				calculatorGUI.showMessage("Copied to clipboard!");
			}
			else if(event.getActionCommand().equals("shift")){
				if(calculatorGUI.getbuttonSin().getText().equals("sin")){
					calculatorGUI.getbuttonSin().setText("cos");
					calculatorGUI.getbuttonTan().setText("cot");
				}
				else{
					calculatorGUI.getbuttonSin().setText("sin");
					calculatorGUI.getbuttonTan().setText("tan");
				}
			}
			else{
				
				String buttonText = event.getActionCommand(); 
				
				if(buttonText.charAt(0) <= '9' && buttonText.charAt(0) >= '0'){
					
		            if (calculatorLogic.getOperator().equals("")){
		            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + buttonText);
		            } 	
		            else{
		            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + buttonText);
		            }       
				}
				else if(buttonText.equals("pi")){
		            if (calculatorLogic.getOperator().equals("")){
		            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + Math.PI);
		            } 	
		            else{
		            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + Math.PI);
		            }  
				}
				else if(buttonText.equals("e")){
		            if (calculatorLogic.getOperator().equals("")){
		            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + Math.E);
		            } 	
		            else{
		            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + Math.E);
		            }  
				}
				else if(buttonText.equals("sin")){
		            calculatorLogic.setFirstOperand("");
		            calculatorLogic.setOperator("sin");
		            
				}
				else if(buttonText.equals("tan")){
		            calculatorLogic.setFirstOperand("");
		            calculatorLogic.setOperator("tan");
		            
				}
				else if(buttonText.equals("cos")){
		            calculatorLogic.setFirstOperand("");
		            calculatorLogic.setOperator("cos");
		            
				}
				else if(buttonText.equals("cot")){
		            calculatorLogic.setFirstOperand("");
		            calculatorLogic.setOperator("cot");
		            
				}
				else if(buttonText.equals("exp")){
		            calculatorLogic.setFirstOperand("");
		            calculatorLogic.setOperator("exp");
		            
				}
				else if(buttonText.equals("log")){
		            calculatorLogic.setFirstOperand("");
		            calculatorLogic.setOperator("log");
		            
				}
				else if(buttonText.equals("=")){
					calculatorLogic.performCalculations();
				}
				else if(buttonText.equals("AC")){
					calculatorLogic.setFirstOperand("");
					calculatorLogic.setOperator("");
					calculatorLogic.setSecondOperand("");
				}
				else{
					calculatorLogic.setOperator(buttonText);
				}
				
			}

			//updating the display after each event
			calculatorGUI.updateDisplayText(calculatorLogic.getFirstOperand() + calculatorLogic.getOperator() + calculatorLogic.getSecondOperand());
		}
		
	}
	
	/**
	 * keyboard event handler class
	 * @author alireza
	 *
	 */
	class KeyEventHandler implements KeyListener {

		
		@Override
		public void keyReleased(KeyEvent event) {
			
			String keyString = KeyEvent.getKeyText(event.getKeyCode());
			
			System.out.println(event.getKeyCode());
			System.out.println(keyString);
			
			if(keyString.equals("0") || keyString.equals("NumPad-0")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "0");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "0");
	            }
			}
			else if(keyString.equals("1") || keyString.equals("NumPad-1")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "1");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "1");
	            }
			}
			else if(keyString.equals("2") || keyString.equals("NumPad-2")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "2");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "2");
	            }
			}
			else if(keyString.equals("3") || keyString.equals("NumPad-3")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "3");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "3");
	            }
			}
			else if(keyString.equals("4") || keyString.equals("NumPad-4")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "4");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "4");
	            }
			}
			else if(keyString.equals("5") || keyString.equals("NumPad-5")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "5");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "5");
	            }
			}
			else if(keyString.equals("6") || keyString.equals("NumPad-6")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "6");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "6");
	            }
			}
			else if(keyString.equals("7") || keyString.equals("NumPad-7")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "7");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "7");
	            }
			}
			else if(keyString.equals("8") || keyString.equals("NumPad-8")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "8");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "8");
	            }
			}
			else if(keyString.equals("9") || keyString.equals("NumPad-9")){
	            if (calculatorLogic.getOperator().equals("")){
	            	calculatorLogic.setFirstOperand(calculatorLogic.getFirstOperand() + "9");
	            } 	
	            else{
	            	calculatorLogic.setSecondOperand(calculatorLogic.getSecondOperand() + "9");
	            }
			}
			else if(keyString.equals("NumPad +")){
				calculatorLogic.setOperator("+");
			}
			else if(keyString.equals("NumPad -")){
				calculatorLogic.setOperator("-");
			}
			else if(keyString.equals("NumPad *")){
				calculatorLogic.setOperator("*");
			}
			else if(keyString.equals("NumPad /")){
				calculatorLogic.setOperator("/");
			}
			else if(keyString.equals("Equals") || keyString.equals("Enter")){
				calculatorLogic.performCalculations();
			}
			else if(keyString.equals("E")){
				System.exit(0);
			}
			else if(event.isControlDown() && KeyEvent.getKeyText(event.getKeyCode()).equals("C")){
				StringSelection stringSelection = new StringSelection(calculatorGUI.getDisplay().getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				
				calculatorGUI.showMessage("Copied to clipboard!");
			}
			
			
			//updating the display after each event
			calculatorGUI.updateDisplayText(calculatorLogic.getFirstOperand() + calculatorLogic.getOperator() + calculatorLogic.getSecondOperand());
		}

		
		
		@Override
		public void keyTyped(KeyEvent event) {

			
		}
	
		
		@Override
		public void keyPressed(KeyEvent e) {
			//nothing
		}



		
	}
	
	
	
}

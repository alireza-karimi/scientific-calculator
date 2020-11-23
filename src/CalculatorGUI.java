import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * UI of our calculator
 * @author alireza
 *
 */
public class CalculatorGUI extends JFrame {
	
	//calculator display
	private JTextArea display;
	
	//tabbed pane
	private JTabbedPane tp;
	
	//number buttons
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	
	//operator buttons
	private JButton buttonAdd;
	private JButton buttonMinus;
	private JButton buttonMultiply;
	private JButton buttonDivide;
	private JButton buttonEqual;
	private JButton buttonRemainder;
	//scientific operator buttons
	private JButton buttonSin;
	private JButton buttonTan;
	private JButton buttonExp;
	private JButton buttonLog;
	private JButton buttonPi;
	private JButton buttonE;
	
	//control buttons
	private JButton buttonClear;
	private JButton buttonShift;
	
	
	//menu buttons
	private JMenuItem exit;
	private JMenuItem copy;
	
	/**
	 * creating a new calculator UI
	 */
	public CalculatorGUI(){
		setTitle("Alireza Calculator!");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		int width = 250;
		int height = 350;
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//adding tabbed pane to frame
		addTabbedPane();
		//adding display to frame
		addDisplay();
		//adding menu
		addMenu();
	}
	
	/**
	 * getting exit item in menu
	 * @return exit item in menu
	 */
	public JMenuItem getExit(){
		return exit;
	}
	
	/**
	 * getting copy item in menu
	 * @return copy item in menu
	 */
	public JMenuItem getCopy(){
		return copy;
	}
	
	/**
	 * getting display of calculator
	 * @return display of calculator
	 */
	public JTextArea getDisplay(){
		return display;
	}
	
	/**
	 * getting tan button
	 * @return tan button
	 */
	public JButton getbuttonTan(){
		return buttonTan;
	}
	
	/**
	 * getting sin button
	 * @return sin button
	 */
	public JButton getbuttonSin(){
		return buttonSin;
	}
	
	/**
	 * adding menu to frame
	 */
	private void addMenu(){
		JMenuBar menu = new JMenuBar();
		
		exit = new JMenuItem("Exit");
		menu.add(exit);
		exit.setMnemonic(KeyEvent.VK_E);
		
		copy = new JMenuItem("Copy");
		menu.add(copy);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		setJMenuBar(menu);
		
	}

	/**
	 * creating all buttons
	 */
	private void createButtons(){
		
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		
		//operators
		buttonAdd = new JButton("+");
		buttonMinus = new JButton("-");
		buttonMultiply = new JButton("*");
		buttonDivide = new JButton("/");
		buttonEqual = new JButton("=");
		buttonRemainder = new JButton("%");
		buttonSin = new JButton("sin");
		buttonTan = new JButton("tan");
		buttonExp = new JButton("exp");
		buttonLog = new JButton("log");
		buttonPi = new JButton("pi");
		buttonE = new JButton("e");
		
		buttonClear = new JButton("AC");
		buttonClear.setToolTipText("clear all");
		
		buttonShift = new JButton("shift");
		buttonShift.setToolTipText("change sin to cos and tan to cot");
	}
	
	/**
	 * creating panel with usual buttons
	 * @return panel with usual buttons
	 */
	private JPanel createUsualButtonsPanel(){
		
		JPanel panel = new JPanel();
		
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);

		panel.add(buttonAdd);
		panel.add(buttonMinus);
		panel.add(buttonMultiply);
		panel.add(buttonDivide);
		panel.add(buttonEqual);
		panel.add(buttonRemainder);
		
		panel.add(buttonClear);
		
		return panel;
	}
	
	/**
	 * creating panel with scientific buttons
	 * @return panel with scientific buttons
	 */
	private JPanel createScientificButtonsPanel(){
	
		JPanel panel = new JPanel();
		
		panel.add(buttonSin);
		panel.add(buttonTan);
		panel.add(buttonExp);
		panel.add(buttonLog);
		panel.add(buttonPi);
		panel.add(buttonE);
		
		panel.add(buttonShift);
		
		return panel;
	}
	
	/**
	 * creating a tabbed pane
	 */
	private void addTabbedPane(){
		
		createButtons();
		
	    tp = new JTabbedPane();
	    
	    tp.add("usual", createUsualButtonsPanel());  
	    tp.add("scientifc", createScientificButtonsPanel());
	      
	    this.add(tp, BorderLayout.CENTER); 
	   
	}
	
	/**
	 * adding display to frame
	 */
	private void addDisplay(){
		display = new JTextArea(2, 5);
		display.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(display);
		display.setToolTipText("Display of calculator");
		
		this.add(scrollPane, BorderLayout.NORTH);
		
	}
	
	/**
	 * updating display text
	 * @param text final text
	 */
	public void updateDisplayText(String text){
		display.setText(text);
	}
	
	/**
	 * showing o pop up message
	 * @param message message
	 */
	public void showMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	
	//add event listeners to number buttons
	
	void button0Listener(ActionListener ActionEventHandler){
		button0.addActionListener(ActionEventHandler);
	}
	
	void button1Listener(ActionListener ActionEventHandler){
		button1.addActionListener(ActionEventHandler);
	}
	
	void button2Listener(ActionListener ActionEventHandler){
		button2.addActionListener(ActionEventHandler);
	}
	
	void button3Listener(ActionListener ActionEventHandler){
		button3.addActionListener(ActionEventHandler);
	}
	
	void button4Listener(ActionListener ActionEventHandler){
		button4.addActionListener(ActionEventHandler);
	}
	
	void button5Listener(ActionListener ActionEventHandler){
		button5.addActionListener(ActionEventHandler);
	}
	
	void button6Listener(ActionListener ActionEventHandler){
		button6.addActionListener(ActionEventHandler);
	}
	
	void button7Listener(ActionListener ActionEventHandler){
		button7.addActionListener(ActionEventHandler);
	}
	
	void button8Listener(ActionListener ActionEventHandler){
		button8.addActionListener(ActionEventHandler);
	}
	
	void button9Listener(ActionListener ActionEventHandler){
		button9.addActionListener(ActionEventHandler);
	}
	
	//add event listeners to operator buttons
	
	void buttonAddListener(ActionListener ActionEventHandler){
		buttonAdd.addActionListener(ActionEventHandler);
	}
	
	void buttonMinusListener(ActionListener ActionEventHandler){
		buttonMinus.addActionListener(ActionEventHandler);
	}
	
	void buttonMultiplyListener(ActionListener ActionEventHandler){
		buttonMultiply.addActionListener(ActionEventHandler);
	}
	
	void buttonDivideListener(ActionListener ActionEventHandler){
		buttonDivide.addActionListener(ActionEventHandler);
	}
	
	void buttonEqualListener(ActionListener ActionEventHandler){
		buttonEqual.addActionListener(ActionEventHandler);
	}
	
	void buttonRemainderListener(ActionListener ActionEventHandler){
		buttonRemainder.addActionListener(ActionEventHandler);
	}
	
	
	//clear button event listener
	
	void buttonClearListener(ActionListener ActionEventHandler){
		buttonClear.addActionListener(ActionEventHandler);
	}
	
	
	//menu listeners
	
	
	void exitListener(ActionListener ActionEventHandler){
		exit.addActionListener(ActionEventHandler);
	}
	
	void copyListener(ActionListener ActionEventHandler){
		copy.addActionListener(ActionEventHandler);
	}
	
	
	//scientific buttons
	
	void buttonPiListener(ActionListener ActionEventHandler){
		buttonPi.addActionListener(ActionEventHandler);
	}
	
	void buttonEListener(ActionListener ActionEventHandler){
		buttonE.addActionListener(ActionEventHandler);
	}
	
	void buttonShiftListener(ActionListener ActionEventHandler){
		buttonShift.addActionListener(ActionEventHandler);
	}
	
	void buttonSinListener(ActionListener ActionEventHandler){
		buttonSin.addActionListener(ActionEventHandler);
	}
	
	void buttonTanListener(ActionListener ActionEventHandler){
		buttonTan.addActionListener(ActionEventHandler);
	}
	
	void buttonExpListener(ActionListener ActionEventHandler){
		buttonExp.addActionListener(ActionEventHandler);
	}
	
	void buttonLogListener(ActionListener ActionEventHandler){
		buttonLog.addActionListener(ActionEventHandler);
	}
	
	
	
	/**
	 * adding keyboard event listener to all JComponenets
	 * @param KeyEventHandler event handler object
	 */
	void frameKeyListener(KeyListener KeyEventHandler){
		button0.addKeyListener(KeyEventHandler);
		button1.addKeyListener(KeyEventHandler);
		button2.addKeyListener(KeyEventHandler);
		button3.addKeyListener(KeyEventHandler);
		button4.addKeyListener(KeyEventHandler);
		button5.addKeyListener(KeyEventHandler);
		button6.addKeyListener(KeyEventHandler);
		button7.addKeyListener(KeyEventHandler);
		button8.addKeyListener(KeyEventHandler);
		button9.addKeyListener(KeyEventHandler);
		
		display.addKeyListener(KeyEventHandler);
		
		tp.addKeyListener(KeyEventHandler);
		
		
		buttonAdd.addKeyListener(KeyEventHandler);
		buttonMinus.addKeyListener(KeyEventHandler);
		buttonMultiply.addKeyListener(KeyEventHandler);
		buttonDivide.addKeyListener(KeyEventHandler);
		buttonEqual.addKeyListener(KeyEventHandler);
		buttonRemainder.addKeyListener(KeyEventHandler);
		
		buttonSin.addKeyListener(KeyEventHandler);
		buttonTan.addKeyListener(KeyEventHandler);
		buttonExp.addKeyListener(KeyEventHandler);
		buttonLog.addKeyListener(KeyEventHandler);
		buttonPi.addKeyListener(KeyEventHandler);
		buttonE.addKeyListener(KeyEventHandler);
		
		
		buttonClear.addKeyListener(KeyEventHandler);
		buttonShift.addKeyListener(KeyEventHandler);
		
		exit.addKeyListener(KeyEventHandler);
		copy.addKeyListener(KeyEventHandler);
	}
	
	
}

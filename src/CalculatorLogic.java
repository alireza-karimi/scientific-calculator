/**
 * logic of calculator (model)
 * @author alireza
 *
 */
public class CalculatorLogic {
	
	
	private String firstOperand;
	private String secondOperand;
	private String operator;

	/**
	 * creating a new model for calculator
	 */
	public CalculatorLogic(){
		firstOperand = "";
		secondOperand = "";
		operator = "";
	}
	
	/**
	 * getting first operand
	 * @return first operand
	 */
	public String getFirstOperand(){
		return firstOperand;
	}
	
	/**
	 * getting second operand
	 * @return second operand
	 */
	public String getSecondOperand(){
		return secondOperand;
	}
	
	/**
	 * getting operator
	 * @return operator
	 */
	public String getOperator(){
		return operator;
	}
	
	/**
	 * settign first operand
	 * @param firstOperand first operand
	 */
	public void setFirstOperand(String firstOperand){
		this.firstOperand = firstOperand;
	}
	
	/**
	 * settign second operand
	 * @param secondOperand second operand
	 */
	public void setSecondOperand(String secondOperand){
		this.secondOperand = secondOperand;
	}
	
	/**
	 * setting operator
	 * @param operator
	 */
	public void setOperator(String operator){
		this.operator = operator;
	}
	
	/**
	 * perform calculation
	 */
	public void performCalculations(){

		double result = 0;
		
		if(!operator.equals("") && !firstOperand.equals("")){
			
			if(secondOperand.equals("")){
				//firstOperand = firstOperand;
				operator = "";
				secondOperand = "";		
			}
			else{
				
				if(operator.equals("+")){
					result = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
				}
				else if(operator.equals("-")){
					result = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
				}
				else if(operator.equals("*")){
					result = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
				}
				else if(operator.equals("/")){
					result = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
				}
				else if(operator.equals("%")){
					result = Double.parseDouble(firstOperand) % Double.parseDouble(secondOperand);
				}
				
				firstOperand = Double.toString(result);
				operator = "";
				secondOperand = "";	
			}
	
		}
		else if(!operator.equals("") && !secondOperand.equals("") && firstOperand.equals("")){
			
			if(operator.equals("sin")){
				result = Math.sin(Double.parseDouble(secondOperand));
			}
			else if(operator.equals("sin")){
				result = Math.sin(Double.parseDouble(secondOperand));
			}
			else if(operator.equals("tan")){
				result = Math.tan(Double.parseDouble(secondOperand));
			}
			else if(operator.equals("cos")){
				result = Math.cos(Double.parseDouble(secondOperand));
			}
			else if(operator.equals("cot")){
				result = Math.sin(Double.parseDouble(secondOperand)) / Math.cos(Double.parseDouble(secondOperand));
			}
			else if(operator.equals("exp")){
				System.out.println("*");
				result = Math.pow(Math.E, Double.parseDouble(secondOperand));
			}
			else if(operator.equals("log")){
				result = Math.log(Double.parseDouble(secondOperand));
			}
			
			firstOperand = Double.toString(result);
			operator = "";
			secondOperand = "";	
		}
		
	}
	
}

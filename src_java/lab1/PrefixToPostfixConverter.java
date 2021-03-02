/*
PrefixToPostfixConverter converts a given prefix equation to a postfix
*/
public class PrefixToPostfixConverter
{
	//list of valid operations
	private static final String [] operators 
		= {"-", "+", "/", "*", "$"}; 
	/*
	input - input prefix equation to be converted into a postfix equation and 
		returned to the caller via the output equation
	precondition - input equation is a single valid prefix equation
	process - convert prefix equation to postfix equation if possible
	postcondition - the output stack now contains the converted postfix equation
	output - true if successful, false if failed to convert
	*/
	public boolean prefixToPostfix(Stack inputEquation, Stack outputEquation)
	{
		boolean success = true;
		Stack symbolStack = new Stack();
		String inputChar;
		String pop1;
		String pop2;

		if(inputEquation.isEmpty()) return success = false;

		while(inputEquation.isEmpty() == false)
		{
			inputChar = (String) inputEquation.pop();
			///System.out.println("\tinconverter: >" + inputChar + "<");
			
			if(isOperator(inputChar))
			{
				if(symbolStack.isEmpty()==false) pop1 = (String) symbolStack.pop();
				else return success = false; //not enough operands
			
				if(symbolStack.isEmpty()==false) pop2 = (String) symbolStack.pop();
				else return success = false; //not enough operands

				symbolStack.push(String.format("%s%s%s",pop1, pop2, inputChar));
				///System.out.print("\n"+symbolStack.peak());	
			}
			else
			{
				if(Character.isLetter(inputChar.charAt(0)))
					symbolStack.push(inputChar);
				else return success = false; //invalid input
			}
		}
		outputEquation.push(symbolStack.pop());	
		return success = symbolStack.isEmpty(); //extra operand
	}


	/*
	input - a single character as a String
	precondition - none
	process - compare input against list of valid operators
	postcondition - none
	output - return true if input found to be valid operator
	*/
	private static boolean isOperator(String inputChar)
	{
		boolean inputIsOperator = false;
		for (String operator : operators)
			if (inputChar.equals(operator))
				inputIsOperator = true;

		return inputIsOperator;
	}
}
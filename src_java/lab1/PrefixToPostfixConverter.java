public class PrefixToPostfixConverter
{
	private static final String [] operators 
		= {"-", "+", "/", "*", "$"}; 
	/*
	input
	precondition
	process
	postcondition
	output
	*/
	public boolean prefixToPostfix(String inputEquation, Stack outputEquation)
	{
		boolean success = true;
		Stack symbolStack = new Stack(inputEquation.length());
		String inputChar;
		String pop1;
		String pop2;

		if(inputEquation.length() == 0) return success = false;

		for (int i = inputEquation.length() - 1; i >= 0; i--)
		{
			inputChar = Character.toString(inputEquation.charAt(i));

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
	input
	precondition
	process
	postcondition
	output
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
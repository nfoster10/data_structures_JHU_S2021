public class PrefixToPostfixConverter
{
	private static final [] char operators 
		= {'-', '+', '/', '*', '^'}; 
	/*
	input
	precondition
	process
	postcondition
	output
	*/
	public boolean prefixToPostfix(String inputEquation, String outputEquation)
	{
		boolean success = false;
		Stack alpha = new Stack(inputEquation.length());
		char inputChar;
		char pop1;
		char pop2;

		for (int i = inputEquation.length() - 1; i >= 0; i--)
		{
			inputChar = inputEquation.charAt(i);
			if (isOperator(inputChar))
			{
				if (alpha.isEmpty())
					break;
				else
					pop1 = (char) alpha.pop();
				if (alpha.isEmpty())
				{
					sucess = true; //boundary condition acheived, last operator and operand
					outputEquation.append(String.format(pop1+inputChar));
				}
				else
					pop2 = (char) alpha.pop();

				outputEquation.append(String.format(pop1+pop2+inputChar));
			}
			else
			{
				alpha.push(inputChar);
			}
		}	

		return success;
	}

	private static boolean isOperator(char inputChar)
	{
		boolean inputIsOperator = false;
		for (char operator : operators)
			if (inputChar == operator)
				inputIsOperator = true;

		return inputIsOperator;
	}


}
public class PolynomialCalculator
{
	private int [][] xyz;

	PolynomialCalculator(int [] x, int [] y, int [] z)
	{
		xyz = new int[x.length][3];

		for (int i = 0; i < x.length; i++)
		{
			xyz[i][0] = x[i];
			xyz[i][1] = y[i];
			xyz[i][2] = z[i];
		}
	}

	public int [] process(LinkedList inputPolynomial)
	{
		int [] output = new int[xyz.length];

		for (int i = 0; i < xyz.length; i++)
		{
			output[i] = this.processHelper(inputPolynomial.head, 
				xyz[i][0], xyz[i][1], xyz[i][0]);
		}

		return output;
	}

	private int processHelper(ListNode inputNode, int x, int y, int z)
	{
		///TODO: negative exponents or double digits not handled - use doubles and better checking
		int sign = 1;
		int digit = 0;

		LinkedList evaluatedPolynomials = new LinkedList();

		while(inputNode != null)
		{
			if(((Character)inputNode.data).equals(new Character('-')))
			{
				sign = -1;
			}
			else if (Character.isDigit(((Character)inputNode.data).charValue())) 
			{
				if (inputNode.next != null & Character.isDigit(((Character)inputNode.next.data).charValue()))
				{
					digit = 10*Character.getNumericValue(((Character) inputNode.data).charValue()) +
						Character.getNumericValue(((Character) inputNode.next.data).charValue());
					inputNode = inputNode.next;
				}
				else
					digit = Character.getNumericValue(((Character) inputNode.data).charValue());

				digit = sign * digit;
				sign = 1;
			}
			else if (((Character)inputNode.data).equals(new Character('x')))
			{
				return 
			}

			if (((Character)inputNode.next.data).equals(new Character('x')))
			{
				//then digit is a coefficient
				evaluatedPolynomials.insert( digit * recursiveProcessHelper(inputNode.next, x,y,z));
					///might need to force to double or integer
			}
			else
			{
				//jump to next node until another coefficient is found
				inputNode = inputNode.next;
			}
		}

		///TODO: sum evaluated

		/*if(inputNode == null)
		{
			return 0;
		}
		else if (Character.isDigit(((Character)inputNode.data).charValue()) & 
			inputNode.next != null &&
			inputNode.next.data.equals(new Character('x')))
		{
			return Character.getNumericValue(((Character) inputNode.data).charValue()) * 
				processHelper(inputNode.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('x')))
		{
			return (int) Math.pow(x,Character.getNumericValue(((Character) inputNode.next.data).charValue())) * 
				processHelper(inputNode.next.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('y')))
		{
			return (int) Math.pow(y,Character.getNumericValue(((Character) inputNode.next.data).charValue())) * 
				processHelper(inputNode.next.next, x,y,z);	
		}
		else if (((Character)inputNode.data).equals(new Character('z')))
		{
			return (int) Math.pow(z,Character.getNumericValue(((Character) inputNode.next.data).charValue())) + 
				processHelper(inputNode.next.next, x,y,z);		
		}
		else if (((Character)inputNode.data).equals(new Character('+')))
		{
			return processHelper(inputNode.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('-')))
		{
			return -1 * processHelper(inputNode.next, x,y,z);
		}
		else
			return -1;*/

		///TODO: deal with -1 error returns
	}

	private int recursiveProcessHelper(ListNode inputNode, int x, int y, int z)
	{
		///TODO: need to add processing for negative/double digits
		if (((Character)inputNode.data).equals(new Character('x')))
		{
			return (int) Math.pow(x,Character.getNumericValue(((Character) inputNode.next.data).charValue())) * 
				recursisveProcessHelper(inputNode.next.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('y')))
		{
			return (int) Math.pow(y,Character.getNumericValue(((Character) inputNode.next.data).charValue())) * 
				recursiveProcessHelper(inputNode.next.next, x,y,z);	
		}
		else if (((Character)inputNode.data).equals(new Character('z')))
		{
			return (int) Math.pow(z,Character.getNumericValue(((Character) inputNode.next.data).charValue()));
		}
	}

}
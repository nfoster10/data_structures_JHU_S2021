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

	public double [] process(LinkedList inputPolynomial)
	{
		double [] output = new double[xyz.length];

		for (int i = 0; i < xyz.length; i++)
		{
			///System.out.printf("x: %d, y: %d, z: %d\n", xyz[i][0], xyz[i][1], xyz[i][2]);
			output[i] = this.processHelper(inputPolynomial.head, 
				xyz[i][0], xyz[i][1], xyz[i][2]);
		}

		return output;
	}

	private double processHelper(ListNode inputNode, int x, int y, int z)
	{
		int sign = 1;
		int digit = 0;

		LinkedList evaluatedPolynomials = new LinkedList();

		while(inputNode != null)
		{
			///System.out.println("start while loop");
			if(((Character)inputNode.data).equals(new Character('-')))
			{
				sign = -1;
				///System.out.println("negative enocuntered");
			}
			if (Character.isDigit(((Character)inputNode.data).charValue())) 
			{
				///System.out.println("digit encountered");
				if (inputNode.next != null)
				{
					if(Character.isDigit(((Character)inputNode.next.data).charValue()))
					{
						///System.out.println("process digit as double digit");
						digit = 10*Character.getNumericValue(((Character) inputNode.data).charValue()) +
							Character.getNumericValue(((Character) inputNode.next.data).charValue());
						inputNode = inputNode.next;
						///System.out.println("double digits enocuntered");
					}
					else
						digit = Character.getNumericValue(((Character) inputNode.data).charValue());
				}

				digit = sign * digit;
				sign = 1;
			}

			///System.out.println("right before check against x");

			if (inputNode.next != null)
			{ 
				if(((Character)inputNode.next.data).equals(new Character('x')))
				{
					///System.out.println("x encountered");
					//then digit is a coefficient
					evaluatedPolynomials.insert(new Double((double)digit * recursiveProcessHelper(inputNode.next, x,y,z)), -1);
					///System.out.println("outside the recursive call");
				}
			}
			//jump to next node until another coefficient is found
			inputNode = inputNode.next;
			///System.out.println("jumping to next node in list");
		}

		///System.out.println("outside the while loop");
		ListNode currentNode = evaluatedPolynomials.head;

		double output = 0;

		///System.out.println("adding the polys");
		while(currentNode != null)
		{
			output += ((Double)currentNode.data).doubleValue();
			currentNode = currentNode.next;
		}

		return output;
	}

	private double recursiveProcessHelper(ListNode inputNode, int x, int y, int z)
	{
		int sign = 1;
		int digit = 0;

		///System.out.println("inside the recursive fxn");

		if (((Character)inputNode.data).equals(new Character('x')))
		{
			///System.out.println("found an x");
			if(((Character)inputNode.next.data).equals(new Character('-')))
			{
				sign = -1;
				inputNode = inputNode.next;
			}
			if (Character.isDigit(((Character)inputNode.next.data).charValue())) 
			{
				inputNode = inputNode.next;
				///System.out.println("still alive");
				if (inputNode.next != null)
				{
					if(Character.isDigit(((Character)inputNode.next.data).charValue()))
					
					{
						///System.out.println("still alive2");
						digit = 10*((int)((Character) inputNode.data).charValue() - '0') +
							Character.getNumericValue(((Character) inputNode.next.data).charValue()) - '0';
						inputNode = inputNode.next;
					}
					else
						digit = (int)((Character) inputNode.data).charValue() - '0';
				}
				else
					digit = (int)((Character) inputNode.data).charValue() - '0';
				
				///System.out.println("still alive3");

				digit = sign * digit;
				sign = 1;
			}

			///System.out.printf("x^exp=%d^%d= %f\n", x,digit, Math.pow(x,digit));
			return Math.pow(x,digit) * 
				recursiveProcessHelper(inputNode.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('y')))
		{
			///System.out.println("found an y");
			if(((Character)inputNode.next.data).equals(new Character('-')))
			{
				sign = -1;
				inputNode = inputNode.next;
			}
			if (Character.isDigit(((Character)inputNode.next.data).charValue())) 
			{
				inputNode = inputNode.next;
				///System.out.println("still alive");
				if (inputNode.next != null)
				{
					if(Character.isDigit(((Character)inputNode.next.data).charValue()))
					
					{
						///System.out.println("still alive2");
						digit = 10*((int)((Character) inputNode.data).charValue() - '0') +
							Character.getNumericValue(((Character) inputNode.next.data).charValue()) - '0';
						inputNode = inputNode.next;
					}
					else
						digit = (int)((Character) inputNode.data).charValue() - '0';
				}
				else
					digit = (int)((Character) inputNode.data).charValue() - '0';
				
				///System.out.println("still alive3");

				digit = sign * digit;
				sign = 1;
			}

			///System.out.printf("y^exp=%d^%d= %f\n", y,digit, Math.pow(y,digit));
			return Math.pow(y,digit) * 
				recursiveProcessHelper(inputNode.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('z')))
		{
			///System.out.println("found an z");
			if(((Character)inputNode.next.data).equals(new Character('-')))
			{
				sign = -1;
				inputNode = inputNode.next;
			}
			if (Character.isDigit(((Character)inputNode.next.data).charValue())) 
			{
				inputNode = inputNode.next;
				///System.out.println("still alive");
				if (inputNode.next != null)
				{
					if(Character.isDigit(((Character)inputNode.next.data).charValue()))
					
					{
						///System.out.println("still alive2");
						digit = 10*((int)((Character) inputNode.data).charValue() - '0') +
							Character.getNumericValue(((Character) inputNode.next.data).charValue()) - '0';
						inputNode = inputNode.next;
					}
					else
						digit = (int)((Character) inputNode.data).charValue() - '0';
				}
				else
					digit = (int)((Character) inputNode.data).charValue() - '0';
				
				///System.out.println("still alive3");

				digit = sign * digit;
				sign = 1;
			}

			///System.out.printf("z^exp=%d^%d= %f\n", z,digit, Math.pow(z,digit));
			return Math.pow(z,digit);
		}
		else
			return recursiveProcessHelper(inputNode.next, x,y,z);
	}
}
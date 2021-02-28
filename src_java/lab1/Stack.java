public class Stack implements Stack_I
{
	private int length;
	private Object [] stack;

	/*
		input
		precondition
		process
		postcondition
		output
	*/
	Stack()
	{
		this.length = 0;
		this.stack = new Object[10];
	}

	/*
		input
		precondition
		process
		postcondition
		output
	*/
	Stack(int stackSize)
	{
		this.length = 0;
		this.stack = new Object[stackSize];
	}

	public Object pop()
	{
		length--;
		//System.out.println("CCC" + length);
		return this.stack[this.length];
	}

	public Object peak()
	{
		return this.stack[this.length - 1];
	}

	public boolean push(Object inputObject)
	{
		this.stack[this.length] = inputObject;
		this.length++;
		return (length > 0);
	}

	public boolean isEmpty()
	{
		return !(length > 0);
	}
}
public class Stack implements Stack_I
{
	private int length;
	private [] Object stack;

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

	Object pop()
	{
		return this.stack[this.length--];
	}

	Object peak()
	{
		return this.stack[this.length - 1];
	}

	boolean push(Object inputObject);
	{
		this.stack[this.length] = inputObject;
		this.length++;
		return (length > 0);
	}

	boolean isEmpty()
	{
		return !(length > 0);
	}
}
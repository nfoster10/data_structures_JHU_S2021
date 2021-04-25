//defines a singly linked linked list
public class LinkedList
{
	public ListNode head;
	public ListNode tail;
	public int length;

	LinkedList()
	{
		head = null;
		tail = null;
		length = 0;
	}

	/*
	inputs - new node and where in the list to put the data
	precondtion - the index exists
	process - the new node data is inserted into the list at the desired index of end if -1
	postcondition - linked list length increased by 1
	outputs - N/A
	*/
	public void insert(Object newNodeData, int index)
	{
		ListNode newNode = new ListNode(newNodeData);
		if(index < 0 || this.isEmpty())
		{
			if(this.isEmpty())
			{
				head = tail = newNode;
				newNode.next = null;
			}
			else
			{
				tail.next = newNode;
				tail = newNode;
				tail.next = null;
			}
		}
		else if (index > 0)
		{
			ListNode beforeMovingNode = head;
			for (int i = 0; i < index - 1; i++)
				beforeMovingNode = beforeMovingNode.next;
			
			ListNode movingNode = beforeMovingNode.next;
			beforeMovingNode.next = newNode;
			newNode.next = movingNode; 
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}

		length++;
	}

	/*
	inputs - index to delete
	precondtion - index exists
	process - remove links to index to delete
	postcondition - linked list length decrease by 1
	outputs - N/A
	*/
	public void delete(int index)
	{
		ListNode nodePriorToRemove = head;

		for (int i = 0; i < index-1; i++)
		{
			if (nodePriorToRemove == null)
				return;
			else
				nodePriorToRemove = nodePriorToRemove.next;
		}

		if (nodePriorToRemove == head)
			head = nodePriorToRemove.next;
		else if (nodePriorToRemove == tail)
			return;
		else
		{
			if(nodePriorToRemove.next == this.tail)
				this.tail = nodePriorToRemove.next.next;
			nodePriorToRemove.next = nodePriorToRemove.next.next;
		}
	}

	/*
	inputs - N/A
	precondtion - N/A
	process - check if head is null
	postcondition - N/A
	outputs - empty status
	*/
	public boolean isEmpty()
	{
		return head == null;
	}

	/*
	inputs - N/A
	precondtion - N/A
	process - create a string representation of the linked list
	postcondition - N/A
	outputs - string representation of list
	*/
	public String toString()
	{
		String output = "";

		ListNode currentNode = this.head;

		while(currentNode != null)
		{
			output = output + ((Character)currentNode.data).charValue();
			currentNode = currentNode.next;
		}

		return output;
	}
}
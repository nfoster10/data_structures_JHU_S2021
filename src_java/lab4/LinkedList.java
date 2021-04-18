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

	public boolean isEmpty()
	{
		return head == null;
	}

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
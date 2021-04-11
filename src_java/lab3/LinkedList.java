public class LinkedList
{
	public ListNode head;
	public ListNode tail;

	LinkedList()
	{
		head = null;
		tail = null;
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
			///TODO: need to add check in case movingNode is null
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


	}

	public void delete(int index)
	{

	}

	public boolean isEmpty()
	{
		return head == null;
	}
}
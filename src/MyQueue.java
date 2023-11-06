import java.util.NoSuchElementException;

public class MyQueue implements QueueADT<Square>{
	/* 
	 * An implementation of the provided QueueADT interface 
	 * that is capable of storing an arbitrarily large amount 
	 * of data. Use a simple (but efficient) linked-node 
	 * implementation.
	*/

	private Node head;
	private Node tail;


	class Node 
	{
		public Square data;
		public Node next;
	}

	public MyQueue() {
		head = null;
		tail = null;
	}

    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    public void enqueue(Square obj) {
		Node nextnode = new Node();
		nextnode.data = obj;
		nextnode.next = null;
		
		if (head == null) {
			head = nextnode;
			tail = nextnode;
			return;
		}
		
		tail.next = nextnode;
		tail = nextnode;
	}

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Square dequeue() {
		if (head == null) throw new NoSuchElementException();
		Square ogdata = head.data;
		head = head.next;
		return ogdata;
	}

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Square front() {
		if (head == null) throw new NoSuchElementException();
		return head.data;
	}

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size() {
		int count = 1;
		Node nodecount = head;
		while(nodecount.next != null) {
			count++;
			nodecount = nodecount.next;
		}
		if (head == null) count = 0;
		return count;
	}

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty() {
		return head == null;
	}

    /**
     * Clear out the data structure
     */
    public void clear() {
		head = null;
		tail = null;
	}
}

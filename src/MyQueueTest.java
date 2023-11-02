public class MyQueueTest {
	
	public static void main(String[] args) {
		MyQueue queueue = new MyQueue();

		System.out.println("isEmpty (true): "+queueue.isEmpty());
		queueue.enqueue(new Square(1, 2, 3));
		queueue.enqueue(new Square(2, 3, 1));
		queueue.enqueue(new Square(3, 4, 2));

		System.out.println("isEmpty (false): "+queueue.isEmpty());
		System.out.println("size (3): "+queueue.size());
		
		System.out.println("front (2, 1, 3): "+queueue.front());
		System.out.println("dequeue (same): "+queueue.dequeue());
		System.out.println("front (3, 2, 1): "+queueue.front());
		System.out.println("size (2): "+queueue.size());

		queueue.clear();
		
		System.out.println("size: "+queueue.size());
 

	}
}

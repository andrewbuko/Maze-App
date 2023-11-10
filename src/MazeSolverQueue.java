public class MazeSolverQueue extends MazeSolver {
	

	private MyQueue queue;

	public MazeSolverQueue(Maze maze){
		super(maze);
	}


  	//create an empty worklist
  	void makeEmpty() {
		this.queue = new MyQueue();

	}

	//return true if the worklist is empty
	boolean isEmpty() {
		return queue.isEmpty();
	}

	//add the given Square to the worklist
	//make sure given Square isn't already in worklist
	void add(Square sq) {
		queue.enqueue(sq);
	}

	//return the "next" item from the worklist
	Square next() {
		return queue.dequeue();
	}

}

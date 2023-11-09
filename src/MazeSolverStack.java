public class MazeSolverStack extends MazeSolver {
    //create an empty worklist
    private MyStack stack;

    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }

	public void makeEmpty()
    {
        stack = new MyStack();
    }

	//return true if the worklist is empty
	public boolean isEmpty()
    {
        return stack.isEmpty();
    }

	//add the given Square to the worklist
	//make sure given Square isn't already in worklist
	public void add(Square sq)
    {
        stack.push(sq);
    }

	//return the "next" item from the worklist
	public Square next()
    {
        return stack.pop();
    }



}

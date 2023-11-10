public class MazeSolverStack extends MazeSolver {
    //create an empty worklist
    private MyStack<Square> stack;
    private Square current;

    public MazeSolverStack(Maze maze)
    {
        super(maze);
        makeEmpty();
        add(maze.getStart());
        current = (Square) this.stack.top();
    }

	public void makeEmpty()
    {
        stack = new MyStack<>();
    }

	//return true if the worklist is empty
	public boolean isEmpty()
    {
        return stack.size() == 0;
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
        return (Square) stack.pop();
    }



}
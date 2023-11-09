import java.util.*;
import java.lang.*;

public abstract class MazeSolver {

    private Maze maze;
	private String finalpath;
  
  	//create an empty worklist
  	abstract void makeEmpty();

	//return true if the worklist is empty
	abstract boolean isEmpty();

	//add the given Square to the worklist
	//make sure given Square isn't already in worklist
	abstract void add(Square sq);

	//return the "next" item from the worklist
	abstract Square next();

	//Create a (non-abstract) constructor that takes a Maze as a parameter and stores it in a variable that the children classes can access.
	public MazeSolver(Maze maze) {	
		this.maze = maze;
		this.finalpath = "";
		makeEmpty();
		add(maze.getStart());
	}

	//A non-abstract method that the application program can use to see if this 
	//algorithm has solved this maze. That is, has it determined the path to the exit or if there is no path.
	//This method will return true if either:
	//A path from the start to the exit has been found; OR
	//You determine there is no such path (worklist is now empty)
	public boolean isSolved() {
		return isEmpty() || !this.finalpath.equals("");
	}

	//Returns either a string of the solution path as a list of coordinates
	//[i,j] from the start to the exit or a message indicating no such path exists
	//If the maze isn't solved, you should probably return a message indicating such.
	public String getPath() {
		try {
			return this.finalpath; 
		}
		catch (Exception e) {
			return "No solution found";

		}
	}

	public Square step() {
		//worklist=empty, so there's "no such path"
		if(isEmpty()) return null; 

		//otherwise grab the next square to compute
		Square currentsq = next();

		if (currentsq == maze.getFinish()) {
			//turn the final path into Xs

			String path = "";
			maze.getFinish().getPrev();
			//find last square
			//trace through previous squares from the last sq until you reach beginning
			//append them to "path"
			Stack<Square> pathlist = new Stack<>();
			Square sq = maze.getFinish();
			while(sq != null) {
				pathlist.push(sq);
				sq.finalPath();
				sq = sq.getPrev();
			}

			sq = null;
			while(!pathlist.empty()) {
				sq = pathlist.pop();
				path += sq.toString();
			}
			this.finalpath = path;

			return currentsq;
		}
		//if the square being processed is not the finish, put neighbors into workload
		
		ArrayList<Square> neighbors = maze.getNeighbors(currentsq);
		for (Square neighbor : neighbors) {
			if (neighbor.getType() == '_') {
				neighbor.setPrev(currentsq);
				neighbor.putWorkList();
				this.add(neighbor);
			}
			if (neighbor.getType() == 'E') {
				neighbor.setPrev(currentsq);
				this.add(neighbor);
			}
		}
		if (currentsq.getType() == '_') currentsq.explored();

		currentsq.explored(); //mark current square as explored
		
		return currentsq;
	}

	//repeatedly call step() until you get to the exit square or the worklist is empty.
	public void solve() {
		while (!this.isSolved()) 
			step();
		getPath();
	}
}

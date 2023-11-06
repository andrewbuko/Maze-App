import java.util.*;

public abstract class MazeSolver {

    private Maze maze;
  
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
		makeEmpty();
		add(maze.getStart());
	}

	//A non-abstract method that the application program can use to see if this 
	//algorithm has solved this maze. That is, has it determined the path to the exit or if there is no path.
	//This method will return true if either:
	//A path from the start to the exit has been found; OR
	//You determine there is no such path (worklist is now empty)
	public boolean isSolved() {
		return isEmpty() || !getPath().equals("");
	}

	//Returns either a string of the solution path as a list of coordinates
	//[i,j] from the start to the exit or a message indicating no such path exists
	//If the maze isn't solved, you should probably return a message indicating such.
	public String getPath() {
		
		String path = "";

		//find last square
		//trace through previous squares from the last sq until you reach beginning
		//append them to "path"
		ArrayList<Square> pathlist = new ArrayList<>();
		Square currentsq = maze.getFinish();
		while(currentsq != null) {
			pathlist.add(currentsq);
			currentsq.finalPath();
			currentsq = currentsq.prev;
		}

		Square sq;
		for (int i = pathlist.size() - 1; i >= 0; i--) {
			sq = pathlist.get(i);
			path += sq.toString();
		}
		
		return path;
	}

	public Square step() {
		//worklist=empty, so there's "no such path"
		if(isEmpty()) return null; 

		//otherwise grab the next square to compute
		Square currentsq = next();

		//if the square being processed is not the finish, put neighbors into workload
		if (currentsq != maze.getFinish()) {
			
			ArrayList<Square> neighbors = maze.getNeighbors(currentsq);
			Square neighbor;
			for (int i = 0; i < neighbors.size(); i++) {
				neighbor = neighbors.get(i);
				//make sure neighbors aren't walls or something
				if(neighbor.getType() == '_' || neighbor.getType() == 'E') {
					neighbor.prev = currentsq; //make sure neighbor squares know "parent" square
					neighbor.putWorkList(); //changes neighbors' char status to reflect it being on the worklist
					add(neighbor); //actually put the sq in a worklist 
				}
			}
			currentsq.explored(); //mark current square as explored
		}
		return currentsq;
	}

	//repeatedly call step() until you get to the exit square or the worklist is empty.
	public void solve() {
		while (!isEmpty() || maze.getFinish().prev == null) 
			step();
	}
}
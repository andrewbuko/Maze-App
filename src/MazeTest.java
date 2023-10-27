import java.util.*;

public class MazeTest {

	public static void main(String[] args) {

		Maze maze = new Maze()

		maze.loadMaze("src\\maze-1");
		System.out.println(maze);
		System.out.println("getstart: "+ maze.getStart());
		System.out.println("getfinish: "+ maze.getFinish());

		System.out.print("neighbors of start: ");
		ArrayList<Square> sqs = maze.getNeighbors(maze.getStart());
		for (Square sq : sqs) {
			System.out.print(sq + " ");
		}
		System.out.print("neighbors of end: ");
		sqs = maze.getNeighbors(maze.getFinish());
		for (Square sq : sqs) {
			System.out.print(sq + " ");
		}
		
		maze.reset();
		System.out.println(maze);
	}
}
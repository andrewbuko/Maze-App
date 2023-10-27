public class Maze {
    private int rows;
    private int cols;
    private Square[][] maze;

    //A constructor that takes no arguments
    //NOTE: you can just omit writing a constructor and Java will just use the default values, the real work will be done with the loadMaze() method described next.
    public Maze()



    //load the maze that is contained in the file named fname. The format of the file is described above. As a quick refresher, here is how you can declare a 2D array and fill it:
     //If you encounter a problem while reading in the file, you should return false to indicate that it failed. Returning true indicates that you have now loaded the file from disk successfully.
    //Be sure to catch the exception that is raised if the user specifies an incorrect file and print out an appropriate error message when this occurs and return false. Don't just let the program crash dumping the stack trace to the user.
    boolean loadMaze(String fname)
    {
        this.maze = new Square[numRows][numCols];
        
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                maze[row][col] = null;
            }
        }
    }         
    //return an ArrayList of the Square neighbors of the parameter Square sq. There will be at most four of these (to the North, East, South, and West) and you should list them in that order.
    //If the square is on a border, skip over directions that are out of bounds of the maze. Don't be adding in null values.
    ArrayList<Square> getNeighbors(Square sq)
    
    Square getStart()
    Square getFinish()
    /*
     * Return the maze back to the initial state after loading. 
     * Erase any marking on squares (e.g., visited or worklist) but keep the layout.
    One way you might do this is by giving each Square a reset() method too, and then just loop through the squares and asking them to reset themselves.
     */
    void reset()


    String toString()
    
}
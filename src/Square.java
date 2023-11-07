

public class Square {
	private int row, col;
	private char type;
	private char ogtype;
	public Square prev;

	/**
	 *     _ - empty space (0)
	 * 	   # - wall        (1)
     *     S - Start       (2)
     *     E - Exit        (3)

     *     o - is on the solver work list
     *     . - has been explored
     *     x - is on the final path to the exit
	 */

	public Square(int row, int col, int type) {
		this.prev = null;
		this.row = row;
		this.col = col;
		this.prev = null;
		switch (type) {
			case 0:
				this.type = '_';
				break;
			case 1:
				this.type = '#';
				break;
			case 2:
				this.type = 'S';
				break;
			case 3:
				this.type = 'E';
				break;
			default:
				this.type = '\0';	
		}
		ogtype = this.type;
	}

	public void putWorkList() {
		type = 'o';
	}
	public void explored() {
		type = '.';
	}
	public void finalPath() {
		type = 'x';
	}
	public void reset() {
		if (type != ogtype) {
			type = ogtype;
		}
	}

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public char getType() {
		return type;
	}

	public String toString() {
		return "(" + col + ", " + row + ") " + type;
	}
}
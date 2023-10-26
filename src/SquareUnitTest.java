public class SquareUnitTest {

	public static void main(String[] args) {

		Square sq = new Square(1, 2, 3);
		System.out.println(sq);
		System.out.println(sq.getCol());
		System.out.println(sq.getRow());
		System.out.println(sq.getType());
		sq.explored();
		System.out.println(sq);
		sq.putWorkList();
		System.out.println(sq);
		sq.finalPath();
		System.out.println(sq);

	}
}
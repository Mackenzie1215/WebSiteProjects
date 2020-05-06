
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MazeProj {

	public static void main(String[] args) {
//create variable SOLVABLE to tell us if the maze was solved or not 
		int SOLVABLE = 0;
		
//keep running program till it finds a solution for a maze
		while (SOLVABLE == 0) {
			
//create maze array
				int[][] maze = new int[10][10];
				int value = 1;
		for (int row = 0; row <= 9; row++) {
			for (int col = 0; col <= 9; col++) {

//setting the barriers around the edge
			if (row == 0 || row == 9 || col == 0 || col == 9)
				maze[row][col] = value;

//setting the random walls in the maze
				Random R = new Random();
			if (maze[row][col] == 0) {
			if (row == 2 || row == 4 || row == 6) {
			if (R.nextInt(10) < 5)
				maze[row][col] = value;
						}
			if (col == 2 || col == 4 || col == 6) {
			if (R.nextInt(10) > 5)
				maze[row][col] = value;
						}
					}
				}
			}
//setting random start and finish points
				int ZERO = 0;
				Random random = new Random();
				int X = random.nextInt(8);
			while (ZERO == 0) {
				X = random.nextInt(8);
			if (X != 9 && X > 5) {
					ZERO = 1;
				}
			}
				ZERO = 0;
				int Y = random.nextInt();
			while (ZERO == 0) {
				Y = random.nextInt(8);
			if (Y != 0 && X != 9) {
				ZERO = 1;
				}
			}
				ZERO = 0;
				int X2 = random.nextInt(8);
			while (ZERO == 0) {
				X2 = random.nextInt(8);
			if (X2 < 5 && X2 != 0) {
				ZERO = 1;
				}
			}
				ZERO = 0;
				int Y2 = random.nextInt();
			while (ZERO == 0) {
				Y2 = random.nextInt(8);
				if (Y2 != 0 && Y2 != 9) {
					ZERO = 1;
				}
			}
//set our start point on maze
	maze[X2][Y2] = 7;

//set finish Point on maze
	maze[X][Y] = 4;

//initialize our maze into the mazeSolver class
	MazeProj solve = new MazeProj(maze);
	String[][] unsolved = new String[10][10];
			
//out print message 
	System.out.println(" Mackenzie Hagerty Maze Project\n" 
	+ " CIT260 Data Structures \n	"
	+ "\n This maze project creates a random start point\n"
	+ " and a random finish point and uses a breadth first\n"
	+ " search alrorithm to find the shortest path through \n"
	+ " the maze. when it cannot solve the maze it generates\n"
	+ " a new random maze and keeps trying until it finds a\n" 
	+ " succesful path through the maze \n\n"
	+ "	Unsolved maze");
			
//out prints maze before it is solved
			solve.toMaze();

//create our array to show path from start to finish on
			int Display[][] = new int[10][10];
			
		try {

//initialize out start point to Perform Breadth First Search
				Point p = BFS(X2, Y2);
				Display[X2][Y2] = 7;
// find our path back by calling the parent of our current point
				while (p.getParent() != null) {
					Display[p.getX()][p.getY()] = 5;
					p = p.getParent();
				}
//put our path onto our original board
			for (int row = 0; row < 10; row++) {
				for (int col = 0; col < 10; col++) {

				if (board[row][col] == 2) {
				board[row][col] = Display[row][col];
					}
				}
			}

// out prints solved board
				System.out.println("	Maze Solved\n");
				solve.toMaze();

/*
 *we set SOLVABLE = 1 so if it is solvable and it does not catch
 * an exception it will stop running and print out the solved board
 */				SOLVABLE = 1;

//when there is no path the program throws the exception 
		} catch (NullPointerException E) {

//if an exception is caught then the maze was unsolvable so we set SOLVABLE
//back to 0 so it runs the program over again
				SOLVABLE = 0;
			}
		}
	}

//create our nonstatic board 
	private static int[][] board;

//create out method to initiate what ever board we call to this method as board
	public MazeProj(int[][] board) {
				MazeProj.board = new int[10][10];

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				MazeProj.board[row][col] = board[row][col];
			}
		}

	}

//create our point class
	private static class Point {
		int x;
		int y;
		Point parent;

//create our method to call X
		public int getX() {
			return x;
		}

//create our method to call Y
		public int getY() {
			return y;
		}

// create our class where we define the variables
		public Point(int x, int y, Point parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}

//create our method to call parent
		public Point getParent() {
			return this.parent;
		}

	}

//create our queue to solve board
	public static Queue<Point> q = new LinkedList<Point>();

//create our BFS method
	public static Point BFS(int x, int y) {

//add our starting point the the queue to begin process
		q.add(new Point(x, y, null));

		while (!q.isEmpty()) {
//grab our point to work with
			Point p = q.remove();
//see if it is the finish point
			if (board[p.x][p.y] == 4) {
				return p;
			}
//check the boxes surrounding our current point are empty
			if (isOkay(p.x + 1, p.y)) {
				board[p.x][p.y] = 2;
				Point nextP = new Point(p.x + 1, p.y, p);
				q.add(nextP);
			}

			if (isOkay(p.x - 1, p.y)) {
				board[p.x][p.y] = 2;
				Point nextP = new Point(p.x - 1, p.y, p);
				q.add(nextP);
			}

			if (isOkay(p.x, p.y + 1)) {
				board[p.x][p.y] = 2;
				Point nextP = new Point(p.x, p.y + 1, p);
				q.add(nextP);
			}

			if (isOkay(p.x, p.y - 1)) {
				board[p.x][p.y] = 2;
				Point nextP = new Point(p.x, p.y - 1, p);
				q.add(nextP);
			}

		}
		return null;
	}

//create our method to set parameters for what is and isn't okay
	public static boolean isOkay(int x, int y) {
		if (board[x][y] == 8 || y < board[x].length && (board[x][y] == 0 || board[x][y] == 4)) {
			return true;
		}
		return false;

	}

	public static int numOfPlus = 0;

//create our method to display our solved maze
	public static void toMaze() {
		String[][] stringMaze = new String[10][10];
		for (int row = 0; row < 10; row++) {
			System.out.print("     ");
			for (int col = 0; col < 10; col++) {
				if (board[row][col] == 1) {
					stringMaze[row][col] = "O";
				}
				if (board[row][col] == 0) {
					stringMaze[row][col] = " ";
				}
				if (board[row][col] == 7) {
					stringMaze[row][col] = "S";
				}
				if (board[row][col] == 4) {
					stringMaze[row][col] = "F";
				}
				if (board[row][col] == 5) {
					stringMaze[row][col] = "+";
					numOfPlus++;
				}

				System.out.print(stringMaze[row][col]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		System.out.println("_");
	}
}

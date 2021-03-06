package _04_Maze_Maker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		
		Random ran = new Random();
		
		
		
		Cell c = maze.cells[randGen.nextInt(maze.cells.length)][randGen.nextInt(maze.cells.length)];
		
		//5. call selectNextPath method with the randomly selected cell
		
		
		selectNextPath(c);
		
		Cell b = maze.cells[randGen.nextInt(maze.cells.length)][randGen.nextInt(maze.cells.length)];
		b.set
		
		
		
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		
		currentCell.setBeenVisited(true);

		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		
			ArrayList <Cell> unvisitedNeighs = getUnvisitedNeighbors(currentCell);
			
		//C. if has unvisited neighbors,
			
			if(unvisitedNeighs.size() > 0){
				
			
		
			//C1. select one at random.
				
				int r = randGen.nextInt(unvisitedNeighs.size());
				
			//C2. push it to the stack
				
			Cell ran =	unvisitedNeighs.get(r);
	
			uncheckedCells.push(ran);
			
			
			//C3. remove the wall between the two cells
			
			removeWalls(ran, currentCell);

			//C4. make the new cell the current cell and mark it as visited
		
			currentCell = ran;
			
			currentCell.setBeenVisited(true);
			
			//C5. call the selectNextPath method with the current cell
			
			selectNextPath(currentCell);
			
			
			}
		//D. if all neighbors are visited
		
			if(unvisitedNeighs.size() == 0) {
				
				if(uncheckedCells.size() > 0) {
					
					Cell poppedCell = uncheckedCells.pop();
					
					currentCell = poppedCell;
					
					selectNextPath(currentCell);
					
				}
				
			}
			
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX() == c2.getX()) {
			if(c1.getY() > c2.getY()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			}
			
			else {
				
				c2.setNorthWall(false);
				c1.setSouthWall(false);
				
			}
		}
		
		else {
			
			if(c1.getX() > c2.getX()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			}
			
		
		
		else { 
			
			c2.setWestWall(false);
			c1.setEastWall(false);
			
			
		}
			
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
	
		ArrayList<Cell> unvisited = new ArrayList<Cell>();
		
		Cell left;
		
		if(c.getX() > 0) {
			left = maze.getCell(c.getX() - 1, c.getY());
			
			if(left.hasBeenVisited()==false) {
				
				unvisited.add(left);
				
			}
			
		}
		
		Cell right;
		
		if(c.getX() < width - 1) {
		
		right = maze.getCell(c.getX()+1, c.getY());
		
		if(right.hasBeenVisited()==false) {
			
			unvisited.add(right);
			
			}
		
		}
		
		Cell up;
		
		if(c.getY()>0) {
		
			up = maze.getCell(c.getX(), c.getY()-1);
			
			if(up.hasBeenVisited()==false) {
				
				unvisited.add(up);
				
			}
			
		}
		
		
		Cell down;
		
		if(c.getY() < height-1) {
		
		down = maze.getCell(c.getX(), c.getY()+1);
		
		if(down.hasBeenVisited()==false) {
			
			unvisited.add(down);
			
		}
		
		}
		
		
		return unvisited;
		
		
	}
}

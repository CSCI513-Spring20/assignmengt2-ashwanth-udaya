
import java.awt.Point;
import java.util.Random;

public class OceanMap {

	int dimension = 10;
	int islandCount = 10;
	int[][] myGrid;
	Random rand = new Random();
	Point currentShipLocation;
	Point currentPirateShipLocation, secondPirateShipLocation;

	public OceanMap() {
		myGrid = new int[this.dimension][this.islandCount];
		for (int x = 0; x < this.dimension; x++)
			for (int y = 0; y < this.islandCount; y++)
				myGrid[x][y] = 0;

		placeIslands();
		currentShipLocation = placeCCShip();
		currentPirateShipLocation = placePirateShip();
		secondPirateShipLocation = placeSecondPirateShip();
	}

	// Return generated map
	public int[][] getMap() {
		return myGrid;
	}

	public void placeIslands() {
		int count = this.islandCount;
		do {
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if (myGrid[x][y] == 0) {
				myGrid[x][y] = 1;
				count--;
			}
		} while (count > 0);
	}

	public Point placeCCShip() {
		
		int x = rand.nextInt(10);
		int y = rand.nextInt(10);
		boolean CellOccupied = false;
		do {
			if (myGrid[x][y] == 0) {
				CellOccupied = true;
				myGrid[x][y] = 2;
			}
		} while (!CellOccupied);
		return new Point(x, y);
	}

	public Point placePirateShip() {
		
		int x = rand.nextInt(10);
		int y = rand.nextInt(10);
		boolean CellOccupied = false;
		do  {
			if (myGrid[x][y] == 0 && myGrid[x][y] != 2) {
				CellOccupied = true;
				myGrid[x][y] = 3;
			}
		} while(!CellOccupied);
		return new Point(x, y);
	}
	
	public Point placeSecondPirateShip() {
		
		int x = rand.nextInt(5);
		int y = rand.nextInt(5);
		boolean CellOccupied = false;
		while (!CellOccupied) {
			if (myGrid[x][y] == 0 && myGrid[x][y] != 2) {
				CellOccupied = true;
				myGrid[x][y] = 3;
			}
		}
		return new Point(x, y);
	}

	public Point getShipLocation() {
		return currentShipLocation;
	}

	public Point getPirateShipLocation() {
		return currentPirateShipLocation;
	}
	
	public Point getSecondPirateShipLocation() {
		return secondPirateShipLocation;
	}

}

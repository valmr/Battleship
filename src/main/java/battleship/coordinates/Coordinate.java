package battleship.coordinates;

public class Coordinate {
	private int xCoordinate;
	private int yCoordinate;
	
	public Coordinate(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}
	
}

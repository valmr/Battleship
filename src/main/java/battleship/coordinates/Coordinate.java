package battleship.coordinates;

import java.util.Collection;
import java.util.Set;

public class Coordinate {
	private int xCoordinate;
	private int yCoordinate;
	
	public Coordinate(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public static boolean checkIfCoordinatesAreContainedInThisCollection(Collection<Coordinate> givenCoordinates, 
																	     Coordinate 		    testCoordinate) {
		boolean coordinatesContained = false;
		
		for(Coordinate coordinate : givenCoordinates) {
			if(coordinate.getxCoordinate() == testCoordinate.getxCoordinate() &&
			   coordinate.getyCoordinate() == testCoordinate.getyCoordinate() ) {
				coordinatesContained = true;
				break;
			}
		}
		
		return coordinatesContained;
	}
	
	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	@Override
	public String toString() {
		return "Coordinate [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + "]";
	}	
}

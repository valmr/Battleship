package battleship.gameparts;

import java.util.HashSet;
import java.util.Set;

public class Board {
	private int xLength;
	private int yLength;
	private Set<Ship> ships;
	
	public Board(int xLength, int yLength){
		this.xLength = xLength;
		this.yLength = yLength;
		this.ships = new HashSet<Ship>();
	}
	
	public Board(int xLength, int yLength, Set<Ship> ships){
		this.xLength = xLength;
		this.yLength = yLength;
		
		for(Ship ship : ships){
			this.addShip(ship);
		}
	}

	public void addShip(Ship newShip){
		if(hasNoOverlapWithOtherShips(newShip)){
			this.addShip(newShip);
		}
		else {
			System.out.println("ERROR: This ship overlaps with one of the other ships!");
		}
	}

	private boolean hasNoOverlapWithOtherShips(Ship newShip) {		
		boolean noOverlapWithOtherShips = true;		
		for(Ship ship : this.ships){
			if(ship.getCoordinates().contains(newShip.getCoordinates())){
				noOverlapWithOtherShips = false;
				break;
			}
		}
		
		return noOverlapWithOtherShips;
	}
	
	public int getxLength() {
		return xLength;
	}

	public int getyLength() {
		return yLength;
	}

	public Set<Ship> getShips() {
		return ships;
	}
	
	
}

















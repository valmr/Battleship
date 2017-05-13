package battleship.gameparts;

import java.util.Set;

import battleship.coordinates.Coordinate;

public class Ship {
	private Set<Coordinate> coordinates;
	private int length;
	private int numberOfHits;
	private boolean isDestroyed;
	
	public Ship(Set<Coordinate> coordinates){
		if(coordinates != null && coordinates.size() > 0){
			this.coordinates = coordinates;
			this.length = coordinates.size();
			this.numberOfHits = 0;
			this.isDestroyed = false;
		}
		else {
			System.out.println("ERROR: Can't create Ship - no coordinates given!");
		}
	}
	
	public void receiveHit(){
		System.out.println("You have hit a ship!");
		if(!isDestroyed()){
			this.numberOfHits++;
			if(this.numberOfHits == this.length) {
				destroy();
			}
		}
	}

	private void destroy() {
		System.out.println("Boom! This ship has been destroyed!");
		this.isDestroyed = true;
	}

	public Set<Coordinate> getCoordinates() {
		return coordinates;
	}

	public int getLength() {
		return length;
	}

	public int getNumberOfHits() {
		return numberOfHits;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public String toString() {
		return "Ship [coordinates=" + coordinates + ", length=" + length + ", numberOfHits=" + numberOfHits
				+ ", isDestroyed=" + isDestroyed + "]";
	}
	
	
}





















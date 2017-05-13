package battleship.game;

import java.util.HashSet;
import java.util.Set;

import battleship.coordinates.Coordinate;
import battleship.gameparts.Board;
import battleship.gameparts.Ship;

public class Game {
	private Board board;
	private int numberOfRemainingShots;
	private Set<Coordinate> alreadyHitFields;
	
	public Game(int xLength, int yLength, int numberOfShots){
		this.board = new Board(xLength, yLength);
		this.numberOfRemainingShots = numberOfShots;
		this.alreadyHitFields = new HashSet<Coordinate>();
	}
	
	public void runGame() {		
		showGameSpecifiactions();
		
		for( ; this.numberOfRemainingShots > 0; this.numberOfRemainingShots--) {
		
			showNumberOfRemainingShots();
			
			Coordinate shotCoordinates = null;
			while(true) {
				shotCoordinates = getShotCoordinatesFromUser();
				if(isShotWithinBoardLimits(shotCoordinates)) {
					if(!hasThisFieldAlreadyBeenShot(shotCoordinates)) {
						this.alreadyHitFields.add(shotCoordinates);
						break;
					}
					else {
						System.out.println("This field has already been shot before...");
					}				
				}
				else {
					System.out.println("This shot is outside the board limits!");
				}
				
				System.out.println("Since I'm nice, I'll let you try again...");
			}
			
			if(isAShipBeingHitByTheUsersShot(shotCoordinates)) {
				Ship hitShip = getHitShip(shotCoordinates);
				hitShip.receiveHit();
				
				System.out.println("You've hit a ship!");
				
				if(areAllShipsDestroyed()){
					showGloriousVictory();
					return;
				}
			}
			else {
				System.out.println("You missed!");
			}
		
		}
		
		showDefeat();		
	}
	
	private void showDefeat() {		
		System.out.println("You missed your last shot!");
		System.out.println("You lose, loser! Try harder next time, or just get a life...");		
	}

	private void showGloriousVictory() {
		System.out.println("Congratulations! You have destroyed all the ships!");
		System.out.println("You are the glorious winner!");
	}

	private boolean areAllShipsDestroyed() {
		
		boolean allShipsDestroyed = true;
		
		for(Ship ship : this.board.getShips()) {
			allShipsDestroyed = ship.isDestroyed() && allShipsDestroyed;
		}
		
		return allShipsDestroyed;
	}

	private Ship getHitShip(Coordinate shotCoordinates) {
		
		Ship hitShip = null;
		
		for(Ship ship : this.board.getShips()) {
			if(ship.getCoordinates().contains(shotCoordinates)) {
				hitShip = ship;
				break;
			}
		}
		
		return hitShip;
	}

	private boolean isAShipBeingHitByTheUsersShot(Coordinate shotCoordinates) {
		boolean isAShipHit = false;
		for(Ship ship : this.board.getShips()) {
			if(ship.getCoordinates().contains(shotCoordinates)) {
				isAShipHit = true;
				break;
			}
		}
		return isAShipHit;
	}

	private boolean hasThisFieldAlreadyBeenShot(Coordinate shotCoordinates) {
		return this.alreadyHitFields.contains(shotCoordinates);
	}

	private boolean isShotWithinBoardLimits(Coordinate shotCoordinates) {
		return (shotCoordinates.getxCoordinate() >= 1 && shotCoordinates.getxCoordinate() <= board.getxLength()) && 
			   (shotCoordinates.getyCoordinate() >= 1 && shotCoordinates.getyCoordinate() <= board.getyLength());
	}

	public void setupGame() {
		// Destroyers
		Set<Coordinate> coordinatesDestroyer1 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(1,1));
		coordinatesDestroyer1.add(new Coordinate(2,1));
		
		Set<Coordinate> coordinatesDestroyer2 = new HashSet<Coordinate>();
		coordinatesDestroyer2.add(new Coordinate(7,2));
		coordinatesDestroyer2.add(new Coordinate(7,2));
		
		Set<Coordinate> coordinatesDestroyer3 = new HashSet<Coordinate>();
		coordinatesDestroyer3.add(new Coordinate(5,8));
		coordinatesDestroyer3.add(new Coordinate(6,8));
		
		// Cruisers
		Set<Coordinate> coordinatesCruiser1 = new HashSet<Coordinate>();
		coordinatesCruiser1.add(new Coordinate(1,10));
		coordinatesCruiser1.add(new Coordinate(2,10));
		coordinatesCruiser1.add(new Coordinate(3,10));
		
		Set<Coordinate> coordinatesCruiser2 = new HashSet<Coordinate>();
		coordinatesCruiser2.add(new Coordinate(3,3));
		coordinatesCruiser2.add(new Coordinate(3,4));
		coordinatesCruiser2.add(new Coordinate(3,5));
		
		// Carriers
		Set<Coordinate> coordinatesCarrier1 = new HashSet<Coordinate>();
		coordinatesCarrier1.add(new Coordinate(9,9));
		coordinatesCarrier1.add(new Coordinate(9,8));
		coordinatesCarrier1.add(new Coordinate(9,7));
		coordinatesCarrier1.add(new Coordinate(9,6));
		coordinatesCarrier1.add(new Coordinate(9,5));
		
		Ship destroyer1 = new Ship(coordinatesDestroyer1);
		Ship destroyer2 = new Ship(coordinatesDestroyer2);
		Ship destroyer3 = new Ship(coordinatesDestroyer3);
		Ship cruiser1   = new Ship(coordinatesCruiser1);
		Ship cruiser2   = new Ship(coordinatesCruiser2);
		Ship carrier1   = new Ship(coordinatesCarrier1);
		
		this.board.addShip(destroyer1);
		this.board.addShip(destroyer2);
		this.board.addShip(destroyer3);
		this.board.addShip(cruiser1);
		this.board.addShip(cruiser2);
		this.board.addShip(carrier1);		
	}

	private Coordinate getShotCoordinatesFromUser() {
		
		System.out.print("Enter the x coordinate of your shot: ");
		int xCoordinateOfShot = new java.util.Scanner(System.in).nextInt();
		
		System.out.print("Enter the y coordinate of your shot: ");		
		int yCoordinateOfShot = new java.util.Scanner(System.in).nextInt();
		
		return new Coordinate(xCoordinateOfShot, yCoordinateOfShot);
	}

	private void showNumberOfRemainingShots() {
		if(this.numberOfRemainingShots > 1)
			System.out.println("You still have " + this.numberOfRemainingShots + " shots.");
		else if(this.numberOfRemainingShots == 1)
			System.out.println("This is your last shot, good luck!");
	}

	private void showGameSpecifiactions() {
		System.out.println("Welcome to Battleship!");
		System.out.println("The board has dimensions of (width)x(height) = " + 
						   this.board.getxLength() + "x" + this.board.getyLength());		
	}

	public Board getBoard() {
		return board;
	}

	public int getNumberOfRemainingShots() {
		return numberOfRemainingShots;
	}
	
	
}

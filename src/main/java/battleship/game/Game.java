package battleship.game;

import java.util.HashSet;
import java.util.Set;

import battleship.coordinates.Coordinate;
import battleship.gameparts.Board;
import battleship.gameparts.Ship;

public class Game {
	private Board board;
	private int numberOfRemainingShots;
	
	public Game(int xLength, int yLength, int numberOfShots){
		this.board = new Board(xLength, yLength);
		this.numberOfRemainingShots = numberOfShots;
	}
	
	public void runGame() {
//		showGameSpecifiactions();
//		
//		showNumberOfRemainingShots();
//		
//		Coordinate shotCoordinates = getShotCoordinatesFromUser();
	}
	
	private void setupGame() {
		// Destroyers
		Set<Coordinate> coordinatesDestroyer1 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(1,1));
		coordinatesDestroyer1.add(new Coordinate(2,1));
		
		Set<Coordinate> coordinatesDestroyer2 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(7,2));
		coordinatesDestroyer1.add(new Coordinate(7,2));
		
		Set<Coordinate> coordinatesDestroyer3 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(5,8));
		coordinatesDestroyer1.add(new Coordinate(6,8));
		
		// Cruisers
		Set<Coordinate> coordinatesCruiser1 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(1,10));
		coordinatesDestroyer1.add(new Coordinate(2,10));
		coordinatesDestroyer1.add(new Coordinate(3,10));
		
		Set<Coordinate> coordinatesCruiser2 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(3,3));
		coordinatesDestroyer1.add(new Coordinate(3,4));
		coordinatesDestroyer1.add(new Coordinate(3,5));
		
		// Carriers
		Set<Coordinate> coordinatesCarrier1 = new HashSet<Coordinate>();
		coordinatesDestroyer1.add(new Coordinate(9,9));
		coordinatesDestroyer1.add(new Coordinate(9,8));
		coordinatesDestroyer1.add(new Coordinate(9,7));
		coordinatesDestroyer1.add(new Coordinate(9,6));
		coordinatesDestroyer1.add(new Coordinate(9,5));
		
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
		return null;
	}

	private void showNumberOfRemainingShots() {
		System.out.println("You have " + this.numberOfRemainingShots + " shots remaining!");		
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

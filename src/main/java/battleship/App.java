package battleship;

import battleship.game.Game;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {

	public static void main(String[] args) {
		
		Game game = new Game(10, 10, 100);
		game.createAndPlaceShips();
//		System.out.println(game.getBoard());
		game.runGame();
	}

}

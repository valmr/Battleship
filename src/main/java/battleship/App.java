package battleship;

import battleship.game.Game;

public class App {

	public static void main(String[] args) {
		
		Game game = new Game(10, 10, 3);
		game.createAndPlaceShips();
//		System.out.println(game.getBoard());
		game.runGame();
	}

}

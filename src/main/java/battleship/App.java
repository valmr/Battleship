package battleship;

import battleship.game.Game;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game = new Game(10, 10, 100);
		game.createAndPlaceShips();
		System.out.println(game.getBoard());
		//game.runGame();
	}

}

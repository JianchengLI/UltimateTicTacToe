package perso.tictactoe.game.test;

import org.junit.Test;

import perso.tictactoe.game.Game;

public class TestUserCase {

	@Test
	public void testUserCase() {
		Game game = new Game();
		game.enableConsole();
		game.display();
	}

}

package perso.tictactoe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import perso.tictactoe.game.Game;
import perso.tictactoe.game.Placement;
import perso.tictactoe.game.Player;
import perso.tictactoe.game.Position;

public class TestPlayer {
	@Test
	public void testPlayByIndex(){
		Game game = new Game();
		game.disableConsole();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		
		player1.play(0, 0);
		assertEquals(Placement.CIRCLE, game.getTableBoard()[0][0].getPlacement());
		player2.play(1, 2);
		assertEquals(Placement.CROSS, game.getTableBoard()[1][2].getPlacement());
	}
	
	@Test
	public void testPlayByPosition(){
		Game game = new Game();
		game.enableConsole();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		
		player1.play(Position.LEFT, Position.LEFT);
		assertEquals(Placement.CIRCLE, game.getTableBoard()[4][0].getPlacement());
		player2.play(Position.LEFT, Position.RIGHT);
		assertEquals(Placement.CROSS, game.getTableBoard()[4][2].getPlacement());
	}
}

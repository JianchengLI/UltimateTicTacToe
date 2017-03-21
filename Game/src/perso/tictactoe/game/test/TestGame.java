package perso.tictactoe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;
import perso.tictactoe.game.*;

public class TestGame {
	@Test
	public void testCheckerboardDisplay() {
		Player player1 = new Player("Player1", Placement.CIRCLE);
		Player player2 = new Player("Player2", Placement.CROSS);
		Game game =  new Game(player1,player2);
		game.disableConsole();
		game.display();
		
		Player[] players = game.getPlayers();
		assert players[0].getName() == "Player1";
		assert players[0].getPlacement() ==  Placement.CIRCLE;
		assert players[1].getName() == "Player2";
		assert players[1].getPlacement() ==  Placement.CROSS;
		
		assertEquals(game.getCurrentPlayer().getName(),"Player1");
	}
	
	@Test
	public void testPlayByPositionFailed(){
		System.out.println("\nTestPlayByPositionFailed :\n");
		Player player1 = new Player("Player1", Placement.CIRCLE);
		Player player2 = new Player("Player2", Placement.CROSS);
		Game game =  new Game(player1,player2);
		
		assert game.play(Position.LEFT,Position.LEFT);
		assertEquals(game.getCurrentPlayer().getName(),"Player2");
		assertFalse(game.play(Position.LEFT,Position.LEFT));
		assertEquals(game.getCurrentPlayer().getName(),"Player2");
	}
	
	@Test
	public void testPlayByIndexFailed(){
		System.out.println("\nTestPlayByIndexFailed :\n");
		Player player1 = new Player("Player1", Placement.CIRCLE);
		Player player2 = new Player("Player2", Placement.CROSS);
		Game game =  new Game(player1,player2);
		
		assert game.play(0,0);
		assertEquals(game.getCurrentPlayer().getName(),"Player2");
		assertFalse(game.play(0,0));
		assertEquals(game.getCurrentPlayer().getName(),"Player2");
	}
	
	public void testPlayByPosition(){
		// TODO :
	}
	
	public void testPlayByIndex(){
		// TODO :
	}
}

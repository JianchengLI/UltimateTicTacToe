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
		game.display();
		
		Player[] players = game.getPlayers();
		assert players[0].getName() == "Player1";
		assert players[0].getPlacement() ==  Placement.CIRCLE;
		assert players[1].getName() == "Player2";
		assert players[1].getPlacement() ==  Placement.CROSS;
		
		assertEquals(game.getCurrentPlayer().getName(),"Player1");
	}
	
	public void testPlayByPositionFailed(){
		// TODO :
	}
	
	public void testPlayByIndexFailed(){
		// TODO :
	}
	
	public void testPlayByPosition(){
		// TODO :
	}
	
	public void testPlayByIndex(){
		// TODO :
	}
}

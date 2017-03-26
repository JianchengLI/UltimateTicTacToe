package perso.tictactoe.game.test;

import static org.junit.Assert.*;

import java.awt.GraphicsEnvironment;
import java.util.Vector;

import org.junit.Test;
import perso.tictactoe.game.*;

public class TestGame {
	@Test
	public void testCheckerboardDisplay() {
		Game game =  new Game();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
	
		game.disableConsole();
		game.display();
		
		Vector<Player> players = game.getPlayers();
		assert players.get(0).getName() == player1.getName();
		assert players.get(0).getPlacement() ==  player1.getPlacement();
		assert players.get(1).getName() == player2.getName();
		assert players.get(1).getPlacement() ==  player2.getPlacement();
		
		assertEquals(game.getCurrentPlayer().getName(),player1.getName());
	}
	
	@Test
	public void testPlayByPositionFailed(){
		Game game =  new Game();
		game.disableConsole();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		
		assert game.play(player1,Position.LEFT,Position.LEFT);
		assertEquals(game.getCurrentPlayer().getName(), player2.getName());
		
		assertFalse(game.play(player1, Position.LEFT,Position.TOP_LEFT)); // Same player
		assertFalse(game.play(player2, Position.LEFT,Position.LEFT)); // Same place
		assertEquals(game.getCurrentPlayer().getName(), player2.getName());
	}
	
	@Test
	public void testPlayByIndexFailed(){
		Game game =  new Game();
		game.disableConsole();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		
		assert game.play(player1,0,0);
		assertEquals(game.getCurrentPlayer().getName(),player2.getName());
		
		assertFalse(game.play(player1,0,1)); // Same player
		assertFalse(game.play(player2,0,0)); // Same place
		assertEquals(game.getCurrentPlayer().getName(),player2.getName());
	}
	
	@Test
	public void testPlayByPosition(){
		Game game =  new Game();
		game.disableConsole();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		
		assertEquals(game.getCurrentPlayer(),player1);
		assertFalse(game.play(player2, Position.LEFT, Position.LEFT));
		
		assertTrue(game.play(player1, Position.LEFT, Position.LEFT));
		assertEquals(Placement.CIRCLE, game.getTableBoard()[4][0].getPlacement());
		
		assertFalse(game.play(player1, Position.LEFT, Position.RIGHT));
		assertTrue(game.play(player2, Position.LEFT, Position.RIGHT));
		assertEquals(Placement.CROSS, game.getTableBoard()[4][2].getPlacement());
	}
	
	@Test
	public void testPlayByIndex(){
		Game game = new Game();
		game.disableConsole();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		
		assertEquals(game.getCurrentPlayer(), player1);
		assertFalse(game.play(player2, 4, 0));
		
		assertTrue(game.play(player1, 4, 0));
		assertEquals(Placement.CIRCLE, game.getTableBoard()[4][0].getPlacement());
		
		assertFalse(game.play(player1, 4, 2));
		assertTrue(game.play(player2, 4, 2));
		assertEquals(Placement.CROSS, game.getTableBoard()[4][2].getPlacement());
	}
	
	@Test
	public void testSwitchEnableCase(){
		Game game = new Game();
		game.disableConsole();
		for (int i = 0; i < game.getTableBoard().length; i++) {
			Case[] cases = game.getTableBoard()[i];
			for (int j = 0; j < cases.length; j++) {
				assertTrue(cases[j].isEnable());
			}
		}
		game.display();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		assertTrue(game.play(player1, 4, 0));
		Case[] tableCase = game.getCheckerBoard().getChildren().get();
		for (int i = 0; i < tableCase.length; i++) {
			if (i== 3)
				continue;
			assertFalse(tableCase[i].isEnable());
		}
		
		assertFalse(game.play(player2, Position.TOP, Position.MID));
		assertTrue(game.play(player2, Position.LEFT, Position.MID));
	}
	
	@Test
	public void testSwitchEnableCaseWithAlreadyPlacement(){
		Game game = new Game();
		game.enableConsole();
		for (int i = 0; i < game.getTableBoard().length; i++) {
			Case[] cases = game.getTableBoard()[i];
			for (int j = 0; j < cases.length; j++) {
				assertTrue(cases[j].isEnable());
			}
		}
		game.display();
		Player player1 = new Player("Player1", Placement.CIRCLE, game);
		Player player2 = new Player("Player2", Placement.CROSS, game);
		assertTrue(game.play(player1, 4, 0));
		Case[] tableCase = game.getCheckerBoard().getChildren().get();
		for (int i = 0; i < tableCase.length; i++) {
			if (i== 3)
				continue;
			assertFalse(tableCase[i].isEnable());
		}
		
		assertFalse(game.play(player2, Position.TOP, Position.MID));
		game.getCheckerBoard().getChildren().get()[4].setPlacement(Placement.CIRCLE);
		assertTrue(game.play(player2,4,1));
	}
}

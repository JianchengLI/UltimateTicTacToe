package perso.tictactoe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;
import perso.tictactoe.game.Moves;
import perso.tictactoe.game.Position;

public class TestHistory {
	@Test
	public void testInitHistory() {
		Moves history = new Moves(0, 0);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(0, 1);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(0, 2);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(1, 0);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(1, 1);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(1, 2);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(2, 0);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(2, 1);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(2, 2);
		assertEquals(Position.TOP_LEFT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		history = new Moves(0,3);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(0, 4);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(0, 5);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(1, 3);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(1,4);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(1, 5);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(2, 3);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(2, 4);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(2, 5);
		assertEquals(Position.TOP, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		
		history = new Moves(0, 6);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(0, 7);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(0, 8);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(1, 6);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(1,7);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(1, 8);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(2, 6);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(2, 7);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(2, 8);
		assertEquals(Position.TOP_RIGHT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		
		
		history = new Moves(3, 0);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(3, 1);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(3, 2);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(4, 0);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(4, 1);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(4, 2);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(5, 0);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(5, 1);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(5, 2);
		assertEquals(Position.LEFT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		history = new Moves(3, 3);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(3, 4);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(3, 5);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(4, 3);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(4, 4);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(4, 5);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(5, 3);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(5, 4);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(5, 5);
		assertEquals(Position.MID, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		
		history = new Moves(3, 6);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(3, 7);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(3, 8);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(4, 6);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(4, 7);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(4, 8);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(5, 6);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(5, 7);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(5, 8);
		assertEquals(Position.RIGHT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		
		
		history = new Moves(6, 0);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(6, 1);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(6, 2);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(7, 0);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(7,1);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(7,2);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(8,0);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(8,1);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(8,2);
		assertEquals(Position.BOT_LEFT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		history = new Moves(6, 3);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(6, 4);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(6, 5);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(7,3);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals( Position.LEFT, history.getPositionY());
		
		history = new Moves(7, 4);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(7, 5);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(8, 3);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(8, 4);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(8, 5);
		assertEquals(Position.BOT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
		
		history = new Moves(6, 6);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.TOP_LEFT, history.getPositionY());
		
		history = new Moves(6, 7);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.TOP, history.getPositionY());
		
		history = new Moves(6, 8);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.TOP_RIGHT, history.getPositionY());
		
		history = new Moves(7, 6);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.LEFT, history.getPositionY());
		
		history = new Moves(7, 7);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.MID, history.getPositionY());
		
		history = new Moves(7, 8);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.RIGHT, history.getPositionY());
		
		history = new Moves(8, 6);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.BOT_LEFT, history.getPositionY());
		
		history = new Moves(8, 7);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.BOT, history.getPositionY());
		
		history = new Moves(8, 8);
		assertEquals(Position.BOT_RIGHT, history.getPositionX());
		assertEquals(Position.BOT_RIGHT, history.getPositionY());
		
	}
	
	@Test
	public void testInitHistoryByPosition() {
		
		Moves history = new Moves(Position.TOP_LEFT, Position.TOP_LEFT);
		assertEquals(0, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.TOP);
		assertEquals(0, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.TOP_RIGHT);
		assertEquals(0, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.LEFT);
		assertEquals(1, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.MID);
		assertEquals(1, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.RIGHT);
		assertEquals(1, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.BOT_LEFT);
		assertEquals(2, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.BOT);
		assertEquals(2, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.TOP_LEFT, Position.BOT_RIGHT);
		assertEquals(2, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.TOP, Position.TOP_LEFT);
		assertEquals(0, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.TOP, Position.TOP);
		assertEquals(0, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.TOP, Position.TOP_RIGHT);
		assertEquals(0, history.getX());
		assertEquals(5, history.getY());
		
		history = new Moves(Position.TOP, Position.LEFT);
		assertEquals(1, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.TOP, Position.MID);
		assertEquals(1, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.TOP, Position.RIGHT);
		assertEquals(1, history.getX());
		assertEquals(5, history.getY());
		
		history = new Moves(Position.TOP, Position.BOT_LEFT);
		assertEquals(2, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.TOP, Position.BOT);
		assertEquals(2, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.TOP, Position.BOT_RIGHT);
		assertEquals(2, history.getX());
		assertEquals(5, history.getY());
		
		
		history = new Moves(Position.TOP_RIGHT, Position.TOP_LEFT);
		assertEquals(0, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.TOP);
		assertEquals(0, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.TOP_RIGHT);
		assertEquals(0, history.getX());
		assertEquals(8, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.LEFT);
		assertEquals(1, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.MID);
		assertEquals(1, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.RIGHT);
		assertEquals(1, history.getX());
		assertEquals(8, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.BOT_LEFT);
		assertEquals(2, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.BOT);
		assertEquals(2, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.TOP_RIGHT, Position.BOT_RIGHT);
		assertEquals(2, history.getX());
		assertEquals(8, history.getY());
		
		
		
		
		history = new Moves(Position.LEFT, Position.TOP_LEFT);
		assertEquals(3, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.LEFT, Position.TOP);
		assertEquals(3, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.LEFT, Position.TOP_RIGHT);
		assertEquals(3, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.LEFT, Position.LEFT);
		assertEquals(4, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.LEFT, Position.MID);
		assertEquals(4, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.LEFT, Position.RIGHT);
		assertEquals(4, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.LEFT, Position.BOT_LEFT);
		assertEquals(5, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.LEFT, Position.BOT);
		assertEquals(5, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.LEFT, Position.BOT_RIGHT);
		assertEquals(5, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.MID, Position.TOP_LEFT);
		assertEquals(3, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.MID, Position.TOP);
		assertEquals(3, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.MID, Position.TOP_RIGHT);
		assertEquals(3, history.getX());
		assertEquals(5, history.getY());
		
		history = new Moves(Position.MID, Position.LEFT);
		assertEquals(4, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.MID, Position.MID);
		assertEquals(4, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.MID, Position.RIGHT);
		assertEquals(4, history.getX());
		assertEquals(5, history.getY());
		
		history = new Moves(Position.MID, Position.BOT_LEFT);
		assertEquals(5, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.MID, Position.BOT);
		assertEquals(5, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.MID, Position.BOT_RIGHT);
		assertEquals(5, history.getX());
		assertEquals(5, history.getY());
		
		
		history = new Moves(Position.RIGHT, Position.TOP_LEFT);
		assertEquals(3, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.RIGHT, Position.TOP);
		assertEquals(3, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.RIGHT, Position.TOP_RIGHT);
		assertEquals(3, history.getX());
		assertEquals(8, history.getY());
		
		history = new Moves(Position.RIGHT, Position.LEFT);
		assertEquals(4, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.RIGHT, Position.MID);
		assertEquals(4, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.RIGHT, Position.RIGHT);
		assertEquals(4, history.getX());
		assertEquals(8, history.getY());
		
		history = new Moves(Position.RIGHT, Position.BOT_LEFT);
		assertEquals(5, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.RIGHT, Position.BOT);
		assertEquals(5, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.RIGHT, Position.BOT_RIGHT);
		assertEquals(5, history.getX());
		assertEquals(8, history.getY());
		
		
		
		history = new Moves(Position.BOT_LEFT, Position.TOP_LEFT);
		assertEquals(6, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.TOP);
		assertEquals(6, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.TOP_RIGHT);
		assertEquals(6, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.LEFT);
		assertEquals(7, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.MID);
		assertEquals(7, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.RIGHT);
		assertEquals(7, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.BOT_LEFT);
		assertEquals(8, history.getX());
		assertEquals(0, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.BOT);
		assertEquals(8, history.getX());
		assertEquals(1, history.getY());
		
		history = new Moves(Position.BOT_LEFT, Position.BOT_RIGHT);
		assertEquals(8, history.getX());
		assertEquals(2, history.getY());
		
		history = new Moves(Position.BOT, Position.TOP_LEFT);
		assertEquals(6, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.BOT, Position.TOP);
		assertEquals(6, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.BOT, Position.TOP_RIGHT);
		assertEquals(6, history.getX());
		assertEquals(5, history.getY());
		
		history = new Moves(Position.BOT, Position.LEFT);
		assertEquals(7, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.BOT, Position.MID);
		assertEquals(7, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.BOT, Position.RIGHT);
		assertEquals(7, history.getX());
		assertEquals(5, history.getY());
		
		history = new Moves(Position.BOT, Position.BOT_LEFT);
		assertEquals(8, history.getX());
		assertEquals(3, history.getY());
		
		history = new Moves(Position.BOT, Position.BOT);
		assertEquals(8, history.getX());
		assertEquals(4, history.getY());
		
		history = new Moves(Position.BOT, Position.BOT_RIGHT);
		assertEquals(8, history.getX());
		assertEquals(5, history.getY());
		
		
		history = new Moves(Position.BOT_RIGHT, Position.TOP_LEFT);
		assertEquals(6, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.TOP);
		assertEquals(6, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.TOP_RIGHT);
		assertEquals(6, history.getX());
		assertEquals(8, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.LEFT);
		assertEquals(7, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.MID);
		assertEquals(7, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.RIGHT);
		assertEquals(7, history.getX());
		assertEquals(8, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.BOT_LEFT);
		assertEquals(8, history.getX());
		assertEquals(6, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.BOT);
		assertEquals(8, history.getX());
		assertEquals(7, history.getY());
		
		history = new Moves(Position.BOT_RIGHT, Position.BOT_RIGHT);
		assertEquals(8, history.getX());
		assertEquals(8, history.getY());
		
	}
		
}

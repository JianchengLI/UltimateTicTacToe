package perso.tictactoe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import perso.tictactoe.game.Moves;
import perso.tictactoe.game.Position;

public class TestMoves {
	@Test
	public void testGetXByPosition(){
		assertEquals(0,Moves.getXByPosition(Position.TOP_LEFT, Position.TOP_LEFT));
		assertEquals(0,Moves.getXByPosition(Position.TOP_LEFT, Position.TOP));
		assertEquals(0,Moves.getXByPosition(Position.TOP_LEFT, Position.TOP_RIGHT));
		assertEquals(1,Moves.getXByPosition(Position.TOP_LEFT, Position.LEFT));
		assertEquals(1,Moves.getXByPosition(Position.TOP_LEFT, Position.MID));
		assertEquals(1,Moves.getXByPosition(Position.TOP_LEFT, Position.RIGHT));
		assertEquals(2,Moves.getXByPosition(Position.TOP_LEFT, Position.BOT_LEFT));
		assertEquals(2,Moves.getXByPosition(Position.TOP_LEFT, Position.BOT));
		assertEquals(2,Moves.getXByPosition(Position.TOP_LEFT, Position.BOT_RIGHT));
		
		assertEquals(3,Moves.getXByPosition(Position.MID, Position.TOP_LEFT));
		assertEquals(3,Moves.getXByPosition(Position.MID, Position.TOP));
		assertEquals(3,Moves.getXByPosition(Position.MID, Position.TOP_RIGHT));
		assertEquals(4,Moves.getXByPosition(Position.MID, Position.LEFT));
		assertEquals(4,Moves.getXByPosition(Position.MID, Position.MID));
		assertEquals(4,Moves.getXByPosition(Position.MID, Position.RIGHT));
		assertEquals(5,Moves.getXByPosition(Position.MID, Position.BOT_LEFT));
		assertEquals(5,Moves.getXByPosition(Position.MID, Position.BOT));
		assertEquals(5,Moves.getXByPosition(Position.MID, Position.BOT_RIGHT));
		
		assertEquals(6,Moves.getXByPosition(Position.BOT_RIGHT, Position.TOP_LEFT));
		assertEquals(6,Moves.getXByPosition(Position.BOT_RIGHT, Position.TOP));
		assertEquals(6,Moves.getXByPosition(Position.BOT_RIGHT, Position.TOP_RIGHT));
		assertEquals(7,Moves.getXByPosition(Position.BOT_RIGHT, Position.LEFT));
		assertEquals(7,Moves.getXByPosition(Position.BOT_RIGHT, Position.MID));
		assertEquals(7,Moves.getXByPosition(Position.BOT_RIGHT, Position.RIGHT));
		assertEquals(8,Moves.getXByPosition(Position.BOT_RIGHT, Position.BOT_LEFT));
		assertEquals(8,Moves.getXByPosition(Position.BOT_RIGHT, Position.BOT));
		assertEquals(8,Moves.getXByPosition(Position.BOT_RIGHT, Position.BOT_RIGHT));
	}
	
	@Test
	public void testGetYByPosition(){
		assertEquals(0,Moves.getYByPosition(Position.TOP_LEFT, Position.TOP_LEFT));
		assertEquals(0,Moves.getYByPosition(Position.TOP_LEFT, Position.LEFT));
		assertEquals(0,Moves.getYByPosition(Position.TOP_LEFT, Position.BOT_LEFT));
		assertEquals(1,Moves.getYByPosition(Position.TOP_LEFT, Position.TOP));
		assertEquals(1,Moves.getYByPosition(Position.TOP_LEFT, Position.MID));
		assertEquals(1,Moves.getYByPosition(Position.TOP_LEFT, Position.BOT));
		assertEquals(2,Moves.getYByPosition(Position.TOP_LEFT, Position.TOP_RIGHT));
		assertEquals(2,Moves.getYByPosition(Position.TOP_LEFT, Position.RIGHT));
		assertEquals(2,Moves.getYByPosition(Position.TOP_LEFT, Position.BOT_RIGHT));
		
		assertEquals(3,Moves.getYByPosition(Position.MID, Position.TOP_LEFT));
		assertEquals(3,Moves.getYByPosition(Position.MID, Position.LEFT));
		assertEquals(3,Moves.getYByPosition(Position.MID, Position.BOT_LEFT));
		assertEquals(4,Moves.getYByPosition(Position.MID, Position.TOP));
		assertEquals(4,Moves.getYByPosition(Position.MID, Position.MID));
		assertEquals(4,Moves.getYByPosition(Position.MID, Position.BOT));
		assertEquals(5,Moves.getYByPosition(Position.MID, Position.TOP_RIGHT));
		assertEquals(5,Moves.getYByPosition(Position.MID, Position.RIGHT));
		assertEquals(5,Moves.getYByPosition(Position.MID, Position.BOT_RIGHT));
		
		assertEquals(6,Moves.getYByPosition(Position.BOT_RIGHT, Position.TOP_LEFT));
		assertEquals(6,Moves.getYByPosition(Position.BOT_RIGHT, Position.LEFT));
		assertEquals(6,Moves.getYByPosition(Position.BOT_RIGHT, Position.BOT_LEFT));
		assertEquals(7,Moves.getYByPosition(Position.BOT_RIGHT, Position.TOP));
		assertEquals(7,Moves.getYByPosition(Position.BOT_RIGHT, Position.MID));
		assertEquals(7,Moves.getYByPosition(Position.BOT_RIGHT, Position.BOT));
		assertEquals(8,Moves.getYByPosition(Position.BOT_RIGHT, Position.TOP_RIGHT));
		assertEquals(8,Moves.getYByPosition(Position.BOT_RIGHT, Position.RIGHT));
		assertEquals(8,Moves.getYByPosition(Position.BOT_RIGHT, Position.BOT_RIGHT));
	}
	
	@Test
	public void testGetPostionXByIndex(){
		assertEquals(Position.TOP_LEFT,Moves.getPostionXByIndex(0, 0));
		assertEquals(Position.LEFT,Moves.getPostionXByIndex(3, 0));
		assertEquals(Position.BOT_LEFT,Moves.getPostionXByIndex(6, 0));
		assertEquals(Position.TOP,Moves.getPostionXByIndex(0, 3));
		assertEquals(Position.MID,Moves.getPostionXByIndex(3, 3));
		assertEquals(Position.BOT,Moves.getPostionXByIndex(6, 3));
		assertEquals(Position.TOP_RIGHT,Moves.getPostionXByIndex(0, 6));
		assertEquals(Position.RIGHT,Moves.getPostionXByIndex(3, 6));
		assertEquals(Position.BOT_RIGHT,Moves.getPostionXByIndex(6, 6));
	}
	
	@Test
	public void testGetPostionYByIndex(){
		assertEquals(Position.TOP_LEFT,Moves.getPostionYByIndex(0, 0));
		assertEquals(Position.LEFT,Moves.getPostionYByIndex(1, 0));
		assertEquals(Position.BOT_LEFT,Moves.getPostionYByIndex(2, 0));
		assertEquals(Position.TOP,Moves.getPostionYByIndex(0, 1));
		assertEquals(Position.MID,Moves.getPostionYByIndex(1, 1));
		assertEquals(Position.BOT,Moves.getPostionYByIndex(2, 1));
		assertEquals(Position.TOP_RIGHT,Moves.getPostionYByIndex(0, 2));
		assertEquals(Position.RIGHT,Moves.getPostionYByIndex(1, 2));
		assertEquals(Position.BOT_RIGHT,Moves.getPostionYByIndex(2, 2));
	}
}

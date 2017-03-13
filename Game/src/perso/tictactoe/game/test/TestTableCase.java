package perso.tictactoe.game.test;


import org.junit.Test;

import perso.tictactoe.game.Case;
import perso.tictactoe.game.Checkboard;
import perso.tictactoe.game.Placement;
import perso.tictactoe.game.Position;
import perso.tictactoe.game.TicTacToeCase;

public class TestTableCase {

	@Test
	public void testInit() {
		TicTacToeCase tictactoe = new TicTacToeCase();
		Case[] cases = tictactoe.getCases();
		for (Case e : cases) {
		   assert e.getPlacement() == Placement.EMPTY;
		}
	}

	@Test
	public void testTablePlacementBysetCasePlacement() {
		TicTacToeCase tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.TOP_LEFT, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.TOP, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.TOP_RIGHT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;

		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.LEFT, Placement.CROSS);
		tictactoe.setCasePlacement(Position.MID, Placement.CROSS);
		tictactoe.setCasePlacement(Position.RIGHT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;

		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.BOT_LEFT, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.BOT, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.BOT_RIGHT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;

		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.TOP_LEFT, Placement.CROSS);
		tictactoe.setCasePlacement(Position.LEFT, Placement.CROSS);
		tictactoe.setCasePlacement(Position.BOT_LEFT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;

		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.TOP, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.MID, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.BOT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;

		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.TOP_RIGHT, Placement.CROSS);
		tictactoe.setCasePlacement(Position.RIGHT, Placement.CROSS);
		tictactoe.setCasePlacement(Position.BOT_RIGHT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;
		
		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.TOP_LEFT, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.MID, Placement.CIRCLE);
		tictactoe.setCasePlacement(Position.BOT_RIGHT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;
		
		tictactoe = new TicTacToeCase();
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setCasePlacement(Position.TOP_RIGHT, Placement.CROSS);
		tictactoe.setCasePlacement(Position.MID, Placement.CROSS);
		tictactoe.setCasePlacement(Position.BOT_LEFT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;
	}
	
	@Test
	public void testCheckboardPlacementBysetCasePlacement(){
		Checkboard checkboard = new Checkboard();
		checkboard.setCasePlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.setCasePlacement(Position.MID, Placement.CIRCLE);
		checkboard.setCasePlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getPlacement() == Placement.CIRCLE;
		
		checkboard = new Checkboard();
		assert checkboard.getPlacement() == Placement.EMPTY;
		checkboard.getCases()[Position.LEFT.getValue()].setCasePlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.getCases()[Position.LEFT.getValue()].setCasePlacement(Position.MID, Placement.CIRCLE);
		checkboard.getCases()[Position.LEFT.getValue()].setCasePlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getCases()[Position.LEFT.getValue()].getPlacement() == Placement.CIRCLE;
	
		checkboard.getCases()[Position.RIGHT.getValue()].setCasePlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.getCases()[Position.RIGHT.getValue()].setCasePlacement(Position.MID, Placement.CIRCLE);
		checkboard.getCases()[Position.RIGHT.getValue()].setCasePlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getCases()[Position.RIGHT.getValue()].getPlacement() == Placement.CIRCLE;
	
		checkboard.getCases()[Position.MID.getValue()].setCasePlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.getCases()[Position.MID.getValue()].setCasePlacement(Position.MID, Placement.CIRCLE);
		checkboard.getCases()[Position.MID.getValue()].setCasePlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getCases()[Position.MID.getValue()].getPlacement() == Placement.CIRCLE;
	
		assert checkboard.getPlacement() == Placement.CIRCLE;
	}

}

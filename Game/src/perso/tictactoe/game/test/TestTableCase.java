package perso.tictactoe.game.test;


import org.junit.Test;

import perso.tictactoe.game.Case;
import perso.tictactoe.game.Placement;
import perso.tictactoe.game.Position;
import perso.tictactoe.game.TableCase;

public class TestTableCase {

	@Test
	public void testInit() {
		TableCase tictactoe = new TableCase((parent) -> new Case(parent));
		Case[] cases = tictactoe.getChildren().get();
		for (Case e : cases) {
		   assert e.getPlacement() == Placement.EMPTY;
		}
	}

	@Test
	public void testTablePlacementBysetPlacement() {
		TableCase tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.TOP_LEFT, Placement.CIRCLE);
		tictactoe.setPlacement(Position.TOP, Placement.CIRCLE);
		tictactoe.setPlacement(Position.TOP_RIGHT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;

		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.LEFT, Placement.CROSS);
		tictactoe.setPlacement(Position.MID, Placement.CROSS);
		tictactoe.setPlacement(Position.RIGHT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;

		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.BOT_LEFT, Placement.CIRCLE);
		tictactoe.setPlacement(Position.BOT, Placement.CIRCLE);
		tictactoe.setPlacement(Position.BOT_RIGHT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;

		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.TOP_LEFT, Placement.CROSS);
		tictactoe.setPlacement(Position.LEFT, Placement.CROSS);
		tictactoe.setPlacement(Position.BOT_LEFT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;

		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.TOP, Placement.CIRCLE);
		tictactoe.setPlacement(Position.MID, Placement.CIRCLE);
		tictactoe.setPlacement(Position.BOT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;

		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.TOP_RIGHT, Placement.CROSS);
		tictactoe.setPlacement(Position.RIGHT, Placement.CROSS);
		tictactoe.setPlacement(Position.BOT_RIGHT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;
		
		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.TOP_LEFT, Placement.CIRCLE);
		tictactoe.setPlacement(Position.MID, Placement.CIRCLE);
		tictactoe.setPlacement(Position.BOT_RIGHT, Placement.CIRCLE);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CIRCLE;
		
		tictactoe = new TableCase((parent) -> new Case(parent));
		assert tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.EMPTY;
		tictactoe.setPlacement(Position.TOP_RIGHT, Placement.CROSS);
		tictactoe.setPlacement(Position.MID, Placement.CROSS);
		tictactoe.setPlacement(Position.BOT_LEFT, Placement.CROSS);
		assert !tictactoe.isEmpty();
		assert tictactoe.getPlacement() == Placement.CROSS;
	}
	
	@Test
	public void testCheckboardPlacementBysetPlacement(){
		TableCase checkboard = new TableCase(
				(parent)-> new TableCase(parent, (e)-> new Case(e)));
		
		checkboard.setPlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.setPlacement(Position.MID, Placement.CIRCLE);
		checkboard.setPlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getPlacement() == Placement.CIRCLE;
		
		checkboard = new TableCase(
				(parent)-> new TableCase(parent, (e)-> new Case(e)));
		
		assert checkboard.getPlacement() == Placement.EMPTY;
		checkboard.getChildren().get()[Position.LEFT.getValue()].setPlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.getChildren().get()[Position.LEFT.getValue()].setPlacement(Position.MID, Placement.CIRCLE);
		checkboard.getChildren().get()[Position.LEFT.getValue()].setPlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getChildren().get()[Position.LEFT.getValue()].getPlacement() == Placement.CIRCLE;
	
		checkboard.getChildren().get()[Position.RIGHT.getValue()].setPlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.getChildren().get()[Position.RIGHT.getValue()].setPlacement(Position.MID, Placement.CIRCLE);
		checkboard.getChildren().get()[Position.RIGHT.getValue()].setPlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getChildren().get()[Position.RIGHT.getValue()].getPlacement() == Placement.CIRCLE;
	
		checkboard.getChildren().get()[Position.MID.getValue()].setPlacement(Position.LEFT, Placement.CIRCLE);
		checkboard.getChildren().get()[Position.MID.getValue()].setPlacement(Position.MID, Placement.CIRCLE);
		checkboard.getChildren().get()[Position.MID.getValue()].setPlacement(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getChildren().get()[Position.MID.getValue()].getPlacement() == Placement.CIRCLE;
	
		assert checkboard.getPlacement() == Placement.CIRCLE;
	}

}

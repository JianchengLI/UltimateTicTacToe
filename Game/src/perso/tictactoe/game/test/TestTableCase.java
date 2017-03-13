package perso.tictactoe.game.test;

import java.util.ArrayList;

import org.junit.Test;

import perso.tictactoe.game.Case;
import perso.tictactoe.game.Placement;
import perso.tictactoe.game.Position;
import perso.tictactoe.game.TableCase;

public class TestTableCase {

	@Test
	public void testInit() {
		ArrayList<Case> arrayCases = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			arrayCases.add(new Case());
		}
		TableCase<Case> tableCase = new TableCase<>(arrayCases);
		ArrayList<Case> cases = tableCase.getCases();
		for (Case e : cases) {
		   assert e.getPlacement() == Placement.EMPTY;
		}
	}

	@Test
	public void testTablePlacementBySetCase() {
		ArrayList<Case> arrayCases = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			arrayCases.add(new Case());
		}
		TableCase<Case> tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.TOP_LEFT, Placement.CIRCLE);
		tableCase.setCase(Position.TOP, Placement.CIRCLE);
		tableCase.setCase(Position.TOP_RIGHT, Placement.CIRCLE);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CIRCLE;

		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.LEFT, Placement.CROSS);
		tableCase.setCase(Position.MID, Placement.CROSS);
		tableCase.setCase(Position.RIGHT, Placement.CROSS);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CROSS;

		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.BOT_LEFT, Placement.CIRCLE);
		tableCase.setCase(Position.BOT, Placement.CIRCLE);
		tableCase.setCase(Position.BOT_RIGHT, Placement.CIRCLE);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CIRCLE;

		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.TOP_LEFT, Placement.CROSS);
		tableCase.setCase(Position.LEFT, Placement.CROSS);
		tableCase.setCase(Position.BOT_LEFT, Placement.CROSS);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CROSS;

		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.TOP, Placement.CIRCLE);
		tableCase.setCase(Position.MID, Placement.CIRCLE);
		tableCase.setCase(Position.BOT, Placement.CIRCLE);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CIRCLE;

		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.TOP_RIGHT, Placement.CROSS);
		tableCase.setCase(Position.RIGHT, Placement.CROSS);
		tableCase.setCase(Position.BOT_RIGHT, Placement.CROSS);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CROSS;
		
		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.TOP_LEFT, Placement.CIRCLE);
		tableCase.setCase(Position.MID, Placement.CIRCLE);
		tableCase.setCase(Position.BOT_RIGHT, Placement.CIRCLE);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CIRCLE;
		
		tableCase = new TableCase<>(arrayCases);
		assert tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.EMPTY;
		tableCase.setCase(Position.TOP_RIGHT, Placement.CROSS);
		tableCase.setCase(Position.MID, Placement.CROSS);
		tableCase.setCase(Position.BOT_LEFT, Placement.CROSS);
		assert !tableCase.isEmpty();
		assert tableCase.getPlacement() == Placement.CROSS;
	}
	
	@Test
	public void testCheckboardPlacementBySetCase(){
		ArrayList<TableCase<Case>> arrayTableCases = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			ArrayList<Case> arrayCases = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				arrayCases.add(new Case());
			}
			arrayTableCases.add(new TableCase<>(arrayCases));
		}
		TableCase<TableCase<Case>> checkboard = new TableCase<>(arrayTableCases);
		checkboard.setCase(Position.LEFT, Placement.CIRCLE);
		checkboard.setCase(Position.MID, Placement.CIRCLE);
		checkboard.setCase(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getPlacement() == Placement.CIRCLE;
		
		checkboard = new TableCase<>(arrayTableCases);
		assert checkboard.getPlacement() == Placement.EMPTY;
		checkboard.getCases().get(Position.LEFT.getValue()).setCase(Position.LEFT, Placement.CIRCLE);
		checkboard.getCases().get(Position.LEFT.getValue()).setCase(Position.MID, Placement.CIRCLE);
		checkboard.getCases().get(Position.LEFT.getValue()).setCase(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getCases().get(Position.LEFT.getValue()).getPlacement() == Placement.CIRCLE;
	
		checkboard.getCases().get(Position.RIGHT.getValue()).setCase(Position.LEFT, Placement.CIRCLE);
		checkboard.getCases().get(Position.RIGHT.getValue()).setCase(Position.MID, Placement.CIRCLE);
		checkboard.getCases().get(Position.RIGHT.getValue()).setCase(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getCases().get(Position.RIGHT.getValue()).getPlacement() == Placement.CIRCLE;
	
		checkboard.getCases().get(Position.MID.getValue()).setCase(Position.LEFT, Placement.CIRCLE);
		checkboard.getCases().get(Position.MID.getValue()).setCase(Position.MID, Placement.CIRCLE);
		checkboard.getCases().get(Position.MID.getValue()).setCase(Position.RIGHT, Placement.CIRCLE);
		assert checkboard.getCases().get(Position.MID.getValue()).getPlacement() == Placement.CIRCLE;
	
		assert checkboard.getPlacement() == Placement.CIRCLE;
	}

}

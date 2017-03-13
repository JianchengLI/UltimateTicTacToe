package perso.tictactoe.game.test;

import org.junit.Test;

import perso.tictactoe.game.Case;
import perso.tictactoe.game.Placement;

public class TestCase {

	@Test
	public void testIsEmpty() {
		Case caseEmpty = new Case();
		assert caseEmpty.isEmpty();
		
		Case caseNotEmpty = new Case(caseEmpty);
		caseNotEmpty.setPlacement(Placement.CIRCLE);
		assert !caseNotEmpty.isEmpty();
	}
}

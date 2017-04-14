package perso.tictactoe.network.test;

import static org.junit.Assert.*;

import org.junit.Test;

import perso.tictactoe.network.GameWaitingState;

public class TestGameServer {

	@Test
	public void test() {
		assertTrue(GameWaitingState.parseProtocol("{name:player1};").matches());
		assertFalse(GameWaitingState.parseProtocol("{name:player1}").matches());
		assertFalse(GameWaitingState.parseProtocol("name:player1;").matches());
	}

}

package perso.tictactoe.network.test;

import static org.junit.Assert.*;
import java.util.Optional;
import org.junit.Test;

import perso.tictactoe.game.Moves;
import perso.tictactoe.network.Util;

public class TestUtil {

	@Test
	public void test_before_begin_state() {
		String message = "{name:user};";
		assertEquals(Optional.of("user"), Util.parserProtocolBeforeBegin(message));
		
		message = "{name:};";
		assertEquals(Optional.empty(), Util.parserProtocolBeforeBegin(message));
		
		message = "{name:user}";
		assertEquals(Optional.empty(), Util.parserProtocolBeforeBegin(message));
		
		message = "name:user;";
		assertEquals(Optional.empty(), Util.parserProtocolBeforeBegin(message));
	}
	
	@Test
	public void test_begin_state(){
		String message = "{move:1,1};";
		Optional<Moves> moves = Util.parserProtocolBeginState(message);
		assertEquals(1, moves.get().getX());
		assertEquals(1, moves.get().getY());
		
		message = "{move:3,5};";
		moves = Util.parserProtocolBeginState(message);
		assertEquals(3, moves.get().getX());
		assertEquals(5, moves.get().getY());
		
		message = "{move:13,5};";
		moves = Util.parserProtocolBeginState(message);
		assertFalse(moves.isPresent());
		
		message = "{move:s,s};";
		moves = Util.parserProtocolBeginState(message);
		assertFalse(moves.isPresent());
		
		message = "{move:3,5}";
		moves = Util.parserProtocolBeginState(message);
		assertFalse(moves.isPresent());
		
		message = "{mov:3,5}";
		moves = Util.parserProtocolBeginState(message);
		assertFalse(moves.isPresent());
	}
}

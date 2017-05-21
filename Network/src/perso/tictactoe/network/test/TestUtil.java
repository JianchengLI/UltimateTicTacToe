package perso.tictactoe.network.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import perso.tictactoe.network.Util;

public class TestUtil {

	@Test
	public void test() {
		String message = "{name:user};";
		assertEquals(Optional.of("user"), Util.parserProtocolBeforeBegin(message));
		
		message = "{name:};";
		assertEquals(Optional.empty(), Util.parserProtocolBeforeBegin(message));
		
		message = "{name:user}";
		assertEquals(Optional.empty(), Util.parserProtocolBeforeBegin(message));
		
		message = "name:user;";
		assertEquals(Optional.empty(), Util.parserProtocolBeforeBegin(message));
	}

}

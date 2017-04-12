package perso.tictactoe.network;

public class GameBeginState implements GameState {
	private GameServer _protocol;
	
	public GameBeginState(GameServer protocol) {
		_protocol = protocol;
	}

	@Override
	public String processInput(String input) {
		return "";
	}

}

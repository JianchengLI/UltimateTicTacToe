package perso.tictactoe.network;

public class GameBeginState implements GameState {
	private GameServer _gameServer;
	
	public GameBeginState(GameServer gameServer) {
		_gameServer = gameServer;
	}

	@Override
	public String processInput(String input) {
		return "";
	}

}

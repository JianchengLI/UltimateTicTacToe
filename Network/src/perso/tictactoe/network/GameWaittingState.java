package perso.tictactoe.network;

public class GameWaittingState implements GameState {
	private GameServer _protocol;
	
	public GameWaittingState(GameServer protocol) {
		_protocol = protocol;
	}
	@Override
	public String processInput(String input) {
		if (_protocol.getGame().getPlayers().size() == 2)
			_protocol.setState(_protocol.getBeginState());
		
		return "";
	}

}

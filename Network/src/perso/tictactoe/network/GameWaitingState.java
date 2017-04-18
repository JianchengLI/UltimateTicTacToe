package perso.tictactoe.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import perso.tictactoe.game.Placement;
import perso.tictactoe.game.Player;

public class GameWaitingState implements GameState {
	private GameServer _server;
	
	public GameWaitingState(GameServer server) {
		_server = server;
	}
	
	@Override
	public String processInput(String input) {
		System.out.println("[Client]: "+ input);
		String response;
		Matcher matcher = parseProtocol(input);
		if (matcher.matches()) {
			String userName = matcher.group(1);
			Player player = (_server.getGame().getPlayers().size() == 0) ?
				new Player(userName, Placement.CIRCLE, _server.getGame()) :
				new Player(userName, Placement.CROSS, _server.getGame());
				
			response = "Hello "+player.getName()+", welcome join the game. You are using " + player.getPlacement();
		} else {
			response = "Sorry, please enter: \"{name:YourName};\"";
		}
		
		if (_server.getGame().getPlayers().size() == 2){
			System.out.println("[Server]: Two Players joined, the game will begin");
			_server.setState(_server.getBeginState());
		}
		return response;
	}
	
	/**
	 * Waiting State Protocol
	 * Input must be : {name:YourName};
	 */
	public static Matcher parseProtocol(String input){
		Pattern pattern = Pattern.compile("\\{name:(.*)\\};");
		Matcher macher = pattern.matcher(input);
		return macher;
	}
}

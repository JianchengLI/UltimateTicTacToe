package perso.tictactoe.network;

import java.net.Socket;

import perso.tictactoe.game.Placement;
import perso.tictactoe.game.Player;

/**
 * After Connection State, Entry all user's informations ( new Players ) 
 * @author Jiancheng
 *
 */
public class BeforeBeginState extends State {

	public BeforeBeginState(Server server) {
		super(server);
	}

	@Override
	public void parser(Socket socket, String message) {
		if(_server.getPlayers().containsKey(socket)){
			_server.send(socket, "[Server]: Sorry, you have regisered already with a player-" + _server.getPlayers().get(socket));
			return;
		}
		
		if(!stateProtocolValid(message)){
			_server.send(socket, "[Server]: Sorry, please entry your name in the format of \"{name:your_name};\"");
			return;
		}
		
		/*
		 * ok, message was valided, create a player for this client socket
		 * player1: CIRCLE
		 * player2: CROSS 
		 */
		Player player =  _server.getPlayers().size() == 0 ?
				new Player(message, Placement.CIRCLE, _server.getGame()) :
				new Player(message, Placement.CROSS, _server.getGame());
		
		_server.getPlayers().put(socket, player);
		_server.send(socket, "[Server]: You have regisered with a player( " + player + " )" );
		
		if(_server.getPlayers().size() == 2){
			_server.broadcast("[Server]: 2 Players were registered. Game is begin, BON COURAGE !");
			_server.setState(_server.getBeginState());
			
			Socket first = _server.getClientsSockets().get(0);
			_server.send(first, "[Server]: Hello "+ _server.getGame().getCurrentPlayer() + " you will play first.");
			_server.send(first, "[Server]: Please entry your move in the format of \"{move:x,y};\"");
			
			Socket second = _server.getClientsSockets().get(1);
			_server.send(second, "[Server]: Hello, " + _server.getPlayers().get(second) + " you will play second.");
			_server.send(second, "[Server]: Please wait first player to move and then you can entry your move in the format of \"{move:x,y};\"");
		}
	}
	
	private boolean stateProtocolValid(String message){
		return true;
	}

}

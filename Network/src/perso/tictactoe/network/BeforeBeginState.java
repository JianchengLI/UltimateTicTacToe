package perso.tictactoe.network;

import java.net.Socket;
import java.util.Optional;

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
		
	// Already register ?
		// yes, sorry, just wait an other player to register
		// no, message valid ?
			// yes, register this player, first player CIRCLE, second player CROSS
				// two player already ?
					// yes, broadcast game is begin, notify first to play, second to wait
			// no, error message ( bad message format ) and re-entry
		
		if(_server.getPlayers().containsKey(socket)){
			_server.send(socket, "[Server]: Sorry, you have regisered already with a player-" + _server.getPlayers().get(socket));
			return;
		}
		
		Optional<String> userName = parserProtocol(message);
		if(!userName.isPresent()){
			_server.send(socket, "[Server]: Sorry, please entry your name in the format of \"{name:your_name};\"");
			return;
		}
		
		Player player =  _server.getPlayers().size() == 0 ?
				new Player(userName.get(), Placement.CIRCLE, _server.getGame()) :
				new Player(userName.get(), Placement.CROSS, _server.getGame());
		
		_server.getPlayers().put(socket, player);
		_server.send(socket, "[Server]: You have regisered with a player( " + player + " )" );
		
		if(_server.getPlayers().size() == 2){
			_server.broadcast("[Server]: 2 Players were registered. Game is begin, BON COURAGE !");
			_server.setState(_server.getBeginState());
			
			Socket first = _server.getGame().getCurrentPlayer() == _server.getPlayers().get(socket) ?
					socket : opponent(socket);
			_server.send(first, "[Server]: Hello "+ _server.getGame().getCurrentPlayer() + " you will play first.");
			_server.send(first, "[Server]: Please entry your move in the format of \"{move:x,y};\"");
			
			Socket second =opponent(first);
			_server.send(second, "[Server]: Hello, " + _server.getPlayers().get(second) + " you will play second.");
			_server.send(second, "[Server]: Please wait " + _server.getGame().getCurrentPlayer() + " to move and then you can entry your move in the format of \"{move:x,y};\"");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<String> parserProtocol(String message){
	   return Util.parserProtocolBeforeBegin(message);
	}

}

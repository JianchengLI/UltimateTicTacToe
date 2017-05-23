package perso.tictactoe.network;

import java.net.Socket;
import java.util.Optional;

import perso.tictactoe.game.Moves;
import perso.tictactoe.game.PlayStates;
import perso.tictactoe.game.Player;

/**
 * Begin, play the game
 * @author Jiancheng
 *
 */
public class BeginState extends State {

	public BeginState(Server server) {
		super(server);
	}
	
	@Override
	public void parser(Socket socket, String message) {
		
	// current player ?
		// yes, message right ?
			// yes, play this movement. 
				// success ?
					// yes, finish ?
						// yes, broadcast this player was win the game
						// no, notify next player to move
					//no, error message( why can't play this movement )  re-entry movement
			//no, error message ( bad entry ), re-entry movement.
		// no, please wait the other player to move ...
		
		Player player = _server.getGame().getCurrentPlayer();
		if(player != _server.getPlayers().get(socket)) {
			_server.send(socket, "[Server]: Sorry, it's not your turn, please waiting.");
			return;
		}
		Optional<Moves> move = parserProtocol(message);
		if(!move.isPresent()) {
			_server.send(socket, "[Server]: Sorry, please entry your movement in the format of \"{move:x,y};\"");
			return;
		}
		
		int index_x = move.get().getX();
		int index_y = move.get().getY();
		PlayStates state = _server.getGame().play(player, index_x, index_y);
		if (state != PlayStates.SUCCESS) {
			_server.send(socket, "[Server]: Sorry, you can't play in this place(" + index_x + "," + index_y + "), State:" + state);
			return;
		}
		
		_server.broadcast("[Server]: " + player + " place to (" + index_x + "," + index_y + ")");
		_server.send(socket, "[Server]: It's your opponent's turn");
		_server.send(opponent(socket), "[Server]: It's your your turn "+ _server.getGame().getCurrentPlayer() +", please entry your movement in the format of \"{move:x,y};");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Moves> parserProtocol(String message){
		return Util.parserProtocolBeginState(message);
	}
}

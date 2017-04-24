package perso.tictactoe.network;

import java.net.Socket;

/**
 * Begin, Player can play the game
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
		
		if (_server.getGame().getCurrentPlayer() != _server.getPlayers().get(socket)) {
			_server.send(socket, "[Server]: Sorry, it's not your turn, please waiting.");
			return;
		}
		
		if(!stateProtocolValid(message)) {
			_server.send(socket, "[Server]: Sorry, please entry your movement in the format of \"{move:x,y};\"");
			return;
		}
	}
	
	@Override
	public boolean stateProtocolValid(String message){
		return true;
	}
}

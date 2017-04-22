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
		
		// Current player ?
			// yes, message right ?
				// yes, play this movement. 
					// seccess ?
						// yes, finish ?
							// yes, boardcast this player was win the game
							// no, notify next player to move
						//no, error message( why can't play this movement )  re-entry movement
				//no, error message ( bad entry ), re-entry movement.
			// no, please wait the other player to move ...
		
	}

}

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
		// TODO Auto-generated method stub		
	}

}

package perso.tictactoe.network;

import java.net.Socket;

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
		// TODO Auto-generated method stub
		
	}

}

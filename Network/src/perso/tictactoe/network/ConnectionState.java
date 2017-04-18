package perso.tictactoe.network;

/**
 * Waiting two connection( sockets ) to join the server
 * @author Jiancheng
 *
 */
public class ConnectionState extends State {

	public ConnectionState(Server server) {
		super(server);
	}

	@Override
	public void parser(String message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void talking(String message) {
		// TODO Auto-generated method stub
		
	}

}

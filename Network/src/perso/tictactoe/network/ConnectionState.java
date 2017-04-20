package perso.tictactoe.network;

import java.net.Socket;

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
	public void parser(Socket socket, String message) {
		System.out.println( socket + ": " + message);
		_server.send(socket, "[Server]: Hi, we are waiting for another player to join the game ...");
	}
}

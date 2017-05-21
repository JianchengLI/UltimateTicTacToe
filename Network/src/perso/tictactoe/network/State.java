package perso.tictactoe.network;

import java.net.Socket;
import java.util.Optional;

public abstract class State {
	protected Server _server;
	
	public State(Server server){
		_server = server;
	}
	
	public abstract void parser(Socket socket, final String message);
	public abstract Optional<String> parserProtocolBeforeBegin(String message);
	
	public Socket opponent(Socket player){
		return _server.getClientsSockets().stream()
				.filter(socket-> socket != player)
				.findFirst().get();
	}
}

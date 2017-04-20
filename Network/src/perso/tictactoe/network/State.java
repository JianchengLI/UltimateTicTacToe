package perso.tictactoe.network;

import java.net.Socket;

public abstract class State {
	protected Server _server;
	
	public State(Server server){
		_server = server;
	}
	
	public abstract void parser(Socket socket, final String message);
}

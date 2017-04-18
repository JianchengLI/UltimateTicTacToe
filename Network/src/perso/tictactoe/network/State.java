package perso.tictactoe.network;

public abstract class State {
	private Server _server;
	
	public State(Server server){
		_server = server;
	}
	public abstract void parser(final String message);
	public abstract void talking(final String message);
}

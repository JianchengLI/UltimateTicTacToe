package perso.tictactoe.network;

public interface GameState {
	public abstract void onePlayerConnected();
	public abstract void onePlayerMoved();
}

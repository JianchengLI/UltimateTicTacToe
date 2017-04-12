package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import perso.tictactoe.game.Game;

public class GameServer {
	private static ServerSocket serverSocket;

	private Game _game;
	private GameState _state;
	private GameWaittingState _waittingState;
	private GameBeginState _beginState;
	
	public Game getGame(){ return _game;}
	public void setState(GameState state) {this._state = state;}
	public GameWaittingState getWaittingState() {return _waittingState;}
	public GameBeginState getBeginState() {return _beginState;}
	
	public GameServer(Game game) {
		_waittingState = new GameWaittingState(this);
		_beginState = new GameBeginState(this);
		_game = game;
		_state = _waittingState;
	}
	
	public void processInput(String input, Socket clientSocket) throws IOException{
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		out.println(_state.processInput(input));
	}
	
	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(4321);
			Game game = new Game();
			GameServer gameServer = new GameServer(game);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				if (clientSocket.isConnected()) {
					Runnable thread = () -> {
						try {
							String inputLine;
							BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
							while ((inputLine = in.readLine()) != null) {
								gameServer.processInput(inputLine, clientSocket);
							}
						} catch (IOException e) {
							System.out.println("Read failed");
							System.exit(-1);
						}
					};
					new Thread(thread).start();
				}
			}
		} catch (IOException e) {
			System.out.println("Could not listen on port 4321");
			System.exit(-1);
		}
	}
}

package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import perso.tictactoe.game.Game;

public class GameServer {
	private static ServerSocket serverSocket;

	private Game _game;
	private GameState _state;
	private GameWaitingState _waitingState;
	private GameBeginState _beginState;
	private Vector<Socket> _clients = new Vector<>();
	
	public Game getGame(){ return _game;}
	public void setState(GameState state) {this._state = state;}
	public GameWaitingState getWaittingState() {return _waitingState;}
	public GameBeginState getBeginState() {return _beginState;}
	public Vector<Socket> getClients(){return _clients;}
	
	public GameServer(Game game) {
		_waitingState = new GameWaitingState(this);
		_beginState = new GameBeginState(this);
		_game = game;
		_state = _waitingState;
	}
	
	public void processInput(String input, Socket clientSocket) throws IOException{
		boardcast(_state.processInput(input));
	}
	
	public void boardcast(String message){
		_clients.forEach(client ->{
			PrintWriter out;
			try {
				out = new PrintWriter(client.getOutputStream(), true);
				out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(4321);
			System.out.println("[Server]: Game Server is started, waiting players to join");
			
			Game game = new Game();
			GameServer server = new GameServer(game);
			while (true) {
				Socket cient = serverSocket.accept();
				server.getClients().add(cient);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(cient.getInputStream()));
				Runnable thread = () -> {
					try {
						String inputLine;
						while ((inputLine = in.readLine()) != null) {
							server.processInput(inputLine, cient);
						}
					} catch (IOException e) {
						System.out.println("Read failed");
						System.exit(-1);
					}
				};
				new Thread(thread).start();
			}
		} catch (IOException e) {
			System.out.println("Could not listen on port 4321");
			System.exit(-1);
		}
	}
}

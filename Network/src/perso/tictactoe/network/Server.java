package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
	private int _port; 
	private static ServerSocket _serverSocket;
	private static List<Socket> _clientsSockets;

	private State _state;
	private State _connectiong_state;
	private State _before_begin_state;
	private State _begin_state;
	
	public State getState() {return _state;}
	public State getConnectiongState() {return _connectiong_state;}
	public State getBeforeBeginState() {return _before_begin_state;}
	public State getBeginState() {return _begin_state;}
	
	public void setState(State _state) {this._state = _state;}
	public static List<Socket> getClientsSockets() {return _clientsSockets;}
	
	public Server(int port) throws IOException{
		_port = port;
		_serverSocket = new ServerSocket(_port);
		_clientsSockets = new LinkedList<>();
		
		_connectiong_state = new ConnectionState(this);
		_before_begin_state = new BeforeBeginState(this);
		_begin_state = new BeginState(this);
		_state = _connectiong_state;
	}
	

	public void start() throws IOException{
		System.out.println("[Server]: Server Start at port: " + _port);
		System.out.println("[Server]: Watting Player to Join.");
		while (true) {
			Socket socket = _serverSocket.accept();
			if (socket != null) {
				if (_clientsSockets.size() >= 2){
					send(socket, "Sorry, there are two player already in this Server.");
					continue;
				}
				
				send(socket, "[Server]: Welcome to the Game - Ultimate TicTacToc.");
				_clientsSockets.add(socket);
				if (_clientsSockets.size() == 2) {
					_clientsSockets.forEach(client -> {
						if (socket != client) {
							send(client, "[Server]: "+ socket + " has join the Server.");
						}
					});
					broadcast("[Server]: 2 clients connected to the Server, Tell me what's player name do you want to display in this Game ?");
					broadcast("[Server]: Please entry your name in the format of \"{name:myname};\"");
					setState(_before_begin_state);
					System.out.println("[Server]: A Client join the Server with " + socket);
				}
				listening(socket);
			}
		}
	}
	
	public void broadcast(final String message){
		_clientsSockets.forEach(client->{send(client, message);});
	}
	
	public void send(Socket client, final String message){
		PrintWriter out;
		try {
			out = new PrintWriter(client.getOutputStream(), true);
			out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Start a Thread to Listening a Socket 
	 * @param socket
	 */
	public void listening(Socket socket){
		new Thread(() -> {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputLine = "";
				while ((inputLine = in.readLine()) != null) {
					_state.parser(socket, inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) throws IOException{
		Server server = new Server(4322);
		server.start();
	}
}

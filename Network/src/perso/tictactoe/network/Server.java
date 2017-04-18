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
	
	public Server(int port) throws IOException{
		_port = port;
		_serverSocket = new ServerSocket(_port);
		_clientsSockets = new LinkedList<>();
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
				_clientsSockets.add(socket);
				System.out.println("[Server]: A Client join the Server with " + socket);
				
				send(socket, "Welcom to Game Ultimate TicTacToc.");
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
					System.out.println("[Client]: " + inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public static void main(String[] args) throws IOException{
		Server server = new Server(4321);
		server.start();
	}
}

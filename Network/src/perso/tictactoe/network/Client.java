package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket _socket;

	public Client(Socket socket) {
		_socket = socket;
		listenThread().start();
	}
	
	public Thread listenThread(){
		return new Thread(() -> {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
				String inputLine = "";
				while ((inputLine = in.readLine()) != null) {
					System.out.println("[Server]:" + inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		new Client(new Socket("localhost", 4321));
	}
}

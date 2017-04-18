package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private Socket _socket;

	public Client(Socket socket) {
		_socket = socket;
		listening();
		calling();
	}
	
	public void listening(){
		new Thread(() -> {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
				String inputLine = "";
				while ((inputLine = in.readLine()) != null) {
					System.out.println("[Server]:" + inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public void calling(){
		new Thread(() -> {
			try {
				Scanner scanner = new Scanner(System.in);
				String inputLine;
				
				PrintWriter out = new PrintWriter(_socket.getOutputStream(), true);
				while ((inputLine = scanner.nextLine()) != null) {
					out.println(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}).start();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		new Client(new Socket("localhost", 4321));
	}
}

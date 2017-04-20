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
	private Scanner scanner;

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
					System.out.println(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public void calling(){
		new Thread(() -> {
			try {
				scanner = new Scanner(System.in);
				String inputLine;
				
				PrintWriter out = new PrintWriter(_socket.getOutputStream(), true);
				while ((inputLine = scanner.nextLine()) != null) {
					System.out.println("[Me]: " + inputLine);
					out.println(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		new Client(new Socket("localhost", 4322));
	}
}

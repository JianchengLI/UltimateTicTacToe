package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 4321);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Scanner scanner = new Scanner(System.in);
			String inputLine;
			while ((inputLine = scanner.nextLine()) != null) {
				System.out.println("[Me]:" + inputLine);
				out.println(inputLine);
				String fromServer;
				while ((fromServer = in.readLine()) != null) {
					System.out.println("[Server]:"+fromServer);
					break;
				}
			}
		} 
		catch (UnknownHostException e) {
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} 
		catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}
	}
}

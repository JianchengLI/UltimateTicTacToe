package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(4321);
			Socket client = server.accept();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				String inputLine, outputLine;
				while ((inputLine = in.readLine()) != null) {
					System.out.println("Text recived : " + inputLine);
					out.println("Who are you ?");
				}
				System.out.print("Server Bye~");
				
			} catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
			}
		} catch (IOException e) {
			System.out.println("Could not listen on port 4321");
			System.exit(-1);
		}

	}
}

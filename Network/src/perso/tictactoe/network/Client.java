package perso.tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		try{
		     Socket socket = new Socket("localhost", 4321);
		     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     
		     out.println("Hello ~");
		     
		   } catch (UnknownHostException e) {
		     System.out.println("Unknown host: kq6py");
		     System.exit(1);
		} catch (IOException e) {
		     System.out.println("No I/O");
		     System.exit(1);
		}
	}
}

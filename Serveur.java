import java.io.*;
import java.util.*;
import java.net.*;

public class Serveur {
	public static HashSet<String> stock = new HashSet<String>();
	public static boolean stop = true;
	
	public static final int DEFAULT_PORT = 9874;

	public static void main(String[] args) throws Exception {
		ServerSocket listener = new ServerSocket(DEFAULT_PORT);
		System.out.println("The server is running at port " + DEFAULT_PORT  + ".");
		try {
			while (stop) {
				new Thread(new Responder(listener.accept())).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Responder implements Runnable {
		private Socket socket;

		public Responder(Socket socket) {
			this.socket = socket;
			log("New connection with client at " + socket);
		}

		@Override
		public void run() {
			try {

				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				String msg = in.readLine();
				if (stock[stock.length].)
				{

				}
				else
					stock.add(msg);
					out.println("coucou");
				}
	
				log("Message: " + stock);
			} catch (IOException e) {
				log("Error handling client at " + socket + ": " + e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					log("Couldn't close a socket");
				}
				log("Connection with " + socket + " closed");
			}
		}

		private void log(String message) {
			System.out.println(stock);
		}
	}
}
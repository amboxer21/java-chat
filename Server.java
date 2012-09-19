import java.util.*;
import java.net.*;
import java.io.*;

class Server {
private static String recv;
final static String quit = "quit";
  public static void main(String[] args) {

	try {
	ServerSocket socket = new ServerSocket(62400);
	Socket clientSocket = socket.accept();
	// Create a reader
	  while(true) {
	  BufferedReader bytesRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  // Get the client message
	    recv = bytesRead.readLine();
	      if(recv.equals(quit)) {
	      System.out.print("Client manually closed connection.\n");
	      System.exit(0);
	      }
	      	   else {
	           System.out.println("CLIENT: " + recv);
	           }

	  String sendTo;
          PrintWriter bytesWritten = new PrintWriter(clientSocket.getOutputStream(),true);
	  System.out.print("Message: ");
	  Scanner user_input = new Scanner(System.in);
	  sendTo = user_input.next();
	  bytesWritten.println(sendTo);
	  }
	}

		catch(IOException e) {
		System.out.println(e);
		}
  }
}


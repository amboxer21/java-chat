import java.util.*;
import java.net.*;
import java.io.*;

class ServerTest {
private static String recv;

  public static void main(String[] args) {

	try {
	ServerSocket socket = new ServerSocket(62400);
	Socket clientSocket = socket.accept();
	// Create a reader
	  while(true) {
	  BufferedReader bytesRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  // Get the client message
	    recv = bytesRead.readLine();
	    System.out.println("CLIENT: " + recv);
	    //System.out.flush();

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


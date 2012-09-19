import java.util.*;
import java.net.*;
import java.io.*;

class Client {
private static String recv;
final static String quit = "quit";
  public static void main(String[] args) {

        try {
	String sendTo;
	Socket socket = new Socket("localhost",62400);
	  while(true) {
          PrintWriter bytesWritten = new PrintWriter(socket.getOutputStream(),true);
	  System.out.print("Message: ");
	  Scanner user_input = new Scanner(System.in);
	  sendTo = user_input.next();
	    if(sendTo.equals(quit)) {
	    bytesWritten.println("quit");
	    System.out.print("Quiting now.\n");
	    Thread.sleep(1000);
	    System.exit(0);
	    }
	    	else {
		bytesWritten.println(sendTo);
		}

	  BufferedReader bytesRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	  recv = bytesRead.readLine();
	  System.out.println("SERVER: " + recv);
          }
	}

		catch(Exception e) {
		System.out.println(e);
		}
  }
}


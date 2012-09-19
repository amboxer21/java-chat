import java.util.*;
import java.net.*;
import java.io.*;

class ClientTest {
private static String recv;

  public static void main(String[] args) {

        try {
	String sendTo;
	Socket socket = new Socket("localhost",62400);
	  while(true) {
          PrintWriter bytesWritten = new PrintWriter(socket.getOutputStream(),true);
	  System.out.print("Message: ");
	  Scanner user_input = new Scanner(System.in);
	  sendTo = user_input.next();
          bytesWritten.println(sendTo);
	  System.out.flush();

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


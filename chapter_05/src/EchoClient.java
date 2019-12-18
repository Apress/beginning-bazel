import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EchoClient {
    private static final String kHostName = "localhost";
    private static final int kPortNumber = 1234;

    public static void main (String args[]) {
        System.out.println("Spinning up the Echo Client in Java...");
        try {
            final Socket socketToServer = new Socket(kHostName, kPortNumber);
            final BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
            final BufferedReader commandLineInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Waiting on input from the user...");
            final String inputFromUser = commandLineInput.readLine();
            if (inputFromUser != null) {
                System.out.println("Received by Java: " + inputFromUser);

                TransmissionObject transmissionObject = new TransmissionObject();
                transmissionObject.message = inputFromUser;
                transmissionObject.value = 3.145f;
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();        
                final PrintWriter outputToServer = new PrintWriter(socketToServer.getOutputStream(), true);
                outputToServer.println(gson.toJson(transmissionObject));
                System.out.println(inputFromServer.readLine());                
            }
            socketToServer.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import transmission_object.TransmissionObjectOuterClass.TransmissionObject;

public class EchoClient {
    public static void main (String args[]) {
        System.out.println("Spinning up the Echo Client in Java...");
        try {
            final Socket socketToServer = new Socket("localhost", 1234);
            // Note we don't need the second BufferedReader here.
            final BufferedReader commandLineInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Waiting on input from the user...");
            final String inputFromUser = commandLineInput.readLine();
            if (inputFromUser != null) {
                System.out.println("Received by Java: " + inputFromUser);

                TransmissionObject transmissionObject = TransmissionObject.newBuilder()
                    .setMessage(inputFromUser)
                    .setValue(3.145f)
                    .build();
                transmissionObject.writeTo(socketToServer.getOutputStream());

                TransmissionObject receivedObject = TransmissionObject.parseFrom(socketToServer.getInputStream());
                System.out.println("Received Message from server: ");
                System.out.println(receivedObject);
            }
            socketToServer.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
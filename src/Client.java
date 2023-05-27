import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8010);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Input user information
            System.out.print("Enter your name: ");
            String name = userInput.readLine();
            System.out.print("Enter your age: ");
            String age = userInput.readLine();

            // Send user information to the server
            out.println("Name: " + name + ", Age: " + age);

            // Receive response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            in.close();
            out.close();
            userInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;

public class SimpleChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            
            String message;
            while (true) {
                message = in.readLine();
                if (message == null || message.equalsIgnoreCase("exit")) break;
                System.out.println("Client: " + message);
                
                System.out.print("Server: ");
                String response = console.readLine();
                out.println(response);
                if (response.equalsIgnoreCase("exit")) break;
            }
            
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
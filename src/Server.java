import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            DataInputStream reader = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());
            OutputStreamWriter writer2 = new OutputStreamWriter(clientSocket.getOutputStream());

            int x1 = reader.readInt();
            int y1 = reader.readInt();
            int x2 = reader.readInt();
            int y2 = reader.readInt();

            String eq = "x - " + x1 + " / " + (x2 - x1) + " = " + "y - " + y1 + " / " + (y2 - y1) + "\n";

            writer2.write(eq);
            writer2.flush();

            writer2.close();
            reader.close();
            writer.close();
            clientSocket.close();
        }
    }
}
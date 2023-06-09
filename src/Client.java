import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        DataInputStream reader = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());


        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            writer.writeInt(in.nextInt());
            writer.flush();
        }

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println(reader2.readLine());

        reader2.close();
        writer.close();
        reader.close();
        clientSocket.close();
    }
}


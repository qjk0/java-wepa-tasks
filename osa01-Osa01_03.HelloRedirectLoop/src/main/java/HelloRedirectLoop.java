
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloRedirectLoop {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        int tries = 0;

        while (true) {
            Socket socket = server.accept();

            Scanner reader = new Scanner(socket.getInputStream());
            String line = reader.nextLine();
            System.out.println(line);
            if (line.contains("quit")) {
                socket.close();
                break;
            }

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("HTTP/1.1 302 Found");
            writer.println("Location: http://localhost:8080/");
            writer.println("");
            tries++;

            writer.flush();

            reader.close();
            writer.close();
            socket.close();
            System.out.println("Retrying... " + tries);
        }
    }

}


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            Scanner reader = new Scanner(socket.getInputStream());
            String line = reader.nextLine();
            if (line.contains("QUIT")) {
                socket.close();
                break;
            }

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("HTTP/1.1 200 OK");
            writer.println("");

            readFileContents(writer);
            writer.flush();

            reader.close();
            writer.close();
            socket.close();
        }
    }

    public static void readFileContents(PrintWriter writer) {
        try {
            Files.lines(Paths.get("index.html")).forEach(line -> writer.println(line));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

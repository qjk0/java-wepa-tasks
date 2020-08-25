// Test
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("================");
        System.out.println("THE INTERNETS!");
        System.out.println("================");

        System.out.print("Where to? ");
        String osoite = input.nextLine();
        int portti = 80;

        System.out.println("================");
        System.out.println("RESPONSE");
        System.out.println("================");

        Socket socket = new Socket(osoite, portti);
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("GET / HTTP/1.1");
        writer.println("Host: " + osoite);
        writer.println("");
        writer.flush();

        input = new Scanner(socket.getInputStream());
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
        
        writer.close();
        input.close();
        socket.close();

    }
}

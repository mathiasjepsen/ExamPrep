package examprep;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author mathiasjepsen
 */
public class Monitor implements Runnable {

    private Socket clientSocket;
    private PrintWriter output;
    private Scanner input;
    private AtomicInteger sharedCount;
    private HashMap<Integer, Turnstile> turnstiles;

    public Monitor(Socket socket, AtomicInteger sharedCount, HashMap<Integer, Turnstile> turnstiles) {
        this.clientSocket = socket;
        this.sharedCount = sharedCount;
        this.turnstiles = turnstiles;
    }

    @Override
    public void run() {
        try {
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new Scanner(clientSocket.getInputStream());
            output.println("New monitor connected");

            String inputLine;
            while ((inputLine = input.nextLine()) != null) {
                if (inputLine.equals("STOP")) {
                    break;
                }
                if (inputLine.equals("GET")) {
                    output.println("Current count: " + sharedCount);
                }
                if (inputLine.equals("GETID")) {
                    output.println("Input ID of turnstile:");
                    inputLine = input.nextLine();
                    if (inputLine != null) {
                        try {
                            Turnstile turnstile = getCountById(Integer.parseInt(inputLine));
                            output.println("Turnstile with ID: " + turnstile.getId() + " has a private count of: " + turnstile.getPrivateCount());
                        } catch (NullPointerException e) {
                            output.println("No turnstile with the given ID");
                        }
                    }
                }
            }

        } catch (IOException e) {

        }
    }

    private Turnstile getCountById(Integer id) {
        return turnstiles.get(id);
    }
}

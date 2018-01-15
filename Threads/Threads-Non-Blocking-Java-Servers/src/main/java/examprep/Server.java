package examprep;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjepsen
 */
public class Server {
    
    private static String IP = "0.0.0.0";
    private ServerSocket serverSocketClient;
    private ServerSocket serverSocketMonitor;
    private final ExecutorService es = Executors.newCachedThreadPool();
    private Integer nextId = 1;
    private final AtomicInteger SHAREDCOUNT = new AtomicInteger(0);
    private static final HashMap<Integer, Turnstile> TURNSTILES = new HashMap();

    public void start() throws IOException {
        Thread t1 = new Thread(() -> {
            try {
                serverSocketClient = new ServerSocket();
                serverSocketClient.bind(new InetSocketAddress(IP, 1238));
                while (true) {
                    Turnstile turnstile = new Turnstile(serverSocketClient.accept(), nextId, SHAREDCOUNT);
                    TURNSTILES.put(nextId, turnstile);
                    es.execute(turnstile);
                    nextId++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Thread t2 = new Thread(() -> {
            try {
                serverSocketMonitor = new ServerSocket();
                serverSocketMonitor.bind(new InetSocketAddress(IP, 1239));
                while (true) {
                    Monitor monitor = new Monitor(serverSocketMonitor.accept(), SHAREDCOUNT, TURNSTILES);
                    es.execute(monitor);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        t1.start();
        t2.start();
    }

    public void stopClient() throws IOException {
        serverSocketClient.close();
    }
    
    public void stopMonitor() throws IOException {
        serverSocketMonitor.close();
    }

    public static void main(String[] args) throws IOException {
        Server ems = new Server();
        ems.start();
    }

}

//When and why we will use Threads in our programs?
//  For performance and responsiveness. You don't want a GUI to wait for another thread to finish running before it's allowed input.
//Explain about the Race Condition Problem and ways to solve it in Java
//  If multiple threads are attempting to mutate a shared value that is not atomic, you have a race condition. You can use
//      locks or the synchronized keyword to make methods or blocks atomic and solve the problem.
//Explain how we can write reusable non-blocking Java Controls using Threads 
//  
//Explain about deadlocks, how to detect them and ways to solve the Deadlock Problem
//  A deadlock occurs when two or more threads are blocked forever, waiting for each other. 


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examprep;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjepsen
 */
public class Turnstile implements Runnable {

    private Socket clientSocket;
    private PrintWriter output;
    private Integer id;
    private AtomicInteger sharedCount;
    private Integer privateCount = 0;

    public Turnstile(Socket socket, Integer id, AtomicInteger sharedCount) {
        this.clientSocket = socket;
        this.id = id;
        this.sharedCount = sharedCount;
    }

    @Override
    public void run() {
        try {
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            output.println("New turnstile activated with ID: " + id);
            while (true) {
                sharedCount.getAndIncrement();
                privateCount++;
                Thread.sleep(5000);
            }
            
        } catch (IOException e) {

        } catch (InterruptedException ex) {
            Logger.getLogger(Turnstile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Integer getPrivateCount() {
        return privateCount;
    }

    public Integer getId() {
        return id;
    }
    
    
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author mathiasjepsen
 */
public class Tester {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Long> array = new ArrayList(Arrays.asList(4l, 5l, 8l, 12l, 21l, 22l, 34l, 35l, 36l, 37l, 42l));
        BlockingQueue<Long> s1 = new ArrayBlockingQueue(11, true, array);
        BlockingQueue<Long> s2 = new ArrayBlockingQueue(11);

        executeThreads(12, s1, s2);
    }
    
    private static void executeThreads(int numberOfThreads, BlockingQueue s1, BlockingQueue s2) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(numberOfThreads);
        ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);

        for(int i = 0; i < numberOfThreads; i++) {
            es.execute(new FibonacciProducer(s1, s2, count));
        }
        es.execute(new FibonacciConsumer(s2, count));
        
        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Closing Down");
    }

}

//  When and why will we use Threads in our programs?
//      You use threads when you want to accomplish multiple tasks at the same time, not having to wait for one or the other to finish
//      first in what's called 'sequential execution'.
//  What is the Race Condition Problem and how can you solve it?
//      A race condition is when two or more threads are using one or more methods in a non-atomic way, meaning that one might have
//      started reading a value and is about to change it, but before it's been changed, another thread as just read the original value,
//      when what you wanted was for the second thread to have read the new value. 
//  Explain the Producer/Consumer-problem and how to solve it in modern Java Programs
//      You have a producer thread putting elements into an array, and a consumer thread extracting the elements from the array. The
//      problem lies in the fact that the producer should only put something if there's room, and the consumer needs to wait until
//      there's something to take. Using a BlockingQueue solves this problem.
//  Explain what Busy Waiting is and why it's a bad thing in a modern software system.
//      Busy waiting is when a thread is constantly waiting for a result from another thread to become available, so it will continue
//      executing while waiting, but is essentially doing nothing.
//  Describe Java's BlockingQueue interface, relevant implementations and methods relevant for the producer consumer problem.
//      The BlockingQueue adds methods to insert, remove and get elements from an array. Some of the methods block, some return null 
//      if an operation is not possible, and some throw an exception. There is also the option to time out, blocking until it eventually
//      times out. This is only possible for the add and remove methods.

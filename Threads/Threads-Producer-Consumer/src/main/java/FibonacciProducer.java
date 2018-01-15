
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathiasjepsen
 */
public class FibonacciProducer implements Runnable {

    private AtomicInteger count;
    private final BlockingQueue<Long> s1;
    private final BlockingQueue<Long> s2;
    private Lock lock = new ReentrantLock();

    public FibonacciProducer(BlockingQueue<Long> s1, BlockingQueue<Long> s2, AtomicInteger count) {
        this.s1 = s1;
        this.s2 = s2;
        this.count = count;
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
        boolean moreNumbersToFetch = true;
        while (moreNumbersToFetch) {
            lock.lock();
            try {
                Long num = s1.poll();

                if (num == null) {
                    moreNumbersToFetch = false;
                    count.getAndDecrement();
                } else {
                    s2.put(fib(num));
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FibonacciProducer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                lock.unlock();
            }

        }

    }
}

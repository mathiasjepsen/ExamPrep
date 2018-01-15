
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author mathiasjepsen
 */
public class FibonacciConsumer implements Runnable {

    private final BlockingQueue<Long> s2;
    private final AtomicInteger count;

    public FibonacciConsumer(BlockingQueue<Long> s2, AtomicInteger count) {
        this.s2 = s2;
        this.count = count;
    }

    @Override
    public void run() {
        int sum = 0;
        while (count.get() > 0) {
            try {
                Long num = s2.take();

                if (num != null) {
                    sum += num;
                    System.out.println("New fibonacci number: " + num);
                    System.out.println("Sum of fibonacci numbers: " + sum);

                }
            } catch (InterruptedException e) {

            }

        }
    }

}

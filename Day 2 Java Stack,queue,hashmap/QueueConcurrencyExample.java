import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueConcurrencyExample {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        Thread blockingProducer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Blocking Producer producing: " + i);
                    blockingQueue.put(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread blockingConsumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    Integer item = blockingQueue.take();
                    System.out.println("Blocking Consumer consuming: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        ConcurrentLinkedQueue<Integer> concurrentQueue = new ConcurrentLinkedQueue<>();

        Thread concurrentProducer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                concurrentQueue.offer(i);
                System.out.println("Concurrent Producer producing: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread concurrentConsumer = new Thread(() -> {
            while (true) {
                Integer item = concurrentQueue.poll();
                if (item != null) {
                    System.out.println("Concurrent Consumer consuming: " + item);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        blockingProducer.start();
        blockingConsumer.start();
        concurrentProducer.start();
        concurrentConsumer.start();
    }
}

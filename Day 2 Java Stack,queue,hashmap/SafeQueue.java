import java.util.*;

public class SafeQueue {
    private Queue<Integer> queue;

    public SafeQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(int value) {
        queue.add(value);
    }

    public Integer dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Current Queue: " + queue);
        }
    }

    public static void main(String[] args) {
        SafeQueue safeQueue = new SafeQueue();

        safeQueue.enqueue(10);
        safeQueue.enqueue(20);
        safeQueue.enqueue(30);

        safeQueue.printQueue();

        System.out.println("Dequeued: " + safeQueue.dequeue());
        System.out.println("Dequeued: " + safeQueue.dequeue());
        System.out.println("Dequeued: " + safeQueue.dequeue());

        System.out.println("Dequeued: " + safeQueue.dequeue());
        safeQueue.printQueue();
    }
}

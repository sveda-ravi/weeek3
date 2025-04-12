import java.util.*;

public class LazyDeletionPriorityQueue {
    private PriorityQueue<Integer> priorityQueue;
    private Set<Integer> deletedItems;

    public LazyDeletionPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
        this.deletedItems = new HashSet<>();
    }

    public void push(int value) {
        priorityQueue.add(value);
    }

    public void delete(int value) {
        deletedItems.add(value);
    }

    public Integer pop() {
        cleanup();
        if (priorityQueue.isEmpty()) {
            return null;
        }
        Integer item = priorityQueue.poll();
        while (item != null && deletedItems.contains(item)) {
            item = priorityQueue.poll();
        }
        return item;
    }

    public void cleanup() {
        priorityQueue.removeAll(deletedItems);
        deletedItems.clear();
    }

    public void printQueue() {
        System.out.println("Current Priority Queue: " + priorityQueue);
    }

    public static void main(String[] args) {
        LazyDeletionPriorityQueue queue = new LazyDeletionPriorityQueue();

        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);

        queue.printQueue();

        queue.delete(20);

        System.out.println("Popped: " + queue.pop());
        System.out.println("Popped: " + queue.pop());

        queue.printQueue();

        queue.cleanup();
        queue.printQueue();
    }
}

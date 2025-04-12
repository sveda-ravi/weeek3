public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full, cannot add element: " + value);
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue.");
            return -1;
        }

        int dequeuedValue = queue[front];

        if (front == rear) {
            front = rear = -1;
        } else {

            front = (front + 1) % capacity;
        }

        size--;
        return dequeuedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue elements:");
        int i = front;
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println(queue[rear]);
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        System.out.println("Queue after enqueuing 5 elements:");
        cq.displayQueue();

        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Dequeue: " + cq.dequeue());

        System.out.println("Queue after dequeuing 2 elements:");
        cq.displayQueue();

        cq.enqueue(60);
        cq.enqueue(70);

        System.out.println("Queue after enqueuing 2 more elements:");
        cq.displayQueue();
    }
}

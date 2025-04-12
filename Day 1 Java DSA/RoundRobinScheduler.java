import java.util.*;

class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnAroundTime;
    Process next;

    public Process(int id, int bt, int pr) {
        processId = id;
        burstTime = bt;
        remainingTime = bt;
        priority = pr;
        waitingTime = 0;
        turnAroundTime = 0;
    }
}

class CircularLinkedList {
    Process tail;

    public void addProcess(int id, int bt, int pr) {
        Process newNode = new Process(id, bt, pr);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeProcess(Process process) {
        if (tail == null || process == null) return;

        Process current = tail;
        Process prev = null;
        do {
            if (current.next == process) {
                prev = current;
                break;
            }
            current = current.next;
        } while (current != tail);

        if (prev != null) {
            if (process == tail) {
                if (tail.next == tail) {
                    tail = null;
                } else {
                    prev.next = process.next;
                    tail = prev;
                }
            } else {
                prev.next = process.next;
            }
        }
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void displayProcesses() {
        if (tail == null) return;
        Process current = tail.next;
        do {
            System.out.println("Process ID: " + current.processId + ", Remaining Time: " + current.remainingTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != tail.next);
    }

    public void roundRobinSchedule(int quantum) {
        if (tail == null) return;

        int time = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        Map<Integer, Integer> startTimes = new HashMap<>();
        Map<Integer, Integer> endTimes = new HashMap<>();

        Process current = tail.next;
        while (!isEmpty()) {
            if (current.remainingTime > 0) {
                if (!startTimes.containsKey(current.processId)) {
                    startTimes.put(current.processId, time);
                }

                int executionTime = Math.min(quantum, current.remainingTime);
                time += executionTime;
                current.remainingTime -= executionTime;

                if (current.remainingTime == 0) {
                    current.turnAroundTime = time;
                    current.waitingTime = time - current.burstTime;
                    totalWaitingTime += current.waitingTime;
                    totalTurnAroundTime += current.turnAroundTime;
                    endTimes.put(current.processId, time);
                    Process temp = current;
                    current = current.next;
                    removeProcess(temp);
                    processCount++;
                } else {
                    current = current.next;
                }

                System.out.println("\nProcesses after time " + time + ":");
                displayProcesses();
            } else {
                current = current.next;
            }
        }

        double avgWT = (double) totalWaitingTime / processCount;
        double avgTAT = (double) totalTurnAroundTime / processCount;
        System.out.println("\nAverage Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList scheduler = new CircularLinkedList();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Enter Priority: ");
            int pr = sc.nextInt();
            scheduler.addProcess(id, bt, pr);
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        System.out.println("\nInitial Process Queue:");
        scheduler.displayProcesses();

        scheduler.roundRobinSchedule(quantum);
    }
}

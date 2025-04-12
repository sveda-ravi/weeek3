import java.util.*;

class MyHashMap {
    static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] map;

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
            return;
        }
        Node curr = map[index];
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index];
        if (curr == null) return;
        if (curr.key == key) {
            map[index] = curr.next;
            return;
        }
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap myMap = new MyHashMap();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Put  2. Get  3. Remove  4. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter key and value:");
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                myMap.put(key, value);
            } else if (choice == 2) {
                System.out.println("Enter key to get:");
                int key = scanner.nextInt();
                int val = myMap.get(key);
                if (val != -1) System.out.println("Value: " + val);
                else System.out.println("Key not found");
            } else if (choice == 3) {
                System.out.println("Enter key to remove:");
                int key = scanner.nextInt();
                myMap.remove(key);
                System.out.println("Key removed");
            } else {
                break;
            }
        }
    }
}

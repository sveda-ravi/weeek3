import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManager {
    private Item head;

    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(int position, String name, int id, int qty, double price) {
        if (position <= 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }

        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Item ID not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Item removed.");
    }

    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public void searchItem(String query) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(query) || temp.itemName.equalsIgnoreCase(query)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item item) {
        System.out.println("ID: " + item.itemId + ", Name: " + item.itemName +
                ", Qty: " + item.quantity + ", Price: ₹" + item.price);
    }

    public void sort(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted by " + criteria + " (" + (ascending ? "asc" : "desc") + ").");
    }

    private Item mergeSort(Item head, String criteria, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;

        middle.next = null;

        Item left = mergeSort(head, criteria, asc);
        Item right = mergeSort(nextOfMiddle, criteria, asc);

        return merge(left, right, criteria, asc);
    }

    private Item getMiddle(Item head) {
        if (head == null)
            return head;

        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Item merge(Item a, Item b, String criteria, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (criteria.equalsIgnoreCase("name")) {
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                    : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, criteria, asc);
            return a;
        } else {
            b.next = merge(a, b.next, criteria, asc);
            return b;
        }
    }
}

public class InventoryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item by ID");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Calculate Total Value");
            System.out.println("7. Sort Items");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, qty, pos;
            double price;
            String name, query, sortBy;
            boolean asc;

            switch (choice) {
                case 1:
                    System.out.println("Enter position (1 for beginning, -1 for end, or actual position): ");
                    pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();

                    if (pos == 1)
                        manager.addAtBeginning(name, id, qty, price);
                    else if (pos == -1)
                        manager.addAtEnd(name, id, qty, price);
                    else
                        manager.addAtPosition(pos, name, id, qty, price);
                    break;

                case 2:
                    System.out.print("Enter Item ID to remove: ");
                    id = sc.nextInt();
                    manager.removeById(id);
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter new Quantity: ");
                    qty = sc.nextInt();
                    manager.updateQuantity(id, qty);
                    break;

                case 4:
                    System.out.print("Enter Item ID or Name to search: ");
                    query = sc.nextLine();
                    manager.searchItem(query);
                    break;

                case 5:
                    manager.displayAll();
                    break;

                case 6:
                    manager.calculateTotalValue();
                    break;

                case 7:
                    System.out.print("Sort by (name/price): ");
                    sortBy = sc.nextLine();
                    System.out.print("Ascending? (true/false): ");
                    asc = sc.nextBoolean();
                    manager.sort(sortBy, asc);
                    break;

                case 0:
                    System.out.println("Exiting Inventory System...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

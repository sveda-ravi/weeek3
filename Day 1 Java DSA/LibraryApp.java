import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

class Library {
    private Book head, tail;

    public void addAtBeginning(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int position, String title, String author, String genre, int id, boolean status) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, id, status);
            return;
        }

        Book newBook = new Book(title, author, genre, id, status);
        Book temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, status);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
    }

    public void removeById(int id) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book ID not found.");
    }

    public void search(String query) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found.");
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books: " + count);
    }

    private void displayBook(Book b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book by ID");
            System.out.println("3. Search Book");
            System.out.println("4. Update Availability");
            System.out.println("5. Display Books (Forward)");
            System.out.println("6. Display Books (Reverse)");
            System.out.println("7. Count Total Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            String title, author, genre;
            int id, pos;
            boolean status;

            switch (choice) {
                case 1:
                    System.out.print("Enter Position (1 for beginning, -1 for end, or actual position): ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    status = sc.nextBoolean();

                    if (pos == 1)
                        library.addAtBeginning(title, author, genre, id, status);
                    else if (pos == -1)
                        library.addAtEnd(title, author, genre, id, status);
                    else
                        library.addAtPosition(pos, title, author, genre, id, status);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();
                    library.removeById(id);
                    break;

                case 3:
                    System.out.print("Enter Book Title or Author to search: ");
                    String query = sc.nextLine();
                    library.search(query);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Set Availability (true/false): ");
                    status = sc.nextBoolean();
                    library.updateAvailability(id, status);
                    break;

                case 5:
                    library.displayForward();
                    break;

                case 6:
                    library.displayReverse();
                    break;

                case 7:
                    library.countBooks();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

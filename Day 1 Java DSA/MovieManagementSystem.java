import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newMovie;
        } else {
            tail = newMovie;
        }

        temp.next = newMovie;
    }

    public void removeByTitle(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        System.out.println("Movie removed: " + temp.title);
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        Movie temp = head;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(Movie m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director +
                ", Year: " + m.year + ", Rating: " + m.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display Movies (Forward)");
            System.out.println("8. Display Movies (Reverse)");
            System.out.println("9. Update Movie Rating");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            String title, director;
            int year, position;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    list.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    list.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    list.addAtPosition(position, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    title = sc.nextLine();
                    list.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter Director to Search: ");
                    director = sc.nextLine();
                    list.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter Rating to Search: ");
                    rating = sc.nextDouble();
                    list.searchByRating(rating);
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter Movie Title to Update Rating: ");
                    title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
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

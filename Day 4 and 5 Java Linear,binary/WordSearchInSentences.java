import java.util.Scanner;

public class WordSearchInSentences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        System.out.print("Enter word to search: ");
        String word = scanner.nextLine();

        String result = "Not Found";

        for (int i = 0; i < n; i++) {
            if (sentences[i].contains(word)) {
                result = sentences[i];
                break;
            }
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}

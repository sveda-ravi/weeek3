import java.util.Scanner;

public class SelectionSortExamScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printScores(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] examScores = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter exam score for student " + (i + 1) + ": ");
            examScores[i] = scanner.nextInt();
        }

        System.out.println("Scores before sorting:");
        printScores(examScores);

        selectionSort(examScores);

        System.out.println("Scores after sorting in ascending order:");
        printScores(examScores);

        scanner.close();
    }
}

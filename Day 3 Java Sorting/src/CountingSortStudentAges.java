import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void printAges(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] studentAges = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            int age = scanner.nextInt();
            if (age < 10 || age > 18) {
                System.out.println("Age must be between 10 and 18. Please re-enter.");
                i--;
            } else {
                studentAges[i] = age;
            }
        }

        System.out.println("Ages before sorting:");
        printAges(studentAges);

        countingSort(studentAges);

        System.out.println("Ages after sorting:");
        printAges(studentAges);

        scanner.close();
    }
}

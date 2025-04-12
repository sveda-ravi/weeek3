import java.util.Scanner;

public class CompareBufferBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of times to concatenate: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the string to concatenate: ");
        String input = scanner.nextLine();

        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(input);
        }
        long endBuffer = System.nanoTime();

        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(input);
        }
        long endBuilder = System.nanoTime();

        System.out.println("Time taken by StringBuffer: " + (endBuffer - startBuffer) + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + (endBuilder - startBuilder) + " nanoseconds");

        scanner.close();
    }
}

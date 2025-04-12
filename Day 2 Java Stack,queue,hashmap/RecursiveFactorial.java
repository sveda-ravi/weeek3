import java.util.Scanner;

public class RecursiveFactorial {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative input not allowed");
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(factorial(input));
    }
}

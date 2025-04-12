public class FibonacciComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Fibonacci Number (N): ");
        int N = sc.nextInt();

        long startTime, endTime;

        startTime = System.nanoTime();
        fibonacciRecursive(N);
        endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        fibonacciIterative(N);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci Time: " + (endTime - startTime) / 1000000 + "ms");

        sc.close();
    }

    static void fibonacciRecursive(int n) {
        if (n <= 1) return;
        fibonacciRecursive(n - 1);
        fibonacciRecursive(n - 2);
    }

    static void fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
    }
}

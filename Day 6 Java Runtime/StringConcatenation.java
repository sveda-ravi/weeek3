public class StringConcatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Operations Count (N): ");
        int N = sc.nextInt();

        long startTime, endTime;

        startTime = System.nanoTime();
        stringConcatenation(N);
        endTime = System.nanoTime();
        System.out.println("String Concatenation Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        stringBuilderConcatenation(N);
        endTime = System.nanoTime();
        System.out.println("StringBuilder Concatenation Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        stringBufferConcatenation(N);
        endTime = System.nanoTime();
        System.out.println("StringBuffer Concatenation Time: " + (endTime - startTime) / 1000000 + "ms");

        sc.close();
    }

    static void stringConcatenation(int N) {
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
    }

    static void stringBuilderConcatenation(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
    }

    static void stringBufferConcatenation(int N) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
    }
}

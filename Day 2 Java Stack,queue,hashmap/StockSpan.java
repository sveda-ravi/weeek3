import java.util.*;

public class StockSpan {
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }

    public void printSpan(int[] prices) {
        int[] span = calculateSpan(prices);
        System.out.println("Stock Span: " + Arrays.toString(span));
    }

    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        int[] prices = { 10, 4, 5, 90, 120, 80 };
        stockSpan.printSpan(prices);
    }
}

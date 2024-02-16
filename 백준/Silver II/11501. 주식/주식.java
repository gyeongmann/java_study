import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
 
            Stack<Long> price = new Stack<>();
            for (int i = 0; i < N; i++) {
                price.push(sc.nextLong());
            }
 
            long max = 0;
            long profit = 0;
            for (int i = 0; i < N; i++) {
                long pop = price.pop();
                if (pop > max) {
                    max = pop;
                    continue;
                }
 
                profit += max - pop;
            }
 
            System.out.println(profit);
        } // test case
    } // main
}
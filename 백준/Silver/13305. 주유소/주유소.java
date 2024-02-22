import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] dist = new long[N - 1];
        long[] price = new long[N];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = sc.nextLong();
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            long cur = sc.nextLong();
            if (cur < min) {
                min = cur;
            }
            price[i] = min;
        }

        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += dist[i] * price[i];
        }

        System.out.println(sum);
    }

}

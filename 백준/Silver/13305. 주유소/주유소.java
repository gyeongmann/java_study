import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dist = new int[N - 1];
        int[] price = new int[N];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int cur = sc.nextInt();
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

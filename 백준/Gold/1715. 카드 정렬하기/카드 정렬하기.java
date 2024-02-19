import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Long> q = new PriorityQueue<>();

        if (N == 1) {
            int a = sc.nextInt();
            System.out.println((int) (a * Math.log(a)));
            return;
        }

        for (int i = 0; i < N; i++) {
            q.offer(sc.nextLong());
        }

        int sum = 0;
        while (q.size() > 1) {
            Long a = q.poll();
            Long b = q.poll();

            sum += a + b;

            q.offer(a + b);
        }

        System.out.println(sum);
    }

}

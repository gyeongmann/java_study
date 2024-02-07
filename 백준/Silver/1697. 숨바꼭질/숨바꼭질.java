import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] count;

    static boolean isValid(int x) {
        if (x < 0 || x > 100000) {
            return false;
        }

        if (count[x] != 0) {
            return false;
        }

        return true;
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();

        count[N] = 0;
        q.add(N);

        while (!q.isEmpty()) {
//            System.out.println(q);
            int x = q.poll();
            if (count[K] != 0) {
                break;
            }

            int x1 = x - 1;
            int x2 = x + 1;
            int x3 = x * 2;

            if (isValid(x1)) {
                q.add(x1);
                count[x1] = count[x] + 1;
            }
            if (isValid(x2)) {
                q.add(x2);
                count[x2] = count[x] + 1;
            }
            if (isValid(x3)) {
                q.add(x3);
                count[x3] = count[x] + 1;
            }

//            System.out.println(Arrays.toString(count));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            return;
        }

        count = new int[100001];
        BFS();

        System.out.println(count[K]);
    } // main
}

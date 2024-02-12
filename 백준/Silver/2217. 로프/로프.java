
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] ropes = new Integer[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int max = 0;
        for (int k = 0; k < N; k++) {
            int cur = ropes[k] * (k + 1);
            if (max < cur) {
                max = cur;
            }
        }

        System.out.println(max);
    }
}
